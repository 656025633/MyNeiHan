package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.CommonFragmentPagerAdapter;
import myneihan.ming.com.myneihan.Constants;
import myneihan.ming.com.myneihan.R;
/**
 * A simple {@link Fragment} subclass.
 * 整个应用程序首页部分，内部包含viewpager显示不同的列表
 */
public class HomeFragment extends Fragment {
    private View indicator;
    private LinearLayout titleContainer;

    public HomeFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =   inflater.inflate(R.layout.fragment_home, container, false);
        //进行各种内容设置
        //1，获取分类内容
        indicator = view.findViewById(R.id.home_category_indicator);
        titleContainer = (LinearLayout) view.findViewById(R.id.home_category_titles);
        //TODO 获取LinearLayout内部的TextView制定的点击事件
        //2，获取ViewPager 设置分类的列表
        ViewPager pager = (ViewPager) view.findViewById(R.id.home_pager);

        List<Fragment> fragments = new ArrayList<>();
        //加载推荐
        ContentListFragment fragment = new ContentListFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ARG_CONTENT_LIST_TYPE,ContentListFragment.TYPE_RECOMMEND);
        fragment.setArguments(args);
        fragments.add(fragment);
        // 加载视屏
        fragment = new ContentListFragment();
        Bundle args1 = new Bundle();
        args.putInt(Constants.ARG_CONTENT_LIST_TYPE, ContentListFragment.TYPE_VIDEO);
        fragment.setArguments(args1);
        fragments.add(fragment);
        // 加载图片
        fragment = new ContentListFragment();
        Bundle args2 = new Bundle();
        args.putInt(Constants.ARG_CONTENT_LIST_TYPE, ContentListFragment.TYPE_IMAGE);
        fragment.setArguments(args2);
        fragments.add(fragment);
        // 加载文本
        fragment = new ContentListFragment();
        Bundle args3 = new Bundle();
        args.putInt(Constants.ARG_CONTENT_LIST_TYPE, ContentListFragment.TYPE_TEXT);
        fragment.setArguments(args3);
        fragments.add(fragment);
        //!!!!!!
        //如果在Fragment内部使用，ViewPager，这个ViewPager又需要加载Fragment
        //那么FragmentPagerAdapter在构造的时候，必须指定getChildFragmentManager
        CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(getChildFragmentManager(),
                fragments );
        pager.setAdapter(adapter);

        return view;
    }
}