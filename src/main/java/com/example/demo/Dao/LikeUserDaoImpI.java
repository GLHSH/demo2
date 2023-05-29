package com.example.demo.Dao;

//import com.github.yulichang.query.MPJQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.GoodEx;
import com.example.demo.entity.LikeEx;
import com.example.demo.entity.LikeUser;
import com.example.demo.mapper.LikeExMapper;
import com.example.demo.mapper.LikeUserMapper;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class LikeUserDaoImpI implements ILikeUserDao {

    @Resource
    LikeUserMapper likeUserMapper;

    @Override
    public int addLikeUser(LikeUser likeUser) {
        System.out.println("LikeUser层的待添加的 : \t" + likeUser);
        QueryWrapper<LikeUser> wrapper = new QueryWrapper<>(likeUser);
        val lu = likeUserMapper.selectOne(wrapper);
        var i = -1;
        if (lu == null){
            i = likeUserMapper.insert(likeUser);
            System.out.println("刚刚添加的记录:\t" + likeUser +"\n");
        }
        return i;
    }

    @Override
    public int delLikeUser(LikeUser likeUser) {
        System.out.println("LikeUser层的待删除的: \t" + likeUser);
        QueryWrapper<LikeUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", likeUser.getUserId());
        wrapper.eq("like_user_id", likeUser.getLikeUserId());
        return likeUserMapper.delete(wrapper);
    }

    @Override
    public LikeUser selectLike(LikeUser likeUser) {
        QueryWrapper<LikeUser> wrapper = new QueryWrapper<>(likeUser);
        return  likeUserMapper.selectOne(wrapper);
    }
}
