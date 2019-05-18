package com.example.tuan4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;

public class Activity6 extends AppCompatActivity {
    private Button btnCallActivity7;
    private Button btnCallActivity5;
    private Button btnResult;
    private Switch switch1;
    private Switch switch2;
    private Switch switch3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        btnCallActivity7 = findViewById(R.id.btnCallActivity7);

        btnCallActivity7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity6.this, Activity7.class);
                startActivity(intent);
            }
        });

        btnCallActivity5 = findViewById(R.id.btnCallActivity5);

        btnCallActivity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity6.this, Activity5.class);
                startActivity(intent);
            }
        });

        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch3 = (Switch) findViewById(R.id.switch3);
        btnResult = (Button) findViewById(R.id.btnResult6);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Bạn đã trả lời câu hỏi đầu tiên là : ").append(switch1.getText());
                result.append("\nBạn đã trả lời câu hỏi thứ hai là : ").append(switch2.getText());
                result.append("\nBạn đã trả lời câu hỏi thứ ba là : ").append(switch3.getText());
                Toast.makeText(Activity6.this, result.toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}







