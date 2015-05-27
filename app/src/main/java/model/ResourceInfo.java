package model;

import org.json.JSONObject;

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

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
    }

    ///////////////////////////////////////

}
