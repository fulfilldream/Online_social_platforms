package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.Groups;
import com.xbb.entity.User;

public class GroupsComment{

    private static final long serialVersionUID = 1L;

    //  小组交流ID
    private Integer id;

    //  小组ID
    private Integer groupsId;

    //  用户ID
    private Integer userId;

    //  交流内容
    private String content;

    //  交流时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatTime;

    //  类型
    private Integer types;

    private Groups groups;

    private User user;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setGroupsId(Integer groupsId){
        this.groupsId = groupsId;
    }

    public Integer getGroupsId(){
        return groupsId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public void setCreatTime(Date creatTime){
        this.creatTime = creatTime;
    }

    public Date getCreatTime(){
        return creatTime;
    }

    public void setTypes(Integer types){
        this.types = types;
    }

    public Integer getTypes(){
        return types;
    }

    public Groups getGroups(){
        return groups;
    }

    public void setGroups(Groups groups){
        this.groups = groups;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupsId", getGroupsId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("creatTime", getCreatTime())
            .append("types", getTypes())
            .toString();
    }
}
