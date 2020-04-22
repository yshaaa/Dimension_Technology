package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.wd.tech.R;
import com.wd.tech.adapter.zixun.ZixunAdapter;
import com.wd.tech.adapter.zixun.Zixun_Xq_Adapter;
import com.wd.tech.adapter.zixun.Zixun_tuijianAdapter;
import com.wd.tech.bean.zixun.ZixunBean;
import com.wd.tech.bean.zixun.Zixun_XQBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zixun_XQ extends BaseActivity {
    RecyclerView recyclerView,recyclerView2;
    private Integer iid;

    List<Zixun_XQBean.ResultBean> list=new ArrayList<>();
    private Zixun_tuijianAdapter zixunAdapter;


    @Override
    protected void startCoding() {
        String id = getIntent().getStringExtra("id");
        iid = Integer.valueOf(id);

        Log.e("aaa","id_xq"+iid);

        Zixun_Xq_Adapter zixun_xq_adapter = new Zixun_Xq_Adapter(list, Zixun_XQ.this);
        recyclerView.setAdapter(zixun_xq_adapter);


        //资讯详情
        Map<String,Object> map=new HashMap<>();
        map.put("id",iid);
        mPresenter.startgetInofHava(MyUrl.BASE_ZixunXQ, Zixun_XQBean.class,map);



        //详情推荐
        HashMap<String,Object> map1=new HashMap<>();
        map1.put("plateId",2);
        map1.put("page",1);
        map1.put("count",11);
        mPresenter.startgetInofHava(MyUrl.BASE_Zixun, ZixunBean.class,map1);

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        recyclerView=findViewById(R.id.recyc_zixun_xq);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView2=findViewById(R.id.recyc_Xq_tuijian);
        LinearLayoutManager manager1=new LinearLayoutManager(this);
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView2.setLayoutManager(manager1);

    }

    @Override
    protected int Layout() {
        return R.layout.activity_zixun__x_q;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof Zixun_XQBean){
            list.add(((Zixun_XQBean) o).getResult());

        }


        if(o instanceof ZixunBean) {
            zixunAdapter = new Zixun_tuijianAdapter(((ZixunBean) o).getResult(), Zixun_XQ.this);
            recyclerView2.setAdapter(zixunAdapter);
            zixunAdapter.setZixunCallBack(new Zixun_tuijianAdapter.ZixunCallBack() {
                @Override
                public void onClick(int position) {
                    int id = ((ZixunBean) o).getResult().get(position).getId();
                    String s = String.valueOf(id);
                    Intent intent = new Intent(Zixun_XQ.this, Zixun_XQ.class);
                    intent.putExtra("id", s);
                    Log.e("aaa", "id" + s + "///" + id);
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void onError(String error) {

    }
}
