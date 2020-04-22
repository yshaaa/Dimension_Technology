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

import java.text.SimpleDateFormat;
import java.util.List;

public class ZixunAdapter extends RecyclerView.Adapter<ZixunAdapter.Holder> {
    List<ZixunBean.ResultBean> list;
    Context context;

    public ZixunAdapter(List<ZixunBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zixun, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getThumbnail())
                .error(R.drawable.notnet)
                .placeholder(R.drawable.notnet)
                .into(holder.imageView);

        holder.name.setText(list.get(position).getTitle());
        holder.summry.setText(list.get(position).getSummary());

        Log.e("aaa","详细文章"+list.get(position).getSummary());
        Log.e("aaa","头像"+list.get(position).getThumbnail());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(list.get(position).getReleaseTime());
        holder.time.setText(format+"");
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
            summry=itemView.findViewById(R.id.zixun_summary);
            time=itemView.findViewById(R.id.zixun_time);
            imageView=itemView.findViewById(R.id.zixun_ima);
        }
    }
}
