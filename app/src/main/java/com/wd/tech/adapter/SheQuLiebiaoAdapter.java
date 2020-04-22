package com.wd.tech.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.tech.R;
import com.wd.tech.bean.sheqv.SheqvLiebiaoBean;
import com.wd.tech.mvp.glide.GlideUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * 功能：SheQuLiebiaoAdapter类
 * 作者：闫圣豪
 * 当前日期：2020/4/21
 * 当前时间：15:25
 */
public class SheQuLiebiaoAdapter extends XRecyclerView.Adapter<SheQuLiebiaoAdapter.Holder> {
    private final ArrayList<SheqvLiebiaoBean.ResultBean> list;
    private final FragmentActivity activity;
    private SimpleDateFormat simpleDateFormat;

    public SheQuLiebiaoAdapter(ArrayList<SheqvLiebiaoBean.ResultBean> list, FragmentActivity activity) {

        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(activity, R.layout.sheqvliebiao,null);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.sheqv_nickName.setText(list.get(position).getNickName());
        holder.sheqv_content.setText(list.get(position).getContent());


      //  Glide.with(activity).load(list.get(position).getHeadPic()).into(holder.sheqv_headPic);

        Glide.with(activity).load(list.get(position).getFile()).into(holder.sheqv_file);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(list.get(position).getPublishTime());
        Log.e("time",time);
        holder.sheqv_publishTime.setText(simpleDateFormat.format(list.get(position).getPublishTime())+"");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView sheqv_headPic,sheqv_file;
        private TextView sheqv_nickName,sheqv_publishTime,sheqv_content;
        public Holder(@NonNull View itemView) {
            super(itemView);
            sheqv_nickName=itemView.findViewById(R.id.sheqv_nickName);
            sheqv_publishTime=itemView.findViewById(R.id.sheqv_publishTime);
            sheqv_content=itemView.findViewById(R.id.sheqv_content);
            sheqv_file=itemView.findViewById(R.id.sheqv_file);
        }
    }
}
