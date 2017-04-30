package com.ajohn.saystr.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;

import org.xutils.common.util.LogUtil;
import org.xutils.x;

import java.io.Serializable;

//import com.alibaba.sdk.android.push.CloudPushService;
//import com.alibaba.sdk.android.push.CommonCallback;
//import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;

/**
 * Created by jnn on 2017/1/3.
 */
public class SayStrApplication extends MultiDexApplication implements Serializable {



    @Override
    public void onCreate() {
        super.onCreate();


        //xutils3.0初始化
        x.Ext.init(this);
        x.Ext.setDebug(true); //输出debug日志，开启会影响性能

        LogUtil.e("==============初始化推送==============");
        //阿里推送初始化
        initCloudChannel(this);
        LogUtil.e("==============结束初始化推送============");

        //初始化语音搜索
        // SpeechUtility.createUtility(context, SpeechConstant.APPID +"=58845eeb");

    }

    /**
     * 初始化云推送通道
     *
     * @param applicationContext
     */
    private void initCloudChannel(Context applicationContext) {
        PushServiceFactory.init(applicationContext);
        CloudPushService pushService = PushServiceFactory.getCloudPushService();


        pushService.register(applicationContext, new CommonCallback() {
            @Override
            public void onSuccess(String response) {
                LogUtil.e("==============初始化推送成功init cloudchannel success===============");
                //cloudPushService.getDeviceId();
            }

            @Override
            public void onFailed(String errorCode, String errorMessage) {
                LogUtil.e("===========初始化推送失败init cloudchannel failed -- errorcode:========" + errorCode + " -- errorMessage:" + errorMessage);
            }
        });
    }




}
