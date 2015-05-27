package client;

import android.os.Build;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import common.utils.CommonHttpUtil;

/**
 * Created by Administrator on 2015/5/27.
 * 内涵段子网络请求的接口实现类
 */
public class ClientAPI {
    /**
     * 获取段子部分的接口,根据contentType累心，请求接口
     * @param contentType -101推荐  -104视频   -103图片  -102 段子
     * @return
     */
    public static JSONObject getEssayList(String contentType,int count){
       //1、拼网址、get请求
        //2.连网调用接口
        //3.生成json
        JSONObject ret=null;
        StringBuilder sb=new StringBuilder("http://ic.snssdk.com/neihan/stream/mix/v1/");
        //拼参数的部分
        sb.append("?content_type=").append(contentType);
        sb.append("&message_cursor=-1");
        try {
            sb.append("&city=").append(URLEncoder.encode("北京","utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append("&count=").append(count);
        //设置屏幕宽度的操作
        //todo 屏幕宽度需要上下文，需要单独分析
        sb.append("&screen_width=640");
        sb.append("&ac=wifi");
        sb.append("&channel=baidu2");
        sb.append("&aid=7");
        sb.append("&version_code=400");
        sb.append("&device_platform=android");
        sb.append("&device_type=KFTT");
        //andord手机sdk级别
        sb.append("&os_api=").append(Build.VERSION.SDK_INT);
        //版本号
        sb.append("&os_version=").append(Build.VERSION.RELEASE);
        //获取手机的唯一序列号，在androidapi9以上
        sb.append("&openudid=").append(Build.SERIAL);
        String url=sb.toString();
        //todo 连网
        byte[] data= new byte[0];
        try {
            data = CommonHttpUtil.getJsonString(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data != null) {
            try {
                String jsonStr=new String(data,"utf-8");
                ret=new JSONObject(jsonStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
