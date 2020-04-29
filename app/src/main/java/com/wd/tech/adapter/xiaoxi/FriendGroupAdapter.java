package com.wd.tech.adapter.xiaoxi;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.activity.xiaoxi.XinPengyouActivity;
import com.wd.tech.activity.xiaoxi.liaotian.ChatinterfaceActivity;
import com.wd.tech.bean.xiaoxi.FriendGroupBean;
import com.wd.tech.bean.xiaoxi.FriendListBean;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FriendGroupAdapter extends RecyclerView.Adapter<FriendGroupAdapter.GroupViewHolder> {


    private final Context context;
    private List<FriendGroupBean.ResultBean> list=new ArrayList<>();
    List<FriendListBean.ResultBean> child=new ArrayList<>();

    private int pos=-1;



    public FriendGroupAdapter(Context context, List<FriendGroupBean.ResultBean> result) {

        this.context = context;
        list = result;
    }

    public void addAllChild(int position, List<FriendListBean.ResultBean> mchild) {
        child=mchild;
        pos=position;
    }
    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= View.inflate(parent.getContext(), R.layout.friend_group, null);
        return new GroupViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {

        FriendGroupBean.ResultBean resultBean = list.get(position);
        int currentNumber = resultBean.getCurrentNumber();
        String groupName = resultBean.getGroupName();
        if (resultBean.isClosed()){
            holder.iv.setImageResource(R.drawable.you1);
            holder.rc.setVisibility(View.GONE);
        }else {
            if (currentNumber==0){
                child=null;
            }else {
                holder.rc.setVisibility(View.VISIBLE);
            }
            holder.iv.setImageResource(R.drawable.xia1);

        }
        holder.name.setText(groupName);
        holder.num.setText("0/" + currentNumber);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child=null;
                boolean closed = resultBean.isClosed();
                closed = !closed;
                resultBean.setClosed(closed);
                    if (onClickListener != null) {
                        onClickListener.onClick(position, resultBean.getGroupId());
                }
            }
        });
        holder.rc.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        if (child!=null){
            FriendChildAdapter friendChildAdapter = new FriendChildAdapter(child);
            holder.rc.setAdapter(friendChildAdapter);

            //点击跳转
            friendChildAdapter.setItemClick(new FriendChildAdapter.ItemClick() {
                @Override
                public void setClick(String p) {
                    Intent intent = new Intent(context, ChatinterfaceActivity.class);
                    intent.putExtra("name",p);
                    context.startActivity(intent);
                }
            });



        }

}

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GroupViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.rc)
        RecyclerView rc;
    public GroupViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

}
    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(int position, int groupId);
    }
}
