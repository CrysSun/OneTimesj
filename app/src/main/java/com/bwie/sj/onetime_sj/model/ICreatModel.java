package com.bwie.sj.onetime_sj.model;

import android.net.Uri;

import java.io.File;

/**
 * Created by Administrator on 2018/03/30.
 */

public interface ICreatModel {
    //登录
    void getCreatjoke(Uri jokeFiles, String url, String uid, String token, String content, GetDataListener getDataListener);

}
