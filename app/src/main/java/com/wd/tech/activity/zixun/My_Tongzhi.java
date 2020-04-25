package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.wd.tech.R;
import com.wd.tech.adapter.zixun.My_Tongzhi_Adapter;
import com.wd.tech.bean.zixun.MyTongzhiBean;
import com.wd.tech.bean.zixun.My_ShoucangBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class My_Tongzhi extends BaseActivity {
    TextView textViewtime,textViewxinxi;

    RecyclerView recyclerView;

    @Override
    protected void startCoding() {
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",15);
        mPresenter.startgetInofHava(MyUrl.BASE_Tongzhi, MyTongzhiBean.class,map);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        recyclerView=findViewById(R.id.recyc_tongzhi);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_my__tongzhi;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof MyTongzhiBean){

            My_Tongzhi_Adapter my_tongzhi_adapter = new My_Tongzhi_Adapter(((MyTongzhiBean) o).getResult(), My_Tongzhi.this);
            recyclerView.setAdapter(my_tongzhi_adapter);

//            for (int i = 0; i < result.size(); i++) {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//                String format = simpleDateFormat.format(list.get(i).getCreateTime());
//                textViewtime.setText(format+"");
//                Log.e("aaa","format+\"\""+format+"");
//
//
//                textViewxinxi.setText(list.get(i).getContent());
//                Log.e("aaa","通知信息"+list.get(i).getContent());
//            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
