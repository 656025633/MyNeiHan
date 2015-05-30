package model;

import android.content.res.Resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/27.
 * 图片段子的定义
 */
public class ImageEssay extends CommonEssay {
    /***
     * 图片最大能够显示的比例
     */
    private  double maxScreenWidthPercent;
    //图片最小能够显示屏幕的百分比
    private double minScreenWidthPercent;
    //保存大图的信息
    private List<ResourceInfo> largeImages;
    //小图信息
    private List<ResourceInfo> middleImages;
    //图片的状态
    private  int imageStatus;

    public double getMaxScreenWidthPercent() {
        return maxScreenWidthPercent;
    }

    public double getMinScreenWidthPercent() {
        return minScreenWidthPercent;
    }

    public int getImageStatus() {
        return imageStatus;
    }

    public List<ResourceInfo> getLargeImages() {
        return largeImages;

    }

    public List<ResourceInfo> getMiddleImages() {
        return middleImages;
    }

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
        super.parseJSON(json);
        //进行图片部分的解析
        //json对象，是完整的端子的数据结构
        maxScreenWidthPercent=json.optDouble("max_screen_width_percent",0.6);
        minScreenWidthPercent=json.optDouble("min_screen_width_percent",0.167);

        try {
            //上一级是data，先解析group
            JSONObject group=json.getJSONObject("group");

            //解析大图片
            largeImages=new LinkedList<>();
            JSONObject object=group.getJSONObject("large_image");
            ResourceInfo largeImage=new ResourceInfo();
            largeImage.parseJSON(object);
            largeImages.add(largeImage);
            //////

            imageStatus=group.getInt("image_status");

            //小图片
            JSONObject middleImage = group.getJSONObject("middle_image");
            middleImages=new LinkedList<>();
            largeImage=new ResourceInfo();
            largeImage.parseJSON(middleImage);
            middleImages.add(largeImage);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////
}





































