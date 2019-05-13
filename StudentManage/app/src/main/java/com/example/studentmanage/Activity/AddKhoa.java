package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

public class AddKhoa extends AppCompatActivity {

    String urlinsert = "http://192.168.43.253:8080/quanlysinhvien/public/api/addKhoa";

    EditText edtMaKhoa, edtTenKhoa;
    Button btnThem, btnHuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_khoa);

        AnhXa();


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String makhoa = edtMaKhoa.getText().toString().trim();
                String tenkhoa = edtTenKhoa.getText().toString().trim();
                if(makhoa.isEmpty() || tenkhoa.isEmpty()){
                    Toast.makeText(AddKhoa.this, "Vui lòng nhập đủ thông tin khoa!", Toast.LENGTH_SHORT).show();
                }

                ThemKhoa(urlinsert);
                startActivity(new Intent(AddKhoa.this, MainActivity.class));
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
        btnThem     = (Button) findViewById(R.id.buttonOkAddKhoa);
        btnHuy      = (Button) findViewById(R.id.buttonHuyAddKhoa);
        edtMaKhoa   = (EditText) findViewById(R.id.edittextMaKhoaAdd);
        edtTenKhoa  = (EditText) findViewById(R.id.edittextTenKhoaAdd);

    }


    private void ThemKhoa(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(AddKhoa.this, response.toString(), Toast.LENGTH_LONG).show();
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
                params.put("addMaKhoa",edtMaKhoa.getText().toString().trim());
                params.put("addTenKhoa",edtTenKhoa.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
