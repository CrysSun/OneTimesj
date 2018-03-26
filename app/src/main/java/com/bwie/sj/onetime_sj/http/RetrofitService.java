package com.bwie.sj.onetime_sj.http;

import com.bwie.sj.onetime_sj.bean.GgBean;
import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.bwie.sj.onetime_sj.bean.VideoBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * retrofit的get  post请求
 * Created by Administrator on 2018/03/22.
 */

public interface RetrofitService {
    //视频
    @POST("quarter/getVideos?source=android&appVersion=101")
    Call<VideoBean> getVideoList();

    //段子
    @POST("quarter/getJokes?source=android&appVersion=101")
    Call<JokeBean> getJokeList();
    //关注    https://www.zhaoapi.cn/quarter/follow
//    @POST("quarter/follow?source=android&appVersion=101");
}
