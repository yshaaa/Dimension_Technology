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
import com.wd.tech.bean.zixun.My_ShoucangBean;

import java.text.SimpleDateFormat;
import java.util.List;

public class My_Tongzhi_Adapter extends RecyclerView.Adapter<My_Tongzhi_Adapter.Holder> {
    List<MyTongzhiBean.ResultBean> list;
    Context context;

    public My_Tongzhi_Adapter(List<MyTongzhiBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tongzhi, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.xinxi.setText(list.get(position).getContent());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(list.get(position).getCreateTime());
        holder.time.setText(format+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView xinxi,time;

        public Holder(@NonNull View itemView) {
            super(itemView);
            xinxi=itemView.findViewById(R.id.tongzhi_xinxi);
            time=itemView.findViewById(R.id.tongzi_time);
        }
    }




}
