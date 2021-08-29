package com.lida.dy.cal.temp;

import com.lida.dy.cal.dao.PriceRepository;
import com.lida.dy.cal.dao.TalentUserRepository;
import com.lida.dy.cal.entity.PriceEntity;
import com.lida.dy.cal.entity.TalentUserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/6 0006 21:19
 * @Version: 1.0
 */
@Component
public class FixPriceMain {
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    TalentUserRepository talentUserRepository;

    public void main() {
        main2();
//        long total = talentUserRepository.count();
//        int page = 0;
//        PageRequest pageRequest;
//        Page<TalentUserInfoEntity> all;
//        do {
//            pageRequest = PageRequest.of(page, 20);
//            page++;
//            all = talentUserRepository.findAll(pageRequest);
//            List<TalentUserInfoEntity> content = all.getContent();
//            for (TalentUserInfoEntity talentUserInfoEntity : content) {
//                String price = talentUserInfoEntity.getPrice();
//                if (price != null) {
//                    ArrayList<PriceEntity> priceEntities = parsePrice(price, talentUserInfoEntity.getId());
//                    priceRepository.saveAll(priceEntities);
//                }
//            }
//        } while (all.hasNext());
    }

    public void main2() {
        List<TalentUserInfoEntity> allByPlatformId = talentUserRepository.findAllByPlatformId(2);
        System.out.println(allByPlatformId.size());
        for (TalentUserInfoEntity talentUserInfoEntity : allByPlatformId) {
            String price = talentUserInfoEntity.getPrice();
            if (price.indexOf("视频") < 3) {
                price = price.replace("视频", "1-30s视频");
                price = price.replace(",", "");
            }
            talentUserInfoEntity.setPrice(price);
        }
        talentUserRepository.saveAll(allByPlatformId);
    }

    private ArrayList<PriceEntity> parsePrice(String price, int talentId) {
        String[] split = price.split(",");
        ArrayList<PriceEntity> priceEntities = new ArrayList<>();
        for (String s : split) {
            if (s.length() > 3) {
                PriceEntity priceEntity = new PriceEntity();
                String[] split1 = s.split("-");
                if (!s.contains("null")) {
                    priceEntity.setPrice(Integer.parseInt(split1[3]));
                } else {
                    priceEntity.setPrice(-1);
                }
                priceEntity.setType(split1[2]);
                priceEntity.setTimeRange(split1[0] + "-" + (split1[1].replace("视频", "")));
                priceEntity.setTalentUserId(talentId);
                priceEntities.add(priceEntity);
            }
        }
        return priceEntities;
    }
}
