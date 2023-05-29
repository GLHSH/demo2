package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-16
 */
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String text;

    private Integer experienceId;

    private Integer commentId;

    private Integer userId;

    private Integer user2Id;

    private String time;

    private String user1Nickname;
    private String user1Imgurl;

    public String getUser1Nickname() {
        return user1Nickname;
    }

    public void setUser1Nickname(String userNickname) {
        this.user1Nickname = userNickname;
    }

    public String getUser1Imgurl() {
        return user1Imgurl;
    }

    public void setUser1Imgurl(String userImgurl) {
        this.user1Imgurl = userImgurl;
    }

    private String user2Nickname;
    private String user2Imgurl;

    private Integer good;

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public String getUser2Nickname() {
        return user2Nickname;
    }

    public void setUser2Nickname(String userNickname) {
        this.user2Nickname = userNickname;
    }

    public String getUser2Imgurl() {
        return user2Imgurl;
    }

    public void setUser2Imgurl(String userImgurl) {
        this.user2Imgurl = userImgurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", experienceId=" + experienceId +
                ", commentId=" + commentId +
                ", userId=" + userId +
                ", userId2='" + user2Id + '\'' +
                ", time=" + time +
                ", user1Nickname='" + user1Nickname + '\'' +
                ", user1Imgurl='" + user1Imgurl + '\'' +
                ", user2Nickname='" + user2Nickname + '\'' +
                ", user2Imgurl='" + user2Imgurl + '\'' +
                ", good=" + good +
                '}';
    }
}
