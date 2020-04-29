package com.wd.tech.adapter.xiaoxi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.tech.R;

import com.wd.tech.bean.xiaoxi.FriendListBean;
import com.wd.tech.mvp.glide.GlideUtil;



import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/23 0023
 * author:胡锦涛(Administrator)
 * function:
 */
public class FriendChildAdapter extends RecyclerView.Adapter<FriendChildAdapter.ViewHolder>{
    private List<FriendListBean.ResultBean> list;

    public FriendChildAdapter(List<FriendListBean.ResultBean> child) {
        list = child;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(), R.layout.friend_child, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FriendListBean.ResultBean resultBean = list.get(position);

        GlideUtil.Loadimage(list.get(position).getHeadPic(),holder.iv);
        holder.name.setText(resultBean.getNickName());
        holder.remark.setText(resultBean.getRemarkName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.setClick(resultBean.getNickName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.remark)
        TextView remark;
        @BindView(R.id.red)
        ImageView red;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }



    public interface ItemClick{
        void setClick(String p);
    }
    private ItemClick itemClick;
    public void setItemClick(ItemClick itemClick){
        this.itemClick=itemClick;
    }
}
