package com.lida.dy.schedle.dao.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/29 0029 14:48
 * @Version: 1.0
 */
public interface MCommentRepositry extends MongoRepository<MComment, String> {
    public List<MComment> findAllByCid(String cid);

    List<MComment> findAllByMyAuthorId(int authorId);
    @Query(value="{'my_video_id':?0}")
    public Page<MComment> findByMyVideoIds(int videoId, Pageable pageable);

}
