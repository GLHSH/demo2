package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Reply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-16
 */
public interface IReplyService extends IService<Reply> {
    List<Reply> selectById(int experience_id);

    void addReply(Reply reply);

    void delReply(Reply reply);

    int updateReplyGood(Reply reply);
}
