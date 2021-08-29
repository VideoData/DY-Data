package com.lida.dy.controller;

import com.lida.dy.conf.SessionKey;
import com.lida.dy.model.entity.PriceEntity;
import com.lida.dy.model.entity.TalentUserInfoEntity;
import com.lida.dy.model.vo.BagVo;
import com.lida.dy.serviceImpl.CoreService;
import com.lida.dy.serviceImpl.TalentUserService;
import com.lida.dy.serviceImpl.TypeService;
import com.lida.dy.tool.Result;
import com.lida.dy.utils.Page;
import com.lida.dy.utils.ThymeleafUtil;
import com.lida.dy.utils.ToolUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 18:59
 * @Version: 1.0
 */
@Controller
@Slf4j
@Api(tags = "结算相关接口")
public class CalculateController {
    @Autowired
    TalentUserService talentUserService;
    @Autowired
    CoreService coreService;
    @Autowired
    ToolUtil toolUtil;
    @Autowired
    TypeService typeService;

    /**
     * 上传候选列表计算背包
     *
     * @param bagVo
     * @return
     */
    @PostMapping("/calculate/calculate")
    @ResponseBody
    @ApiOperation("上传候选达人列表计算背包")
    public Result calculate( BagVo bagVo) {
        if (bagVo != null) {
            log.info("======= 背包計算 =====");
            log.info("入參： {}", bagVo.toString());
            bagVo = coreService.calcBag(bagVo);
            BagVo maxPlayNumBagVo = new BagVo();
            BagVo maxPriceOptimizationBagVo = new BagVo();
            BeanUtils.copyProperties(bagVo, maxPlayNumBagVo);
            BeanUtils.copyProperties(bagVo, maxPriceOptimizationBagVo);
            coreService.calcOtherOptimizationByForce(maxPlayNumBagVo, maxPriceOptimizationBagVo);
            HashMap<String, BagVo> map = new HashMap<>();
            map.put("maxPlayNum", maxPlayNumBagVo);
            map.put("maxPriceOptimization", maxPriceOptimizationBagVo);
            return Result.success(map);
        }
        return Result.fail("计算错误");
    }

    /**
     * 全局计算
     *
     * @param bagVo
     * @return
     */
    @PostMapping("/calculate/calculate/all")
    @ResponseBody
    @ApiOperation("全局计算背包")
    public Result calculateAll( BagVo bagVo) {
        if (bagVo != null) {
            log.info("======= 背包計算 =====");
            log.info("入參： {}", bagVo.toString());
            List<TalentUserInfoEntity> users = coreService.calcBagAll(bagVo);

            BagVo maxPlayNumBagVo = new BagVo();
            BagVo maxPriceOptimizationBagVo = new BagVo();
            BeanUtils.copyProperties(bagVo, maxPlayNumBagVo);
            BeanUtils.copyProperties(bagVo, maxPriceOptimizationBagVo);
            coreService.calcOtherOptimizationByForceAll(maxPlayNumBagVo, maxPriceOptimizationBagVo,users);
            HashMap<String, BagVo> map = new HashMap<>();
            map.put("maxPlayNum", maxPlayNumBagVo);
            map.put("maxPriceOptimization", maxPriceOptimizationBagVo);

            return Result.success(map);
        }
        return Result.fail("计算错误");
    }

    @PostMapping("/calculate/updateCandidate")
    @ApiOperation(value = "",hidden = true)
    public String updateCandidate(Model model, @RequestParam String data) {
        System.out.println(data);
        List<TalentUserInfoEntity> candidatePage = updatePanel(model, data, "candidatePage");
        return "page/settlement::candidatePanel";
    }

    public Integer parsePrice(String price, int index) {
        price = price.split(",")[index];
        if (price.indexOf("null") == 0) {
            price = price.split("视频")[1].replace("固定价格", "");
        } else {
            price = price.split("-")[3];
        }
        return Integer.parseInt(price);
    }

    /*更新面板html公共方法*/
    private List<TalentUserInfoEntity> updatePanel(Model model, String data, String tagid) {
        Set<Integer> ids = new HashSet<>();
        if (data != null && !data.equals("false") && !data.equals("null")) {
            if (data.indexOf(",") > 0) {
                String[] split = data.split(",");
                for (String s : split) {
                    ids.add(Integer.parseInt(s));
                }
            } else {
                ids.add(Integer.parseInt(data));
            }
            List<TalentUserInfoEntity> talentUserInfoEntities = talentUserService.searchByListId(ids);
            toolUtil.wrapperTanlentUserInfo(talentUserInfoEntities);
            Page page = new Page();
            page.setDataList(talentUserInfoEntities);
            page.setTotalElement(talentUserInfoEntities.size());
            model.addAttribute(tagid, page);
            return talentUserInfoEntities;
        } else {
            model.addAttribute(tagid, new Page());
            return null;
        }
    }
    @ApiOperation(value = "",hidden = true)
    @PostMapping("/calculate/updateLastCandidate")
    public String updateLastCandidate(Model model, @RequestParam String data) {
        System.out.println(data);
        List<TalentUserInfoEntity> lastCandidatePage = updatePanel(model, data, "lastCandidatePage");
        return "page/settlement::lastCandidatePanels";

    }

    @ApiOperation(value = "",hidden = true)
    @PostMapping("/calculate/updateAllCandidate")
    public String updateLastCandidate(Model model, @RequestParam String data, @RequestParam String dataLast) {
        System.out.println(data);
        System.out.println(dataLast);
        List<TalentUserInfoEntity> lastCandidatePage = updatePanel(model, dataLast, "lastCandidatePage");
        List<TalentUserInfoEntity> candidatePage = updatePanel(model, data, "candidatePage");
        return "page/settlement::main_right";
    }
    @ApiOperation(value = "",hidden = true)
    @GetMapping("/getCandidate")
    public String getCandidate(HttpSession session, Model model) {
        getTalentUserInfoPage(model, session);
        return "page/settlement::candidatePanel";
    }
    @ApiOperation(value = "",hidden = true)
    @GetMapping("/getLastCandidate")
    public String getLastCandidate(HttpSession session, Model model) {
        getTalentUserInfoPageForLast(model, session);
        return "page/settlement::lastCandidatePanel";
    }


    /**
     * 从session中获取候选列表
     *
     * @param session
     * @return
     */
    private void getTalentUserInfoPage(Model model, HttpSession session) {
        Set<Integer> ids = (Set<Integer>) session.getAttribute(SessionKey.candidateSetField);
        if (ids != null) {
            List<TalentUserInfoEntity> talentUserInfoEntities = talentUserService.searchByListId(ids);
            toolUtil.wrapperTanlentUserInfo(talentUserInfoEntities);
            Page page = new Page();
            page.setDataList(talentUserInfoEntities);
            page.setTotalElement(talentUserInfoEntities.size());
            model.addAttribute("candidatePage", page);
        } else {
            model.addAttribute("candidatePage", new Page());
        }
    }

    /**
     * 从session中获取选定列表
     *
     * @param session
     * @return
     */
    private void getTalentUserInfoPageForLast(Model model, HttpSession session) {
        Page page = new Page();
        Set<Integer> lastIds = (Set<Integer>) session.getAttribute(SessionKey.lastCandidateSetField);
        Set<Integer> lastIdsByAuto = (Set<Integer>) session.getAttribute(SessionKey.lastCandidateSetByAutoField);
        Set<Integer> temp = new HashSet<>();
        if (lastIds != null) {
            temp.addAll(lastIds);
        }
        if (lastIdsByAuto != null) {
            temp.addAll(lastIdsByAuto);
        }
        if (!temp.isEmpty()) {
            List<TalentUserInfoEntity> talentUserInfoEntities = talentUserService.searchByListId(temp);
            toolUtil.wrapperTanlentUserInfo(talentUserInfoEntities);
            for (TalentUserInfoEntity talentUserInfoEntity : talentUserInfoEntities) {
                System.out.println(talentUserInfoEntity.toString());
            }
            page.setDataList(talentUserInfoEntities);
            page.setTotalElement(talentUserInfoEntities.size());
            model.addAttribute("lastCandidatePage", page);
        } else {
            model.addAttribute("lastCandidatePage", new Page());
        }
    }
    @ApiOperation(value = "",hidden = true)
    @GetMapping("/calculate/getCandidateNum")
    @ResponseBody
    public Result getCandidateNum(HttpSession session) {
        Set<Integer> ids = (Set<Integer>) session.getAttribute(SessionKey.candidateSetField);
        if (ids != null) {
            return Result.success(ids.size());
        } else {
            return Result.fail();
        }
    }


    /**
     * 从session中的指定的key中清除id
     *
     * @param session
     * @param key
     * @param ids
     * @return
     */
    public boolean removeList(HttpSession session, String key, Collection<Integer> ids) {
        boolean flag = false;
        Set<Integer> myid = (Set<Integer>) session.getAttribute(key);
        if (myid != null) {
            for (Integer id : ids) {
                if (myid.contains(id)) {
                    myid.remove(id);
                    flag = true;
                }
            }
            if (!myid.isEmpty()) {
                session.setAttribute(key, myid);
            }
        }
        return flag;
    }

    /**
     * 从session中的指定的key中添加id
     *
     * @param session
     * @param key
     * @param ids
     * @return
     */
    public boolean addList(HttpSession session, String key, Collection<Integer> ids) {
        Set<Integer> myid = (Set<Integer>) session.getAttribute(key);
        boolean flag = false;
        if (myid != null) {
            for (Integer id : ids) {
                myid.add(id);
                flag = true;
            }
            session.setAttribute(key, myid);
        } else {
            myid = new HashSet<>();
            myid.addAll(ids);
            flag = true;
            session.setAttribute(key, myid);
        }
        return flag;
    }

    @ApiOperation(value = "获取所有达人类别")
    @GetMapping("/calculate/getAllTalentType")
    @ResponseBody
    public Result getAllTalentType() {
        List<String> types = typeService.getAllType();
        return Result.success(types);
    }

    @PostMapping("/calculate/getTotalPrice")
    @ResponseBody
    @ApiOperation(value = "上传达人id列表，计算达人报价之和")
    @ApiImplicitParam(name = "data", value = "达人id列表", defaultValue = "2,1,3", required = true)
    public Result getTotalPrice(@RequestParam String data) {
        System.out.println(data);
        Set<Integer> ids = new HashSet<>();
        if (data != null && !data.equals("false") && !data.equals("null")) {
            if (data.indexOf(",") > 0) {
                String[] split = data.split(",");
                for (String s : split) {
                    ids.add(Integer.parseInt(s));
                }
            } else {
                ids.add(Integer.parseInt(data));
            }
            List<TalentUserInfoEntity> talentUserInfoEntities = talentUserService.searchByListId(ids);
            int sum = 0;
            for (TalentUserInfoEntity talentUserInfoEntity : talentUserInfoEntities) {
                List<PriceEntity> priceEntities = talentUserInfoEntity.getPriceEntities();
                for (PriceEntity priceEntity : priceEntities) {
                    if (priceEntity.getTimeRange().contains("20s") && priceEntity.getPrice() > 0) {
                        sum += priceEntity.getPrice();
                        break;
                    }
                }

            }
            return Result.success(ThymeleafUtil.parseMoney(sum));
        }
        return Result.fail();
    }
}