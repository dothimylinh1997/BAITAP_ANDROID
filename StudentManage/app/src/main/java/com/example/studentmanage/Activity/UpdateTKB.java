package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentmanage.Class.ThoiKhoaBieu;
import com.example.studentmanage.R;

import java.util.HashMap;
import java.util.Map;

public class UpdateTKB extends AppCompatActivity {
    String   urlUpdate = "http://192.168.137.39:8080/quanlysinhvien/public/api/updateTKB";

    EditText editMaLopup, editMaMHup, editPhongHocup, editThuup, editTietBDup, editThoiGianup;
    Button btnCapnhat, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_tkb);

        final Intent intent = getIntent();

        ThoiKhoaBieu thoiKhoaBieu = (ThoiKhoaBieu) intent.getSerializableExtra("dataTKB");
        AnhXa();

        editMaLopup.setText(thoiKhoaBieu.getMaLop());
        editMaMHup.setText(thoiKhoaBieu.getMaMH());
        editThuup.setText(thoiKhoaBieu.getThu());
        editThoiGianup.setText(thoiKhoaBieu.getThoiGian());
        editTietBDup.setText(thoiKhoaBieu.getTietBD());
        editPhongHocup.setText(thoiKhoaBieu.getPhongHoc());

        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = editMaLopup.getText().toString().trim();
                String mamon = editMaMHup.getText().toString().trim();
                String thu = editThuup.getText().toString().trim();
                String tietbatdau = editTietBDup.getText().toString().trim();
                String phong = editPhongHocup.getText().toString().trim();
                String thoigian = editThoiGianup.getText().toString().trim();

                if(malop.isEmpty() || mamon.isEmpty() || thu.isEmpty() || tietbatdau.isEmpty() || phong.isEmpty() || thoigian.isEmpty()){
                    Toast.makeText(UpdateTKB.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
                else{
                    CapNhatTKB(urlUpdate);
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
        editMaLopup = (EditText) findViewById(R.id.editMaLopup);
        editMaMHup = (EditText) findViewById(R.id.editMaMonup);
        editPhongHocup = (EditText) findViewById(R.id.editPhongup);
        editTietBDup = (EditText) findViewById(R.id.editTietBatDauup);
        editThoiGianup = (EditText) findViewById(R.id.editThoiGianup);
        editThuup = (EditText) findViewById(R.id.editThuup);
        btnCapnhat = (Button) findViewById(R.id.buttonOkUpdateTKB);
        btnHuy = (Button) findViewById(R.id.buttonHuyUpdateTKB);
    }
    private void CapNhatTKB(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UpdateTKB.this, response.toString(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UpdateTKB.this, ActivityTKB.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateTKB.this, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("addMaLop",editMaLopup.getText().toString().trim());
                params.put("addMaMon",editMaMHup.getText().toString().trim());
                params.put("addThu",editThuup.getText().toString().trim());
                params.put("addTietBD",editTietBDup.getText().toString().trim());
                params.put("addPhongHoc",editPhongHocup.getText().toString().trim());
                params.put("addThoiGian",editThoiGianup.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
