package model;

import android.content.res.Resources;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 * 图片段子的定义
 */
public class ImageEssay extends CommonEssay {
    /***
     * 图片最大能够显示的比例
     */
    private  float maxScreenWidthPercent;
    //图片最小能够显示屏幕的百分比
    private float minScreenWidthPercent;
    //保存大图的信息
    private List<ResourceInfo> largeImages;
    //小图信息
    private List<ResourceInfo> middleImages;
    //图片的状态
    private  int imageStatus;

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
        super.parseJSON(json);
    }

    ///////////////////////////////////////





}





































