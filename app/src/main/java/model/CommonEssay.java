package model;

/**
 * Created by Administrator on 2015/5/27.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 段子的公共部分数据，同时是文本段子。
 */
public class CommonEssay {

    private long onLineTime;
    private long displayTime;
    private long groupId;
    /**
     * 段子包含图片视频文本都是1
     */
    private int type;
    private List<Comment> comments;
    //一下就是段子基本信息
    private long createTime;
    //收藏数
    private int favoriteCount;
    //当前用户是否收藏
    private boolean userFavorite;
    //当前用户是否踩了
    private  boolean userBury;
    //踩数
    private int buryCount;
    private  boolean isCanShare;
    //评论数
    private int commentCount;
    //
    private  String shareUrl;
    private String content;
    //段子分类ID
    private int categoryType;
    /**
     * 分享数量
     */
    private int shareCount;
    //是否有评论
    private boolean hasComments;

    //添加用户部分
    //发表者
    private User user;
    /**
     * 当前 用户是否定过
     */
    private  boolean userDigg;
    //段子所属的分类名成
    private boolean categoryName;
    //猜测是热评
    private  int repinCount;
    //赞顶数
    private int diggCount;
    /***
     * 用户是否热评
     */
    private  boolean userRepin;

    ////////////////////////////////////////
    //解析部分
    public void parseJSON(JSONObject json){
        //todo 进行变量的解析
        if (json != null) {
            try {
                onLineTime=json.getLong("online_time");
                displayTime=json.getLong("display_time");
                type=json.getInt("type");
                //todo 处理grroup部分
                JSONObject group = json.getJSONObject("group");
                 groupId = group.getLong("group_id");
                content=group.getString("content");
               //解析内部的user信息
                //因为视频部分是没有用户的，因此这个地方使用opt
                JSONObject object= group.optJSONObject("user");
                if (object != null) {
                    user=new User();
                    user.parseJSON(object);
                }
                diggCount=group.getInt("digg_count");
                buryCount=group.getInt("bury_count");
                favoriteCount=group.getInt("favorite_count");
                shareCount=group.getInt("share_count");
                commentCount=group.getInt("comment_count");
                hasComments=group.getInt("has_comments")!=0;

                /////////////////////////////

                //处理评论comments
                if(hasComments){
                    comments=new LinkedList<>();
                    JSONArray array = json.getJSONArray("comments");
                    int len= array.length();
                    for (int i = 0; i <len ; i++) {
                        //遍历所有的评论
                        JSONObject jsonComment=array.getJSONObject(i);
                        Comment comment=new Comment();
                        comment.parseJSON(jsonComment);
                        comments.add(comment);

                    }
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    ///////////////////////////////////////


    public long getGroupId() {
        return groupId;
    }

    public long getOnLineTime() {
        return onLineTime;
    }

    public long getDisplayTime() {
        return displayTime;
    }

    public int getType() {
        return type;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public long getCreateTime() {
        return createTime;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public boolean isUserFavorite() {
        return userFavorite;
    }

    public boolean isUserBury() {
        return userBury;
    }

    public int getBuryCount() {
        return buryCount;
    }

    public boolean isCanShare() {
        return isCanShare;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public String getContent() {
        return content;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public int getShareCount() {
        return shareCount;
    }

    public boolean isHasComments() {
        return hasComments;
    }

    public User getUser() {
        return user;
    }

    public boolean isUserDigg() {
        return userDigg;
    }

    public boolean isCategoryName() {
        return categoryName;
    }

    public int getRepinCount() {
        return repinCount;
    }

    public int getDiggCount() {
        return diggCount;
    }

    public boolean isUserRepin() {
        return userRepin;
    }
}





























