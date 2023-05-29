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
 * @since 2023-04-14
 */
@Service
public class ExperienceServiceImpl extends ServiceImpl<ExperienceMapper, Experience> implements IExperienceService {
    @Resource
    IExperienceDao experienceDao;

    @Override
    public List<Experience> SelectAllTest(String city) {
        return experienceDao.FindAll(city);
    }

    @Override
    public List<Experience> SelectAllBySearch(String search) {
        return experienceDao.SelectAllBySearch(search);
    }

    @Override
    public List<Experience> selectMeExperience(int user_id) {
        return experienceDao.selectMeExperience(user_id);
    }

    @Override
    public List<Experience> selectLikeEx(int user_id) {
        return experienceDao.selectLikeEx(user_id);
    }

    @Override
    public void addExperience(Experience experience) {
        experienceDao.addExperience(experience);
    }

    @Override
    public int updateExperience(Experience experience) {
        return experienceDao.updateExperience(experience);
    }

    @Override
    public int updateExperienceStar(Experience experience) {
        return experienceDao.updateExperienceStar(experience);
    }

    @Override
    public int delExperience(Experience experience) {
        return experienceDao.delExperience(experience);
    }
}
