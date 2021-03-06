package com.example.ricardo.tickit2.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ricardo on 2017/11/28.
 */

public class FieldDto {
    @SerializedName("_nickname")
    @Expose
    private String nickname;
    @SerializedName("_realName")
    @Expose
    private String realName;
    @SerializedName("_password")
    @Expose
    private String password;
    @SerializedName("_email")
    @Expose
    private Object email;
    @SerializedName("_isSuperuser")
    @Expose
    private Boolean isSuperuser;
    @SerializedName("_isAdmin")
    @Expose
    private Boolean isAdmin;
    @SerializedName("_mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("_avatar")
    @Expose
    private String avatar;
    @SerializedName("_vipPoint")
    @Expose
    private Integer vipPoint;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getVipPoint() {
        return vipPoint;
    }

    public void setVipPoint(Integer vipPoint) {
        this.vipPoint = vipPoint;
    }

}
