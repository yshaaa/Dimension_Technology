package com.wd.tech.adapter.xiaoxi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.tech.R;
import com.wd.tech.bean.xiaoxi.FenzuBean;
import com.wd.tech.bean.xiaoxi.FenzuHaoyouBean;

import java.util.ArrayList;

/**
 * 功能：FenzuAdapter类
 * 作者：闫圣豪
 * 当前日期：2020/4/24
 * 当前时间：16:31
 */
public class FenzuAdapter extends RecyclerView.Adapter<FenzuAdapter.Holder> {

  //  private ArrayList<FenzuHaoyouBean.ResultBean> list_two = new ArrayList<>();
    private final ArrayList<FenzuBean.ResultBean> list_one;
    private final FragmentActivity activity;

    public FenzuAdapter(ArrayList<FenzuBean.ResultBean> list_one, FragmentActivity activity) {

        this.list_one = list_one;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(activity, R.layout.item_fenzu,null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.item_name.setText(list_one.get(position).getGroupName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClick != null) {
                    itemClick.setClick(position);
                }
            }
        });


//        SmallAdapter smallAdapter = new SmallAdapter(list_two,position);
//        holder.recy_hayou1.setAdapter(smallAdapter);

    }

    @Override
    public int getItemCount() {
        return list_one.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
       // private RecyclerView recy_hayou1;
        private TextView item_name;
        public Holder(@NonNull View itemView) {
            super(itemView);
            item_name=itemView.findViewById(R.id.item_name);
        //    recy_hayou1=itemView.findViewById(R.id.recy_haoyou1);
        }
    }





//    class SmallAdapter extends RecyclerView.Adapter<SmallAdapter.Holder>{
//
//
//        private final ArrayList<FenzuHaoyouBean.ResultBean> list_two;
//        private final int position;
//
//        public SmallAdapter(ArrayList<FenzuHaoyouBean.ResultBean> list_two, int position) {
//
//            this.list_two = list_two;
//            this.position = position;
//        }
//
//        @NonNull
//        @Override
//        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view=View.inflate(activity,R.layout.item_fenzuhaoyou,null);
//            Holder holder = new Holder(view);
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull Holder holder, int i) {
//            holder.name1.setText(list_two.get(position).getNickName());
//            holder.name2.setText(list_two.get(position).getNickName());
//        }
//
//        @Override
//        public int getItemCount() {
//            return list_two.size();
//        }
//
//        public class Holder extends RecyclerView.ViewHolder {
//            private TextView name1,name2;
//            public Holder(@NonNull View itemView) {
//                super(itemView);
//                name1=itemView.findViewById(R.id.item_name1);
//                name2=itemView.findViewById(R.id.item_name2);
//            }
//        }
//    }


    //点赞的点击回调
    public interface ItemClick{
        void setClick(int p);
    }
    private ItemClick itemClick;
    public void setItemClick(ItemClick itemClick){
        this.itemClick=itemClick;
    }
}
