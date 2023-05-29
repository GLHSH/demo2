package com.example.demo.Dao;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Reply;
import com.example.demo.mapper.CommentMapper;
import com.github.yulichang.query.MPJQueryWrapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CommentDaoImpI implements ICommentDao {

    @Resource
    CommentMapper commentMapper;

    @Override
    public List<Comment> seleclById(int experience_id) {
        MPJQueryWrapper<Comment> wrapper = new MPJQueryWrapper<Comment>()
                .select("*")
                .eq("t.experience_id", experience_id);
        //列表查询
        return commentMapper.selectList(wrapper);
    }


    @Override
    public int addComment(Comment comment) {
        return commentMapper.insert(comment);
    }
    @Override
    public int updateCommentGood(Comment comment) {
        System.out.println("CommentDao 层updateCommentGood" + comment);
        UpdateWrapper<Comment> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", comment.getId())
                .set("good", comment.getGood());
        return commentMapper.update(null, updateWrapper);
    }
}
