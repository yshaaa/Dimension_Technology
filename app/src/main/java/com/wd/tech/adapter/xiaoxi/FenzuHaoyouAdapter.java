package com.wd.tech.adapter.xiaoxi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.bean.xiaoxi.FenzuHaoyouBean;

import java.util.ArrayList;

/**
 * 功能：FenzuHaoyouAdapter类
 * 作者：闫圣豪
 * 当前日期：2020/4/24
 * 当前时间：17:06
 */
public class FenzuHaoyouAdapter extends RecyclerView.Adapter<FenzuHaoyouAdapter.Holder> {
    private final ArrayList<FenzuHaoyouBean.ResultBean> list_two;
    private final FragmentActivity activity;

    public FenzuHaoyouAdapter(ArrayList<FenzuHaoyouBean.ResultBean> list_two, FragmentActivity activity) {

        this.list_two = list_two;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(activity, R.layout.item_fenzuhaoyou,null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name1.setText(list_two.get(position).getNickName());
        holder.name2.setText(list_two.get(position).getNickName());
    }

    @Override
    public int getItemCount() {
        return list_two.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView name1,name2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name1=itemView.findViewById(R.id.item_name1);
            name2=itemView.findViewById(R.id.item_name2);
        }
    }
}
