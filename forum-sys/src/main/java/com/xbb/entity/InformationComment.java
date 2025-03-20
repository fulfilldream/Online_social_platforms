package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.User;
import com.xbb.entity.Information;

public class InformationComment{

    private static final long serialVersionUID = 1L;

    //  动态评论ID
    private Integer id;

    //  用户ID
    private Integer userId;

    //  动态ID
    private Integer informationId;

    //  评论内容
    private String content;

    //  评论时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatTime;

    private User user;

    private Information information;

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

    public void setInformationId(Integer informationId){
        this.informationId = informationId;
    }

    public Integer getInformationId(){
        return informationId;
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

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Information getInformation(){
        return information;
    }

    public void setInformation(Information information){
        this.information = information;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("informationId", getInformationId())
            .append("content", getContent())
            .append("creatTime", getCreatTime())
            .toString();
    }
}
