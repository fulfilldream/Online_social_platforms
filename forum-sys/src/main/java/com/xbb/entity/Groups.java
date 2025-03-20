package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.User;

public class Groups{

    private static final long serialVersionUID = 1L;

    //  小组ID
    private Integer id;

    //  用户ID
    private Integer userId;

    //  名称
    private String name;

    //  标签
    private String label;

    //  展示图
    private String img;

    //  内容
    private String content;

    //  创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatTime;

    //  审核状态
    private Integer status;

    //  审核意见
    private String opinion;

    private User user;

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

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getImg(){
        return img;
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

    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return status;
    }

    public void setOpinion(String opinion){
        this.opinion = opinion;
    }

    public String getOpinion(){
        return opinion;
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
            .append("userId", getUserId())
            .append("name", getName())
            .append("label", getLabel())
            .append("img", getImg())
            .append("content", getContent())
            .append("creatTime", getCreatTime())
            .append("status", getStatus())
            .append("opinion", getOpinion())
            .toString();
    }
}
