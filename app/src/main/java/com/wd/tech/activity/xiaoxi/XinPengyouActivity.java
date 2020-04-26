package com.wd.tech.activity.xiaoxi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wd.tech.R;
import com.wd.tech.adapter.xiaoxi.XinPengyouAdapter;
import com.wd.tech.bean.xiaoxi.sousuo.XinPengyouBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class XinPengyouActivity extends BaseActivity {


    private ImageView fanhui_xinpengyou;
    private RecyclerView recy_xinpengyou;
    private   ArrayList<XinPengyouBean.ResultBean> list = new ArrayList<>();
    private XinPengyouAdapter xinPengyouAdapter;


    @Override
    protected void startCoding() {
        xinPengyouAdapter = new XinPengyouAdapter(list, this);
        recy_xinpengyou.setAdapter(xinPengyouAdapter);
        HashMap<String, Object> map = new HashMap<>();
        map.put("page",1);
        map.put("count",5);
        mPresenter.startgetInofHava(MyUrl.xinpengyou,XinPengyouBean.class,map);

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        fanhui_xinpengyou = findViewById(R.id.fanhui_xinpengyou);
        fanhui_xinpengyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recy_xinpengyou =  findViewById(R.id.recy_xinpengyou);
        recy_xinpengyou.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected int Layout() {
        return R.layout.activity_xin_pengyou;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof XinPengyouBean){
            list.clear();
            list.addAll(((XinPengyouBean)o).getResult());
            xinPengyouAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
