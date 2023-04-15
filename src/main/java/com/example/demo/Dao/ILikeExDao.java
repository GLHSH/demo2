package com.example.demo.Dao;

import com.example.demo.entity.LikeEx;
import com.example.demo.entity.LikeUser;

public interface ILikeExDao {
    int addLikeEx(LikeEx likeEx);
    int delLikeEx(LikeEx likeEx);
}
