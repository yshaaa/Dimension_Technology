package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.wd.tech.R;
import com.wd.tech.adapter.zixun.My_Jifen_Adapter;
import com.wd.tech.bean.zixun.My_TieziBean;
import com.wd.tech.bean.zixun.My_jifenBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class My_Jifen extends BaseActivity {
    TextView jifen_number,jifen_day;
    RecyclerView recyclerView;

    List<My_jifenBean.ResultBean> list=new ArrayList<>();

    @Override
    protected void startCoding() {
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",99);
        mPresenter.startgetInofHava(MyUrl.BASe_Jifen_Mx, My_jifenBean.class,map);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        jifen_number=findViewById(R.id.jifen_number);
        jifen_day=findViewById(R.id.jifen_day);

        recyclerView=findViewById(R.id.recyc_jifen);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_my__jifen;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof My_jifenBean){
            My_Jifen_Adapter my_jifen_adapter = new My_Jifen_Adapter(((My_jifenBean) o).getResult(), My_Jifen.this);
            recyclerView.setAdapter(my_jifen_adapter);
            jifen_number.setText(my_jifen_adapter.sum()+"");
        }
    }

    @Override
    public void onError(String error) {

    }
}
