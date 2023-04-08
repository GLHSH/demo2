package com.example.demo.service.impl;

import com.example.demo.Dao.ILoginDao;
import com.example.demo.entity.BaseModel;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    ILoginDao loginDao;
    @Override
    public BaseModel<User> login(User user) {
        return loginDao.login(user);
    }
}
