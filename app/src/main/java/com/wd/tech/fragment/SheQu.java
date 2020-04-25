package com.wd.tech.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.tech.R;
import com.wd.tech.activity.shequ.FabuTieziActivity;
import com.wd.tech.adapter.shequ.SheQuLiebiaoAdapter;
import com.wd.tech.bean.sheqv.SheqvLiebiaoBean;
import com.wd.tech.bean.sheqv.SheqvdianzanBean;
import com.wd.tech.bean.sheqv.SheqvqvxiaodianzanBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;


public class SheQu extends BaseFragment implements View.OnClickListener{

    private  ArrayList<SheqvLiebiaoBean.ResultBean> list = new ArrayList<>();
    private XRecyclerView xrecy_sheqv;
    private SheQuLiebiaoAdapter adapter;
    private int whetherGreat;
    private boolean isDianzan=true;
    private int id;
    private int pager=1;
    private int count=6;
    private ImageView tianjiapinglun;

    @Override
    protected void startCoding() {

        adapter = new SheQuLiebiaoAdapter(list, getActivity());
        xrecy_sheqv.setAdapter(adapter);
        HashMap<String, Object> map = new HashMap<>();
        map.put("page",1);
        map.put("count",5);
        mPresenter.startgetInofHava(MyUrl.sheqvliebiao,SheqvLiebiaoBean.class,map);



        adapter.setItemClick(new SheQuLiebiaoAdapter.ItemClick() {
            @Override
            public void setClick(int p) {

//                whetherGreat = list.get(p).getWhetherGreat();
//                id = list.get(p).getId();
//                //如果==1，那就取消关注
//                if(whetherGreat==1){
//                    if(isDianzan==true){
//                        HashMap<String, Object> map = new HashMap<>();
//                        map.put("cinemaId", id);
//                        mPresenter.startdeleteInfoHava(MyUrl.sheqvqvxiaodianzan, SheqvqvxiaodianzanBean.class,map);
//                        isDianzan=false;
//                        Toast.makeText(getContext(), "取消关注", Toast.LENGTH_SHORT).show();
//
//                    } else{
//                        //再次点击时，请求关注接口
//                        HashMap<String, Object> map = new HashMap<>();
//                        map.put("cinemaId", id);
//                        mPresenter.startpostInfoHava(MyUrl.sheqvdianzan,SheqvdianzanBean.class,map);
//                        isDianzan=true;
//                        Toast.makeText(getContext(), "关注成功", Toast.LENGTH_SHORT).show();
//                    }
//                }else if(whetherGreat==2){
//                    //如果==2，那就请求关注接口
//                    if(isDianzan==true){
//                        HashMap<String, Object> map = new HashMap<>();
//                        map.put("cinemaId", id);
//                        mPresenter.startpostInfoHava(MyUrl.sheqvdianzan,SheqvdianzanBean.class,map);
//                        Toast.makeText(getContext(), "关注成功", Toast.LENGTH_SHORT).show();
//                        isDianzan=false;
//                    }else{
//                        //再次点击取消关注
//                        HashMap<String, Object> map = new HashMap<>();
//                        map.put("cinemaId", id);
//                        mPresenter.startdeleteInfoHava(MyUrl.sheqvqvxiaodianzan, SheqvqvxiaodianzanBean.class,map);
//                        isDianzan=true;
//                        Toast.makeText(getContext(), "取消关注", Toast.LENGTH_SHORT).show();
//                    }
//                }



            }
        });
        //评论的点击事件
        adapter.setPinglun(new SheQuLiebiaoAdapter.Pinglun() {
            @Override
            public void setClick(int p) {
                Toast.makeText(getContext(), "2222", Toast.LENGTH_SHORT).show();
            }
        });
        //图片的点击事件
        adapter.setTupian(new SheQuLiebiaoAdapter.Tupian() {
            @Override
            public void setClick(int p) {
                Toast.makeText(getContext(), "3333", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        xrecy_sheqv = view.findViewById(R.id.xrecy_sheqv);
        tianjiapinglun = view.findViewById(R.id.tianjiapinglun);
        tianjiapinglun.setOnClickListener(this);


        xrecy_sheqv.setLayoutManager(new LinearLayoutManager(getContext()));
        xrecy_sheqv.setLoadingMoreEnabled(true);
        xrecy_sheqv.setPullRefreshEnabled(true);
        xrecy_sheqv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                HashMap<String, Object> map = new HashMap<>();
                map.put("page",1);
                map.put("count",5);
                mPresenter.startgetInofHava(MyUrl.sheqvliebiao,SheqvLiebiaoBean.class,map);
                xrecy_sheqv.refreshComplete();
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadMore() {
                count++;
                pager++;
                HashMap<String, Object> map = new HashMap<>();
                map.put("page",1);
                map.put("count",count*3);
                mPresenter.startgetInofHava(MyUrl.sheqvliebiao,SheqvLiebiaoBean.class,map);
                xrecy_sheqv.loadMoreComplete();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tianjiapinglun:
                Intent intent = new Intent(getContext(), FabuTieziActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected int Layout() {
        return R.layout.activity_she_qu;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof SheqvLiebiaoBean);{
            list.clear();
            list.addAll(((SheqvLiebiaoBean)o).getResult());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }


}
