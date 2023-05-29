package com.example.demo.Dao;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Experience;
import com.example.demo.entity.Reply;

import java.util.List;

public interface ICommentDao {
    List<Comment> seleclById(int experience_id);

    int addComment(Comment comment);

    int updateCommentGood(Comment comment);

}
