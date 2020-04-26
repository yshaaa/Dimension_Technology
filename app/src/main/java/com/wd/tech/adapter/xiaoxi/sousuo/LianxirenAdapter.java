package com.wd.tech.adapter.xiaoxi.sousuo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.tech.R;
import com.wd.tech.activity.xiaoxi.sousuo.LianxirenKeyActivity;
import com.wd.tech.bean.xiaoxi.sousuo.LianxirenSearchBean;

import java.util.ArrayList;

/**
 * 功能：LianxirenAdapter类
 * 作者：闫圣豪
 * 当前日期：2020/4/25
 * 当前时间：16:38
 */
public class LianxirenAdapter extends RecyclerView.Adapter<LianxirenAdapter.Holder> {


    private final ArrayList<LianxirenSearchBean.ResultBean> list;
    private final LianxirenKeyActivity lianxirenKeyActivity;

    public LianxirenAdapter(ArrayList<LianxirenSearchBean.ResultBean> list, LianxirenKeyActivity lianxirenKeyActivity) {

        this.list = list;
        this.lianxirenKeyActivity = lianxirenKeyActivity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(lianxirenKeyActivity, R.layout.item_sousuo,null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(lianxirenKeyActivity).load(list.get(position).getHeadPic()).into(holder.iv);
        holder.name.setText(list.get(position).getNickName());
        holder.name1.setText(list.get(position).getNickName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView name,name1;
        public Holder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            name=itemView.findViewById(R.id.name);
            name1=itemView.findViewById(R.id.remark);
        }
    }
}
