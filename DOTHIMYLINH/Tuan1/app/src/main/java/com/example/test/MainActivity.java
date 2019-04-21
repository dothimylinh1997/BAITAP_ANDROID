package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtThongtin;
    Button btnNhap;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Toast.makeText(MainActivity.this,"Gửi thông tin thành công",Toast. LENGTH_LONG).show();
                Log.d("text","Gửi thông tin");
                Intent intent = new Intent(MainActivity.this,XuatThongTin.class);
                intent.putExtra("msg", edtThongtin.getText().toString());
                startActivity(intent);
            }
        });

    }

    private void Anhxa() {
        edtThongtin = (EditText) findViewById(R.id.editThong);
        btnNhap = (Button) findViewById(R.id.buttongui);
    }



}
