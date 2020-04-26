package com.wd.tech.adapter.zixun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.tech.R;
import com.wd.tech.bean.zixun.MyTongzhiBean;
import com.wd.tech.bean.zixun.My_TieziBean;

import java.text.SimpleDateFormat;
import java.util.List;

public class My_Tiezi_Adapter extends RecyclerView.Adapter<My_Tiezi_Adapter.Holder> {
    List<My_TieziBean.ResultBean.CommunityUserPostVoListBean> list;
    Context context;

    public My_Tiezi_Adapter(List<My_TieziBean.ResultBean.CommunityUserPostVoListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tiezi, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.content.setText(list.get(position).getContent());


//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        String format = simpleDateFormat.format(list.get(position).getCreateTime());
//        holder.time.setText(format+"");

        Glide.with(context).load(list.get(position).getFile()).into(holder.imageView);

        holder.zan_number.setText(list.get(position).getPraise()+"");
        holder.xx_number.setText(list.get(position).getComment()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView content,time,zan_number,xx_number;
        ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            content=itemView.findViewById(R.id.tiezi_comment);
            time=itemView.findViewById(R.id.tiezi_time);
            imageView=itemView.findViewById(R.id.tiezi_ima);
            zan_number=itemView.findViewById(R.id.zan_number);
            xx_number=itemView.findViewById(R.id.xx_number);
        }
    }




}
