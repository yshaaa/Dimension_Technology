package com.wd.tech.activity.zixun;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.wd.tech.R;
import com.wd.tech.activity.MyFragmentActicity;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class Zixun_Mohu extends BaseActivity {


    private String edit_mohu;

    RecyclerView recyclerView;

    EditText editText;
    ImageView imageView;


    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();

    TabLayout tabLayout;
    ViewPager pager;
    private Zixun_Mohu_wenzhang zixun_mohu_wenzhang;
    private Zixun_Mohu_Zuozhe zixun_mohu_zuozhe;


    @Override
    protected void startCoding() {

        edit_mohu = getIntent().getStringExtra("edit_mohu");
        Log.e("aaa","模糊查询信息"+edit_mohu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                edit_mohu = editText.getText().toString().trim();
                Log.e("aaa","分页edit:"+edit_mohu);



                Toast.makeText(Zixun_Mohu.this, edit_mohu, Toast.LENGTH_SHORT).show();
            }
        });



        sl.add("文章");
        sl.add("作者");

        Bundle bundle = new Bundle();
        bundle.putString("edit_mohu",edit_mohu);


        zixun_mohu_wenzhang = new Zixun_Mohu_wenzhang();


        zixun_mohu_zuozhe = new Zixun_Mohu_Zuozhe();

        zixun_mohu_wenzhang.setArguments(bundle);
        zixun_mohu_zuozhe.setArguments(bundle);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(500);
                    zixun_mohu_wenzhang.setArguments(bundle);
                    zixun_mohu_zuozhe.setArguments(bundle);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();



        fl.add(zixun_mohu_wenzhang);
        fl.add(zixun_mohu_zuozhe);

        MyFragmentActicity myFragmentActicity = new MyFragmentActicity(getSupportFragmentManager(), sl, fl);

        tabLayout.setupWithViewPager(pager);

        pager.setAdapter(myFragmentActicity);





    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        tabLayout=findViewById(R.id.zixun_tab);
        pager=findViewById(R.id.zixun_pager);

        editText=findViewById(R.id.zixun_mohu_dq_edit);
        imageView=findViewById(R.id.zixun_mohu_dq_sousuo);


    }

    @Override
    protected int Layout() {
        return R.layout.activity_zixun__mohu;
    }

    @Override
    public void onSuccess(Object o) {





    }

    @Override
    public void onError(String error) {

    }
}
