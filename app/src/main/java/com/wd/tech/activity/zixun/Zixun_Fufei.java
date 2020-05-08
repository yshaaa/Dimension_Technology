package com.wd.tech.activity.zixun;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.wd.tech.R;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

public class Zixun_Fufei extends BaseActivity {
    TextView duihuan_jf,duihuan_vip;


    @Override
    protected void startCoding() {

        String id = getIntent().getStringExtra("id");

        duihuan_jf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zixun_Fufei.this, Duihuan_jf_activity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        duihuan_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zixun_Fufei.this, Duihuan_Vip_activity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        duihuan_jf=findViewById(R.id.duihuan_jf);
        duihuan_vip=findViewById(R.id.duihuan_vip);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_zixun__fufei;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
