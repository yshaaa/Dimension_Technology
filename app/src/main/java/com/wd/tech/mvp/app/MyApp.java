package com.wd.tech.mvp.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/**
 * 功能：ApiService类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：11:56
 */

public class MyApp extends Application {
    public static IWXAPI mWxApi;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        registToWX();
    }
    private void registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        mWxApi = WXAPIFactory.createWXAPI(this, "wx4c96b6b8da494224", false);
        // 将该app注册到微信
        mWxApi.registerApp("wx4c96b6b8da494224");
    }

}
