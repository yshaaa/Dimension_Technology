package com.wd.tech.activity.xiaoxi.liaotian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.tech.R;
import com.wd.tech.bean.xiaoxi.FriendListBean;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;

public class ChatinterfaceActivity extends BaseActivity {


    private String name;
    private ImageView fanhui;
    private ImageView xinxi;
    private TextView name1;

    @Override
    protected void startCoding() {

        name = getIntent().getStringExtra("name");
        name1.setText(name);


    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        fanhui = findViewById(R.id.fanhui);
        xinxi = findViewById(R.id.xinxi);
        name1 = findViewById(R.id.name);



    }

    @Override
    protected int Layout() {
        return R.layout.activity_chatinterface;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
