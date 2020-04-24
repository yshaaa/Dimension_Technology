package com.wd.tech.fragment.xiaoxi;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.adapter.xiaoxi.FenzuAdapter;
import com.wd.tech.adapter.xiaoxi.FenzuHaoyouAdapter;
import com.wd.tech.bean.xiaoxi.FenzuBean;
import com.wd.tech.bean.xiaoxi.FenzuHaoyouBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseFragment;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class LianxirenFragment extends BaseFragment implements View.OnClickListener{

    private ArrayList<FenzuBean.ResultBean> list_one = new ArrayList<>();
    private ArrayList<FenzuHaoyouBean.ResultBean> list_two = new ArrayList<>();
    private EditText search_haoyou;
    private TextView xinpengyou;
    private TextView qunzu;
    private RecyclerView recy_fenzu;
    private RecyclerView recy_haoyou;
    private FenzuAdapter fenzuAdapter;
    private FenzuHaoyouAdapter fenzuHaoyouAdapter;


    @Override
    protected void startCoding() {
        fenzuAdapter = new FenzuAdapter(list_one,getActivity());
        recy_fenzu.setAdapter(fenzuAdapter);
        mPresenter.startgetInfo(MyUrl.xiaoxifenzu,FenzuBean.class);
        fenzuAdapter.setItemClick(new FenzuAdapter.ItemClick() {
            @Override
            public void setClick(int p) {
                fenzuHaoyouAdapter = new FenzuHaoyouAdapter(list_two,getActivity());
                recy_haoyou.setAdapter(fenzuHaoyouAdapter);
                int groupId = list_one.get(p).getGroupId();
                HashMap<String, Object> map = new HashMap<>();
                map.put("groupId",groupId);
                mPresenter.startgetInofHava(MyUrl.fenzuhaoyou,FenzuHaoyouBean.class,map);
            }
        });
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        search_haoyou = view.findViewById(R.id.search_haoyou);
        search_haoyou.setOnClickListener(this);
        xinpengyou = view.findViewById(R.id.xinpengyou);
        xinpengyou.setOnClickListener(this);
        qunzu = view.findViewById(R.id.qunzu);
        qunzu.setOnClickListener(this);
        recy_fenzu = view.findViewById(R.id.recy_fenzu);
        recy_fenzu.setLayoutManager(new LinearLayoutManager(getContext()));
        recy_haoyou = view.findViewById(R.id.recy_haoyou);
        recy_haoyou.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_haoyou:

                break;
            case R.id.xinpengyou:

                break;
            case R.id.qunzu:

                break;
        }
    }

    @Override
    protected int Layout() {
        return R.layout.fragment_lianxiren;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof FenzuBean){
            list_one.clear();
            list_one.addAll(((FenzuBean)o).getResult());
            fenzuAdapter.notifyDataSetChanged();
        }
        if(o instanceof FenzuHaoyouBean){
            list_two.clear();
            list_two.addAll(((FenzuHaoyouBean)o).getResult());
            fenzuHaoyouAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onError(String error) {

    }


}
