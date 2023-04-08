package com.example.demo.Dao;

import com.example.demo.entity.BaseModel;
import com.example.demo.entity.User;

public interface ILoginDao {
    BaseModel<User> login(User user);
}
