package com.example.appthongtin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtName;
    private RadioButton rbNam;
    private RadioButton rbNu;
    private CheckBox cbMautim;
    private CheckBox cbMauhong;
    private CheckBox cbNoitam;
    private CheckBox cbKhocTham;
    private Button btnThongTin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
    }
    public void setControl(){
        txtName = (EditText)findViewById(R.id.txt_name);
        rbNam = (RadioButton)findViewById(R.id.rbtn_nam);
        rbNu = (RadioButton)findViewById(R.id.rbtn_nu);
        cbMautim = (CheckBox)findViewById(R.id.cb_mautim);
        cbMauhong = (CheckBox)findViewById(R.id.cb_mauhong);
        cbNoitam = (CheckBox)findViewById(R.id.cb_noitam);
        cbKhocTham = (CheckBox)findViewById(R.id.cb_khoctham);
        btnThongTin = (Button)findViewById(R.id.img_button);
    }
    private void setEvent() {
        btnThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "";
                msg = "Họ tên: " + String.valueOf(txtName.getText()) + " ";

                if(rbNu.isChecked()){
                    msg += "\n-Giới tính: " + rbNu.getText();
                }else{
                    msg += "\n-Giới tính: " + rbNam.getText();
                }
                msg += "\n Sở thích";

                if(cbMautim.isChecked()){
                    msg += "\n- " + cbMautim.getText();
                }
                if(cbMauhong.isChecked()){
                    msg += "\n- " + cbMauhong.getText();
                }
                if(cbNoitam.isChecked()){
                    msg += "\n- " + cbNoitam.getText();
                }
                if(cbKhocTham.isChecked()){
                    msg += "\n- " + cbKhocTham.getText();
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
