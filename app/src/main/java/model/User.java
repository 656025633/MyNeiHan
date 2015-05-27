package model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2015/5/27.
 */
public class User {
    //是否关注
    private  boolean isFollowing;
    //头像地址
    private String avatarUrl;
    //是否加V
    private boolean verified;
    private  long userId;

    private String userName;

    public boolean isFollowing() {
        return isFollowing;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析

        if (json != null) {
            try {
                isFollowing=json.getBoolean("is_following");
                avatarUrl=json.getString("avatar_url");
                verified=json.getBoolean("user_verified");
                userName=json.getString("name");
                userId=json.getLong("user_id");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    ///////////////////////////////////////


}
