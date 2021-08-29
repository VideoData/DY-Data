package com.lida.dy.schedle.dao;

import com.lida.dy.schedle.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 10:47
 * @Version: 1.0
 */

public interface PriceRepository extends JpaRepository<PriceEntity, Integer>, JpaSpecificationExecutor {
}
