package com.example.doihinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {


    RadioButton btnPig, btnCat, btnDog, btnRabbit, btnBird;
    ImageView imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvents();
    }

    private void addEvents() {

        btnPig.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.heo);
                }
            }
        });
        btnCat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.cat);
                }
            }
        });
        btnDog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.dog);
                }
            }
        });
        btnBird.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.chim);
                }
            }
        });
        btnRabbit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.rabbit);
                }
            }
        });
    }

    private void addControl() {
        btnPig = (RadioButton) findViewById(R.id.btnPig);
        btnCat = (RadioButton) findViewById(R.id.btnCat);
        btnDog = (RadioButton) findViewById(R.id.btnDog);
        btnRabbit = (RadioButton) findViewById(R.id.btnRabbit);
        btnBird = (RadioButton) findViewById(R.id.btnBird);
        imgPicture = (ImageView) findViewById(R.id.imgPicture);
    }
}
