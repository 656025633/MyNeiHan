package model;

/**
 * Created by Administrator on 2015/5/27.
 */

import org.json.JSONException;
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
    private  long  createTime;
    //当前用户是否赞过
    private boolean isDigg;
    //用户名称
    private String userName;
    private String userProfileImagerUrl;


    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
        if (json != null) {
            try {
                userId=json.getLong("user_id");
                description=json.getString("description");
                text=json.getString("text");
                diggCount=json.getInt("digg_count");
                commentId=json.getLong("comment_id");
                userVerified=json.getBoolean("user_verified");
                platformId=json.getString("platform_id");
                avatarUrl=json.getString("avatar_url");
                createTime=json.getLong("create_time");
                isDigg=json.getInt("is_digg")!=0;
                userName=json.getString("user_name");
                userProfileImagerUrl=json.getString("user_profile_image_url");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }

    ///////////////////////////////////////
}























