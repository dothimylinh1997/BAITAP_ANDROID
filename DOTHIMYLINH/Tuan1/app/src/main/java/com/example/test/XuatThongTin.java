package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class XuatThongTin extends AppCompatActivity {

    TextView tvThongTin;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuat_thong_tin);

        tvThongTin = findViewById(R.id.tvNhanThongTin);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        tvThongTin.setText(msg);
    }
}
