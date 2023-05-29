package com.example.demo.Dao;

//import com.github.yulichang.query.MPJQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.LikeEx;
import com.example.demo.mapper.LikeExMapper;
import lombok.val;
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
        val ex = selectLike(likeEx);
        if (ex == null){
            i = likeExMapper.insert(likeEx);
        }
        System.out.println("刚刚添加的记录:\t" + likeEx +"\n");
        return i;
    }


    @Override
    public int delLikeEx(LikeEx likeEx) {
        QueryWrapper<LikeEx> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", likeEx.getUserId())
                .eq("experience_id", likeEx.getExperienceId());
        val i = likeExMapper.delete(wrapper);
        System.out.println("刚刚删除的记录:\t" + likeEx +"\n 影响的行数 : "+i);
        return i;
    }

    @Override
    public LikeEx selectLike(LikeEx likeEx) {
        QueryWrapper<LikeEx> wrapper = new QueryWrapper<>();
        wrapper.eq("experience_id",likeEx.getExperienceId())
                .eq("user_id",likeEx.getUserId());
        return  likeExMapper.selectOne(wrapper);
    }

}
