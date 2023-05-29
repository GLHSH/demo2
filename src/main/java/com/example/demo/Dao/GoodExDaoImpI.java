package com.example.demo.Dao;

//import com.github.yulichang.query.MPJQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.GoodEx;
import com.example.demo.entity.LikeEx;
import com.example.demo.mapper.GoodExMapper;
import com.example.demo.mapper.LikeExMapper;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class GoodExDaoImpI implements IGoodExDao {

    @Resource
    GoodExMapper goodExMapper;

    @Override
    public int addGoodEx(GoodEx goodEx) {
        System.out.println("GoodEx层的待添加的 : \t" + goodEx);
        var i = -1;
        val ex = selectLike(goodEx);
        if (ex == null){
            i = goodExMapper.insert(goodEx);
        }
        System.out.println("刚刚添加的记录:\t" + goodEx +"\n");
        return i;
    }


    @Override
    public int delGoodEx(GoodEx goodEx) {
        QueryWrapper<GoodEx> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", goodEx.getUserId())
                .eq("experience_id", goodEx.getExperienceId());
        val i = goodExMapper.delete(wrapper);
        System.out.println("刚刚删除的记录:\t" + goodEx +"\n 影响的行数 : "+i);
        return i;
    }

    @Override
    public GoodEx selectLike(GoodEx goodEx) {
        QueryWrapper<GoodEx> wrapper = new QueryWrapper<>();
        wrapper.eq("experience_id",goodEx.getExperienceId())
                .eq("user_id",goodEx.getUserId());
        return goodExMapper.selectOne(wrapper);
    }

}
