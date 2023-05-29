package com.example.demo.Dao;

import com.example.demo.entity.LikeEx;
import com.example.demo.entity.LikeTalk;

public interface ILikeTalkDao {
    int addLikeTalk(LikeTalk likeTalk);

    int delLikeTalk(LikeTalk likeTalk);

    LikeTalk selectLike(LikeTalk likeTalk);
}
