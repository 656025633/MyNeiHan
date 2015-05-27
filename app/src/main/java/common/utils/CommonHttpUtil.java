package common.utils;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/5/27.
 * 网络工具类
 */
public final class CommonHttpUtil {
    //避免创建
    private CommonHttpUtil(){

    }
    //
    public static byte[] getJsonString(String path) throws IOException
    {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setDoInput(true);
        if(conn.getResponseCode()==200)
        {
            InputStream in = conn.getInputStream();
            try {
                return readStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //get请求

    /**
     *
     * @param url 网址
     * @return
     */
    public static byte[] doGet(String url){
        byte[] ret=null;
        HttpGet request=new HttpGet(url);
        HttpClient client=new DefaultHttpClient();
        try {
            HttpResponse response=client.execute(request);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            Log.d("neihan", statusCode + "statusCode");
            if(statusCode==200){
                HttpEntity entity = response.getEntity();
                InputStream stream = entity.getContent();
               //返回的实际数据
                ret=readStream(stream);
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 进行网络post请求的方式，参数采用key value方式
     * @param url
     * @return
     */
    public static byte[] doPost(String url,HashMap<String,String> params){
        return null;
    }

    /**
     * 尽情put请求的方法，和post类似
     * @param url
     * @return
     */
    public static byte[]  doPut(String url,HashMap<String,String> params){

        return null;
    }

    /**
     * 进行delete请求的方法，实际的操作和get类似
     * @param url
     * @return
     */
    public static byte[] doDelete(String url){
        return null;
    }

    /**
     * 读取输入流，返回数据
     * @param stream
     * @return
     */
    public static byte[] readStream(InputStream stream) throws IOException{
        byte[] ret=null;

        ByteArrayOutputStream bout=null;
        byte[] buf=new byte[1024];
        bout=new ByteArrayOutputStream();
        int len;
        while(true){
            len=stream.read(buf);
            if(len==-1){
                break;
            }
            bout.write(buf,0,len);
        }
        //强制释放临时的资源
        buf=null;
        ret=bout.toByteArray();
        Log.d("neihan", ret + "readStream");
        bout.close();
        return ret;
    }
}







































