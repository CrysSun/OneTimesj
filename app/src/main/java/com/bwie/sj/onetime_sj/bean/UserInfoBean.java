package com.bwie.sj.onetime_sj.bean;

/**
 * eventbus
 * Created by Administrator on 2018/03/31.
 */

public class UserInfoBean {
    private String uid;
    private String token;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoBean(String uid, String token) {

        this.uid = uid;
        this.token = token;
    }
}
