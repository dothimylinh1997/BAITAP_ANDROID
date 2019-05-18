package com.example.doihinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {


    RadioButton btnLandscape, btnSky, btnIsland, btnColor, btnSunshine;
    ImageView imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvents();
    }

    private void addEvents() {

        btnColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.color);
                }
            }
        });
        btnIsland.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.island);
                }
            }
        });
        btnLandscape.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.landscape);
                }
            }
        });
        btnSky.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.sky);
                }
            }
        });
        btnSunshine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    imgPicture.setImageResource(R.drawable.sunshine);
                }
            }
        });
    }

    private void addControl() {
        btnColor = (RadioButton) findViewById(R.id.btnColor);
        btnIsland = (RadioButton) findViewById(R.id.btnIsland);
        btnLandscape = (RadioButton) findViewById(R.id.btnLandscape);
        btnSky = (RadioButton) findViewById(R.id.btnSky);
        btnSunshine = (RadioButton) findViewById(R.id.btnSunshine);
        imgPicture = (ImageView) findViewById(R.id.imgPicture);
    }
}
