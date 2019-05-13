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

public class AddSinhVien extends AppCompatActivity {

    String urlinsert = "http://192.168.137.39:8080/quanlysinhvien/public/api/addSinhVien";

    EditText edtMaSinhVien, edtHoTen, edtGioiTinh, edtNgaySinh, edtMaLop, edtDiaChi;
    Button btnThem, btnHuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);

        Anhxa();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masinhvien = edtMaSinhVien.getText().toString().trim();
                String hoten = edtHoTen.getText().toString().trim();
                String gioitinh = edtGioiTinh.getText().toString().trim();
                String diachi = edtDiaChi.getText().toString().trim();
                String ngaysinh = edtNgaySinh.getText().toString().trim();
                String malop = edtMaLop.getText().toString().trim();
                if(masinhvien.isEmpty() || hoten.isEmpty() || gioitinh.isEmpty() || diachi.isEmpty() || ngaysinh.isEmpty() || malop.isEmpty()){
                    Toast.makeText(AddSinhVien.this, "Vui lòng nhập đủ thông tin sinh viên!", Toast.LENGTH_SHORT).show();
                }

                ThemSinhVien(urlinsert);
                startActivity(new Intent(AddSinhVien.this, ActivitySinhVien.class));
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
        edtMaSinhVien   = (EditText) findViewById(R.id.edittextMaSvAdd);
        edtHoTen        = (EditText) findViewById(R.id.edittextHoTenSvAdd);
        edtNgaySinh     = (EditText) findViewById(R.id.edittextNgaySinhAdd);
        edtDiaChi       = (EditText) findViewById(R.id.edittextDiaChiAdd);
        edtGioiTinh     = (EditText) findViewById(R.id.edittextGioiTinhAdd);
        edtMaLop        = (EditText) findViewById(R.id.edittextMaLopSvAdd);
        btnThem         = (Button)   findViewById(R.id.buttonOkSvAdd);
        btnHuy          = (Button)   findViewById(R.id.buttonHuySvAdd);
    }

    private void ThemSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(AddSinhVien.this, response.toString(), Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(AddKhoa.this, MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("addMaSV",edtMaSinhVien.getText().toString().trim());
                params.put("addTenSV",edtHoTen.getText().toString().trim());
                params.put("addNgaySinh",edtNgaySinh.getText().toString().trim());
                params.put("addGioiTinh",edtGioiTinh.getText().toString().trim());
                params.put("addDiaChi",edtDiaChi.getText().toString().trim());
                params.put("addMaLop",edtMaLop.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
