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
import com.wd.tech.bean.zixun.Zixun_XQBean;

import java.text.SimpleDateFormat;
import java.util.List;

public class Zixun_Xq_Adapter extends RecyclerView.Adapter<Zixun_Xq_Adapter.Holder> {
    List<Zixun_XQBean.ResultBean> list;
    Context context;

    public Zixun_Xq_Adapter(List<Zixun_XQBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zixun_xq, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getThumbnail())
                .error(R.drawable.notnet)
                .placeholder(R.drawable.notnet)
                .into(holder.imageView);

        Log.e("aaa","xq_ima"+list.get(position).getThumbnail());
        holder.name.setText(list.get(position).getTitle());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(list.get(position).getReleaseTime());
        holder.time.setText(format+"");

        holder.itb.setText(list.get(position).getSource());

        holder.content.setText(list.get(position).getComment()+"");



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView name,time,itb,content;
        ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.zixun_xq_name);
            time=itemView.findViewById(R.id.zixun_xq_time);
            itb=itemView.findViewById(R.id.zixun_xq_itb);
            content=itemView.findViewById(R.id.zixun_xq_content);
            imageView=itemView.findViewById(R.id.zixun_xq_ima);
        }
    }


//    public interface ZixunCallBack{
//        void onClick(int position);
//    }
//
//    public ZixunCallBack zixunCallBack;
//
//    public void setZixunCallBack(ZixunCallBack zixunCallBack){
//        this.zixunCallBack=zixunCallBack;
//    }


}
