package com.bawei.applocation;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //默认图片设置
        ImageLoaderConfiguration con = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(con);
    }
}
