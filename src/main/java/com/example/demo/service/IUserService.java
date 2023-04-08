package com.example.demo.service;

import com.example.demo.entity.BaseModel;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-06
 */
public interface IUserService extends IService<User> {
    BaseModel<User> login(User user);
}
