package com.example.maytinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtSoA, txtSoB, txtKetQua;
    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
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

    private void pheptinh(String pt) {
        int soA = Integer.parseInt(txtSoA.getText().toString());
        int soB = Integer.parseInt(txtSoB.getText().toString());

        int kq=0;
        switch (pt) {
            case "+":
                kq = soA + soB;
                break;
            case "-":
                kq =soA-soB;
                break;
            case "*":
                kq=soA*soB;
                break;
            case "/":
                kq=soA/soB;
                break;
        }
        txtKetQua.setText(String.valueOf(kq));
    }

    private void addControls() {
        txtSoA= (TextView) findViewById(R.id.txtSoA);
        txtSoB= (TextView) findViewById(R.id.txtSoB);
        txtKetQua= (TextView) findViewById((R.id.txtKetQua));
        btnCong= (Button) findViewById((R.id.btnCong));
        btnTru= (Button) findViewById((R.id.btnTru));
        btnNhan= (Button) findViewById((R.id.btnNhan));
        btnChia= (Button) findViewById((R.id.btnChia));
    }

}
