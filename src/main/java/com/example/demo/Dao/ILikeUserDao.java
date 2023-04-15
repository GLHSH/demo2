package com.example.demo.Dao;

import com.example.demo.entity.LikeUser;

import java.util.List;

public interface ILikeUserDao {
    int addLikeUser(LikeUser likeUser);

    int delLikeUser(LikeUser likeUser);
}
