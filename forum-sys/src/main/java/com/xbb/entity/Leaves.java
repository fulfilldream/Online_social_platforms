package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.User;

public class Leaves{

    private static final long serialVersionUID = 1L;

    //  私信ID
    private Integer id;

    //  用户ID
    private Integer userId;

    //  私信内容
    private String content;

    //  私信时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatTime;

    //  回复内容
    private String replyCon;

    //  回复时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date replyTime;

    //  私信对象ID
    private Integer staffId;

    private User user;

    private User staff;

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

    public void setReplyCon(String replyCon){
        this.replyCon = replyCon;
    }

    public String getReplyCon(){
        return replyCon;
    }

    public void setReplyTime(Date replyTime){
        this.replyTime = replyTime;
    }

    public Date getReplyTime(){
        return replyTime;
    }

    public void setStaffId(Integer staffId){
        this.staffId = staffId;
    }

    public Integer getStaffId(){
        return staffId;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getStaff(){
        return staff;
    }

    public void setStaff(User staff){
        this.staff = staff;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("creatTime", getCreatTime())
            .append("replyCon", getReplyCon())
            .append("replyTime", getReplyTime())
            .append("staffId", getStaffId())
            .toString();
    }
}
