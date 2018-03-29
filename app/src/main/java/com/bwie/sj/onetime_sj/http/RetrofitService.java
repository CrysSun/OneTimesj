package com.bwie.sj.onetime_sj.http;

import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.bwie.sj.onetime_sj.bean.UserLogin;
import com.bwie.sj.onetime_sj.bean.CoHotBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * retrofit的get  post请求
 * Created by Administrator on 2018/03/22.
 */

public interface RetrofitService {

    //登录   user/login?mobile=18201084287&password=123456
    @POST("user/login")
    Call<UserLogin> userLogin(@Query("modile") String userPhone, @Query("password") String userPwd);

    //视频
    @POST("quarter/getVideos?source=android&appVersion=101")
    Call<CoHotBean> getVideoList(@Query("page") int page);

    //段子
    @POST("quarter/getJokes?source=android&appVersion=101")
    Call<JokeBean> getJokeList(@Query("page") int page);

    //关注    https://www.zhaoapi.cn/quarter/follow
//    @POST("quarter/follow?source=android&appVersion=101");
}
