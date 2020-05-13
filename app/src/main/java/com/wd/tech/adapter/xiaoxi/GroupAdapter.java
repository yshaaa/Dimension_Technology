package com.wd.tech.adapter.xiaoxi;

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

import com.wd.tech.bean.xiaoxi.GroupBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/26
 * author:郑惠洋(Dell)
 * function:群组Adapter
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.VH> {
    private Context context;
    private List<GroupBean.ResultBean> list;

    public GroupAdapter(Context context, List<GroupBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        GroupBean.ResultBean resultBean = list.get(position);
        holder.tvGroup.setText(resultBean.getGroupName() + "");

        String groupImage = resultBean.getGroupImage();
        Glide.with(context)
                .load(groupImage)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.ivGroup);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_group)
        ImageView ivGroup;
        @BindView(R.id.tv_group)
        TextView tvGroup;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
