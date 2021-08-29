package com.lida.dy.serviceImpl;

import com.lida.dy.conf.DefaultConfig;
import com.lida.dy.dao.TypeRepositioy;
import com.lida.dy.model.entity.TalentTypeEntity;
import com.lida.dy.model.vo.TypeDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 10:31
 * @Version: 1.0
 */
@Service
public class TypeService {
    @Autowired
    TypeRepositioy typeRepositioy;

    /**
     * @return获取内容类型
     */
    public List<String> getAllType() {
        List<TalentTypeEntity> talentTypeEntities = typeRepositioy.findAll();
        Set<String> typeNames = new HashSet<>();
        for (TalentTypeEntity talentTypeEntity : talentTypeEntities) {
            typeNames.add(talentTypeEntity.getTypeName());
        }
        LinkedList<String> typeNamesList = new LinkedList<>();
        typeNamesList.addAll(typeNames);
        typeNamesList.remove("汽车");
        typeNamesList.addFirst("汽车");
        return typeNamesList;
    }

    /**
     * 构建删选数据
     *
     * @return
     */
    public TypeDataVo getType() {
        List<String> typeNames = getAllType();

        TypeDataVo typeDataVo = new TypeDataVo();
        TypeDataVo.Advancecondition advancecondition = new TypeDataVo.Advancecondition();
        TypeDataVo.Advancecondition.Val val = new TypeDataVo.Advancecondition.Val();

        TypeDataVo.Advancecondition.Val.Value value = new TypeDataVo.Advancecondition.Val.Value();
        value.setTitle(DefaultConfig.seContentTitle);
        value.setVal(typeNames);
        val.setMultiselect(true);
        val.setValue(value);
        List<TypeDataVo.Advancecondition.Val> vals = new ArrayList<>();
        vals.add(val);

        TypeDataVo.Advancecondition.Val.Value priceValue = new TypeDataVo.Advancecondition.Val.Value();
        priceValue.setTitle(DefaultConfig.sePriceTitle);
        priceValue.setVal(DefaultConfig.pricesItem);
        vals.add(new TypeDataVo.Advancecondition.Val(false, priceValue));

        TypeDataVo.Advancecondition.Val.Value fansNumValue = new TypeDataVo.Advancecondition.Val.Value();
        fansNumValue.setTitle(DefaultConfig.seFansTitle);
        fansNumValue.setVal(DefaultConfig.pricesItem);
        vals.add(new TypeDataVo.Advancecondition.Val(false, fansNumValue));

        advancecondition.setVal(vals);
        advancecondition.setTitle("高级选项");
        typeDataVo.setAdvancecondition(advancecondition);
        return typeDataVo;
    }

    public List<TalentTypeEntity> getTalentTypeEntityByName(String name) {
        List<TalentTypeEntity> talentTypeEntity = typeRepositioy.findByTypeNameEquals(name);
        return talentTypeEntity;
    }
}
