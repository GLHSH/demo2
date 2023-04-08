package com.example.demo.Dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Experience;
import com.example.demo.entity.User;
import com.example.demo.mapper.ExperienceMapper;
import com.github.yulichang.query.MPJQueryWrapper;
import lombok.val;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ExperienceDaoImpI implements IExperienceDao {
    @Resource
    ExperienceMapper experienceMapper;

    @Override
    public List<Experience> SelectAllTest() {
        List<Experience> selectList = experienceMapper.selectList(null);
        System.out.println(selectList);
        return selectList;

    }

    @Override
    public List<Experience> selectMeExperience(int user_id) {
        System.out.println("查询所有记录的 User : " + user_id);
            QueryWrapper<Experience> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", user_id);
        return experienceMapper.selectList(queryWrapper);
    }

    @Override
    public List<Experience> selectLikeEx(int user_id) {
        MPJQueryWrapper wrapper = new MPJQueryWrapper<Experience>()
                .selectAll(Experience.class)
                .leftJoin("like_ex a on  a.experience_id = t.id ")
                .eq("a.user_id", user_id);
    //列表查询
        return experienceMapper.selectJoinList(Experience.class, wrapper);
    }
}
