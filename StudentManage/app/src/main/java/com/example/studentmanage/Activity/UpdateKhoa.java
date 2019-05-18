package com.example.studentmanage.Activity;

import android.content.Intent;
import android.graphics.Color;
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
import com.example.studentmanage.Class.Khoa;
import com.example.studentmanage.R;

import java.util.HashMap;
import java.util.Map;

public class UpdateKhoa extends AppCompatActivity {

    String   urlUpdate = ActivityLogin.url + "quanlysinhvien/public/api/updateKhoa";

    EditText edtMaKhoa, edtTenKhoa;
    Button btnCapNhap, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_khoa);

        Intent intent = getIntent();
        Khoa khoa = (Khoa) intent.getSerializableExtra("dataKhoa");
//        Toast.makeText(this, khoa.getTenKhoa(), Toast.LENGTH_SHORT).show();

        AnhXa();

        edtMaKhoa.setText(khoa.getMaKhoa());
        edtTenKhoa.setText(khoa.getTenKhoa());

        edtMaKhoa.setEnabled(false);
//        disableEditText(edtMaKhoa);



        btnCapNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String makhoa = edtMaKhoa.getText().toString().trim();
                String tenkhoa = edtMaKhoa.getText().toString().trim();
                if(makhoa.isEmpty() || tenkhoa.isEmpty()){
                    Toast.makeText(UpdateKhoa.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else {
                    CapNhatSinhVien(urlUpdate);

                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa() {
        btnCapNhap = (Button) findViewById(R.id.buttonOkKhoaUpdate);
        btnHuy     = (Button) findViewById(R.id.buttonHuyKhoaUpdate);
        edtMaKhoa  = (EditText) findViewById(R.id.edittextMaKhoaUpdate);
        edtTenKhoa = (EditText) findViewById(R.id.edittextTenKhoaUpdate);
    }


    private void CapNhatSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.toString().equals("Thành công")){
                            startActivity(new Intent(UpdateKhoa.this, MainActivity.class));
                        }else {
                            Toast.makeText(UpdateKhoa.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateKhoa.this, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("updateMaKhoa", edtMaKhoa.getText().toString().trim());
                params.put("updateTenKhoa", edtTenKhoa.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setBackgroundColor(Color.TRANSPARENT);
    }
}
