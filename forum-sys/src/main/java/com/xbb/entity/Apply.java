package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.User;
import com.xbb.entity.Groups;

public class Apply{

    private static final long serialVersionUID = 1L;

    //  小组加入ID
    private Integer id;

    //  用户ID
    private Integer userId;

    //  小组ID
    private Integer groupsId;

    private User user;

    private Groups groups;

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

    public void setGroupsId(Integer groupsId){
        this.groupsId = groupsId;
    }

    public Integer getGroupsId(){
        return groupsId;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Groups getGroups(){
        return groups;
    }

    public void setGroups(Groups groups){
        this.groups = groups;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("groupsId", getGroupsId())
            .toString();
    }
}
