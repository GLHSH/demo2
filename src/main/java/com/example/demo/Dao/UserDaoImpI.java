package com.example.demo.Dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.BaseModel;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.github.yulichang.query.MPJQueryWrapper;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpI implements IUserDao {

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
    public void register(User user) {
        val baseModel = login(user);
        if (baseModel.getCode() == 0) {
            int insertResult = userMapper.insert(user);
            System.out.println("\n注册用户影响的MySQL数据库行数:" + insertResult + "");
        } else {
            baseModel.setCode(10);
            baseModel.setMessage("用户名已经存在");
        }
    }

    @Override
    public int update(User user) {
        val i = userMapper.updateById(user);
        System.out.println("UserDao层 after:\t" + user +"\n");
        return i;
    }

    @Override
    public List<User> selectLikeUser(int user_id) {
        MPJQueryWrapper<User> wrapper = new MPJQueryWrapper<User>()
                .select("t.id", "t.img_url", "t.nick_name")
                .leftJoin("like_user a on a.like_user_id = t.id ")
                .eq("a.user_id", user_id);
        //列表查询
        return userMapper.selectJoinList(User.class, wrapper);
    }
    @Override
    public List<User> selectFans(int user_id) {
        MPJQueryWrapper<User> wrapper = new MPJQueryWrapper<User>()
                .select("t.id", "t.img_url", "t.nick_name")
                .leftJoin("like_user a on a.user_id = t.id ")
                .eq("a.like_user_id", user_id);
        //列表查询
        return userMapper.selectJoinList(User.class, wrapper);
    }
}
