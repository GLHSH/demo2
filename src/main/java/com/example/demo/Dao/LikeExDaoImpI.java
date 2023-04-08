package com.example.demo.Dao;

import com.example.demo.entity.Experience;
import com.example.demo.entity.LikeEx;
import com.example.demo.entity.User;
import com.example.demo.mapper.ExperienceMapper;
import com.example.demo.mapper.LikeExMapper;
//import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.query.MPJQueryWrapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class LikeExDaoImpI implements ILikeExDao {
    @Resource
    ExperienceMapper experienceMapper;


}
