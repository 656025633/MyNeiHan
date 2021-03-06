package fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.ContentListAdapter;
import client.ClientAPI;
import model.CommonEssay;
import model.EssayListData;
import model.ResponseData;
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
    private ContentListAdapter adapter;
    //用于adapter展现的lsit
    public List<CommonEssay> essayList;
    private ListView listView;
    //

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
        listView = (ListView)view.findViewById(R.id.content_lsit_view);
        essayList=new ArrayList<>();
        return view;
    }

    /***
     * Fragment显示
     *
     */
    @Override
    public void onResume() {
        super.onResume();
        EssayListTask task=new EssayListTask();
        String contentType=Constants.CONTENT_TYPE_ESSAY__RECOMMEND;
        switch (type){
            case TYPE_RECOMMEND:
                contentType=Constants.CONTENT_TYPE_ESSAY__RECOMMEND;
                break;
            case TYPE_VIDEO:
                contentType=Constants.CONTENT_TYPE_ESSAY_VIDEO;
                break;
            case TYPE_IMAGE:
                contentType=Constants.CONTENT_TYPE_ESSAY_IMAGE;
                break;
            case TYPE_TEXT:
                contentType=Constants.CONTENT_TYPE_ESSAY_TEXT;
                break;
        }
        task.execute(contentType,"30");

    }
    private class EssayListTask extends AsyncTask<String,Void,JSONObject>{
        @Override
        protected JSONObject doInBackground(String... params) {
            String contentType=Constants.CONTENT_TYPE_ESSAY__RECOMMEND;
            String count="30";
            if (params != null) {
                if(params.length>0){
                    //获取contentType
                    contentType=params[0];
                    if(params.length>1){
                        count=params[1];
                    }
                }
            }
            int cc=30;//实际请求返回数量
            try {
                cc=Integer.parseInt(count);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject=ClientAPI.getEssayList(contentType, cc);

            //todo 实际版本需要将JSONObject解析成实际的列表数据

            return jsonObject;
        }
        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            if (jsonObject != null) {
                try {
                    String message = jsonObject.getString("message");
                     Log.d("neihan","contetn"+message);
                    ResponseData responseData=new ResponseData();
                    responseData.parseJSON(jsonObject);
                    //解析网络回来的数据

                    //TODO 获取数据和更新UI
                    EssayListData data = responseData.getData();
                    Log.d("dataaaa",""+data);
                    if (data != null) {
                        //获取所有的段子信息
                        List<CommonEssay> data1 = data.getData();

                        //todo 显示段子列表
                            if(!data1.isEmpty()){
                                //把所有数据添加到最开始
                                for (int i = 0; i <data1.size() ; i++) {
                                   // Log.d("datacontent", "" + data1.get(i).getContent());
                                }
                                essayList.addAll(0,data1);
                                Log.d("aaaaaaaaaaaaa",data1.get(0).getUser()+"");
                                //adapter.notifyDataSetChanged();
                                adapter = new ContentListAdapter(getActivity(),essayList);
                                //
                                ContentListFragment.this.listView.setAdapter(adapter);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
