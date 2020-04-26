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
import com.wd.tech.bean.zixun.My_TieziBean;
import com.wd.tech.bean.zixun.My_jifenBean;

import java.text.SimpleDateFormat;
import java.util.List;

public class My_Jifen_Adapter extends RecyclerView.Adapter<My_Jifen_Adapter.Holder> {
    List<My_jifenBean.ResultBean> list;
    Context context;

    public My_Jifen_Adapter(List<My_jifenBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_jifen, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        int type = list.get(position).getType();

        Log.e("aaa",""+list.get(position).getType()+"");
        Log.e("aaa",""+list.get(position).getCreateTime()+"");
        Log.e("aaa",""+list.get(position).getAmount()+"");
        if(type==1){
            holder.name.setText("签到成功");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }else if(type==2){
            holder.name.setText("评论成功");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }else if(type==3){
            holder.name.setText("分享成功");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }else if(type==4){
            holder.name.setText("发帖成功");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }else if(type==5){
            holder.name.setText("抽奖收入");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }else if(type==6){
            holder.name.setText("付费资讯");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }else if(type==7){
            holder.name.setText("抽奖支出");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }else if(type==8){
            holder.name.setText("个人信息完善");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }else if(type==9){
            holder.name.setText("查看广告");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String format = simpleDateFormat.format(list.get(position).getCreateTime());
            holder.time.setText(format+"");

            holder.jia.setText(list.get(position).getAmount()+"");
        }





//        Glide.with(context).load(list.get(position).getFile()).into(holder.imageView);

//        holder.zan_number.setText(list.get(position).getPraise()+"");
//        holder.xx_number.setText(list.get(position).getComment()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView time,name,jia;
        ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.jifen_time);
            name=itemView.findViewById(R.id.jifen_name);
            jia=itemView.findViewById(R.id.jifen_jia);
        }
    }

    public int sum(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i).getAmount();
        }
        return sum;
    }




}
