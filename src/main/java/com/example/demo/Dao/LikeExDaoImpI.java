package com.example.demo.Dao;

//import com.github.yulichang.query.MPJQueryWrapper;
import com.example.demo.entity.LikeEx;
import com.example.demo.entity.LikeUser;
import com.example.demo.mapper.LikeExMapper;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class LikeExDaoImpI implements ILikeExDao {

    @Resource
    LikeExMapper likeExMapper;

    @Override
    public int addLikeEx(LikeEx likeEx) {
        System.out.println("LikeEx层的待添加的 : \t" + likeEx);
        var i = -1;
        i = likeExMapper.insert(likeEx);
        System.out.println("刚刚添加的记录:\t" + likeEx +"\n");
        return i;
    }


    @Override
    public int delLikeEx(LikeEx likeEx) {
        System.out.println("LikeEx层的待删除的: \t" + likeEx);
        var i = -1;
        i = likeExMapper.deleteById(likeEx);
        System.out.println("刚刚删除的记录:\t" + likeEx +"\n");
        return i;
    }

}
