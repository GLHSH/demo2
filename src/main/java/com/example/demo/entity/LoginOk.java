package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

public class LoginOk {
    User user;
    List<Experience> likeList;
    List<Experience> meExperienceList;
//    int fans;

    @Override
    public String toString() {
        return "LoginOk{" +
                "user=" + user +
                "\n, likeList=" + likeList +
                "\n, meExperienceList=" + meExperienceList +
                '}';
    }

    public LoginOk(User user, List<Experience> likeList, List<Experience> meExperienceList) {
        this.user = user;
        this.likeList = likeList;
        this.meExperienceList = meExperienceList;
//        this.fans = fans;
    }

    public LoginOk() {

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

    public void setLikeList(ArrayList<Experience> likeList) {
        this.likeList = likeList;
    }

    public List<Experience> getMeExperienceList() {
        return meExperienceList;
    }

    public void setMeExperienceList(ArrayList<Experience> meExperienceList) {
        this.meExperienceList = meExperienceList;
    }

//    public int getFans() {
//        return fans;
//    }
//
//    public void setFans(int fans) {
//        this.fans = fans;
//    }


}
