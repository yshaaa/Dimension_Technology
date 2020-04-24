package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wd.tech.R;
import com.wd.tech.activity.zixun.Zixun_Mohu;
import com.wd.tech.activity.zixun.Zixun_XQ;
import com.wd.tech.adapter.zixun.Zixun_Mohu_Adapter;
import com.wd.tech.bean.zixun.Zixun_MohuBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.HashMap;

public class Zixun_Mohu_wenzhang extends BaseFragment {
    RecyclerView recyclerView;
    private String edit_mohu;

    @Override
    protected void startCoding() {
        Bundle arguments = getArguments();
        edit_mohu = arguments.getString("edit_mohu");

        Log.e("aaa","文章edit_mohu:"+edit_mohu);

        HashMap<String,Object> map1=new HashMap<>();
        map1.put("title", edit_mohu);
        map1.put("page",1);
        map1.put("count",20);
        mPresenter.startgetInofHava(MyUrl.BASE_Zixun_Mohu, Zixun_MohuBean.class,map1);






    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        recyclerView=view.findViewById(R.id.recyc_zixun_wenzhang);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_zixun__mohu_wenzhang;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof Zixun_MohuBean){

            Zixun_Mohu_Adapter zixun_mohu_adapter = new Zixun_Mohu_Adapter(((Zixun_MohuBean) o).getResult(), getActivity());
            recyclerView.setAdapter(zixun_mohu_adapter);
            zixun_mohu_adapter.notifyDataSetChanged();

            zixun_mohu_adapter.setZixunCallBack(new Zixun_Mohu_Adapter.ZixunCallBack() {
                @Override
                public void onClick(int position) {
                    int id = ((Zixun_MohuBean) o).getResult().get(position).getId();
                    String s = String.valueOf(id);
                    Intent intent = new Intent(getActivity(), Zixun_XQ.class);
                    intent.putExtra("id",s);
                    Log.e("aaa","id模糊查询"+s);
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void onError(String error) {

    }
}
