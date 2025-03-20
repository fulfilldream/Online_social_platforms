package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Follow{

    private static final long serialVersionUID = 1L;

    //  关注ID
    private Integer id;

    //  用户ID
    private Integer userId;

    //  关注对象ID
    private Integer followUserId;

    private User user;

    private User followUser;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setFollowUserId(Integer followUserId){
        this.followUserId = followUserId;
    }

    public Integer getFollowUserId(){
        return followUserId;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getFollowUser(){
        return followUser;
    }

    public void setFollowUser(User followUser){
        this.followUser = followUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("followUserId", getFollowUserId())
            .toString();
    }
}
