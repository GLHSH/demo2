package com.example.demo.Dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Experience;
import com.example.demo.mapper.ExperienceMapper;
import com.github.yulichang.query.MPJQueryWrapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ExperienceDaoImpI implements IExperienceDao {
    @Resource
    ExperienceMapper experienceMapper;

    @Override
    public List<Experience> FindAll(String city) {
        QueryWrapper<Experience> wrapper = new QueryWrapper<>();
        if (city != null) {
            wrapper.like("city", city);
        }
        wrapper.eq("status","正常");
        return experienceMapper.selectList(wrapper);
    }
    @Override
    public List<Experience> SelectAllBySearch(String search) {
        QueryWrapper<Experience> wrapper = new QueryWrapper<>();
        wrapper.eq("status","正常")
                .like("title",search)
                .or()
                .like("text",search);
        return experienceMapper.selectList(wrapper);
    }

    @Override
    public int delExperience(Experience experience) {
        return experienceMapper.deleteById(experience);
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

    @Override
    public void addExperience(Experience experience) {
        if (experience.getId() != null ){
            experienceMapper.updateById(experience);
        } else {
            experienceMapper.insert(experience);
        }
    }

    @Override
    public int updateExperience(Experience experience) {
        UpdateWrapper<Experience> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", experience.getId())
                .set("good",experience.getGood() );

        return experienceMapper.update(null, updateWrapper);
    }
    @Override
    public int updateExperienceStar(Experience experience) {
        UpdateWrapper<Experience> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", experience.getId())
                .set("star",experience.getStar() );

        return experienceMapper.update(null, updateWrapper);
    }


}
