package com.example.managestudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKhoa , btnLop , btnSinhVien ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKhoa = findViewById(R.id.btnKhoa);
        btnKhoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityKhoa.class);
                startActivity(intent);
            }
        });
        btnLop = findViewById(R.id.btnLop);
        btnLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityLop.class);
                startActivity(intent);
            }
        });
        btnSinhVien = findViewById(R.id.btnSinhVien);
        btnSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitySinhVien.class);
                startActivity(intent);
            }
        });
    }
}
