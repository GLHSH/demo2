package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-16
 */
public class Comment implements Serializable {


    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String text;

    private String time;

    private Integer userId;

    private Integer experienceId;

    private String userNickname;
    private String userImgurl;

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    private Integer good;

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserImgurl() {
        return userImgurl;
    }

    public void setUserImgurl(String userImgurl) {
        this.userImgurl = userImgurl;
    }

    @TableField(exist = false)
    private List<Reply> replyList =new ArrayList<>();

    public void addReplyItem(Reply reply) {
        replyList.add(reply);
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }


    @Override
    public String toString() {
        return "\nComment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", userId=" + userId +
                ", experienceId=" + experienceId +
                ", userNickname='" + userNickname + '\'' +
                ", userImgurl='" + userImgurl + '\'' +
                ", good=" + good +
                '}';
    }
}
