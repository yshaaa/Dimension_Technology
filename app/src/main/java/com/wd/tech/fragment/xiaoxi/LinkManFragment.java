package com.wd.tech.fragment.xiaoxi;


import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.wd.tech.R;

import com.wd.tech.adapter.xiaoxi.FriendGroupAdapter;
import com.wd.tech.bean.xiaoxi.FriendGroupBean;
import com.wd.tech.bean.xiaoxi.FriendListBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.presenter.PresenterImpl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;


public class LinkManFragment extends BaseFragment{


    @BindView(R.id.query)
    EditText query;
    @BindView(R.id.linkManRc)
    RecyclerView linkManRc;
    private FriendGroupAdapter friendGroupAdapter;
    private int position=-1;
    List<FriendGroupBean.ResultBean> group=new ArrayList<>();
    @Override
    protected void startCoding() {



        //查询所有分组
        mPresenter.startgetInfo(MyUrl.xiaoxifenzu, FriendGroupBean.class);
        linkManRc.setLayoutManager(new LinearLayoutManager(getContext()));
        //
        query.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String serach = query.getText().toString().trim();

            }
        });


    }

    @Override
    protected PresenterImpl initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int Layout() {
        return R.layout.fragment_link_man;
    }

    @Override
    public void onSuccess(Object o) {


        if (o instanceof FriendGroupBean&& TextUtils.equals("0000",((FriendGroupBean) o).getStatus())){
            if (((FriendGroupBean) o).getResult().size()>0){
                group.clear();
                List<FriendGroupBean.ResultBean> result = ((FriendGroupBean) o).getResult();
                group.addAll(result);
                friendGroupAdapter = new FriendGroupAdapter(group);
                friendGroupAdapter.setOnClickListener(new FriendGroupAdapter.OnClickListener() {
                    @Override
                    public void onClick(int positon, int groupId) {
                        position=positon;
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("groupId",groupId);
                        //查询分组下所有好友
                        mPresenter.startgetInofHava(MyUrl.fenzuhaoyou, FriendListBean.class,map);
                    }
                });
                linkManRc.setAdapter(friendGroupAdapter);
            }
        }
        if (o instanceof FriendListBean &&TextUtils.equals("0000",((FriendListBean) o).getStatus())){
            if (((FriendListBean) o).getResult().size()>0){
                List<FriendListBean.ResultBean> result = ((FriendListBean) o).getResult();
                if (friendGroupAdapter != null) {
                    friendGroupAdapter.addAllChild(position,result);
                }
            }else {
                if (friendGroupAdapter != null) {
                    friendGroupAdapter.addAllChild(position,null);
                }
            }
            friendGroupAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}

