package com.bwie.sj.onetime_sj.http;

import android.net.Uri;

import com.bwie.sj.onetime_sj.bean.CreatBean;
import com.bwie.sj.onetime_sj.bean.JokeBean;
import com.bwie.sj.onetime_sj.bean.UserLogin;
import com.bwie.sj.onetime_sj.bean.CoHotBean;
import com.bwie.sj.onetime_sj.bean.ViHotBean;

import java.util.Map;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Field;
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

    //点赞  quarter/praise?source=android&appVersion=101&uid=12790&token=7AB84A69BF4A4174F939A40734060657&wid=282
    @POST("quarter/praise?source=android&appVersion=101")
    @FormUrlEncoded
    Call<CreatBean> likeJoke(@FieldMap Map<String, String> params);

    //上传头像 https://www.zhaoapi.cn/file/upload?uid=12790&token=7AB84A69BF4A4174F939A40734060657

    //发布作品7   uid=12790&token=7AB8
    // 4A69BF4A4174F939A40734060657&content=哈哈哈哈
    @POST("quarter/publishJoke?source=android&appVersion=101")
    @FormUrlEncoded
    Call<CreatBean> creatJoke(@FieldMap Map<String, String> params, @Query("jokeFiles") String jokeFiles);

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

    //段子file:///storage/emulated/0/Android/data/com.bwie.sj.onetime_sj/cache/output_image.jpg
    @POST("quarter/getJokes?source=android&appVersion=101")
    Call<JokeBean> getJokeList(@Query("page") int page);

    //视频热门https://www.zhaoapi.cn/quarter/getHotVideos?token=aaa&source=android&appVersion=101&page=1
    @POST("quarter/getJokes?source=android&appVersion=101")
    @FormUrlEncoded
    Call<ViHotBean> getViHotList(@Query("page") int page, @Field("token") String token);

}
