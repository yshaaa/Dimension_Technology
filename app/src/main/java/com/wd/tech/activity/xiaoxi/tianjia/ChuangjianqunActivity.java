package com.wd.tech.activity.xiaoxi.tianjia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.bean.xiaoxi.tianjia.QunzuBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.HashMap;

import butterknife.BindView;

public class ChuangjianqunActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_jieshao)
    EditText etJieshao;
    @BindView(R.id.tijiao)
    Button tijiao;

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {

        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e1 = etName.getText().toString();
                String e2 = etJieshao.getText().toString();

                HashMap<String, Object> map = new HashMap<>();
                map.put("name", e1);
                map.put("description", e2);
                mPresenter.startpostInfoHava1(MyUrl.chunagjian, QunzuBean.class, map);
            }
        });




    }

    @Override
    protected int Layout() {
        return R.layout.activity_chuangjianqun;
    }

    @Override
    public void onSuccess(Object o) {

        if (o instanceof QunzuBean) {

            String message = ((QunzuBean) o).getMessage();

            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(String error) {

    }

}
