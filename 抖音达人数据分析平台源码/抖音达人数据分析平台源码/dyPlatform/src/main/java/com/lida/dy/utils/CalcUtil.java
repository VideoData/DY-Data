package com.lida.dy.utils;

import com.lida.dy.model.entity.TalentUserInfoEntity;
import com.lida.dy.model.vo.BagVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/4 0004 19:45
 * @Version: 1.0
 */
@Component
@Slf4j
public class CalcUtil {
    /**
     * 计算我们的单位播放量
     *
     * @param talentUserInfoEntity
     */
    public static void calcPlayUnit(TalentUserInfoEntity talentUserInfoEntity) {
        long comment = getInt(talentUserInfoEntity.getAvgComment());
        long share = getInt(talentUserInfoEntity.getAvgShareNum());
        long dianzan = getInt(talentUserInfoEntity.getAvgLike());
        long fans = getInt(talentUserInfoEntity.getFansCount());
        double temp = 699.1 * comment - 335.9 * share + 27.3 * dianzan;
        if (temp < 0) {
            temp = new Random().nextInt(4900) + 100;
        }
        double playUnit = (temp) / fans;
        playUnit = playUnit * 10000;
        double predicatPlay = temp;

        log.info("comment :{} , share {}, dianzan {}, fans {}", comment, share, dianzan, fans);
        log.info("playUnit {}", playUnit);
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(playUnit);
        talentUserInfoEntity.setPredicatePlayUnit(str);
        talentUserInfoEntity.setPrePlayNum((int) predicatPlay);
    }

    /**
     * 若为null，则返回0，否则返回原值
     *
     * @param integer
     * @return
     */
    public static int getInt(Integer integer) {
        if (integer != null) {
            return integer;
        } else {
            return 0;
        }
    }

    /**
     * 若为null，则返回0，否则返回原值
     *
     * @param floats
     * @return
     */
    public static float getFloat(Float floats) {
        if (floats != null) {
            return floats;
        } else {
            return 0f;
        }
    }


    /**
     * 背包问题，计算最优
     * 输入如测试数据
     * 测试数据：
     * num = 6  物品的数量（达人的个数），
     * maxPrice = 10 书包能承受的重量（预算），
     * prices = [2, 2, 3, 1, 5, 2] 每个物品的重量（达人的视频报价）
     * values = [2, 3, 1, 5, 4, 3] 每个物品的价值（预计的播放量即传播效用）
     */
    public static void bag(BagVo bagVo) {
        log.info("bagvo 计算背包入参 ： {}", bagVo.toString());
        int w = bagVo.getLimitMony() / 1000;
        float[][] user = bagVo.getUser();
        int[][] val = new int[user.length + 1][w + 1];
        float[][] a = new float[user.length][2];
        for (int i = 0; i < user.length; i++) {
            a[i][0] = (int) user[i][1] / 1000;
            a[i][1] = user[i][2];
        }
        for (int i = 1; i < user.length + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                val[i][j] = val[i - 1][j];
                if (j >= a[i - 1][0] && val[i][j] < val[i - 1][(int) (j - a[i - 1][0])] + a[i - 1][1]) {
                    val[i][j] = (int) (val[i - 1][(int) (j - a[i - 1][0])] + a[i - 1][1]);
                }
            }
        }
        int j = w;

        for (int i = user.length; i > 0; i--) {
            if (val[i][j] > val[i - 1][j]) {
                j -= a[i - 1][0];
                user[i - 1][3] = 1;

            }
        }
        bagVo.setUser(user);

        bagVo.setResultValue(val[user.length][w]);
    }
}
