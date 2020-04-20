package com.wd.tech.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wd.tech.MainActivity;
import com.wd.tech.R;
import com.wd.tech.bean.DlBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;
import com.wd.tech.rsa.RsaCoder;

import java.util.HashMap;

public class LoginActivity extends BaseActivity implements View.OnClickListener{


    private EditText phone;
    private EditText pwd;
    private Button login;
    private String status;
    private String pwd1;
    private SharedPreferences sharedPreferences;
    private String s;
    private String phone1;



    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);


        try {
            s = RsaCoder.encryptByPublicKey("d123456");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e("tag",s);
        sharedPreferences = getSharedPreferences("yan", MODE_PRIVATE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                phone1 = phone.getText().toString().trim();
                pwd1 = pwd.getText().toString().trim();
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                HashMap<String, Object> map = new HashMap<>();
                map.put("phone", phone1);
                map.put("pwd", s);
                mPresenter.startpostInfoHava(MyUrl.BASE_DL, DlBean.class,map);
                break;
        }
    }


    @Override
    protected int Layout() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof DlBean){
            DlBean.ResultBean result = ((DlBean) o).getResult();
            sharedPreferences.edit().putString("userId", result.getUserId() + "").commit();
            sharedPreferences.edit().putString("sessionId", result.getSessionId() + "").commit();
            Toast.makeText(this, "0000", Toast.LENGTH_SHORT).show();
            if(((DlBean) o).getStatus().equals("0000")){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }

    }

    @Override
    public void onError(String error) {

    }


}
