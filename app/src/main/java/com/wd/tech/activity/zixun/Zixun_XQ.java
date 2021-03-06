package com.wd.tech.activity.zixun;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.adapter.zixun.Zixun_Xq_Adapter;
import com.wd.tech.adapter.zixun.Zixun_pl_LiebiaoAdapter;
import com.wd.tech.adapter.zixun.Zixun_tuijianAdapter;
import com.wd.tech.bean.zixun.SC_FBean;
import com.wd.tech.bean.zixun.ScBean;
import com.wd.tech.bean.zixun.ZanBean;
import com.wd.tech.bean.zixun.Zan_f_Bean;
import com.wd.tech.bean.zixun.ZixunBean;
import com.wd.tech.bean.zixun.Zixun_PlBean;
import com.wd.tech.bean.zixun.Zixun_Pl_LiebiaoBean;
import com.wd.tech.bean.zixun.Zixun_XQBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zixun_XQ extends BaseActivity {
    RecyclerView recyclerView,recyclerView2,recyclerView3;
    private Integer iid;

    List<Zixun_XQBean.ResultBean> list=new ArrayList<>();
    private Zixun_tuijianAdapter zixunAdapter;
    private int share;

    EditText editText_pl;
    Button button_fs;
    private Zixun_pl_LiebiaoAdapter zixun_pl_liebiaoAdapter;

    ImageView zixun_xq_pl_ima,zixun_xq_zan_ima,zixun_xq_ax_ima,zixun_xq_share_ima;
    TextView zixun_xq_pl_number,zixun_xq_zan_number,zixun_xq_ax_number,zixun_xq_share_number;

    boolean flag=false;
    boolean flag2=false;
    int j=0;
    private int whetherGreat;

    ImageView ffima;
    private String id;

    @Override
    protected void startCoding() {
        id = getIntent().getStringExtra("id");
        iid = Integer.valueOf(id);

        Log.e("aaa","id_xq"+iid);

        Zixun_Xq_Adapter zixun_xq_adapter = new Zixun_Xq_Adapter(list, Zixun_XQ.this);
        recyclerView.setAdapter(zixun_xq_adapter);


        //资讯详情
        Map<String,Object> map=new HashMap<>();
        map.put("id",iid);
        mPresenter.startgetInofHava(MyUrl.BASE_ZixunXQ, Zixun_XQBean.class,map);



        //详情推荐

        String sshare = String.valueOf(share);
        if(sshare.equals("")){
            Toast.makeText(this, "id为空", Toast.LENGTH_SHORT).show();
        }else {
            HashMap<String,Object> map1=new HashMap<>();
            map1.put("plateId",share);
            map1.put("page",1);
            map1.put("count",11);
            mPresenter.startgetInofHava(MyUrl.BASE_Zixun, ZixunBean.class,map1);
        }


        HashMap<String,Object> map2=new HashMap<>();
        map2.put("infoId",iid);
        map2.put("page",1);
        map2.put("count",15);
        mPresenter.startgetInofHava(MyUrl.BASE_Zixun_Plliebiao, Zixun_Pl_LiebiaoBean.class,map2);




        button_fs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seditText_pl = editText_pl.getText().toString().trim();
                HashMap<String,Object> map3=new HashMap<>();
                map3.put("infoId",iid);
                map3.put("content",seditText_pl);
                mPresenter.startpostInfoHava(MyUrl.BASE_Zixun_Pl, Zixun_PlBean.class,map3);
                zixun_pl_liebiaoAdapter.notifyDataSetChanged();
            }
        });









        //评论,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
        zixun_xq_pl_ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    zixun_xq_pl_ima.setImageResource(R.drawable.xx1);
                    flag=false;
                }else {
                    zixun_xq_pl_ima.setImageResource(R.drawable.xx2);
                    flag=true;
                }
            }
        });


        //点赞,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
        zixun_xq_zan_ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(whetherGreat==1){
                    if(flag2){
                        flag2=false;
                        HashMap<String,Object> map6=new HashMap<>();
                        map6.put("infoId",iid);
                        mPresenter.startpostInfoHava(MyUrl.BASE_Dianzan_false, Zan_f_Bean.class,map6);
                        zixun_xq_zan_ima.setImageResource(R.drawable.zan_1);

                    }else {
                        flag2=true;
                        HashMap<String,Object> map5=new HashMap<>();
                        map5.put("infoId",iid);
                        mPresenter.startpostInfoHava(MyUrl.BASE_Dianzan_true, ZanBean.class,map5);

                        zixun_xq_zan_ima.setImageResource(R.drawable.zan_2);

                    }
                }else if(whetherGreat==2){
                    if(flag2){
                        flag2=false;
                        HashMap<String,Object> map6=new HashMap<>();
                        map6.put("infoId",iid);
                        mPresenter.startpostInfoHava(MyUrl.BASE_Dianzan_false, Zan_f_Bean.class,map6);
                        zixun_xq_zan_ima.setImageResource(R.drawable.zan_1);

                    }else {
                        flag2=true;
                        HashMap<String,Object> map5=new HashMap<>();
                        map5.put("infoId",iid);
                        mPresenter.startpostInfoHava(MyUrl.BASE_Dianzan_true, ZanBean.class,map5);

                        zixun_xq_zan_ima.setImageResource(R.drawable.zan_2);

                    }
                }

            }
        });


        //收藏,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
        zixun_xq_ax_ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    Map<String,Object> map8=new HashMap<>();
                    map8.put("infoId",iid);
                    mPresenter.startpostInfoHava(MyUrl.BASE_F_SC, SC_FBean.class,map8);
                    zixun_xq_ax_ima.setImageResource(R.drawable.ax1);
                    flag=false;
                }else {
                    Map<String,Object> map7=new HashMap<>();
                    map7.put("infoId",iid);
                    mPresenter.startpostInfoHava(MyUrl.BASE_SC, ScBean.class,map7);
                    zixun_xq_ax_ima.setImageResource(R.drawable.ax2);
                    flag=true;
                }
            }
        });



        //分享,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,



    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {

        ffima=findViewById(R.id.zixun_xq_fufei_ima);

        zixun_xq_pl_ima=findViewById(R.id.zixun_xq_pl_ima);
        zixun_xq_pl_number=findViewById(R.id.zixun_xq_pl_number);

        zixun_xq_zan_ima=findViewById(R.id.zixun_xq_zan_ima);
        zixun_xq_zan_number=findViewById(R.id.zixun_xq_zan_number);

        zixun_xq_ax_ima=findViewById(R.id.zixun_xq_ax_ima);
        zixun_xq_ax_number=findViewById(R.id.zixun_xq_ax_number);

        zixun_xq_share_ima=findViewById(R.id.zixun_xq_share_ima);
        zixun_xq_share_number=findViewById(R.id.zixun_xq_share_number);


        editText_pl=findViewById(R.id.zixun_pl_edit);
        button_fs=findViewById(R.id.zixun_pl_btn);

        recyclerView=findViewById(R.id.recyc_zixun_xq);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView2=findViewById(R.id.recyc_Xq_tuijian);
        LinearLayoutManager manager1=new LinearLayoutManager(this);
        manager1.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView2.setLayoutManager(manager1);


        recyclerView3=findViewById(R.id.recyc_Zixun_pl_liebiao);
        LinearLayoutManager manager3=new LinearLayoutManager(this);
        manager3.setOrientation(RecyclerView.VERTICAL);
        recyclerView3.setLayoutManager(manager3);

    }

    @Override
    protected int Layout() {
        return R.layout.activity_zixun__x_q;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof Zixun_XQBean){
            int readPower = ((Zixun_XQBean) o).getResult().getReadPower();
            if(readPower==2){
                Toast.makeText(this, "不可以阅读", Toast.LENGTH_SHORT).show();
//                Glide.with(this).load(R.drawable.fufei2).into(ffima);
                Intent intent = new Intent(Zixun_XQ.this, Zixun_xff.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }else if(readPower==1){
                list.add(((Zixun_XQBean) o).getResult());
                share = ((Zixun_XQBean) o).getResult().getShare();

                whetherGreat = ((Zixun_XQBean) o).getResult().getWhetherGreat();
            }

        }


        if(o instanceof ZixunBean) {
            zixunAdapter = new Zixun_tuijianAdapter(((ZixunBean) o).getResult(), Zixun_XQ.this);
            recyclerView2.setAdapter(zixunAdapter);
            zixunAdapter.setZixunCallBack(new Zixun_tuijianAdapter.ZixunCallBack() {
                @Override
                public void onClick(int position) {
                    int id = ((ZixunBean) o).getResult().get(position).getId();
                    String s = String.valueOf(id);
                    Intent intent = new Intent(Zixun_XQ.this, Zixun_XQ.class);
                    intent.putExtra("id", s);
                    Log.e("aaa", "id" + s + "///" + id);
                    startActivity(intent);
                }
            });

        }


        if(o instanceof Zixun_Pl_LiebiaoBean){
            zixun_pl_liebiaoAdapter = new Zixun_pl_LiebiaoAdapter(((Zixun_Pl_LiebiaoBean) o).getResult(), Zixun_XQ.this);
            recyclerView3.setAdapter(zixun_pl_liebiaoAdapter);


            

            zixun_xq_pl_number.setText((zixun_pl_liebiaoAdapter.sum()+2)+"");
        }

        if(o instanceof Zixun_PlBean){
            String status = ((Zixun_PlBean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((Zixun_PlBean) o).getMessage(), Toast.LENGTH_SHORT).show();
                zixun_pl_liebiaoAdapter.notifyDataSetChanged();
            }else {
                Toast.makeText(this, ((Zixun_PlBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


        if(o instanceof ZanBean){
            String status = ((ZanBean) o).getStatus();
            if(status.equals("0000")){
                Log.e("aaa","st"+status);
                Toast.makeText(this, ((ZanBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                Log.e("aaa","st"+status);
                Toast.makeText(this, ((ZanBean) o).getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

        if(o instanceof Zan_f_Bean){
            String status = ((Zan_f_Bean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((Zan_f_Bean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, ((Zan_f_Bean) o).getMessage(), Toast.LENGTH_SHORT).show();

            }
        }


        if(o instanceof ScBean){
            String status = ((ScBean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((ScBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, ((ScBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        if(o instanceof SC_FBean){
            String status = ((SC_FBean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((SC_FBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, ((SC_FBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


    }

    @Override
    public void onError(String error) {

    }
}
