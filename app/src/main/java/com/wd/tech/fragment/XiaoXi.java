package com.wd.tech.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.tech.R;
import com.wd.tech.fragment.xiaoxi.LinkManFragment;
import com.wd.tech.fragment.xiaoxi.XiaoXiLiebiaoFragment;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;


public class XiaoXi extends BaseFragment {

    private TabLayout tab;
    private ViewPager vp;
    private  ArrayList<Fragment> flsit = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        tab = view.findViewById(R.id.tab_xiaoxi);
        vp = view.findViewById(R.id.vp_xiaoxi);
        list.add("消息");
        list.add("联系人");
        flsit.add(new XiaoXiLiebiaoFragment());
        flsit.add(new LinkManFragment());

        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return flsit.get(position);
            }

            @Override
            public int getCount() {
                return flsit.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        tab.setupWithViewPager(vp);

    }

    @Override
    protected int Layout() {
        return R.layout.activity_xiao_xi;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
