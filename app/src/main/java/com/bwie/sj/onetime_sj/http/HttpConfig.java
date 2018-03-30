package com.bwie.sj.onetime_sj.http;

/**
 * 存放所有的接口--
 * Created by Administrator on 2018/03/09.
 */

public class HttpConfig {
    //公共
    public static String baseUrl = "https://www.zhaoapi.cn/";
    //登录
    public static String loginUrl = "user/login";

    public static String regUrl = "quarter/register";


    //1.广告接口   热门界面轮播图
    public static String advertiseUrl = "https://www.zhaoapi.cn/quarter/getAd";
    //source=android、appVersion=101 视频作品列表
    public static String videoUrl = "https://www.zhaoapi.cn/quarter/getVideos";
    //获取段子列表
    public static String jokesUrl = "https://www.zhaoapi.cn/quarter/getJokes";
}
