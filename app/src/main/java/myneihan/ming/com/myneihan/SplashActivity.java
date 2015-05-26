package myneihan.ming.com.myneihan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 启动扉页
 */
public class SplashActivity extends ActionBarActivity implements  Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取sharedpreference ，找一下是否系那是过引导教程
        SharedPreferences sp = getSharedPreferences(Constants.SP_NAME_APP,MODE_PRIVATE);
        int versionCode=1;
        PackageManager manager = getPackageManager();
        try {
            PackageInfo packageInfo = manager.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Boolean aBoolean=sp.getBoolean(Constants.SP_KEY_SHOW_TUTORIAL+versionCode,false);
        if(aBoolean){
            //
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent=new Intent(this,TutorialActivity.class);
            startActivity(intent);
            finish();
        }
    }
}









































