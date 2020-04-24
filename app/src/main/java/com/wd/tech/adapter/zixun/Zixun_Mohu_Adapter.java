package com.wd.tech.adapter.zixun;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.tech.R;
import com.wd.tech.bean.zixun.ZixunBean;
import com.wd.tech.bean.zixun.Zixun_MohuBean;

import java.text.SimpleDateFormat;
import java.util.List;

public class Zixun_Mohu_Adapter extends RecyclerView.Adapter<Zixun_Mohu_Adapter.Holder> {
    List<Zixun_MohuBean.ResultBean> list;
    Context context;

    public Zixun_Mohu_Adapter(List<Zixun_MohuBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zixun_mohu, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {


        holder.name.setText(list.get(position).getTitle());
        holder.summry.setText(list.get(position).getSource());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(list.get(position).getReleaseTime());
        holder.time.setText(format+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zixunCallBack.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView name,summry,time;
        ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.zixun_name);
            summry=itemView.findViewById(R.id.zixun_itb);
            time=itemView.findViewById(R.id.zixun_time);
        }
    }


    public interface ZixunCallBack{
        void onClick(int position);
    }

    public ZixunCallBack zixunCallBack;

    public void setZixunCallBack(ZixunCallBack zixunCallBack){
        this.zixunCallBack=zixunCallBack;
    }


}
