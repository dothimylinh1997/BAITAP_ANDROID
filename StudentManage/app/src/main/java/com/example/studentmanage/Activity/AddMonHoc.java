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

public class AddMonHoc extends AppCompatActivity {

    String urlinsert =  ActivityLogin.url + "quanlysinhvien/public/api/addMonHoc";

    EditText edtMaMH, edtTenMH;
    Button btnThem, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mon_hoc);

        AnhXa();


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mamonhoc = edtMaMH.getText().toString().trim();
                String tenmonhoc = edtTenMH.getText().toString().trim();

                if(mamonhoc.isEmpty() || tenmonhoc.isEmpty()){
                    Toast.makeText(AddMonHoc.this, "Vui lòng nhập đủ thông tin môn học!", Toast.LENGTH_SHORT).show();
                }

                ThemMonHoc(urlinsert);

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
        btnThem     = (Button) findViewById(R.id.buttonOkAddMH);
        btnHuy      = (Button) findViewById(R.id.buttonHuyAddMH);
        edtTenMH  = (EditText) findViewById(R.id.edittextTenMHAdd);
        edtMaMH    = (EditText) findViewById(R.id.edittextMaMHAdd);

    }


    private void ThemMonHoc(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.toString().equals("Thành công")){
                            startActivity(new Intent(AddMonHoc.this, ActivityMonHoc.class));
                        }else {
                            Toast.makeText(AddMonHoc.this, response.toString(), Toast.LENGTH_LONG).show();
                        }
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
                params.put("addMaMH",edtMaMH.getText().toString().trim());
                params.put("addTenMH",edtTenMH.getText().toString().trim());


                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
