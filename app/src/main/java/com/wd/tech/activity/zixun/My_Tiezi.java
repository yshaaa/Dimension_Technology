package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.wd.tech.R;
import com.wd.tech.adapter.zixun.My_Tiezi_Adapter;
import com.wd.tech.bean.zixun.MyTongzhiBean;
import com.wd.tech.bean.zixun.My_TieziBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class My_Tiezi extends BaseActivity {
    RecyclerView recyclerView;

    List<My_TieziBean.ResultBean> list=new ArrayList<>();

    @Override
    protected void startCoding() {
        Map<String,Object> map=new HashMap<>();
        map.put("fromUid",1384);
        map.put("page",1);
        map.put("count",15);
        mPresenter.startgetInofHava(MyUrl.BASE_Tiezi, My_TieziBean.class,map);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        recyclerView=findViewById(R.id.recyc_tiezi);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_my__tiezi;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof My_TieziBean){
            List<My_TieziBean.ResultBean> result = ((My_TieziBean) o).getResult();
            for (int i = 0; i < result.size(); i++) {
                My_Tiezi_Adapter my_tiezi_adapter = new My_Tiezi_Adapter(((My_TieziBean) o).getResult().get(i).getCommunityUserPostVoList(), My_Tiezi.this);
                recyclerView.setAdapter(my_tiezi_adapter);
            }

        }
    }

    @Override
    public void onError(String error) {

    }
}
