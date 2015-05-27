package myneihan.ming.com.myneihan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adapter.TutorialAdapter;

/**
 * 引导页activity
 */
public class TutorialActivity extends ActionBarActivity implements View.OnClickListener {

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
            String versionName=packageInfo.versionName;
            Log.d("versionnum","++"+versionCode);
            Log.d("versionnum","++"+versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        SharedPreferences sp = getSharedPreferences(Constants.SP_NAME_APP,MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        //todo 根据版本进行存储
        edit.putBoolean(Constants.SP_KEY_SHOW_TUTORIAL+versionCode,true);
        edit.commit();
        //viewPager的设置
        ViewPager pager=(ViewPager)findViewById(R.id.tutorial_pager);
        List<Integer> images=new ArrayList<>();
        images.add(R.mipmap.bg_intros1);
        images.add(R.mipmap.bg_intros2);
        images.add(R.mipmap.bg_intros3);
        images.add(R.mipmap.bg_intros4);
        TutorialAdapter adapter = new TutorialAdapter(this, images);
        //设置最后一页按钮点击事件
        adapter.setGoNextOnClickListener(this);
        pager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}










































