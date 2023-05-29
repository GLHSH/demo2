package com.example.demo.Dao;

import com.example.demo.entity.GoodEx;
import com.example.demo.entity.LikeEx;

public interface IGoodExDao {
    int addGoodEx(GoodEx goodEx);
    int delGoodEx(GoodEx goodEx);

    GoodEx selectLike(GoodEx goodEx);
}
