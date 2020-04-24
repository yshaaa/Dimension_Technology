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
import com.wd.tech.R;
import com.wd.tech.bean.zixun.ZiXun_BankuaiBean;

import java.util.List;

/**
 * @author 邓先超
 * @date 2020/4/23 15:39
 */
public class Zixun_Bankuai_Adapter extends RecyclerView.Adapter<Zixun_Bankuai_Adapter.Holder> {
    List<ZiXun_BankuaiBean.ResultBean>list;
    Context context;

    public Zixun_Bankuai_Adapter(List<ZiXun_BankuaiBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zixun_bankuai, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(context).load(list.get(position).getPic())
                .error(R.drawable.notnet)
                .placeholder(R.drawable.notnet)
                .into(holder.imageView);

        holder.textView.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bankuaiCallBack.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.bankuai_ima);
            textView=itemView.findViewById(R.id.bankuai_name);
        }
    }

    public interface BankuaiCallBack{
        void onClick(int position);
    }

     public BankuaiCallBack bankuaiCallBack;

    public void setBankuaiCallBack(BankuaiCallBack bankuaiCallBack){
        this.bankuaiCallBack=bankuaiCallBack;
    }
}
