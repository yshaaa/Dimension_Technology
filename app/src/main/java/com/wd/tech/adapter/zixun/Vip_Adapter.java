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
import com.wd.tech.bean.zixun.VipBean;
import com.wd.tech.bean.zixun.ZixunBean;

import java.text.SimpleDateFormat;
import java.util.List;
//123

public class Vip_Adapter extends RecyclerView.Adapter<Vip_Adapter.Holder> {
    List<VipBean.ResultBean> list;
    Context context;

    public Vip_Adapter(List<VipBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vip, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getImageUrl())
                .error(R.drawable.notnet)
                .placeholder(R.drawable.notnet)
                .into(holder.imageView);


        holder.name.setText(list.get(position).getCommodityName());





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
        TextView name;
        ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.vip_name);
            imageView=itemView.findViewById(R.id.vip_ima);
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
