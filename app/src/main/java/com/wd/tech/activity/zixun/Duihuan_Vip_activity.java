package com.wd.tech.activity.zixun;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.wd.tech.R;
import com.wd.tech.adapter.zixun.Vip_Adapter;
import com.wd.tech.bean.zixun.GmBean;
import com.wd.tech.bean.zixun.VipBean;
import com.wd.tech.bean.zixun.ZhifuBean;
import com.wd.tech.mvp.MD5Utils;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.NetUtil;
import com.wd.tech.mvp.app.MyApp;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class Duihuan_Vip_activity extends BaseActivity{
    RecyclerView recyclerView;
    List<VipBean.ResultBean> list=new ArrayList<>();

    TextView vip_price;
    Button vip_kaitong;
    private int commodityId;
    private String orderId;

    @Override
    protected void startCoding() {
        mPresenter.startgetInfo(MyUrl.BASE_VIP, VipBean.class);

        vip_kaitong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pss = getSharedPreferences("yan", MODE_PRIVATE);
                String userId = pss.getString("userId", "");
                Log.e("aaa","购买userId"+userId);

                Log.e("aaa","commodityId,log:"+commodityId);

                MD5Utils md5Utils = new MD5Utils();
                String md5_sign = md5Utils.MD5(userId + commodityId + "tech");


                Log.e("aaa","合并"+userId+ commodityId +"tech");
                Log.e("aaa","加密sign"+md5_sign);


                Map<String,Object> map=new HashMap<>();
                map.put("commodityId",commodityId);
                map.put("sign",md5_sign);
                mPresenter.startpostInfoHava(MyUrl.BASE_Gm, GmBean.class,map);




                Map<String,Object> map1=new HashMap<>();
                map1.put("orderId",orderId);
                map1.put("payType",1);
                mPresenter.startpostInfoHava(MyUrl.BASE_Zhifu, ZhifuBean.class,map1);


            }
        });

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        vip_kaitong=findViewById(R.id.vip_kaitong);

        vip_price=findViewById(R.id.vip_price);

        recyclerView=findViewById(R.id.recyc_vip);
        GridLayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);


    }

    @Override
    protected int Layout() {
        return R.layout.activity_duihuan__vip_activity;
    }


    @Override
    public void onSuccess(Object o) {
        if(o instanceof  VipBean){
            Vip_Adapter vip_adapter = new Vip_Adapter(((VipBean) o).getResult(), Duihuan_Vip_activity.this);
            recyclerView.setAdapter(vip_adapter);
            vip_adapter.setZixunCallBack(new Vip_Adapter.ZixunCallBack() {
                @Override
                public void onClick(int position) {
                    double price = ((VipBean) o).getResult().get(position).getPrice();
                    Log.e("aaa","vip价格"+price);
                    String s = String.valueOf(price);
                    vip_price.setText(s);

                    commodityId = ((VipBean) o).getResult().get(position).getCommodityId();

                    Log.e("aaa","commodityId:"+ commodityId);




                }
            });
        }



        if(o instanceof GmBean){
            orderId = ((GmBean) o).getOrderId();
            Log.e("aaa","单号"+ orderId);
            Toast.makeText(this, ((GmBean) o).getMessage(), Toast.LENGTH_SHORT).show();






//            NetUtil.getInstance().Net_pal(MyUrl.ZHIFUURL, OrderBean.class, map, map1, new Icontract.ToCall() {
//                @Override
//                public void success(String stra) {
//                    OrderBean orderBean = gson.fromJson(stra, OrderBean.class);
////                                String status = orderBean.getStatus();
//
//                    PayReq req = new PayReq();
//
//                    req.appId = orderBean.getAppId();
//                    req.nonceStr = orderBean.getNonceStr();
//                    req.partnerId = orderBean.getPartnerId();
//                    req.prepayId = orderBean.getPrepayId();
//                    req.sign = orderBean.getSign();
//                    req.timeStamp = orderBean.getTimeStamp();
//                    req.packageValue = orderBean.getPackageValue();
//
//                    //去调微信
//                    MyApp.mWxApi.sendReq(req);
//                }
//            });


        }




        if(o instanceof ZhifuBean){

            String status = ((ZhifuBean) o).getStatus();


            PayReq req = new PayReq();

            req.appId = ((ZhifuBean) o).getAppId();
            req.nonceStr = ((ZhifuBean) o).getNonceStr();
            req.partnerId = ((ZhifuBean) o).getPartnerId();
            req.prepayId = ((ZhifuBean) o).getPrepayId();
            req.sign = ((ZhifuBean) o).getSign();
            req.timeStamp = ((ZhifuBean) o).getTimeStamp();
            req.packageValue = ((ZhifuBean) o).getPackageValue();

            //去调微信
            MyApp.mWxApi.sendReq(req);
        }


    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


}
