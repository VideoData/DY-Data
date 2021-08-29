package com.lida.dy.cal.dao.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/29 0029 14:48
 * @Version: 1.0
 */
public interface MCommentRepositry extends MongoRepository<MComment, String> {
    public List<MComment> findAllByCid(String cid);

}
