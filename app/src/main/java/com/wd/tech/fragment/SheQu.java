package com.wd.tech.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.tech.R;
import com.wd.tech.adapter.SheQuLiebiaoAdapter;
import com.wd.tech.bean.sheqv.SheqvLiebiaoBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;


public class SheQu extends BaseFragment {

    private  ArrayList<SheqvLiebiaoBean.ResultBean> list = new ArrayList<>();
    private XRecyclerView xrecy_sheqv;
    private SheQuLiebiaoAdapter adapter;

    @Override
    protected void startCoding() {

        adapter = new SheQuLiebiaoAdapter(list, getActivity());
        xrecy_sheqv.setAdapter(adapter);
        HashMap<String, Object> map = new HashMap<>();
        map.put("page",1);
        map.put("count",5);
        mPresenter.startgetInofHava(MyUrl.sheqvliebiao,SheqvLiebiaoBean.class,map);

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        xrecy_sheqv = view.findViewById(R.id.xrecy_sheqv);
        xrecy_sheqv.setLayoutManager(new LinearLayoutManager(getContext()));
        xrecy_sheqv.setLoadingMoreEnabled(true);
        xrecy_sheqv.setPullRefreshEnabled(true);
        xrecy_sheqv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });

    }

    @Override
    protected int Layout() {
        return R.layout.activity_she_qu;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof SheqvLiebiaoBean);{
            list.clear();
            list.addAll(((SheqvLiebiaoBean)o).getResult());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
