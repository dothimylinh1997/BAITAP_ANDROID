package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studentmanage.R;

public class Home extends AppCompatActivity {

    LinearLayout lnrKhoa, lnrLop, lnrSv, lnrFind, lnrTKB, lnrNotify;
    TextView txtRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Anhxa();

        lnrKhoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });
        lnrLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ActivityLop.class));
            }
        });
        lnrSv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ActivitySinhVien.class));
            }
        });
        lnrFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, SearchSinhVien.class));
            }
        });
        lnrTKB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Home.this, ActivityTKB.class));
            }
        });
        lnrNotify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Home.this, UpdateThongBao.class));
            }
        });
    }

    private void Anhxa() {
        txtRole = (TextView) findViewById(R.id.textviewRoleName);
        lnrKhoa  = (LinearLayout) findViewById(R.id.linearKhoa);
        lnrLop  = (LinearLayout) findViewById(R.id.LinearLop);
        lnrSv = (LinearLayout) findViewById(R.id.LinearSinhVien);
        lnrFind = (LinearLayout) findViewById(R.id.linearPhieu);
        lnrTKB = (LinearLayout) findViewById(R.id.LinearThoiKhoaBieu);
        lnrNotify = (LinearLayout) findViewById(R.id.LinearThongBao);
    }
}
