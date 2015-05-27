package model;

import org.json.JSONObject;

/**
 * Created by Administrator on 2015/5/27.
 * 视频段子部分
 */
public class MovieEssay extends  CommonEssay{
    private  ResourceInfo video360p;
    private String mp4Url;
    private ResourceInfo video720p;
    private String  keyword;
    private  ResourceInfo video480p;
    //视频的时长
    private  int duration;
    /**
     * 是苹果的视频播放器使用的一种播放列表用于流媒体的播放
     */
    private String m3u8Url;
    //视频封面
    private ResourceInfo largeCover;
    //视频的标题
    private String title;
    //原始视频
    private ResourceInfo originVideo;
    //视频的高度
    private int videoHeight;
    private String publishTime;
    //播放次数
    private int playCount;
    private int videoWidth;
    //flash的视频网址
    private String flashUrl;
    /**
     * 封面图像的唯一地址
     */
    private String coverImageUrl;
    //视频
    private boolean isVideo;



    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
        super.parseJSON(json);
    }

    ///////////////////////////////////////


}



















