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
import com.wd.tech.bean.xiaoxi.tianjia.FindpeopleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FindPeopleAdapter extends RecyclerView.Adapter<FindPeopleAdapter.VH> {
    public Context context;
    List<FindpeopleBean.ResultBean> list;

    public FindPeopleAdapter(Context context, List<FindpeopleBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_findpeople, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        FindpeopleBean.ResultBean resultBean = list.get(position);
        holder.tvNamePeople.setText(resultBean.getNickName());

        String headPic = resultBean.getHeadPic();
        Glide.with(context)
                .load(headPic)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.ivHeadPeople);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_head_people)
        ImageView ivHeadPeople;
        @BindView(R.id.tv_name_people)
        TextView tvNamePeople;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
