package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

public class LoginOk {
    User user;
    List<Experience> likeList;
    List<Experience> meExperienceList;

    List<User> meUserLikeList;

    List<User> fans;

    @Override
    public String toString() {
        return "LoginOk{" +
                "user=" + user +
                ", likeList=" + likeList +
                ", meExperienceList=" + meExperienceList +
                ", meUserLikeList=" + meUserLikeList +
                ", fans=" + fans +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Experience> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<Experience> likeList) {
        this.likeList = likeList;
    }

    public List<Experience> getMeExperienceList() {
        return meExperienceList;
    }

    public void setMeExperienceList(List<Experience> meExperienceList) {
        this.meExperienceList = meExperienceList;
    }

    public List<User> getMeUserLikeList() {
        return meUserLikeList;
    }

    public void setMeUserLikeList(List<User> meUserLikeList) {
        this.meUserLikeList = meUserLikeList;
    }

    public List<User> getFans() {
        return fans;
    }

    public void setFans(List<User> fans) {
        this.fans = fans;
    }

    public LoginOk(User user, List<Experience> likeList, List<Experience> meExperienceList, List<User> meUserLikeList, List<User> fans) {
        this.user = user;
        this.likeList = likeList;
        this.meExperienceList = meExperienceList;
        this.meUserLikeList = meUserLikeList;
        this.fans = fans;
    }
}
