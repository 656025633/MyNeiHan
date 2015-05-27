package model;

import org.json.JSONObject;

/**
 * 从服务器返回的额总提对象
 * Created by Administrator on 2015/5/27.
 */
public class ResponseData {

    /**
     * message如果是success成功
     */
    private String message;
    private EssayListData data;


    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
    }

    ///////////////////////////////////////

}
