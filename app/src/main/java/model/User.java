package model;

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

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
    }

    ///////////////////////////////////////


}
