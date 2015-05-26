package myneihan.ming.com.myneihan;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import fragment.HomeFragment;

/**
 *
 */

public class MainActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener {

    private HomeFragment home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        //

        home = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.main_fragmnet_container, home);
        transaction.commit();

        //RadioGroup的选中事件，
        RadioGroup group=(RadioGroup)findViewById(R.id.main_tab_bar);
        group.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.tab_home:
                //todo 点击切换到主界面
                break;
            case R.id.tab_discover:
                //todo 切换到发现
                break;
            case R.id.tab_message:
                //todo 切换到消息
                break;
        }
    }
}
