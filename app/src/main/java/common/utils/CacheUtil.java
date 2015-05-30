package common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2015/5/30.
 * 文件缓存的工具类，包含网址到文件名称的映射
 */
public final class CacheUtil {
    private CacheUtil(){

    }

    /**
     * 将网址映射成md5的字符串信息，确保唯一
     * @param url
     * @return
     */
    public static String md5(String url){
        String ret=null;
        if (url != null) {
            //针对数据进行的特定算法的处理，形成唯一的内容
            //每一个数据生成的内容都不同
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                //生成了url对应的唯一的信息
                byte[] data = digest.digest(url.getBytes());
                //todo 需要把data转为16进制
               ret=toHex(data);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 十六进制转换
     * @param data
     * @return
     */
    public static String toHex(byte[] data){
        String ret=null;
        if (data != null) {
            StringBuilder sb=new StringBuilder();
            for (byte b : data) {
                int h,l;
                //底四位
                l=b&0x0f;
                //高四位
                h=(b>>4)&0x0f;
                sb.append(Integer.toHexString(h));
                sb.append(Integer.toHexString(l));
            }
            ret=sb.toString();
            sb=null;
        }
        return ret;
    }
}
