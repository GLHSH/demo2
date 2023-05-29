package com.example.demo.service.impl;

import com.example.demo.Dao.ICommentDao;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Reply;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-16
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Resource
    ICommentDao iCommentDao;
    @Override
    public List<Comment> selectById(int experience_id) {
        return iCommentDao.seleclById(experience_id);
    }

    @Override
    public int addComment(Comment comment){
        return iCommentDao.addComment(comment);
    }

    @Override
    public int updateCommentGood(Comment comment){
        return iCommentDao.updateCommentGood(comment);
    }

}
