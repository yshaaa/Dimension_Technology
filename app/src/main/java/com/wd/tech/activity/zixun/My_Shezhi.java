package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.tech.My_Shezhi_pwd;
import com.wd.tech.R;
import com.wd.tech.activity.dlzc.LoginActivity;
import com.wd.tech.adapter.zixun.My_Jifen_Adapter;
import com.wd.tech.bean.zixun.My_jifenBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.HashMap;
import java.util.Map;

public class My_Shezhi extends BaseActivity {
    TextView textViewname,textView_sex,textView_style,textView_sr,textView_phone,textView_email,textView_jf,textView_vip,textView_faceid;
            TextView textView_wx,call_login,xiugai;
    ImageView imageView_hea;


    private String headPic;
    private String phone;
    private String nickName;
    private int sum;

    @Override
    protected void startCoding() {
        Intent intent = getIntent();
        headPic = intent.getStringExtra("headPic");
        phone = intent.getStringExtra("phone");
        nickName = intent.getStringExtra("nickName");

        Glide.with(this).load(headPic).into(imageView_hea);
        textViewname.setText(nickName);

        textView_phone.setText(phone);


        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",99);
        mPresenter.startgetInofHava(MyUrl.BASe_Jifen_Mx, My_jifenBean.class,map);



        call_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(My_Shezhi.this, LoginActivity.class));
            }
        });


        xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(My_Shezhi.this, My_Shezhi_pwd.class);
                startActivity(intent1);
            }
        });




    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        imageView_hea=findViewById(R.id.shezhi_hea);

        textViewname=findViewById(R.id.shezhi_name);
        textView_sex=findViewById(R.id.shezhi_sex);
        textView_style=findViewById(R.id.shezhi_style);
        textView_sr=findViewById(R.id.shezhi_sr);
        textView_phone=findViewById(R.id.shezhi_phone);
        textView_email=findViewById(R.id.shezhi_Email);

        textView_jf=findViewById(R.id.shezhi_jf);
        textView_vip=findViewById(R.id.shezhi_vip);
        textView_faceid=findViewById(R.id.shezhi_faceid);

        call_login=findViewById(R.id.call_login);
        xiugai=findViewById(R.id.xiugaimima);


    }

    @Override
    protected int Layout() {
        return R.layout.activity_my__shezhi;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof My_jifenBean){
            My_Jifen_Adapter my_jifen_adapter = new My_Jifen_Adapter(((My_jifenBean) o).getResult(), My_Shezhi.this);

            textView_jf.setText(my_jifen_adapter.sum()+"");
        }
    }

    @Override
    public void onError(String error) {

    }
}
