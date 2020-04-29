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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.tech.R;
import com.wd.tech.bean.zixun.ZixunBean;
import com.wd.tech.bean.zixun.Zixun_Pl_LiebiaoBean;

import java.text.SimpleDateFormat;
import java.util.List;

public class Zixun_pl_LiebiaoAdapter extends RecyclerView.Adapter<Zixun_pl_LiebiaoAdapter.Holder> {
    List<Zixun_Pl_LiebiaoBean.ResultBean> list;
    Context context;

    public Zixun_pl_LiebiaoAdapter(List<Zixun_Pl_LiebiaoBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zixun_pl_liebiao, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getHeadPic())
                .error(R.drawable.notnet)
                .placeholder(R.drawable.notnet)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(holder.imageView);


        holder.name.setText(list.get(position).getNickName());
        holder.content.setText(list.get(position).getContent());


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        String format = simpleDateFormat.format(list.get(position).getCommentTime());
        holder.time.setText(format+"");


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                liebiaoCallBack.onClick(position);
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView name,time,content;
        ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.zixun_Pl_Leibiao_name);
            time=itemView.findViewById(R.id.zixun_Pl_Leibiao_time);
            content=itemView.findViewById(R.id.zixun_Pl_Leibiao_content);
            imageView=itemView.findViewById(R.id.zixun_Pl_Leibiao_ima);
        }
    }

//    public interface LiebiaoCallBack{
//        void onClick(int position);
//    }
//
//    public LiebiaoCallBack liebiaoCallBack;
//
//    public void setLiebiaoCallBack(LiebiaoCallBack liebiaoCallBack){
//        this.liebiaoCallBack=liebiaoCallBack;
//    }


    public int sum(){
        int sum=0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getHeadPic().length(); j++) {
                sum++;
            }
        }
        return sum;
    }



}
