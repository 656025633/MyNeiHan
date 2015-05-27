package model;

import org.json.JSONException;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EssayListData getData() {
        return data;
    }

    public void setData(EssayListData data) {
        this.data = data;
    }

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析

        try {
            message=json.getString("message");
            //创建对象 对象自己解析json
            data=new EssayListData();
            JSONObject d=json.getJSONObject("data");
            data.parseJSON(d);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    ///////////////////////////////////////

}
