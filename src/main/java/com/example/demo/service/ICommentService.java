package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Reply;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-16
 */
public interface ICommentService extends IService<Comment> {
    List<Comment> selectById(int experience_id);

    int addComment(Comment comment);

    int updateCommentGood(Comment comment);

}
