package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentmanage.Adapter.DsDiemDanhSVAdapter;
import com.example.studentmanage.Adapter.XemDiemDanhAdapter;
import com.example.studentmanage.Class.SinhVienDiemDanh;
import com.example.studentmanage.Class.SinhVienXemDiemDanh;
import com.example.studentmanage.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XemDiemDanh extends AppCompatActivity {

    String urlinsert = ActivityLogin.url + "quanlysinhvien/public/api/getDiemDanh";
    String url = ActivityLogin.url + "quanlysinhvien/public/api/getAll1";


    TextView txtTesst2;
    ListView lvDsSV;
    Button btnXong;
    public static ArrayList<SinhVienXemDiemDanh> arraySinhVien;
    XemDiemDanhAdapter adapter;
    String maLop;
    String maMH;
    String ngay;
    String newdataArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_diem_danh); Intent intent = getIntent();

        setControl();
        maLop = intent.getStringExtra("maLop");
        maMH = intent.getStringExtra("maMH");
        ngay = intent.getStringExtra("ngay");
        txtTesst2.setText("Danh sách lớp: " + maLop);

        arraySinhVien = new ArrayList<>();
        adapter = new XemDiemDanhAdapter(this, R.layout.item_sinhvien3, arraySinhVien);
        lvDsSV.setAdapter(adapter);

        lvDsSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("CLick",position + " fsdfsdfs");
                Toast.makeText(XemDiemDanh.this, position+"-", Toast.LENGTH_SHORT).show();
            }
        });

        TimKiem(urlinsert);

        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostData(url);
            }
        });
    }

    void setControl(){
        lvDsSV = findViewById(R.id.listviewDsSV1);
        txtTesst2  = findViewById(R.id.tesst3) ;
        btnXong = findViewById(R.id.buttonDiemDanhSv1) ;
    }

    private void TimKiem(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response1) {
                        try {
                            arraySinhVien.clear();
                            JSONArray array = new JSONArray(response1);
                            for (int i = 0; i < array.length(); i++){
                                JSONObject object = array.getJSONObject(i);
                                arraySinhVien.add(new SinhVienXemDiemDanh(
                                        object.getString("MaSV"),
                                        object.getString("MaMH"),
                                        object.getString("Ngay"),
                                        object.getString("DiemDanh"),
                                        object.getString("HoTen")
                                ));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
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
                params.put("MaLop",maLop);
                params.put("MaMH",maMH);
                params.put("Ngay",ngay);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void PostData(String url){
        for(SinhVienXemDiemDanh s: arraySinhVien)
            Log.e("ssss",s.getMaSv() + " " + s.getDiemDanh());


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.toString().equals("Thành công")){
                            startActivity(new Intent(XemDiemDanh.this, ActivityDiemDanh.class));
                        }else {
                            Toast.makeText(XemDiemDanh.this, response.toString(), Toast.LENGTH_LONG).show();
                        }
                        String result = response.toString();
                        Log.d("response","result: " + result);
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
                Gson gson = new Gson();
                newdataArray = gson.toJson(arraySinhVien);
                Log.d("result", newdataArray);
                params.put("array",newdataArray);
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
}
