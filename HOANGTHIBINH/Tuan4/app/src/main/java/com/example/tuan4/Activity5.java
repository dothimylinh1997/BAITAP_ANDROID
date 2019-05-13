package com.example.tuan4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton;
import android.support.v7.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {


    private Button btnCallActivity4;
    private Button btnCallActivity6;
    private Button btnResult;
    private ToggleButton toggle1;
    private ToggleButton toggle2;
    private ToggleButton toggle3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

            btnCallActivity6 = findViewById(R.id.btnCallActivity6);

            btnCallActivity6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity5.this, Activity6.class);
                    startActivity(intent);
                }
            });

            btnCallActivity4 = findViewById(R.id.btnCallActivity4);

            btnCallActivity4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity5.this, Activity4.class);
                    startActivity(intent);
                }
            });

        toggle1 = (ToggleButton) findViewById(R.id.toggle1);
        toggle2 = (ToggleButton) findViewById(R.id.toggle2);
        toggle3 = (ToggleButton) findViewById(R.id.toggle3);
        btnResult = (Button) findViewById(R.id.btnResult5);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Bạn đã trả lời câu hỏi đầu tiên là : ").append(toggle1.getText());
                result.append("\nBạn đã trả lời câu hỏi thứ hai là : ").append(toggle2.getText());
                result.append("\nBạn đã trả lời câu hỏi thứ ba là : ").append(toggle3.getText());
                Toast.makeText(Activity5.this, result.toString(),Toast.LENGTH_SHORT).show();
            }
        });











    }

}
