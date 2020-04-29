package com.wd.tech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wd.tech.bean.zixun.My_Xiugai_PwdBean;
import com.wd.tech.bean.zixun.My_jifenBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;
import com.wd.tech.rsa.RsaCoder;

import java.util.HashMap;
import java.util.Map;

public class My_Shezhi_pwd extends BaseActivity {

    EditText edit_oldpwd,edit_newpwd;
    Button button;
    private String rsaold;
    private String rsanew;

    @Override
    protected void startCoding() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old = edit_oldpwd.getText().toString().trim();
                String newpwd = edit_newpwd.getText().toString().trim();

                try {
                    rsaold = RsaCoder.encryptByPublicKey(old);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    rsanew = RsaCoder.encryptByPublicKey(newpwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Map<String,Object> map=new HashMap<>();
                map.put("oldPwd",rsaold);
                map.put("newPwd",rsanew);
                mPresenter.startputInfoHava(MyUrl.BASE_Xiugai_pwd, My_Xiugai_PwdBean.class,map);
            }
        });




    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        edit_oldpwd=findViewById(R.id.oldpwd);
        edit_newpwd=findViewById(R.id.newpwd);
        button=findViewById(R.id.xiugai_btn);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_my__shezhi_pwd;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof My_Xiugai_PwdBean){
            String status = ((My_Xiugai_PwdBean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((My_Xiugai_PwdBean) o).getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("aaa","密码修改"+((My_Xiugai_PwdBean) o).getMessage());
            }else {
                Toast.makeText(this, ((My_Xiugai_PwdBean) o).getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
