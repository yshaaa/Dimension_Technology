package com.wd.tech.activity.zixun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wd.tech.R;

public class Zixun_xff extends AppCompatActivity {
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zixun_xff);
        String id = getIntent().getStringExtra("id");

        button=findViewById(R.id.zixun_ff_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zixun_xff.this, Zixun_Fufei.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });



    }
}
