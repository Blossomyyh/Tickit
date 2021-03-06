package com.example.ricardo.tickit2.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ricardo on 2018/1/3.
 */

public class TicketFieldDto {
    @SerializedName("_showID")
    @Expose
    private String showID;
    @SerializedName("_studentID")
    @Expose
    private String studentID;
    @SerializedName("_orderStatus")
    @Expose
    private Integer orderStatus;
    @SerializedName("_actualPrice")
    @Expose
    private Integer actualPrice;
    @SerializedName("_createTime")
    @Expose
    private String createTime;
    @SerializedName("_showName")
    @Expose
    private String showName;
    @SerializedName("_showDescription")
    @Expose
    private String showDescription;
    @SerializedName("_showAvatar")
    @Expose
    private String showAvatar;

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Integer actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowDescription() {
        return showDescription;
    }

    public void setShowDescription(String showDescription) {
        this.showDescription = showDescription;
    }

    public String getShowAvatar() {
        return showAvatar;
    }

    public void setShowAvatar(String showAvatar) {
        this.showAvatar = showAvatar;
    }



}
