package com.example.tuan2b;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtXinChao;
    private RadioButton btnNam;
    private RadioButton btnNu;
    private CheckBox cbMeo;
    private CheckBox cbChuot;
    private CheckBox cbHeo;
    private CheckBox cbSinh;
    private Button btnThongTin;

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();


    }

    public void setControl()
    {
        txtXinChao = (EditText) findViewById(R.id.txtXinChao);
        btnNam = (RadioButton) findViewById(R.id.btnNam);
        btnNu = (RadioButton) findViewById(R.id.btnNu);
        cbMeo = (CheckBox) findViewById(R.id.cbMeo);
        cbChuot = (CheckBox) findViewById(R.id.cbChuot);
        cbHeo = (CheckBox) findViewById(R.id.cbHeo);
        cbSinh = (CheckBox) findViewById(R.id.cbSinh);
        btnThongTin = (Button) findViewById(R.id.btnThongTin);
    }
    public void setEvent()
    {
        btnThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg= "";
                msg = "Họ tên:" + String.valueOf(txtXinChao.getText()) + "\n";
                if (btnNu.isChecked())
                {
                    msg += "\n-Giới tính: " + btnNu.getText();

                }
                else
                {
                    msg += "\n-Giới tính: " + btnNam.getText();

                }
                msg += "\n*Sở thích: ";
                if(cbMeo.isChecked()){
                    msg +="\n-" + cbMeo.getText();
                }
                if(cbChuot.isChecked()){
                    msg +="\n-" + cbChuot.getText();
                }
                if(cbHeo.isChecked()){
                    msg +="\n-" + cbHeo.getText() + " - ";
                }
                if(cbSinh.isChecked()){
                    msg +="\n-" + cbSinh.getText();
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
