package myneihan.ming.com.myneihan;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import adapter.TutorialAdapter;

/**
 * 引导页activity
 */
public class TutorialActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        //todo 保存当前版本的引导页已经显示了
        PackageManager manager = getPackageManager();
        //获取清单文件中versioncode
        int versionCode=1;
        try {
            PackageInfo packageInfo = manager.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        SharedPreferences sp = getSharedPreferences(Constants.SP_NAME_APP,MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        //todo 根据版本进行存储
        edit.putBoolean("show.tutorial"+versionCode,true);
        edit.commit();
        //viewPager的设置
        ViewPager pager=(ViewPager)findViewById(R.id.tutorial_pager);
        pager.setAdapter(new TutorialAdapter());

    }
}










































