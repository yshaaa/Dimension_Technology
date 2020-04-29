package com.wd.tech;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.activity.zixun.My_Guanzhu;
import com.wd.tech.activity.zixun.My_Jifen;
import com.wd.tech.activity.zixun.My_Renwu;
import com.wd.tech.activity.zixun.My_Shezhi;
import com.wd.tech.activity.zixun.My_Shoucang;
import com.wd.tech.activity.zixun.My_Tiezi;
import com.wd.tech.activity.zixun.My_Tongzhi;
import com.wd.tech.activity.zixun.Zixun_Right_liebiao;
import com.wd.tech.adapter.zixun.Zixun_Bankuai_Adapter;
import com.wd.tech.bean.zixun.ZiXun_BankuaiBean;
import com.wd.tech.fragment.SheQu;
import com.wd.tech.fragment.XiaoXi;
import com.wd.tech.fragment.ZiXun;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

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

    TextView textView_Shoucang,textView_guanzhu,textView_tiezi,textView_tongzhi,textView_jifen,textView_renwu,textView_shezhi;

    LinearLayout linner;

    RecyclerView recyclerView;
    private String headPic;
    private String phone;
    private String nickName;

    @Override
    protected void startCoding() {

        nickName = getIntent().getStringExtra("nickName");

        Log.e("aaa","用户名字:"+ nickName);

        Intent intent = getIntent();
        headPic = intent.getStringExtra("headPic");
        phone = intent.getStringExtra("phone");
        //邓先超111

        textView.setText(nickName);




        righttextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "2222", Toast.LENGTH_SHORT).show();
            }
        });




        mPresenter.startgetInfo(MyUrl.BASE_Zixun_Bankuai, ZiXun_BankuaiBean.class);



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




        textView_Shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, My_Shoucang.class);
                startActivity(intent);
            }
        });

        textView_guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, My_Guanzhu.class);
                startActivity(intent);
            }
        });

        textView_tiezi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, My_Tiezi.class);
                startActivity(intent);
            }
        });

        textView_tongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, My_Tongzhi.class);
                startActivity(intent);
            }
        });

        textView_renwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, My_Renwu.class);
                startActivity(intent);
            }
        });

        textView_jifen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, My_Jifen.class);
                startActivity(intent);
            }
        });

        textView_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, My_Shezhi.class);
                intent.putExtra("headPic",headPic);
                intent.putExtra("phone",phone);
                intent.putExtra("nickName",nickName);
                startActivity(intent);
            }
        });




    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {

        linner=findViewById(R.id.linner);

        textView_Shoucang=findViewById(R.id.zixun_shoucang);
        textView_guanzhu=findViewById(R.id.zixun_guanzhu);
        textView_tiezi=findViewById(R.id.zixun_tiezi);
        textView_tongzhi=findViewById(R.id.zixun_tongzhi);
        textView_renwu=findViewById(R.id.zixun_renwu);
        textView_jifen=findViewById(R.id.zixun_jifen);
        textView_shezhi=findViewById(R.id.zixun_shezhi);


        recyclerView=findViewById(R.id.recyc_zixun_right);
        GridLayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);

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
        if(o instanceof ZiXun_BankuaiBean){
            Zixun_Bankuai_Adapter zixun_bankuai_adapter = new Zixun_Bankuai_Adapter(((ZiXun_BankuaiBean) o).getResult(), MainActivity.this);
            recyclerView.setAdapter(zixun_bankuai_adapter);

            zixun_bankuai_adapter.setBankuaiCallBack(new Zixun_Bankuai_Adapter.BankuaiCallBack() {
                @Override
                public void onClick(int position) {
                    int id = ((ZiXun_BankuaiBean) o).getResult().get(position).getId();
                    String s = String.valueOf(id);
                    Intent intent = new Intent(MainActivity.this, Zixun_Right_liebiao.class);
                    intent.putExtra("s",s);
                    startActivity(intent);
                }
            });

        }
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
