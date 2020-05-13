package com.wd.tech.fragment.xiaoxi.tinajiahaoyou;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.adapter.xiaoxi.tianjiahaoyou.FindGroupAdapter;

import com.wd.tech.bean.xiaoxi.tianjia.FindGroupBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

//找群
public class FindGroupFragment extends BaseFragment {


    @BindView(R.id.rv_findgroup)
    RecyclerView rvFindgroup;
    @BindView(R.id.iv_ss)
    ImageView ivSs;
    @BindView(R.id.et_ss)
    EditText etSs;
    List<FindGroupBean.ResultBean>list=new ArrayList<>();

    @Override
    protected void startCoding() {
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvFindgroup.setLayoutManager(linearLayoutManager);
        //ivss是点击时收索的一个监听
        ivSs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里是文本框的id
                String groupId = etSs.getText().toString();
                HashMap<String, Object> map = new HashMap<>();
                map.put("groupId",groupId);
                mPresenter.startgetInofHava(MyUrl.find_group,FindGroupBean.class,map);


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
        return R.layout.fragment_find_group;
    }

    @Override
    public void onSuccess(Object o) {
        //查询成展示列表
        //首先判断选择那个Bean类需要进行展示就写那个
        if (o instanceof FindGroupBean) {
            FindGroupBean.ResultBean result = ((FindGroupBean) o).getResult();
            list.add(result);
            FindGroupAdapter findGroupAdapter = new FindGroupAdapter(getContext(),list);
            //设置适配器
            rvFindgroup.setAdapter(findGroupAdapter);

        }

    }

    @Override
    public void onError(String error) {

    }
}
