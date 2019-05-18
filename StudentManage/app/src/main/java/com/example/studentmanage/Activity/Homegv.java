package com.example.studentmanage.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentmanage.R;

public class Homegv extends AppCompatActivity {

    LinearLayout lnrDiem, lnrTKB, lnrDiemDanh, lnrNotify;
    TextView txtRole, txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homegv);
        Toast.makeText(Homegv.this, ActivityLogin.username , Toast.LENGTH_LONG).show();

        Anhxa();

        txtName.setText("Username: " + ActivityLogin.username);


        lnrTKB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Homegv.this, ActivityTKB.class));
            }
        });
        lnrNotify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Homegv.this, UpdateThongBao.class));
            }
        });
        lnrDiem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Homegv.this, ActivityDiem.class));
            }
        });
        lnrDiemDanh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(Homegv.this, ActivityDiemDanh.class));
            }
        });
    }

    private void Anhxa() {
        txtRole = (TextView) findViewById(R.id.textviewRoleName);
        txtName = (TextView) findViewById(R.id.textviewName);
        lnrDiem = (LinearLayout) findViewById(R.id.linearDiem);
        lnrTKB = (LinearLayout) findViewById(R.id.LinearThoiKhoaBieu);
        lnrNotify = (LinearLayout) findViewById(R.id.LinearThongBao);
        lnrDiemDanh = (LinearLayout) findViewById(R.id.linearDiemDanh);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.out_item, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itemLogout:
                if(item.getItemId() == R.id.itemLogout  ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Homegv.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn có chắc muốn đăng xuất?");
                    builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Homegv.this, ActivityLogin.class));
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
