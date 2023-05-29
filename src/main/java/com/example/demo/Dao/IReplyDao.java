package com.example.demo.Dao;

import com.example.demo.entity.Reply;

import java.util.List;

public interface IReplyDao {
    List<Reply> seleclById(int experience_id);

    void addReply(Reply reply);

    void delReply(Reply reply);

    int updateReplyGood(Reply reply) ;

}
