package com.wd.tech.activity.dlzc;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.bean.dlzc.ZCBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;
import com.wd.tech.rsa.RsaCoder;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity {


    private EditText phone;
    private Button register;
    private EditText name;
    private EditText pwd;
    private String pwd1;
    private String phone1;
    private String name1;
    private String s;
    private String status;
    private String a;
    TextView ca_lo;

    @Override
    protected void startCoding() {
        ca_lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        ca_lo=findViewById(R.id.ca_lo);
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        name = findViewById(R.id.name);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone1 = phone.getText().toString().trim();
                pwd1 = pwd.getText().toString().trim();
                try {
                    s = RsaCoder.encryptByPublicKey(pwd1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("aaa","注册密码加密"+s);
                name1 = name.getText().toString().trim();
                HashMap<String, Object> map = new HashMap<>();
                map.put("phone",phone1);
                map.put("nickName",name1);
                map.put("pwd",s);
                mPresenter.startpostInfoHava(MyUrl.BASE_ZC,ZCBean.class,map);
            }
        });


    }

    @Override
    protected int Layout() {
        return R.layout.activity_register;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof ZCBean){
            status = ((ZCBean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((ZCBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, ((ZCBean) o).getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
