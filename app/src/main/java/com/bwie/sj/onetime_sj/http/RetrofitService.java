package com.bwie.sj.onetime_sj.http;

import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.bwie.sj.onetime_sj.bean.UserLogin;
import com.bwie.sj.onetime_sj.bean.CoHotBean;
import com.bwie.sj.onetime_sj.bean.ViHotBean;

import java.util.Map;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * retrofit的get  post请求
 * Created by Administrator on 2018/03/22.
 */

public interface RetrofitService {

    //登录   user/login?mobile=18201084287&password=123456
    @POST
    @FormUrlEncoded
    Call<UserLogin> userLogin(@Url String url, @FieldMap Map<String, String> params);

    //注册   quarter/register?mobile=13935906030&password=123456
    @POST
    @FormUrlEncoded
    Call<UserLogin> userReg(@Url String url, @FieldMap Map<String, String> params);

    //视频
    @POST("quarter/getVideos?source=android&appVersion=101")
    Call<CoHotBean> getVideoList(@Query("page") int page);

    //段子
    @POST("quarter/getJokes?source=android&appVersion=101")
    Call<JokeBean> getJokeList(@Query("page") int page);

    //段子https://www.zhaoapi.cn/quarter/getHotVideos?token=aaa&source=android&appVersion=101&page=1
    @POST("quarter/getJokes?token=aaa&source=android&appVersion=101")
    Call<ViHotBean> getViHotList(@Query("page") int page);

}
