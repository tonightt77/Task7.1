package cn.itcase.duoxuan_danxuan;

import org.litepal.LitePalApplication;



public class  MyApplication extends LitePalApplication {

    public static final String TAG = "-----------";

    private static MyApplication singleton;


    public static MyApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;


    }


}
