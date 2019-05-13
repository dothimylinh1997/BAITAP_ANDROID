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

public class ActivityDangKy extends AppCompatActivity {

    Button btnDangKy, btnLinkDangNhapNgay, btnThoatDangKy;
    EditText TenDangKy, NhapMatKhauDangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        AnhXa();
        ControlButton();
    }

    private void AnhXa() {
        TenDangKy           = (EditText) findViewById(R.id.TenDangKy);
        NhapMatKhauDangky   = (EditText) findViewById(R.id.NhapMatKhauDangKy);
        btnDangKy           = (Button) findViewById(R.id.btnDangKy);
        btnLinkDangNhapNgay = (Button) findViewById(R.id.btnLinkDangNhapNgay);
        btnThoatDangKy      = (Button) findViewById(R.id.btnThoatDangKy);


    }
    private void ControlButton() {
        btnLinkDangNhapNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDangKy.this, ActivityLogin.class);
                startActivity(intent);
            }
        });

        btnThoatDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityDangKy.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
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
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = TenDangKy.getText().toString().trim();
                String password = NhapMatKhauDangky.getText().toString().trim();

                if (!name.isEmpty() && !password.isEmpty() ) {
                    //dangky(UrlSever.URL_REGISTER);
                    // webservice
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Vui lòng nhập thông tin của bạn!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
