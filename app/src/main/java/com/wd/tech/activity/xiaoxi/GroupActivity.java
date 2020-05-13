package com.wd.tech.activity.xiaoxi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;

import com.wd.tech.adapter.xiaoxi.GroupAdapter;
import com.wd.tech.bean.xiaoxi.GroupBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//群组Activity
public class GroupActivity extends BaseActivity implements View.OnClickListener {


    EditText etSearch;
    @BindView(R.id.rv_group)
    RecyclerView rvGroup;
    @BindView(R.id.bt_back)
    Button btBack;

    @Override
    protected void startCoding() {

        mPresenter.startgetInfo(MyUrl.qunzu, GroupBean.class);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        //布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        rvGroup.setLayoutManager(manager);

    }

    @Override
    protected int Layout() {
        return R.layout.activity_group;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof GroupBean) {

            GroupAdapter groupAdapter=new GroupAdapter(this,((GroupBean) o).getResult());
            rvGroup.setAdapter(groupAdapter);

            Toast.makeText(this, "" + ((GroupBean) o).getMessage(), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onError(String error) {
    }


}
