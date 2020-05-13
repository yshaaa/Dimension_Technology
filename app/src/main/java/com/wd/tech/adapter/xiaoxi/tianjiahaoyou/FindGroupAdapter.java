package com.wd.tech.adapter.xiaoxi.tianjiahaoyou;

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
import com.wd.tech.bean.xiaoxi.tianjia.FindGroupBean;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:郑惠洋(Dell)
 * function:找群
 */
public class FindGroupAdapter extends RecyclerView.Adapter<FindGroupAdapter.VH> {

    private Context context;
    List<FindGroupBean.ResultBean> list;

    public FindGroupAdapter(Context context, List<FindGroupBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_findgroup, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        FindGroupBean.ResultBean resultBean = list.get(position);
        holder.tvNameGroup.setText(resultBean.getGroupName());
        String groupImage = resultBean.getGroupImage();
        Glide.with(context)
                .load(groupImage)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.ivHeadGroup);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_head_group)
        ImageView ivHeadGroup;
        @BindView(R.id.tv_name_group)
        TextView tvNameGroup;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
