package com.wd.tech.mvp.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wd.tech.CrashHandler;

/**
 * 功能：ApiService类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：11:56
 */

public class MyApp extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

        //腾讯Bugly
        CrashReport.initCrashReport(getApplicationContext(), "c9cb604460", false);

        //异常类的注册
        CrashHandler.getInstance().init(this);
    }


}
