package com.example.managestudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddLop extends AppCompatActivity {

    EditText edtMaLop, edtTenLop, edtMaKhoa;
    Button btnThem, btnHuy;

    String urlinsert = "http://192.168.43.253:8080/quanlysinhvien/public/api/addKhoa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lop);

        AnhXa();


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtMaLop.getText().toString().trim();
                String tenlop = edtTenLop.getText().toString().trim();
                String makhoa = edtMaKhoa.getText().toString().trim();
                if(makhoa.isEmpty() || tenlop.isEmpty() || malop.isEmpty()){
                    Toast.makeText(AddLop.this, "Vui lòng nhập đủ thông tin lớp!", Toast.LENGTH_SHORT).show();
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
        btnThem     = (Button) findViewById(R.id.buttonThemLop);
        btnHuy      = (Button) findViewById(R.id.buttonHuyLop);
        edtMaKhoa   = (EditText) findViewById(R.id.editMaKhoaLop);
        edtTenLop   = (EditText) findViewById(R.id.editTenLop);
        edtMaLop    = (EditText) findViewById(R.id.editMaLop);

    }


    private void ThemKhoa(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(AddLop.this, response.toString(), Toast.LENGTH_LONG).show();
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
                params.put("addMaLop",edtMaLop.getText().toString().trim());
                params.put("addTenLop",edtTenLop.getText().toString().trim());
                params.put("addMaKhoa",edtMaKhoa.getText().toString().trim());

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
            startActivity(new Intent(AddLop.this, ActivityKhoa.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
