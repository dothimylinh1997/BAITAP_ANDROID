package com.example.studentmanage.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentmanage.R;

public class Home extends AppCompatActivity {

    LinearLayout lnrKhoa, lnrLop, lnrSv, lnrFind, lnrTKB, lnrNotify, lnrDiem, lnrMonHoc, lnrDiemDanh;
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
        lnrDiem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Home.this, ActivityDiem.class));
            }
        });
        lnrMonHoc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Home.this, ActivityMonHoc.class));
            }
        });
        lnrDiemDanh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Home.this, ActivityDiemDanh.class));
            }
        });
    }

    private void Anhxa() {
        txtRole = (TextView) findViewById(R.id.textviewRoleName);
        lnrKhoa  = (LinearLayout) findViewById(R.id.linearKhoa);
        lnrLop  = (LinearLayout) findViewById(R.id.LinearLop);
        lnrSv = (LinearLayout) findViewById(R.id.LinearSinhVien);
        lnrFind = (LinearLayout) findViewById(R.id.linearPhieu);
        lnrDiem  = (LinearLayout) findViewById(R.id.linearDiem);
        lnrMonHoc = (LinearLayout) findViewById(R.id.LinearMonHoc);
        lnrTKB = (LinearLayout) findViewById(R.id.LinearThoiKhoaBieu);
        lnrNotify = (LinearLayout) findViewById(R.id.LinearThongBao);
        lnrDiemDanh = (LinearLayout) findViewById(R.id.linearDiemDanh);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_out_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())

        {
            case R.id.itemTimkiem:
                if(item.getItemId() == R.id.itemTimkiem ){
                    startActivity(new Intent(Home.this, SearchSinhVien.class));
                }
                break;
            case R.id.itemLogout:
                if(item.getItemId() == R.id.itemLogout  ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Home.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn có chắc muốn đăng xuất?");
                    builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Home.this, ActivityLogin.class));
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
