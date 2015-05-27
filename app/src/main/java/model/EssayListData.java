package model;

import org.json.JSONObject;

import java.util.List;

/**
 * 整体的段子列表对象
 * Created by Administrator on 2015/5/27.
 */
public class EssayListData {
    //是否有更多，点击加载更多
    private boolean hasMore;
    /**
     * 下一次加载数据(加载旧数据)使用的参数
     */
    private long maxTime;
    /**
     * 下一次刷新数据(加载新数据)使用的参数
     */
    private long minTime;
    /**
     * 提示信息
     */
    private String tip;
    /**
     * 是否有新消息
     */
    private  boolean hasNewMessage;
    /**
     * 实际的段子列表
     */
    private List<CommonEssay> data;


    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
    }

    ///////////////////////////////////////

}
