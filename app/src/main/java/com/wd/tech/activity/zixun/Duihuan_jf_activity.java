package com.wd.tech.activity.zixun;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.adapter.zixun.My_Jifen_Adapter;
import com.wd.tech.bean.zixun.JfDh_Bean;
import com.wd.tech.bean.zixun.My_jifenBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.HashMap;
import java.util.Map;

public class Duihuan_jf_activity extends BaseActivity {
    TextView jifen_number;

    Button lj_duihuan;
    private Integer idd;

    @Override
    protected void startCoding() {

        String id = getIntent().getStringExtra("id");
        idd = Integer.valueOf(id);


        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",99);
        mPresenter.startgetInofHava(MyUrl.BASe_Jifen_Mx, My_jifenBean.class,map);

        lj_duihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map1=new HashMap<>();
                map1.put("infoId",idd);
                map1.put("integralCost",5);
                mPresenter.startpostInfoHava(MyUrl.BASE_jf_dh, JfDh_Bean.class,map1);
            }
        });

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        jifen_number=findViewById(R.id.duihuan_number);
        lj_duihuan=findViewById(R.id.lj_duihuan);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_duihuan_jf_activity;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof My_jifenBean){
            My_Jifen_Adapter my_jifen_adapter = new My_Jifen_Adapter(((My_jifenBean) o).getResult(), Duihuan_jf_activity.this);
            jifen_number.setText(my_jifen_adapter.sum()+"");
        }

        if((o instanceof JfDh_Bean)){
            String status = ((JfDh_Bean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((JfDh_Bean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, ((JfDh_Bean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
