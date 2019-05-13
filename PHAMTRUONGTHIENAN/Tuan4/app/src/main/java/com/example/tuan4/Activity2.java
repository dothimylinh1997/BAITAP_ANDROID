package com.example.tuan4;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private Button btnCallActivityMain;
    private Button btnCallActivity3;
    private Button btnResult;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private String LOGTAG = "Lưu thành công !";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btnCallActivity3 = findViewById(R.id.btnCallActivity3);
       btnCallActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });
        btnCallActivityMain = findViewById(R.id.btnCallActivityMain);
        btnCallActivityMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2  =  (RadioButton)findViewById(R.id.radioButton2);
        radioButton3  =  (RadioButton)findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

        // Khi radio button 1 có thay đổi.
        this.radioButton1.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnGameCharacterChanged(buttonView,isChecked);
            }
        });
        this.radioButton2.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnGameCharacterChanged(buttonView,isChecked);
            }
        });
        this.radioButton3.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnGameCharacterChanged(buttonView,isChecked);
            }
        });
        this.radioButton4.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnGameCharacterChanged(buttonView,isChecked);
            }
        });

        btnResult = (Button) findViewById(R.id.btnResult2);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSave();
            }
        });
    }

    private void doOnGameCharacterChanged(CompoundButton buttonView, boolean isChecked)  {
        RadioButton radio =(RadioButton) buttonView;

        Log.i(LOGTAG, "RadioButton "+ radio.getText()+" : "+ isChecked);
    }
    private void doSave()  {

        int gameCharacter = this.radioGroup.getCheckedRadioButtonId();


        RadioButton radioButtonGameCharacter = (RadioButton) this.findViewById(gameCharacter);

        String message =" Bạn chọn đáp án là : " + radioButtonGameCharacter.getText() ;

        Toast.makeText(this,message, Toast.LENGTH_LONG).show();

    }
}
