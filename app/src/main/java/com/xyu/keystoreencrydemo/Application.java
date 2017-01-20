package com.xyu.keystoreencrydemo;

/**
 * Created by xiongyu on 2017/1/20.
 */

public class Application extends android.app.Application {
    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }


    public static Application getApplication() {
        return application;
    }
}
