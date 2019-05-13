package com.example.studentmanage.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentmanage.R;

public class ActivityLogin extends AppCompatActivity {

     Button btnDangNhap, btnDangKyTaiKhoan, btnThoatDangNhap;
     EditText edtUserDN, edtPasswordDN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AnhXa();
        ControlButton();
    }

    private void AnhXa() {
        edtUserDN           = (EditText) findViewById(R.id.edtUserDN);
        edtPasswordDN       = (EditText) findViewById(R.id.edtPasswordDN);
        btnDangNhap         = (Button) findViewById(R.id.btnDangNhap);
        btnDangKyTaiKhoan   = (Button) findViewById(R.id.btnDangKyTaiKhoan);
        btnThoatDangNhap    = (Button) findViewById(R.id.btnThoatDangNhap);
    }

    private void ControlButton() {
        btnDangKyTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityDangKy.class);
                startActivity(intent);
            }
        });



        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = "admin";
                String password = "123456";
                String nousername ="";
                String nopassword ="";
                if(edtUserDN.getText().toString().equals(username)  && edtPasswordDN.getText().toString().equals(password) ){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityLogin.this, Home.class);
                    startActivity(intent);
                }
                else if(edtUserDN.getText().toString().equals(nousername) || edtPasswordDN.getText().toString().equals(nopassword) )
                {
                    Toast.makeText(getApplicationContext(),"Tài Khoản hoặc Mật Khẩu không được bỏ trống!",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Tài Khoản hoặc Mật Khẩu sai!",Toast.LENGTH_LONG).show();

                }


            }
        });

        btnThoatDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityLogin.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát khỏi app ?");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }
}
