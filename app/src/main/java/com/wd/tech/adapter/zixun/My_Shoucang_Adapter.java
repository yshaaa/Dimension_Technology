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
import com.wd.tech.bean.zixun.My_ShoucangBean;
import com.wd.tech.bean.zixun.ZixunBean;

import java.text.SimpleDateFormat;
import java.util.List;

public class My_Shoucang_Adapter extends RecyclerView.Adapter<My_Shoucang_Adapter.Holder> {
    List<My_ShoucangBean.ResultBean> list;
    Context context;

    public My_Shoucang_Adapter(List<My_ShoucangBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shoucang, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getThumbnail())
                .error(R.drawable.notnet)
                .placeholder(R.drawable.notnet)
                .into(holder.imageView);


        holder.name.setText(list.get(position).getTitle());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(list.get(position).getCreateTime());
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
        TextView name,time;
        ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.my_shoucang_name);
            time=itemView.findViewById(R.id.my_shoucang_time);
            imageView=itemView.findViewById(R.id.my_shoucang_ima);
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
