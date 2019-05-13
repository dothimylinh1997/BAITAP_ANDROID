package com.example.tuan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //khai bao bien
    EditText txtSoA, txtSoB, txtKetQua;
    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xu ly
        setControl();
        setEvent();
    }
    private  void setControl()
    {
        txtSoA = findViewById(R.id.edtSoA);
        txtSoB = findViewById(R.id.edtSoB);
        txtKetQua = findViewById(R.id.edtResult);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

    }
    private void setEvent()
    {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh("+");
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh("-");
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh("*");
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pheptinh("/");
            }
        });

    }
    private void pheptinh(String pt)
    {
        int soA = Integer.parseInt(txtSoA.getText().toString());
        int soB = Integer.parseInt(txtSoB.getText().toString());
        int kq = 0;
        switch (pt)
        {
            case  "+":
                kq = soA + soB;
                break;
            case  "-":
                kq = soA - soB;
                break;
            case  "*":
                kq = soA * soB;
                break;
            case  "/":
                kq = soA / soB;
                break;
        }
        txtKetQua.setText(String.valueOf(kq));
    }
}
