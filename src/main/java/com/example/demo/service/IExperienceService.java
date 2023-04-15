package com.example.demo.service;

import com.example.demo.entity.Experience;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-14
 */
public interface IExperienceService extends IService<Experience> {
    List<Experience> SelectAllTest();
    List<Experience> selectMeExperience(int user_id);
    List<Experience> selectLikeEx(int user_id);

    void addExperience(Experience experience);
}
