package com.example.demo.service.impl;

import com.example.demo.Dao.IUserDao;
import com.example.demo.entity.BaseModel;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    IUserDao userDao;
    @Override
    public BaseModel<User> login(User user) {
        return userDao.login(user);
    }

    @Override
    public List selectLikeUser(int user_id) {
        return userDao.selectLikeUser(user_id);
    }

    @Override
    public List selectFans(int user_id) {
        return userDao.selectFans(user_id);
    }

    @Override
    public User register(User user) {
        return userDao.register(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }



    @Override
    public User exSelectOne(User user) {
         return userDao.exSelectOne(user);
     }




}
