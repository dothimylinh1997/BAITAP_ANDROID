package com.example.thongtincanhan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtHoTen;
    private RadioButton rbNam;
    private RadioButton rbNu;
    private CheckBox cbYeuMauTim;
    private CheckBox cbThichMauHong;
    private CheckBox cbSongNoiTam;
    private CheckBox cbHayKhocTham;
    private ImageButton btnThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvents();
    }

    private void setEvents() {
        btnThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg ="";
                msg = "Họ tên:" + String.valueOf(txtHoTen.getText()) + "\n";
                if(rbNam.isChecked())
                {
                    msg += "Giới tính :" + rbNam.getText() + "\n";
                }
                else{
                    msg += "Giới tính :" + rbNu.getText() + "\n";
                }
                msg += "Sở thích: ";
                if(cbYeuMauTim.isChecked())
                {
                    msg += "\n" + cbYeuMauTim.getText() ;
                }
                if(cbThichMauHong.isChecked())
                {
                    msg += "\n" + cbThichMauHong.getText() ;
                }
                if(cbSongNoiTam.isChecked())
                {
                    msg += "\n" + cbSongNoiTam.getText() ;
                }
                if(cbHayKhocTham.isChecked())
                {
                    msg += "\n" + cbHayKhocTham.getText() ;
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setControl() {
        txtHoTen =(EditText) findViewById(R.id.txtHoTen);
        rbNam =(RadioButton) findViewById(R.id.rdNam);
        rbNu =(RadioButton) findViewById(R.id.rdNu);
        cbYeuMauTim =(CheckBox) findViewById(R.id.cbYeuMauTim);
        cbThichMauHong =(CheckBox) findViewById(R.id.cbThichMauHong);
        cbSongNoiTam =(CheckBox) findViewById(R.id.cbSongNoiTam);
        cbHayKhocTham =(CheckBox) findViewById(R.id.cbHayKhocTham);
        btnThongTin =(ImageButton) findViewById(R.id.btnThongTin);
    }
}
