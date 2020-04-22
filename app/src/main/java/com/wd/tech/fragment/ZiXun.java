package com.wd.tech.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.tech.R;
import com.wd.tech.activity.zixun.Zixun_XQ;
import com.wd.tech.adapter.zixun.ZixunAdapter;
import com.wd.tech.bean.zixun.BannerBean;
import com.wd.tech.bean.zixun.ZixunBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZiXun extends BaseFragment {

    private Banner banner;

    RecyclerView zixun_recyc;

    ArrayList<String> list=new ArrayList<>();
    private ArrayList<ZixunBean.ResultBean> listzixun=new ArrayList<>();
    private ZixunAdapter zixunAdapter;


    @Override
    protected void startCoding() {
        mPresenter.startgetInfo(MyUrl.BASE_ZiXun_LunBo, BannerBean.class);



        HashMap<String,Object> map=new HashMap<>();
        map.put("plateId",1);
        map.put("page",1);
        map.put("count",11);
        mPresenter.startgetInofHava(MyUrl.BASE_Zixun, ZixunBean.class,map);

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        banner=view.findViewById(R.id.banner);

        zixun_recyc=view.findViewById(R.id.ZiXun_recyc);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        zixun_recyc.setLayoutManager(manager);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_zi_xun;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof BannerBean){
            List<BannerBean.ResultBean> result = ((BannerBean) o).getResult();

            for (int i = 0; i < result.size(); i++) {
                list.add(result.get(i).getImageUrl());
                Log.e("aaa","bannerima"+list.get(i));
            }


            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(getActivity()).load(path).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(imageView);
                }
            }).setDelayTime(1500).setImages(list).start();

        }




        if(o instanceof ZixunBean){
            zixunAdapter = new ZixunAdapter(((ZixunBean) o).getResult(), getActivity());
            zixun_recyc.setAdapter(zixunAdapter);
            zixunAdapter.setZixunCallBack(new ZixunAdapter.ZixunCallBack() {
                @Override
                public void onClick(int position) {
                    int id = ((ZixunBean) o).getResult().get(position).getId();
                    String s = String.valueOf(id);
                    Intent intent = new Intent(getActivity(), Zixun_XQ.class);
                    intent.putExtra("id",s);
                    Log.e("aaa","id"+s+"///"+id);
                    startActivity(intent);
                }
            });


        }
    }

    @Override
    public void onError(String error) {

    }
}
