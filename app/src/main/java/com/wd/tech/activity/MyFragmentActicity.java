package com.wd.tech.activity;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author 邓先超
 * @date 2020/4/23 20:35
 */
public class MyFragmentActicity extends FragmentPagerAdapter {
    List<String> sl;
    List<Fragment> fl;

    public MyFragmentActicity(FragmentManager fm, List<String> sl, List<Fragment> fl) {
        super(fm);
        this.sl = sl;
        this.fl = fl;
    }

    @Override
    public Fragment getItem(int position) {
        return fl.get(position);
    }

    @Override
    public int getCount() {
        return fl.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return sl.get(position);
    }
}
