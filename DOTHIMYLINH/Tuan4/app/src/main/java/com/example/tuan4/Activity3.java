package com.example.tuan4;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    private Button btnCallActivity2;
    private Button btnCallActivity4;
    private Button btnResult;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        btnCallActivity4 = findViewById(R.id.btnCallActivity4);
       btnCallActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity3.this, Activity4.class);
                startActivity(intent);
            }
        });
        btnCallActivity2 = findViewById(R.id.btnCallActivity2);
        btnCallActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity3.this, Activity2.class);
                startActivity(intent);
            }
        });

        checkBox1= (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 =  (CheckBox) findViewById(R.id.checkbox2);
        checkBox3  =  (CheckBox) findViewById(R.id.checkbox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
        btnResult = (Button) findViewById(R.id.btnResult3);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ketqua = "Đáp án của bạn là :\n ";

                if(checkBox1.isChecked()){
                    ketqua = ketqua + checkBox1.getText() +" \n ";
                }
                if(checkBox2.isChecked()){
                    ketqua =  ketqua + checkBox2.getText()+" \n ";
                }
                if(checkBox3.isChecked()){
                   ketqua = ketqua+ checkBox3.getText()+" \n ";
                }
                if(checkBox4.isChecked()){
                    ketqua = ketqua + checkBox4.getText()+" \n ";
                }

                Toast.makeText(Activity3.this, ketqua, Toast.LENGTH_LONG).show();
            }



        });
    }

}
