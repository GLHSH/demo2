package com.example.demo.Dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.BaseModel;
import com.example.demo.entity.User;
import com.example.demo.mapper.ExperienceMapper;
import com.example.demo.mapper.UserMapper;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class LoginDaoImpI implements ILoginDao {

    @Resource
    UserMapper userMapper;

    @Override
    public BaseModel<User> login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        queryWrapper.eq("name",user.getName());
        queryWrapper.eq("password",user.getPassword());
        User userResult = userMapper.selectOne(queryWrapper);
        var baseModel = new BaseModel(0, "登录失败！");
        if (userResult == null) {
            System.out.println("------ result ==null!!!");
        } else {
            baseModel.setCode(1);
            baseModel.setMessage("登录成功！");
            baseModel.setT(userResult);
        }
        return baseModel;
    }
}
