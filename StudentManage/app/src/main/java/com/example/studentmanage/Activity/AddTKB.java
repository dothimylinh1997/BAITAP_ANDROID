package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentmanage.R;

import java.util.HashMap;
import java.util.Map;

public class AddTKB extends AppCompatActivity {

    String urlinsert = ActivityLogin.url + "quanlysinhvien/public/api/addTKB";

    EditText editMaLop, editMaMon, editThu, editTietBatDau, editPhong, editThoiGian;
    Button btnOk, btnHuy;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tkb);
        Anhxa();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = editMaLop.getText().toString().trim();
                String mamon = editMaMon.getText().toString().trim();
                String thu = editThu.getText().toString().trim();
                String tietbatdau = editTietBatDau.getText().toString().trim();
                String phong = editPhong.getText().toString().trim();
                String thoigian = editThoiGian.getText().toString().trim();

                if(malop.isEmpty() || mamon.isEmpty() || thu.isEmpty() || tietbatdau.isEmpty() || phong.isEmpty() || thoigian.isEmpty()){
                    Toast.makeText(AddTKB.this, "Vui lòng nhập đủ thông tin thời khóa biểu!", Toast.LENGTH_SHORT).show();
                }

                ThemTKB(urlinsert);

            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        editMaLop = (EditText) findViewById(R.id.editMaLop);
        editMaMon = (EditText) findViewById(R.id.editMaMon);
        editThu = (EditText) findViewById(R.id.editThu);
        editTietBatDau = (EditText) findViewById(R.id.editTietBatDau);
        editPhong = (EditText) findViewById(R.id.editPhong);
        editThoiGian = (EditText) findViewById(R.id.editThoiGian);
        btnOk = (Button) findViewById(R.id.buttonOkAddTKB);
        btnHuy = (Button) findViewById(R.id.buttonHuyAddTKB);
    }
    private void ThemTKB(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.toString().equals("Thành công")){
                            startActivity(new Intent(AddTKB.this, ActivityTKB.class));
                        }else {
                            Toast.makeText(AddTKB.this, response.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("addMaLop",editMaLop.getText().toString().trim());
                params.put("addMaMon",editMaMon.getText().toString().trim());
                params.put("addThu",editThu.getText().toString().trim());
                params.put("addTietBD",editTietBatDau.getText().toString().trim());
                params.put("addPhongHoc",editPhong.getText().toString().trim());
                params.put("addThoiGian",editThoiGian.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
