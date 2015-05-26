package adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2015/5/26.
 */
public class TutorialAdapter extends PagerAdapter {
    /**
     * 包含了那些图片要显示
     */
    private List<Integer> images;
    private Context context;
    //教程最后一页，增加一个按钮，按钮点击的事件回调
    private View.OnClickListener onClickListener;

    //alt+insert
    public TutorialAdapter(Context context, List<Integer> images) {
        this.context = context;
        this.images = images;
    }
    public void setGoNextOnClickListener(View.OnClickListener onClickListener){

    }

    @Override

    public int getCount() {
        int ret=0;
        if (images != null) {
            ret=images.size();
        }
        return ret;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     * 初始化对象
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret=null;
        //最后一个图片需要添加按钮
        if (position ==images.size()-1) {
            //创建布局，需要增加按钮点击事件
            FrameLayout frameLayout=new FrameLayout(context);
            ImageView imageVIew=new ImageView(context);
            imageVIew.setImageResource(images.get(position));
            frameLayout.addView(imageVIew);
            //设置imageview的排版的宽高：Layoutparams
            //放到哪个容器当中就是用哪一个容器的xxxLayout.layoutparams类
            //宽高匹配父容器
            FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            imageVIew.setLayoutParams(lp);
            //添加右下角的按钮，启动主页面
            Button btnGO=new Button(context);
            btnGO.setText("Go");

            //指定按钮所在位置是右下角
            FrameLayout.LayoutParams lp1=new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    Gravity.RIGHT|Gravity.BOTTOM

            );
            btnGO.setLayoutParams(lp1);
            frameLayout.addView(btnGO);
        //todo 点击事件
            //采用回调的形式，来避免代码写死业务逻辑
            btnGO.setOnClickListener(onClickListener);

            ret=frameLayout;
        }
        else
        {
            //创建图片 ImageView
            ImageView imageView=new ImageView(context);
            imageView.setImageResource(images.get(position));
            ret=imageView;
        }
        //todo 添加ret到container
        container.addView(ret);
        return ret;
    }

    /**
     * 销毁对象
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if(object instanceof  View){
            container.removeView((View)object);
        }
    }
}
