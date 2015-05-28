package adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import model.CommonEssay;
import model.ImageEssay;
import model.MovieEssay;
import model.User;
import myneihan.ming.com.myneihan.R;
/**
 * Created by Administrator on 2015/5/26.
 * 内涵段子列表展现的adapter
 */
public class ContentListAdapter extends BaseAdapter {
    private List<CommonEssay> essayList;
    private LayoutInflater inflater;
    private Context context;
    public ContentListAdapter(Context context, List<CommonEssay> essayList) {
        this.context = context;
        this.essayList = essayList;
        if (context != null) {
            inflater = LayoutInflater.from(context);
        }
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (essayList != null) {
            ret = essayList.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position){
        Object ret = null;
        if (essayList != null) {
            ret = essayList.get(position);
        }
        return ret;
    }

    @Override
    public long getItemId(int position) {
        long ret = 0;
        if (essayList != null) {
            CommonEssay essay = essayList.get(position);
            ret = essay.getGroupId();
        }
        return ret;
    }
    /**
     *
     * @param position 第几个Item
     * @param convertView 对于当前的Item类型来说，能够复用的视图
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("ddddddd",""+position);
        View ret = null;
        CommonEssay essay = essayList.get(position);
        if (essay instanceof ImageEssay) {
            //todo 应该显示图片的内容
        }else if(essay instanceof MovieEssay){
            //TODO 应该显示视屏的内容
        }else{
            //TODO 应该显示文本的内容
        }
        //todo 简单的显示一段文本
        if(convertView!=null){
            ret = convertView;
        }else {
            convertView = inflater.inflate(R.layout.item_easy_essay, parent, false);
            ret = convertView;
        }
        TextViewHolder holder = (TextViewHolder) ret.getTag();
        if(holder==null){
            holder = new TextViewHolder();
            //holder
            holder.txtName = (TextView) ret.findViewById(R.id.item_essay_user_name);
            holder.txtContent = (TextView) ret.findViewById(R.id.item_essay_content);
            holder.txtDiggCount = (TextView) ret.findViewById(R.id.item_essay_digg_count);
            holder.txtBuryCount = (TextView) ret.findViewById(R.id.item_essay_bury_count);
            holder.txtCommentCount = (TextView) ret.findViewById(R.id.item_essay_comment_count);
            ret.setTag(holder);
        }
        else{
            holder = (TextViewHolder) ret.getTag();
        }
        User user  =essay.getUser();
        if (user != null) {
            String name = user.getUserName();
            holder.txtName.setText(name);
        }
        String content = essay.getContent();
        holder.txtContent.setText(content);
        String diggCount = essay.getDiggCount()+"";
        holder.txtDiggCount.setText(diggCount);
        String buryCount = essay.getBuryCount()+"";
        holder.txtBuryCount.setText(buryCount);
        String comentCount = essay.getCommentCount()+"";
        holder.txtCommentCount.setText(comentCount);
        return ret;
    }
    private class TextViewHolder{
        public ImageView imageHead;
        public TextView txtName;
        public TextView txtContent;
        public TextView txtDiggCount;
        public TextView txtBuryCount;
        public TextView txtCommentCount;
    }
}
