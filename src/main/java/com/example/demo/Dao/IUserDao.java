package com.example.demo.Dao;

import com.example.demo.entity.BaseModel;
import com.example.demo.entity.User;

import java.util.List;

public interface IUserDao {
    BaseModel<User> login(User user);

    List selectLikeUser(int user_id);

    List selectFans(int user_id);
}
