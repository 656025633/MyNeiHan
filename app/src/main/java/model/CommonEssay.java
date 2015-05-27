package model;

/**
 * Created by Administrator on 2015/5/27.
 */

import org.json.JSONObject;

import java.util.List;

/**
 * 段子的公共部分数据，同时是文本段子。
 */
public class CommonEssay {
    private long groupId;
    private long onLineTime;
    private long displayTime;
    /**
     * 段子包含图片视频文本都是1
     */
    private int type;
    private List<Comment> comments;
    //一下就是段子基本信息
    private long createTime;
    //收藏数
    private int favoriteCount;
    //当前用户是否收藏
    private boolean userFavorite;
    //当前用户是否踩了
    private  boolean userBury;
    //踩数
    private int buryCount;
    private  boolean isCanShare;
    //评论数
    private int commentCount;
    //
    private  String shareUrl;
    private String content;
    //段子分类ID
    private int categoryType;
    /**
     * 分享数量
     */
    private int shareCount;
    //是否有评论
    private boolean hasComments;

    //添加用户部分
    //发表者
    private User user;
    /**
     * 当前 用户是否定过
     */
    private  boolean userDigg;
    //段子所属的分类名成
    private boolean categoryName;
    //猜测是热评
    private  int repinCount;
    //赞顶数
    private int diggCount;
    /***
     * 用户是否热评
     */
    private  boolean userRepin;

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
    }

    ///////////////////////////////////////









}





























