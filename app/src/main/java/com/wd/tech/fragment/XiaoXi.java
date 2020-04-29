package com.wd.tech.fragment;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wd.tech.MainActivity;
import com.wd.tech.R;
import com.wd.tech.activity.xiaoxi.tianjia.ChuangjianqunActivity;
import com.wd.tech.activity.xiaoxi.tianjia.TianjiahaoyouActivity;
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
    private ImageView jiahao;

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        jiahao = view.findViewById(R.id.jiahao);
        jiahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(jiahao);
            }
        });

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

    private void showPopupMenu(View view) {
        // View当前PopupMenu显示的相对View的位置
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        // menu布局
        popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());
        // menu的item点击事件


        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                CharSequence title = item.getTitle();
                if(title.equals("添加好友/群")){
                    Intent intent = new Intent(getContext(),TianjiahaoyouActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getContext(), ChuangjianqunActivity.class);
                    startActivity(intent);
                }


                return false;
            }
        });
//        // PopupMenu关闭事件
//        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
//            @Override
//            public void onDismiss(PopupMenu menu) {
//              //  Toast.makeText(getContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
//            }
//        });

        popupMenu.show();
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
