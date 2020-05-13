package com.wd.tech.fragment.xiaoxi.tinajiahaoyou;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;

import com.wd.tech.adapter.xiaoxi.tianjiahaoyou.FindPeopleAdapter;
import com.wd.tech.bean.xiaoxi.tianjia.FindpeopleBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//找人
public class FindPeopleFragment extends BaseFragment {


    @BindView(R.id.rv_findpeople)
    RecyclerView rvFindpeople;
    @BindView(R.id.iv_ss)
    ImageView ivSs;
    @BindView(R.id.et_ss)
    EditText etSs;
    List<FindpeopleBean.ResultBean>list=new ArrayList<>();

    @Override
    protected void startCoding() {
        //设置布局管理器
        rvFindpeople.setLayoutManager(new LinearLayoutManager(getContext()));


        //收索按钮设置点击事件
        ivSs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取et的文字内容(也就是文本框里面输入的手机号码)
                String phone = etSs.getText().toString();

                //new HasMap集合
                HashMap<String, Object> map = new HashMap<>();
                //map.参数(这里需要三个参数1.userId2.sessionId3.phone
                // 因为在工具类里面已经封装过userId和sessionId,所以在这里只用写一个phone的参数就行了)
                map.put("phone",phone);
                mPresenter.startgetInofHava(MyUrl.find_people,FindpeopleBean.class,map);
            }
        });


    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    protected int Layout() {
        return R.layout.fragment_find_people;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof FindpeopleBean){
//            SuoAdapter suoAdapter = new SuoAdapter(this, ((BiaotiSerchBean) o).getResult());
//
//            rvv.setAdapter(suoAdapter);

            FindpeopleBean.ResultBean result = ((FindpeopleBean) o).getResult();
            list.add(result);
            FindPeopleAdapter findPeopleAdapter = new FindPeopleAdapter(getContext(),list);
            rvFindpeople.setAdapter(findPeopleAdapter);


        }

    }

    @Override
    public void onError(String error) {
        Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
    }


}
