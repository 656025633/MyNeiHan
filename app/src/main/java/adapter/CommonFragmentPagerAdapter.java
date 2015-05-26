package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/5/26.
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    public CommonFragmentPagerAdapter(FragmentManager manager,List<Fragment> fragments){
        super(manager);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment ret=null;
        if (fragments != null) {
            ret=fragments.get(position);
        }
        return ret;
    }

    @Override
    public int getCount() {
        int ret=0;
        if (fragments.size()>0){
            ret=fragments.size();
        }
        return ret;
    }
}
