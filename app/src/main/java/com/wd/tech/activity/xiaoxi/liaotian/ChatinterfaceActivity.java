package com.wd.tech.activity.xiaoxi.liaotian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.MainActivity;
import com.wd.tech.R;
import com.wd.tech.bean.xiaoxi.FriendListBean;
import com.wd.tech.mvp.app.MyApp;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;
import com.wd.tech.rsa.MD5Utils;
import com.wd.tech.rsa.RsaCoder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.MessageContent;
import cn.jpush.im.android.api.enums.ContentType;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.api.BasicCallback;

public class ChatinterfaceActivity extends BaseActivity {


    private String name;
    private ImageView fanhui;
    private ImageView xinxi;
    private TextView name1;
    private EditText edtext1;
    private TextView text1;
    private Conversation mConversation;

    @Override
    protected void startCoding() {

        name = getIntent().getStringExtra("name");
        name1.setText(name);


    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        fanhui = findViewById(R.id.fanhui);
        xinxi = findViewById(R.id.xinxi);
        name1 = findViewById(R.id.name);



//        注册
        JMessageClient.registerEventReceiver(this);
        String s = "";
        String passWord = "";
//       进行R解密
        try {

            s = RsaCoder.decryptByPublicKey("LA/0Je691M/FqyyreFL9Tyw7aV5PXcaMjUwbtuTaYFhuDNt3HrsWMWi/fjdSxqJDoPiJ72gai78jIrNfNE01BtbAZDiS2Zzu/wrRLQCmMk08pcIXEBVJq5tsk9e3bZVxAexdNpOYlRqo0OY3O1jeQ/ahyqJd5EAqsy9QHYqyKJQ=");
            passWord = MD5Utils.getMd5(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JMessageClient.login("MwzAnd13083692050","d123456", new BasicCallback() {
            @Override
            public void gotResult(int i, String s) {
                Log.i("TAG", "gotResult: i:" + i + "   s:" + s);
                if (i == 0 && TextUtils.equals("Success", s)) {
                    //IM登录成功  开始创建会话对象
                    mConversation = Conversation.createSingleConversation("NY43b315721291693", MyApp.DOCTOR_APP_KEY);
                }
            }
        });

        edtext1 = (EditText) findViewById(R.id.edtext1);
        text1 = (TextView) findViewById(R.id.text1);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edtext1.getText().toString();
                if (!TextUtils.isEmpty(s)) {
                    /**
                     * 1.创建消息对象
                     * 2.发送消息给会话对应的聊天对象
                     */

                    //1
                    Message message = mConversation.createSendTextMessage(s);
                    message.setOnSendCompleteCallback(new BasicCallback() {
                        @Override
                        public void gotResult(int i, String s) {
                            if (i == 0) {
                                //发送成功


                            } else {
                                //发送失败

                            }
                        }
                    });

                    //2
                    JMessageClient.sendMessage(message);

                } else {
                    Toast.makeText(ChatinterfaceActivity.this, "您发送的消息不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    /**
     * 接收在线消息
     **/
    public void onEvent(MessageEvent event) {
        mConversation = JMessageClient.getSingleConversation("NY43b315721291693", MyApp.DOCTOR_APP_KEY);
        final String extra = mConversation.getExtra();
        final String title = mConversation.getTitle();
        Message latestMessage = mConversation.getLatestMessage();
        MessageContent content = latestMessage.getContent();
        ContentType contentType = content.getContentType();
        String s = content.toJson();
        String finalStr = "";
        try {
            JSONObject jsonObject = new JSONObject(s);
            finalStr = (String) jsonObject.get("text");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String finalStr1 = finalStr;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("TAG", "run: extra:" + extra + "   title:" + title);
                Toast.makeText(ChatinterfaceActivity.this, finalStr1, Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    protected int Layout() {
        return R.layout.activity_chatinterface;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
