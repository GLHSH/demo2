package com.example.demo.Dao;

//import com.github.yulichang.query.MPJQueryWrapper;
import com.example.demo.entity.LikeEx;
import com.example.demo.entity.LikeUser;
import com.example.demo.mapper.LikeExMapper;
import com.example.demo.mapper.LikeUserMapper;
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
            var i = -1;
            i = likeUserMapper.insert(likeUser);
            System.out.println("刚刚添加的记录:\t" + likeUser +"\n");
            return i;
    }

    @Override
    public int delLikeUser(LikeUser likeUser) {
        System.out.println("LikeUser层的待删除的: \t" + likeUser);
        var i = likeUserMapper.deleteById(likeUser);
        System.out.println("刚刚删除的记录:\t" + likeUser +"\n");
        return i;
    }
}
