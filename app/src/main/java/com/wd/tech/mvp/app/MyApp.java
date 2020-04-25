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
    public static IWXAPI mWxApi;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

        //腾讯Bugly
        CrashReport.initCrashReport(getApplicationContext(), "c9cb604460", false);

        //异常类的注册
        CrashHandler.getInstance().init(this);



        registToWX();
    }













    private void registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        mWxApi = WXAPIFactory.createWXAPI(this, "wx4c96b6b8da494224", false);
        // 将该app注册到微信
        mWxApi.registerApp("wx4c96b6b8da494224");
    }





}
