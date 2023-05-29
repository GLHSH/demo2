package com.example.demo.Dao;

import com.example.demo.entity.Experience;

import java.util.List;

public interface IExperienceDao {
    List<Experience> FindAll(String city);
    List<Experience> selectMeExperience(int user_id);
    List<Experience> selectLikeEx(int user_id);

    void addExperience(Experience experience);

    int updateExperience(Experience experience);

    int updateExperienceStar(Experience experience);

    List<Experience> SelectAllBySearch(String search);

    int delExperience(Experience experience);
}
