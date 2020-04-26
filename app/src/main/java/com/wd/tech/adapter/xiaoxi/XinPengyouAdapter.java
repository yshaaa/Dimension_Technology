package com.wd.tech.adapter.xiaoxi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.tech.R;
import com.wd.tech.activity.xiaoxi.XinPengyouActivity;
import com.wd.tech.bean.xiaoxi.sousuo.XinPengyouBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * 功能：XinPengyouAdapter类
 * 作者：闫圣豪
 * 当前日期：2020/4/25
 * 当前时间：22:46
 */
public class XinPengyouAdapter extends RecyclerView.Adapter<XinPengyouAdapter.Holder> {


    private final ArrayList<XinPengyouBean.ResultBean> list;
    private final XinPengyouActivity xinPengyouActivity;

    public XinPengyouAdapter(ArrayList<XinPengyouBean.ResultBean> list, XinPengyouActivity xinPengyouActivity) {

        this.list = list;
        this.xinPengyouActivity = xinPengyouActivity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(xinPengyouActivity, R.layout.item_xinpengyou,null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(xinPengyouActivity).load(list.get(position).getFromHeadPic()).into(holder.image);
        holder.name.setText(list.get(position).getFromNickName());
        holder.beizhu.setText("备注："+list.get(position).getRemark());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd mm:ss");
        holder.time.setText(simpleDateFormat.format(list.get(position).getNoticeTime())+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView time,name,beizhu;
        public Holder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_head);
            name=itemView.findViewById(R.id.name);
            beizhu=itemView.findViewById(R.id.beizhu);
            time=itemView.findViewById(R.id.time);
        }
    }
}
