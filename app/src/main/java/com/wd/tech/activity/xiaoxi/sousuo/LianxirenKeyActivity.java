package com.wd.tech.activity.xiaoxi.sousuo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.wd.tech.R;
import com.wd.tech.adapter.xiaoxi.sousuo.LianxirenAdapter;
import com.wd.tech.bean.xiaoxi.sousuo.LianxirenSearchBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class LianxirenKeyActivity extends BaseActivity {


    private EditText sousuo_name;
    private ImageView fanhui;
    private RecyclerView recy_lianxiren;
    private ArrayList<LianxirenSearchBean.ResultBean> list = new ArrayList<>();
    private LianxirenAdapter adapter;

    @Override
    protected void startCoding() {
        adapter = new LianxirenAdapter(list,this);
        recy_lianxiren.setAdapter(adapter);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        fanhui = findViewById(R.id.fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recy_lianxiren = findViewById(R.id.recy_lianxiren);
        recy_lianxiren.setLayoutManager(new LinearLayoutManager(this));

        sousuo_name = findViewById(R.id.sousuo_name);
        sousuo_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String trim = sousuo_name.getText().toString().trim();
                HashMap<String, Object> map = new HashMap<>();
                map.put("searchName",trim);
                mPresenter.startgetInofHava(MyUrl.xiaoxisousuohaoyou, LianxirenSearchBean.class,map);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected int Layout() {
        return R.layout.activity_lianxiren_key;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof LianxirenSearchBean){
            list.clear();
            list.addAll(((LianxirenSearchBean)o).getResult());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
