package com.lida.dy.serviceImpl;

import com.lida.dy.dao.*;
import com.lida.dy.model.entity.*;
import com.lida.dy.model.vo.BagVo;
import com.lida.dy.model.vo.OverlapVo;
import com.lida.dy.utils.CalcUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/5 0005 19:57
 * @Version: 1.0
 */
@Service
@Slf4j
public class CoreService {
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    TalentFansUnionRepository talentFansUnionRepository;
    @Autowired
    OverlapRepostitory overlapRepostitory;
    @Autowired
    TalentTypeRepostitory talentTypeRepostitory;
    @Autowired
    TalentTypeUnionRepositiory talentTypeUnionRepositiory;

    /**
     * 全局計算背包
     *
     * @param bagVo
     * @return
     */
    public List<TalentUserInfoEntity> calcBagAll(BagVo bagVo) {
        List<Integer> id = talentTypeRepostitory.findIdByTypeNames(bagVo.getType());
//        talentUserRepository
        List<TalentUserInfoEntity> users = talentUserRepository.findAllByTalentTypeName(bagVo.getType());
        calcBagTool(bagVo, bagVo.getVideoLength(), users);
        return users;
    }

    /**
     * 根据候选列表进行背包计算
     *
     * @param bagVo
     * @return
     */
    public BagVo calcBag(BagVo bagVo) {
        String[] split = bagVo.getIds().split(",");
        ArrayList<Integer> idlist = new ArrayList<>();
        for (String s : split) {
            idlist.add(Integer.parseInt(s));
        }
        List<TalentUserInfoEntity> talentUserInfoEntities = talentUserRepository.findAllByIdIn(idlist);
        calcBagTool(bagVo, bagVo.getVideoLength(), talentUserInfoEntities);
        return bagVo;
    }

    private void calcBagTool(BagVo bagVo, String videoType, List<TalentUserInfoEntity> talentUserInfoEntities) {
        float[][] users = new float[talentUserInfoEntities.size()][6];
        for (int i = 0; i < talentUserInfoEntities.size(); i++) {
            users[i][0] = talentUserInfoEntities.get(i).getId();
            List<PriceEntity> priceEntities = talentUserInfoEntities.get(i).getPriceEntities();
            String filterVideoType = videoType.contains("20") ? "20s" : "21";
            for (PriceEntity priceEntity : priceEntities) {
                if (priceEntity.getTimeRange().contains(filterVideoType) && priceEntity.getPrice() > -1) {
                    users[i][1] = priceEntity.getPrice();
                    break;
                }
            }
            CalcUtil.calcPlayUnit(talentUserInfoEntities.get(i));
            Integer prePlayNum = (int) talentUserInfoEntities.get(i).getPrePlayNum();
            prePlayNum = prePlayNum == null ? 0 : prePlayNum.intValue();
            float temp = 0f;
            if (talentUserInfoEntities.get(i).getFansCount() != null && talentUserInfoEntities.get(i).getFansCount() != 0) {
                temp = ((float) prePlayNum) * 1000 / talentUserInfoEntities.get(i).getFansCount();
            }
            users[i][2] = temp;
            int realFansCount = talentUserInfoEntities.get(i).getRealFansCount() == null ? 0 : talentUserInfoEntities.get(i).getRealFansCount();
            users[i][4] = realFansCount;
            users[i][5] = prePlayNum;
        }
        bagVo.setUser(users);
        CalcUtil.bag(bagVo);
        float[][] user = bagVo.getUser();
        int sumFan = 0;
        int sumPrice = 0;
        int sumPlayNum = 0;
        List<Integer> ids = new ArrayList<>();
        for (float[] ints : user) {
            if (ints[3] == 1) {
                sumFan += ints[4];
                sumPrice += ints[1];
                ids.add((int) ints[0]);
                sumPlayNum += ints[5];
            }
        }
        bagVo.setRealFans(sumFan);
        bagVo.setTotalPrice(sumPrice);
        bagVo.setResultIds(ids);
        bagVo.setTalentNum(ids.size());
        bagVo.setTotalPlayNum(sumPlayNum);
    }


    /**
     * 计算重合度，并保存到数据库
     *
     * @param overlapVo
     */
    public void calcOverlap(OverlapVo overlapVo) {
        int a = overlapVo.getUserInfoEntitya().getId();
        int b = overlapVo.getUserInfoEntityb().getId();
        log.info("=======计算重合度=======");
        log.info("ida:{} , idb:{}", a, b);
        Set<TalentFansUnionEntity> seta = talentFansUnionRepository.findAllByTalentId(a);
        Set<TalentFansUnionEntity> setb = talentFansUnionRepository.findAllByTalentId(b);
        if (setb == null || seta == null) {
            overlapVo.setOverlapValue(0);
            overlapVo.setTalendaFanNum(seta.size());
            overlapVo.setTalendbFanNum(setb.size());
        } else {
            BigDecimal sizea = new BigDecimal(seta.size() + "");
            BigDecimal sizeb = new BigDecimal(setb.size() + "");
            Set<Integer> fansids = new HashSet<>();
            for (TalentFansUnionEntity talentFansUnionEntity : seta) {
                fansids.add(talentFansUnionEntity.getFansId());
            }
            for (TalentFansUnionEntity talentFansUnionEntity : setb) {
                fansids.add(talentFansUnionEntity.getFansId());
            }
            //sizea , sizeb 是达人a和达人b的样本数，sizec 是 重合数量
            BigDecimal sizec = sizea.add(sizeb).subtract(new BigDecimal("" + fansids.size()));
            //fansa 的总粉丝
            BigDecimal fansa = new BigDecimal(overlapVo.getUserInfoEntitya().getFansCount() + "");
            BigDecimal fansb = new BigDecimal(overlapVo.getUserInfoEntityb().getFansCount());
            BigDecimal gamma = new BigDecimal("" + (double) Math.max(fansa.intValue(), fansb.intValue()) / (double) Math.min(fansa.intValue(), fansb.intValue()));

            BigDecimal temp = sizea.multiply(sizeb).multiply(gamma);
            System.out.println(sizec.multiply(fansa).multiply(fansb));
            temp = sizec.multiply(fansa).multiply(fansb).divide(temp, 10, BigDecimal.ROUND_HALF_DOWN);
            int count = temp.intValue();
            log.info("sizea :{}  sizeb :{}  sizec :{} fansa:{} fansb:{} count:{}  temp:{} ", sizea.intValue(), sizeb.intValue(), sizec.intValue(), fansa.intValue(), fansb.intValue(), count, temp.intValue());
            overlapVo.setOverlapValue(count);
            overlapVo.setTalendaFanNum(fansa.intValue());
            overlapVo.setTalendbFanNum(fansb.intValue());
            FanOverlapEntity fanOverlapEntity = new FanOverlapEntity();
            fanOverlapEntity.setTalentaId(a);
            fanOverlapEntity.setTalentbId(b);
            fanOverlapEntity.setOverlapValue(count);
            fanOverlapEntity.setTalendaFanNum(fansa.intValue());
            fanOverlapEntity.setTalendbFanNum(fansb.intValue());
            overlapRepostitory.save(fanOverlapEntity);
        }
    }

    /*计算预算的50%和80%的效益比*/
    public BagVo calcOtherOptimization(BagVo bagVo) {
        BagVo bagVo50 = new BagVo();
        BeanUtils.copyProperties(bagVo, bagVo50);
        bagVo50.setLimitNum((int) (bagVo50.getLimitMony() * 0.5));
        bagVo50 = calcBag(bagVo50);

        if (bagVo.getResultValue() * 0.6 < bagVo50.getResultValue()) {
            return bagVo50;
        } else {
            BagVo bagVo80 = new BagVo();
            BeanUtils.copyProperties(bagVo, bagVo80);
            bagVo80.setLimitNum((int) (bagVo80.getLimitMony() * 0.8));
            bagVo80 = calcBag(bagVo80);
            if (bagVo.getResultValue() * 0.9 < bagVo80.getResultValue()) {
                return bagVo80;
            }
        }
        return null;
    }

    /*暴力计算80%-110%的更优值*/
    public void calcOtherOptimizationByForce(BagVo maxPlayNumBagVo, BagVo maxPriceOptimizationBagVo) {
        int tempLimitMony = maxPlayNumBagVo.getLimitMony();
        BagVo bagVo = new BagVo();
        BagVo orangeBagVo = new BagVo();
        BeanUtils.copyProperties(maxPlayNumBagVo, bagVo);
        BeanUtils.copyProperties(maxPlayNumBagVo, orangeBagVo);
        float tempPriceOptimization = 0f;
        int tempMaxPlayNum = 0;
        for (float rate = 0.8f; rate < 1.1; rate += 0.01f) {
            bagVo.setLimitMony((int) (bagVo.getLimitMony() * rate));
            bagVo = calcBag(bagVo);
            float now = bagVo.getResultValue() / bagVo.getLimitMony();
            if (tempPriceOptimization < now) {
                System.out.println("ok");
                BeanUtils.copyProperties(bagVo, maxPriceOptimizationBagVo);
                tempPriceOptimization = now;
            }
            if (bagVo.getTotalPlayNum() > tempMaxPlayNum) {
                System.out.println("ok");
                BeanUtils.copyProperties(bagVo, maxPlayNumBagVo);
                tempMaxPlayNum = bagVo.getTotalPlayNum();
            }
            BeanUtils.copyProperties(orangeBagVo, bagVo);
        }
        maxPlayNumBagVo.setLimitMony(tempLimitMony);
    }

    public void calcOtherOptimizationByForceAll(BagVo maxPlayNumBagVo, BagVo maxPriceOptimizationBagVo, List<TalentUserInfoEntity> users) {
        int tempLimitMony = maxPlayNumBagVo.getLimitMony();
        BagVo bagVo = new BagVo();
        BagVo orangeBagVo = new BagVo();
        BeanUtils.copyProperties(maxPlayNumBagVo, bagVo);
        BeanUtils.copyProperties(maxPlayNumBagVo, orangeBagVo);
        float tempPriceOptimization = 0f;
        int tempMaxPlayNum = 0;
        for (float rate = 0.8f; rate < 1.1; rate += 0.01f) {
            bagVo.setLimitMony((int) (bagVo.getLimitMony() * rate));
            calcBagTool(bagVo, bagVo.getVideoLength(), users);
            float now = bagVo.getResultValue() / bagVo.getLimitMony();
            if (tempPriceOptimization < now) {
                System.out.println("ok");
                BeanUtils.copyProperties(bagVo, maxPriceOptimizationBagVo);
                tempPriceOptimization = now;
            }
            if (bagVo.getTotalPlayNum() > tempMaxPlayNum) {
                System.out.println("ok");
                BeanUtils.copyProperties(bagVo, maxPlayNumBagVo);
                tempMaxPlayNum = bagVo.getTotalPlayNum();
            }
            BeanUtils.copyProperties(orangeBagVo, bagVo);
        }
        maxPlayNumBagVo.setLimitMony(tempLimitMony);
    }

    /**
     * 计算标准差
     */
    public double calcStandardDeviation(List<VideoEntity> videoEntities) {
        Assert.assertNotNull("VideoVo not null!!!", videoEntities);
        int num = videoEntities.size();
        double avg = 0.0f, temp = 0.0f;
        for (VideoEntity videoEntity : videoEntities) {
            avg += videoEntity.getPlayNum();
        }
        avg = (double) avg / num;
        for (VideoEntity videoEntity : videoEntities) {
            temp += Math.pow(avg - videoEntity.getPlayNum(), 2);
        }
        temp = temp / num;
        return Math.sqrt(temp);
    }
}
