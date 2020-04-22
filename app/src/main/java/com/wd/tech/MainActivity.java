package com.wd.tech;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.fragment.SheQu;
import com.wd.tech.fragment.XiaoXi;
import com.wd.tech.fragment.ZiXun;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;
import com.wd.tech.rsa.RsaCoder;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    FragmentManager manager;
    RadioGroup radioGroup;
    Fragment fragment;
    TextView textView,righttextView;
    ImageView tx;
    Button button;
    DrawerLayout layout;
    private String s;
    //123123123
    //123123123
    //3123123123
    //123123

    @Override
    protected void startCoding() {





        
        //邓先超111

        textView.setText("11111");

        righttextView.setText("22222");
        righttextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "2222", Toast.LENGTH_SHORT).show();
            }
        });











        try {
            s = RsaCoder.encryptByPublicKey("d123456");
        } catch (Exception e) {
            e.printStackTrace();
        }


        Log.e("aaa",""+s);


        final ZiXun ziXun = new ZiXun();

        final XiaoXi xiaoXi = new XiaoXi();

        final SheQu sheQu = new SheQu();



        manager=getSupportFragmentManager();

        manager.beginTransaction()
                .add(R.id.frag,ziXun)
                .add(R.id.frag,xiaoXi)
                .add(R.id.frag,sheQu)
                .show(ziXun).hide(xiaoXi).hide(sheQu)
                .commit();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio1:
                        manager.beginTransaction()
                                .show(ziXun).hide(xiaoXi).hide(sheQu)
                                .commit();
                        break;

                    case R.id.radio2:
                        manager.beginTransaction()
                                .hide(ziXun).show(xiaoXi).hide(sheQu)
                                .commit();
                        break;

                    case R.id.radio3:
                        manager.beginTransaction()
                                .hide(ziXun).hide(xiaoXi).show(sheQu)
                                .commit();
                        break;
                }
            }
        });

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {

        righttextView=findViewById(R.id.selct_fenlei);

        radioGroup=findViewById(R.id.rg1);
        textView=findViewById(R.id.celaname);

    }

    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
    public void left(View v){
        layout.openDrawer(Gravity.LEFT);
        layout.closeDrawer(Gravity.LEFT);/*重点，自动关闭侧边栏*/
    }

    public void right(View v){
        layout.openDrawer(Gravity.RIGHT);
        layout.closeDrawer(Gravity.RIGHT);/*重点，自动关闭侧边栏*/
    }
    public void name(View view) {
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
    }
}
