package com.example.managestudent;

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

import java.util.HashMap;
import java.util.Map;

public class UpdateLop extends AppCompatActivity {

    String   urlUpdate = "http://192.168.43.253:8080/quanlysinhvien/public/api/updateLop";
    EditText edtMaLop, edtTenLop, edtMaKhoa;
    Button btnCapNhap, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_lop);

        Intent intent = getIntent();
        Lop lop = (Lop) intent.getSerializableExtra("dataLop");
//        Toast.makeText(this, khoa.getTenKhoa(), Toast.LENGTH_SHORT).show();

        AnhXa();

        edtMaLop.setText(lop.getMaLop());
        edtTenLop.setText(lop.getTenLop());
        edtMaKhoa.setText(lop.getMaKhoa());

        btnCapNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtMaLop.getText().toString().trim();
                String tenlop = edtTenLop.getText().toString().trim();
                String makhoa = edtMaKhoa.getText().toString().trim();

                if(makhoa.isEmpty() || tenlop.isEmpty() || malop.isEmpty()){
                    Toast.makeText(UpdateLop.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
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
        btnCapNhap = (Button) findViewById(R.id.buttonCapNhatLop);
        btnHuy     = (Button) findViewById(R.id.buttonHuyCapNhatLop);
        edtMaLop   = (EditText) findViewById(R.id.editMaLopedit);
        edtTenLop  = (EditText) findViewById(R.id.editTenLopedit);
        edtMaKhoa  = (EditText) findViewById(R.id.editMaKhoaLopedit);

    }


    private void CapNhatSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UpdateLop.this, response.toString(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UpdateLop.this, ActivityLop.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateLop.this, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("updateMaLop", edtMaLop.getText().toString().trim());
                params.put("updateTenLop", edtTenLop.getText().toString().trim());
                params.put("updateMaKhoa", edtMaKhoa.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
