package com.wd.tech.adapter.shequ;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.tech.R;
import com.wd.tech.bean.sheqv.SheqvLiebiaoBean;
import com.wd.tech.bean.sheqv.SheqvdianzanBean;
import com.wd.tech.bean.sheqv.SheqvqvxiaodianzanBean;
import com.wd.tech.mvp.MyUrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

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
    private int whetherGreat;
    private boolean isDianzan=true;


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
        whetherGreat = list.get(position).getWhetherGreat();
        holder.sheqv_nickName.setText(list.get(position).getNickName());
        holder.sheqv_content.setText(list.get(position).getContent());

        holder.name.setText(list.get(position).getNickName());
        holder.content.setText(list.get(position).getContent());
        Glide.with(activity).load(list.get(position).getHeadPic()+"").into(holder.sheqv_headPic);

        Glide.with(activity).load(list.get(position).getFile()).into(holder.sheqv_file);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(list.get(position).getPublishTime());
        Log.e("time",time);
        holder.sheqv_publishTime.setText(simpleDateFormat.format(list.get(position).getPublishTime())+"");
        //点赞的点击事件
        holder.zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(whetherGreat==1){
                    if(isDianzan==true){
                        holder.zan.setImageResource(R.mipmap.zan_b);

                        isDianzan=false;
                    } else{
                        //再次点击时，请求关注接口
                        holder.zan.setImageResource(R.mipmap.zan_h);
                        isDianzan=true;

                    }
                }else if(whetherGreat==2){
                    //如果==2，那就请求关注接口
                    if(isDianzan==true){
                        holder.zan.setImageResource(R.mipmap.zan_h);
                        isDianzan=false;
                    }else{
                        //再次点击取消关注
                        holder.zan.setImageResource(R.mipmap.zan_b);
                        isDianzan=true;
                    }
                }

                if (itemClick != null) {
                    itemClick.setClick(position);
                }

            }
        });
        holder.pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pinglun != null) {
                    pinglun.setClick(position);
                }
            }
        });
        holder.sheqv_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tupian != null) {
                    tupian.setClick(position);
                }


        }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView sheqv_headPic,sheqv_file,pinglun;
        public ImageView zan;
        private TextView sheqv_nickName,sheqv_publishTime,sheqv_content,name,content;
        public Holder(@NonNull View itemView) {
            super(itemView);
            sheqv_headPic=itemView.findViewById(R.id.sheqv_headPic);
            sheqv_nickName=itemView.findViewById(R.id.sheqv_nickName);
            sheqv_publishTime=itemView.findViewById(R.id.sheqv_publishTime);
            sheqv_content=itemView.findViewById(R.id.sheqv_content);
            sheqv_file=itemView.findViewById(R.id.sheqv_file);
            pinglun=itemView.findViewById(R.id.pinglun);
            zan=itemView.findViewById(R.id.zan);
            name=itemView.findViewById(R.id.name);
            content=itemView.findViewById(R.id.content);

            if(whetherGreat==1){
                //关注就是红心
                zan.setImageResource(R.mipmap.zan_h);

            }else if(whetherGreat==2){
                //没关注就是白心
                zan.setImageResource(R.mipmap.zan_b);
            }




        }
    }


    //点赞的点击回调
    public interface ItemClick{
        void setClick(int p);
    }
    private ItemClick itemClick;
    public void setItemClick(ItemClick itemClick){
        this.itemClick=itemClick;
    }

    //评论的点击回调
    public interface Pinglun{
        void setClick(int p);
    }
    private Pinglun pinglun;
    public void setPinglun(Pinglun pinglun){
        this.pinglun=pinglun;
    }

    //图片的点击回调
    public interface Tupian{
        void setClick(int p);
    }
    private Tupian tupian;
    public void setTupian(Tupian tupian){
        this.tupian=tupian;
    }



}
