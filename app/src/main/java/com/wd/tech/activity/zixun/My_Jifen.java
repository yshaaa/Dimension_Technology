package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.tech.R;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

public class My_Jifen extends BaseActivity {


    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int Layout() {
        return R.layout.activity_my__jifen;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
