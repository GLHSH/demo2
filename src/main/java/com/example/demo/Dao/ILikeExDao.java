package com.example.demo.Dao;

import com.example.demo.entity.LikeEx;

public interface ILikeExDao {
    int addLikeEx(LikeEx likeEx);
    int delLikeEx(LikeEx likeEx);

    LikeEx selectLike(LikeEx likeEx);
}
