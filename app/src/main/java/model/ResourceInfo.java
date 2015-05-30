package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 * 描述图片和视频的资源信息
 */
public class ResourceInfo {
    private int width;
    private int height;
    private  String uri;
    private List<String> urlList;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUri() {
        return uri;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
        if (json != null) {
            width=json.optInt("width");
            height=json.optInt("height");
            try {
                uri=json.getString("uri");
                JSONArray array=json.getJSONArray("url_list");
                int len= array.length();
                urlList=new ArrayList<>();
                for (int i = 0; i <len ; i++) {
                    JSONObject jsonObject=array.getJSONObject(i);
                    String url=jsonObject.getString("url");
                    urlList.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    ///////////////////////////////////////

}
