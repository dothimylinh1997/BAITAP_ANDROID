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
import com.example.studentmanage.Class.SinhVien;
import com.example.studentmanage.R;

import java.util.HashMap;
import java.util.Map;

public class UpdateSinhVien extends AppCompatActivity {

    String   urlUpdate = "http://192.168.137.39:8080/quanlysinhvien/public/api/updateSinhVien";

    EditText edtMaSv, edtHoTen, edtNgaySinh, edtDiaChi, edtGioiTinh, edtMaLop;
    Button btnCapNhap, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sinh_vien);

        Intent intent = getIntent();
        SinhVien sv = (SinhVien) intent.getSerializableExtra("dataSinhVien");
//        Toast.makeText(this, khoa.getTenKhoa(), Toast.LENGTH_SHORT).show();

        AnhXa();

        edtMaSv.setText(sv.getMaSv());
        edtHoTen.setText(sv.getHoTen());
        edtNgaySinh.setText(sv.getNgaySinh());
        edtDiaChi.setText(sv.getDiaChi());
        edtGioiTinh.setText(sv.getGioiTinh());
        edtMaLop.setText(sv.getMaLop());

        btnCapNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masv = edtMaSv.getText().toString().trim();
                String hoten = edtHoTen.getText().toString().trim();
                String ngaysinh = edtNgaySinh.getText().toString().trim();
                String diachi = edtDiaChi.getText().toString().trim();
                String gioitinh = edtGioiTinh.getText().toString().trim();
                String malop = edtMaLop.getText().toString().trim();
                if(masv.isEmpty() || hoten.isEmpty() || ngaysinh.isEmpty() || diachi.isEmpty() || gioitinh.isEmpty() || malop.isEmpty()){
                    Toast.makeText(UpdateSinhVien.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
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
        btnCapNhap   = (Button) findViewById(R.id.buttonOkSvUpdate);
        btnHuy       = (Button) findViewById(R.id.buttonHuySvUpdate);
        edtMaSv      = (EditText) findViewById(R.id.edittextMaSvUpdate);
        edtHoTen     = (EditText) findViewById(R.id.edittextHoTenSvUpdate);
        edtNgaySinh  = (EditText) findViewById(R.id.edittextNgaySinhUpdate);
        edtDiaChi    = (EditText) findViewById(R.id.edittextDiaChiUpdate);
        edtGioiTinh  = (EditText) findViewById(R.id.edittextGioiTinhUpdate);
        edtMaLop     = (EditText) findViewById(R.id.edittextMaLopSvUpdate);
    }


    private void CapNhatSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UpdateSinhVien.this, response.toString(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UpdateSinhVien.this, ActivitySinhVien.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateSinhVien.this, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("addMaSV", edtMaSv.getText().toString().trim());
                params.put("addTenSV", edtHoTen.getText().toString().trim());
                params.put("addNgaySinh", edtNgaySinh.getText().toString().trim());
                params.put("addGioiTinh", edtGioiTinh.getText().toString().trim());
                params.put("addDiaChi", edtDiaChi.getText().toString().trim());
                params.put("addMaLop", edtMaLop.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
