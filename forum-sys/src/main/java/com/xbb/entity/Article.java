package com.xbb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbb.entity.User;
import com.xbb.entity.ArticleType;
import com.xbb.entity.Groups;

public class Article{

    private static final long serialVersionUID = 1L;

    //  文章ID
    private Integer id;

    //  标题
    private String title;

    //  内容
    private String content;

    //  摘要
    private String summary;

    //  发布者ID
    private Integer userId;

    //  发布时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatTime;

    //  展示图
    private String img;

    //  类型ID
    private Integer articleTypeId;

    //  浏览量
    private Integer readCount;

    //  收藏量
    private Integer collectCount;

    //  小组ID
    private Integer groupsId;

    //  审核状态
    private Integer status;

    //  审核意见
    private String opinion;

    //  点赞量
    private Integer likeCount;

    private User user;

    private ArticleType articleType;

    private Groups groups;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    public void setSummary(String summary){
        this.summary = summary;
    }

    public String getSummary(){
        return summary;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setCreatTime(Date creatTime){
        this.creatTime = creatTime;
    }

    public Date getCreatTime(){
        return creatTime;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getImg(){
        return img;
    }

    public void setArticleTypeId(Integer articleTypeId){
        this.articleTypeId = articleTypeId;
    }

    public Integer getArticleTypeId(){
        return articleTypeId;
    }

    public void setReadCount(Integer readCount){
        this.readCount = readCount;
    }

    public Integer getReadCount(){
        return readCount;
    }

    public void setCollectCount(Integer collectCount){
        this.collectCount = collectCount;
    }

    public Integer getCollectCount(){
        return collectCount;
    }

    public void setGroupsId(Integer groupsId){
        this.groupsId = groupsId;
    }

    public Integer getGroupsId(){
        return groupsId;
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

    public void setLikeCount(Integer likeCount){
        this.likeCount = likeCount;
    }

    public Integer getLikeCount(){
        return likeCount;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public ArticleType getArticleType(){
        return articleType;
    }

    public void setArticleType(ArticleType articleType){
        this.articleType = articleType;
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
                .append("title", getTitle())
                .append("content", getContent())
                .append("summary", getSummary())
                .append("userId", getUserId())
                .append("creatTime", getCreatTime())
                .append("img", getImg())
                .append("articleTypeId", getArticleTypeId())
                .append("readCount", getReadCount())
                .append("collectCount", getCollectCount())
                .append("groupsId", getGroupsId())
                .append("status", getStatus())
                .append("opinion", getOpinion())
                .append("likeCount", getLikeCount())
                .toString();
    }
}
