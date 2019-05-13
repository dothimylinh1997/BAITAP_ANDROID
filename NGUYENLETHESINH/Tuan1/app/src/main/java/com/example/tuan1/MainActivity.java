package com.example.tuan1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNoiDung;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNoiDung = (EditText) findViewById(R.id.editTextThongTin);
        btnClick = (Button) findViewById(R.id.buttonThongTin);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String noiDung = edtNoiDung.getText().toString();
               Toast.makeText(MainActivity.this, noiDung, Toast.LENGTH_LONG).show();
            }
        });



    }



}

