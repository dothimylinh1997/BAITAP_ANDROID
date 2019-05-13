package com.example.tuan4;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Activity4 extends AppCompatActivity {
    private Button btnCallActivity3;
    private Button btnCallActivity5;
    private Button btnResult;
    private Spinner spinA;
    private Spinner spinB;
    private Spinner spinC;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        btnCallActivity5 = findViewById(R.id.btnCallActivity5);


        btnCallActivity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, Activity5.class);
                startActivity(intent);
            }
        });
        btnCallActivity3 = findViewById(R.id.btnCallActivity3);
        btnCallActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, Activity3.class);
                startActivity(intent);
            }
        });
        spinA = (Spinner) findViewById(R.id.spinA);
        spinB = (Spinner) findViewById(R.id.spinB);
        spinC = (Spinner) findViewById(R.id.spinC);
        btnResult = (Button) findViewById(R.id.btnResult4);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("Bạn đã trả lời câu hỏi đầu tiên là : ").append(spinA.getSelectedItem());
                result.append("\nBạn đã trả lời câu hỏi thứ hai là : ").append(spinB.getSelectedItem());
                result.append("\nBạn đã trả lời câu hỏi thứ ba là : ").append(spinC.getSelectedItem());
                Toast.makeText(Activity4.this, result.toString(),Toast.LENGTH_SHORT).show();
            }
        });






    }

}
