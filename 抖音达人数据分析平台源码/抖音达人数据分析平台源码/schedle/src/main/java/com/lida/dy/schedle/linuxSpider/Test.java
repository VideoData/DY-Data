package com.lida.dy.schedle.linuxSpider;

import com.lida.dy.schedle.dao.TalentUserRepository;
import com.lida.dy.schedle.entity.TalentUserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Test {
    @Autowired
    TalentUserRepository talentUserRepository;

    public void test() {
        List<TalentUserInfoEntity> allByOtherWithError = talentUserRepository.findAllByOtherWithError(PageRequest.of(0, 10));
        TalentUserInfoEntity talentUserInfoEntity = allByOtherWithError.get(0);
        talentUserInfoEntity.setXtCpm(50.2f);
        talentUserRepository.save(talentUserInfoEntity);
    }
}
