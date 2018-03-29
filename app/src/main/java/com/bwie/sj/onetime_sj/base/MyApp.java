package com.bwie.sj.onetime_sj.base;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/03/15.
 */

public class MyApp extends Application {
    {
        //友盟第三方登录
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化fresco
        Fresco.initialize(this);
        UMShareAPI.get(this);
        initImageLoader();
    }
    private void initImageLoader() {
        DisplayImageOptions o = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .writeDebugLogs()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .defaultDisplayImageOptions(o)
                .build();
        ImageLoader.getInstance().init(config);
    }

    //返回上下文
    public static Context getAppContext() {
        return getAppContext();
    }
}
