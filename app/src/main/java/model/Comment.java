package model;

/**
 * Created by Administrator on 2015/5/27.
 */

import org.json.JSONObject;

/**
 * 评论部分
 */
public class Comment {
    private long userId;
    private String description;
    private  String text;
    private int diggCount;
    private long commentId;
    private boolean userVerified;
    private String platformId;
    private  String avatarUrl;
    private  long  CreateTime;
    //当前用户是否赞过
    private boolean isDigg;
    //用户名称
    private String userName;
    private String userProfileImagerUrl;


    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
    }

    ///////////////////////////////////////
}
