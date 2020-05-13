package com.wd.tech.activity.xiaoxi.tianjia;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.wd.tech.R;
import com.wd.tech.fragment.xiaoxi.tinajiahaoyou.FindGroupFragment;
import com.wd.tech.fragment.xiaoxi.tinajiahaoyou.FindPeopleFragment;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TianjiahaoyouActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rg)
    RadioGroup rg;

    @BindView(R.id.vp)
    ViewPager vp;

    List<String> stringList = new ArrayList<>();
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void startCoding() {
        stringList.add("找人");
        stringList.add("找群");
        FindPeopleFragment findPeopleFragment = new FindPeopleFragment();
        FindGroupFragment findGroupFragment = new FindGroupFragment();
        fragmentList.add(findPeopleFragment);
        fragmentList.add(findGroupFragment);


        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return stringList.get(position);
            }
        });
//        //选中第一个找人
//
//        rg.getChildAt(rg.getChildAt(0).getId());


    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int Layout() {
        return R.layout.activity_tianjiahaoyou;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }



    @OnClick({R.id.rb1, R.id.rb2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                vp.setCurrentItem(0);
                break;
            case R.id.rb2:
                vp.setCurrentItem(1);
                break;
        }
    }
}
