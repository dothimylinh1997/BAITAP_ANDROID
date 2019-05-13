package com.example.managestudent;

import android.app.Activity;
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

import java.util.HashMap;
import java.util.Map;

public class AddKhoa extends AppCompatActivity {

    EditText edtMaKhoa, edtTenKhoa;
    Button btnThem, btnHuy;

    String urlinsert = "http://192.168.43.253:8080/quanlysinhvien/public/api/addKhoa";

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
        btnThem     = (Button) findViewById(R.id.buttonThem);
        btnHuy      = (Button) findViewById(R.id.buttonHuy);
        edtMaKhoa   = (EditText) findViewById(R.id.editMaKhoa);
        edtTenKhoa  = (EditText) findViewById(R.id.editTenKhoa);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menuDone){
            startActivity(new Intent(AddKhoa.this, ActivityKhoa.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
