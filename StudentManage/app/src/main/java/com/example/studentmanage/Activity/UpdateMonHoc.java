package com.example.studentmanage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.example.studentmanage.Class.MonHoc;
import com.example.studentmanage.R;

import java.util.HashMap;
import java.util.Map;

public class UpdateMonHoc extends AppCompatActivity

{

    String urlUpdate =  ActivityLogin.url + "quanlysinhvien/public/api/updateMonHoc";

    EditText edtMaMH, edtTenMH;
    Button btnCapNhap, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mon_hoc);

        Intent intent = getIntent();
        MonHoc monHoc = (MonHoc) intent.getSerializableExtra("dataMonHoc");


        AnhXa();

        edtMaMH.setText(monHoc.getMaMH());
        edtTenMH.setText(monHoc.getTenMH());

        edtMaMH.setEnabled(false);

        btnCapNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mamh = edtMaMH.getText().toString().trim();
                String tenmh = edtTenMH.getText().toString().trim();


                if(mamh.isEmpty() || tenmh.isEmpty() ){
                    Toast.makeText(UpdateMonHoc.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else {
                    CapNhatMonHoc(urlUpdate);

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
        btnCapNhap = (Button) findViewById(R.id.buttonOkMHUpdate);
        btnHuy     = (Button) findViewById(R.id.buttonHuyMHUpdate);
        edtMaMH   = (EditText) findViewById(R.id.edittextMaMHUpdate);
        edtTenMH  = (EditText) findViewById(R.id.edittextTenMHUpdate);

    }


    private void CapNhatMonHoc(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.toString().equals("Thành công")){
                            startActivity(new Intent(UpdateMonHoc.this, ActivityMonHoc.class));
                        }else {
                            Toast.makeText(UpdateMonHoc.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateMonHoc.this, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("addMaMH", edtMaMH.getText().toString().trim());
                params.put("addTenMH", edtTenMH.getText().toString().trim());


                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}

