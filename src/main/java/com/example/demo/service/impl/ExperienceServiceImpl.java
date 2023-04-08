package com.example.demo.service.impl;

import com.example.demo.Dao.IExperienceDao;
import com.example.demo.entity.Experience;
import com.example.demo.mapper.ExperienceMapper;
import com.example.demo.service.IExperienceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-03-30
 */
@Service
public class ExperienceServiceImpl extends ServiceImpl<ExperienceMapper, Experience> implements IExperienceService {

    @Resource
    IExperienceDao experienceDao;

    @Override
    public List<Experience> SelectAllTest() {
        return experienceDao.SelectAllTest();
    }

    @Override
    public List<Experience> selectMeExperience(int user_id) {
        return experienceDao.selectMeExperience(user_id);
    }

    @Override
    public List<Experience> selectLikeEx(int user_id) {
        return experienceDao.selectLikeEx(user_id);
    }
}
