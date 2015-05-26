package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import adapter.ContentListAdapter;
import myneihan.ming.com.myneihan.Constants;
import myneihan.ming.com.myneihan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentListFragment extends Fragment {
    /***
     * 显示的列表内容类型是什么
     */
    private  int type;
    public static  final int TYPE_RECOMMEND=1;
    public static final int TYPE_VIDEO=2;
    public static final int  TYPE_IMAGE=3;
    public static final int  TYPE_TEXT=4;

    public ContentListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_list, container, false);
       //类型参数的获取
        Bundle arguments=getArguments();
        if (arguments != null) {
          type= arguments.getInt(Constants.ARG_CONTENT_LIST_TYPE);

        }
        ListView listView=(ListView)view.findViewById(R.id.content_lsit_view);
        ContentListAdapter adapter=new ContentListAdapter();
        listView.setAdapter(adapter);
        return view;
    }
}
