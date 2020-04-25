package com.wd.tech.activity.shequ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.bean.sheqv.SheqvFabuTieziBean;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;

import java.util.HashMap;

public class FabuTieziActivity extends BaseActivity implements View.OnClickListener{


    private TextView qvxiao;
    private TextView fasong;
    private EditText edit;
    private TextView jia;
    private TextView nuMaxcount;

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        qvxiao = findViewById(R.id.qvxiao);
        fasong = findViewById(R.id.fasong);
        edit = findViewById(R.id.edit);
        jia = findViewById(R.id.jia);
        nuMaxcount = findViewById(R.id.nuMaxcount);
        qvxiao.setOnClickListener(this);
        fasong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = edit.getText().toString().trim();
                HashMap<String, Object> map = new HashMap<>();
                map.put("content",trim);
                mPresenter.startpostInfoHava(MyUrl.sheqvfabutiezi, SheqvFabuTieziBean.class,map);
            }
        });
        edit.setOnClickListener(this);
        jia.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qvxiao:
                finish();
                break;
            case R.id.fasong:

                break;
            case R.id.edit:
                //输入框字数限制
                        edit.addTextChangedListener(new TextWatcher() {
                            private CharSequence temp;//监听前的文本
                            private int editStart;//光标开始位置
                            private int editEnd;//光标结束位置
                            private final int charMaxNum = 300;

                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                temp = s;
                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                nuMaxcount.setText("还能输入" + (charMaxNum - s.length()) + "字符");
                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                editStart = edit.getSelectionStart();
                                editEnd = edit.getSelectionEnd();
                                if (temp.length() > charMaxNum) {
                                    Toast.makeText(getApplicationContext(), "你输入的字数已经达到了限制！", Toast.LENGTH_LONG).show();
                                    s.delete(editStart - 1, editEnd);
                                    int tempSelection = editStart;
                                    edit.setText(s);
                                    edit.setSelection(tempSelection);
                                }
                            }
                        });
                break;
            case R.id.jia:

                break;
        }
    }


    @Override
    protected int Layout() {
        return R.layout.activity_fabu_tiezi;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof SheqvFabuTieziBean){
            String status = ((SheqvFabuTieziBean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onError(String error) {

    }


}
