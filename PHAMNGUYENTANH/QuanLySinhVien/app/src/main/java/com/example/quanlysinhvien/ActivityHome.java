package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class ActivityHome extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnKhoa , btnLop , btnSinhVien ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        innit();
        btnKhoa.setOnClickListener(this);
        btnLop.setOnClickListener(this);
        btnSinhVien.setOnClickListener(this);

    }

    void innit(){
        btnKhoa = (ImageButton) findViewById(R.id.btnKhoa);
        btnLop= (ImageButton) findViewById(R.id.btnLop);
        btnSinhVien = (ImageButton) findViewById(R.id.btnSinhVien);


    }

    // Hàm load menu mặc định khi tạo 1 Project mới.

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_app, menu);
        return true;
    }


    // backpress

    @Override
    public void onBackPressed() {
        //Khoi tao lai Activity muốn khởi tạo lại khi vào lần nữa

        Intent intent = new Intent(getApplicationContext(), ActivityHome.class);
        startActivity(intent);
        // kết thúc app
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startActivity(startMain);
        finish();
    }

    // onclick

    @Override
    public void onClick(View view) {
        int d = view.getId();
        if(d == R.id.btnKhoa){
            startActivity(new Intent(getApplicationContext(),ActivityKhoa.class));
        }
        if(d == R.id.btnLop){
            startActivity(new Intent(getApplicationContext(),ActivityLop.class));
        }
        if(d == R.id.btnSinhVien){
            startActivity(new Intent(getApplicationContext(),ActivitySinhVien.class));
        }

    }
}
