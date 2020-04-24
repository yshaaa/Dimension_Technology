package com.wd.tech.activity.zixun;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;

import com.wd.tech.R;
import com.wd.tech.adapter.zixun.ZixunAdapter;
import com.wd.tech.bean.zixun.ZixunBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.HashMap;

public class Zixun_Right_liebiao extends BaseActivity {
    RecyclerView recyclerView;
    private ZixunAdapter zixunAdapter;


    @Override
    protected void startCoding() {
        String s = getIntent().getStringExtra("s");
        Integer id = Integer.valueOf(s);

        Log.e("aaa","右侧边框id:"+id);

        HashMap<String,Object> map=new HashMap<>();
        map.put("plateId",id);
        map.put("page",1);
        map.put("count",20);
        mPresenter.startgetInofHava(MyUrl.BASE_Zixun, ZixunBean.class,map);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {


        recyclerView=findViewById(R.id.recyc_zixun_right_liebiao);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_zixun__right_liebiao;
    }

    @Override
    public void onSuccess(Object o) {


        if(o instanceof ZixunBean) {
            zixunAdapter = new ZixunAdapter(((ZixunBean) o).getResult(), Zixun_Right_liebiao.this);
            recyclerView.setAdapter(zixunAdapter);
            zixunAdapter.setZixunCallBack(new ZixunAdapter.ZixunCallBack() {
                @Override
                public void onClick(int position) {
                    int id = ((ZixunBean) o).getResult().get(position).getId();
                    String s = String.valueOf(id);
                    Intent intent = new Intent(Zixun_Right_liebiao.this, Zixun_XQ.class);
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
