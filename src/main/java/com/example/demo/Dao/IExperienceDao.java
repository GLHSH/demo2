package com.example.demo.Dao;

import com.example.demo.entity.Experience;
import com.example.demo.entity.User;

import java.util.List;

public interface IExperienceDao {
    List<Experience> SelectAllTest();
    List<Experience> selectMeExperience(int user_id);
    List<Experience> selectLikeEx(int user_id);
}
