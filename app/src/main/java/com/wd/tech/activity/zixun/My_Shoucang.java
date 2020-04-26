package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.adapter.zixun.My_Shoucang_Adapter;
import com.wd.tech.bean.zixun.My_ShoucangBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.HashMap;
import java.util.Map;

public class My_Shoucang extends BaseActivity {
    RecyclerView recyclerView;


    @Override
    protected void startCoding() {
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",15);
        mPresenter.startgetInofHava(MyUrl.BASE_Shoucang, My_ShoucangBean.class,map);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {

        recyclerView=findViewById(R.id.recyc_Shoucang);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_my__shoucang;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof My_ShoucangBean){
            if(((My_ShoucangBean) o).getResult().equals("")){
                Toast.makeText(this, "没有相关信息", Toast.LENGTH_SHORT).show();
            }else {
                My_Shoucang_Adapter my_shoucang_adapter = new My_Shoucang_Adapter(((My_ShoucangBean) o).getResult(), My_Shoucang.this);
                recyclerView.setAdapter(my_shoucang_adapter);
                my_shoucang_adapter.setZixunCallBack(new My_Shoucang_Adapter.ZixunCallBack() {
                    @Override
                    public void onClick(int position) {
                        int id = ((My_ShoucangBean) o).getResult().get(position).getInfoId();
                        String s = String.valueOf(id);
                        Intent intent = new Intent(My_Shoucang.this, Zixun_XQ.class);
                        Log.e("aaa","收藏id:"+s);
                        intent.putExtra("id",s);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
