package com.example.managestudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class AddSinhVien extends AppCompatActivity {

    EditText edtMaSinhVien, edtHoTen, edtGioiTinh, edtNgaySinh, edtMaLop, edtDiaChi;
    Button btnThem, btnHuy;

    String urlinsert = "";

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
        edtMaSinhVien   = (EditText) findViewById(R.id.editMaSinhVien);
        edtHoTen        = (EditText) findViewById(R.id.editHoTen);
        edtGioiTinh     = (EditText) findViewById(R.id.editGioiTinh);
        edtDiaChi       = (EditText) findViewById(R.id.editDiaChi);
        edtNgaySinh     = (EditText) findViewById(R.id.editNgaySinh);
        edtMaLop        = (EditText) findViewById(R.id.editMaLopSv);
        btnThem         = (Button)   findViewById(R.id.buttonThemSv);
        btnHuy          = (Button)   findViewById(R.id.buttonHuySv);
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
                params.put("addMaSinhVien",edtMaSinhVien.getText().toString().trim());
                params.put("addHoTen",edtHoTen.getText().toString().trim());
                params.put("addGioiTinh",edtGioiTinh.getText().toString().trim());
                params.put("addNgaySinh",edtNgaySinh.getText().toString().trim());
                params.put("addDiaChi",edtDiaChi.getText().toString().trim());
                params.put("addMaLop",edtMaLop.getText().toString().trim());

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
            startActivity(new Intent(AddSinhVien.this, ActivitySinhVien.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
