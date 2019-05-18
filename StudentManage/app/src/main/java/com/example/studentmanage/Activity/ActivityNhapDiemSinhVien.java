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
import com.example.studentmanage.Class.DsSinhVien;
import com.example.studentmanage.Class.Khoa;
import com.example.studentmanage.R;

import java.util.HashMap;
import java.util.Map;

public class ActivityNhapDiemSinhVien extends AppCompatActivity {

    String url = ActivityLogin.url + "quanlysinhvien/public/api/addDiem";

    EditText edtMaSv, edtMaMH,edtDiemCC, edtDiemKT,edtDiemCK, edtDiemTK;
    Button btnOk, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_diem_sinh_vien);

        Intent intent = getIntent();
        DsSinhVien dsSinhVien = (DsSinhVien) intent.getSerializableExtra("dataDsSinhVien");


        AnhXa();

        edtMaSv.setText(dsSinhVien.getMaSv());
        edtMaMH.setText(dsSinhVien.getMaMH());


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diemcc = edtDiemCC.getText().toString().trim();
                String diemkt = edtDiemKT.getText().toString().trim();
                String diemck = edtDiemCK.getText().toString().trim();
                String diemtk = edtDiemTK.getText().toString().trim();
                if(diemcc.isEmpty() || diemkt.isEmpty() || diemck.isEmpty() || diemtk.isEmpty()){
                    Toast.makeText(ActivityNhapDiemSinhVien.this, "Vui lòng nhập đủ điểm!", Toast.LENGTH_SHORT).show();
                }
                else {
                    NhapDiemSV(url);
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
        btnOk      = (Button) findViewById(R.id.buttonOkNhapDiem);
        btnHuy     = (Button) findViewById(R.id.buttonHuyNhapDiem);
        edtMaSv    = (EditText) findViewById(R.id.edittextMaSVDiem);
        edtMaMH    = (EditText) findViewById(R.id.edittextMaMonDiem);
        edtDiemCC  = (EditText) findViewById(R.id.edittextDiemCC);
        edtDiemKT  = (EditText) findViewById(R.id.edittextDiemKT);
        edtDiemCK  = (EditText) findViewById(R.id.edittextDiemCK);
        edtDiemTK  = (EditText) findViewById(R.id.edittextDiemTK);
    }

    private void NhapDiemSV(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.toString().equals("Thành công")){
                            startActivity(new Intent(ActivityNhapDiemSinhVien.this, ActivityNhapDiem.class));
                        }else {
                            Toast.makeText(ActivityNhapDiemSinhVien.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivityNhapDiemSinhVien.this, "Lỗi api nhập điểm", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("MaSV", edtMaSv.getText().toString().trim());
                params.put("MaMH", edtMaMH.getText().toString().trim());
                params.put("DiemCC", edtDiemCC.getText().toString().trim());
                params.put("DiemKT", edtDiemKT.getText().toString().trim());
                params.put("DiemCK", edtDiemCK.getText().toString().trim());
                params.put("TK", edtDiemTK.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


}
