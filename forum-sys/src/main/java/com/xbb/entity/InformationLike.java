package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.Information;
import com.xbb.entity.User;

public class InformationLike{

    private static final long serialVersionUID = 1L;

    //  动态点赞ID
    private Integer id;

    //  动态ID
    private Integer informationId;

    //  用户ID
    private Integer userId;

    private Information information;

    private User user;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setInformationId(Integer informationId){
        this.informationId = informationId;
    }

    public Integer getInformationId(){
        return informationId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public Information getInformation(){
        return information;
    }

    public void setInformation(Information information){
        this.information = information;
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
            .append("informationId", getInformationId())
            .append("userId", getUserId())
            .toString();
    }
}
