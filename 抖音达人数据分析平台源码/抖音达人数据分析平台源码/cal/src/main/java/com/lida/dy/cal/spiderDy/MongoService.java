package com.lida.dy.cal.spiderDy;

import com.alibaba.fastjson.JSON;
import com.lida.dy.cal.dao.mongo.MComment;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.stereotype.Component;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/31 0031 19:08
 * @Version: 1.0
 */
@Component
public class MongoService {

    public static MongoCollection<Document> comment;

    static {
        MongoClient mongoClient = new MongoClient("115.29.172.197", 27017);
        MongoDatabase dy = mongoClient.getDatabase("dy");
        comment = dy.getCollection("comment");
    }


    public void save(MComment videoCommentEntity) {
        FindIterable<Document> documents = comment.find(Filters.eq("cid", videoCommentEntity.getCid()));
        MongoCursor<Document> iterator = documents.iterator();
        if (iterator.hasNext()) {

        } else {
            Document document = Document.parse(JSON.toJSONString(videoCommentEntity));
            comment.insertOne(document);
        }
    }
}
