package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentmanage.Adapter.DsSVAdapter;
import com.example.studentmanage.Adapter.SearchSVAdapter;
import com.example.studentmanage.Class.DsSinhVien;
import com.example.studentmanage.Class.SinhVien;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityNhapDiem extends AppCompatActivity {

    String urlinsert = ActivityLogin.url + "quanlysinhvien/public/api/searchSinhVien";

    TextView txtTesst1;
    ListView lvDsSvDiem;
    ArrayList<DsSinhVien> arraySinhVien;
    DsSVAdapter adapter;
    String MaLop;
    String MaMh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_diem);

        lvDsSvDiem = (ListView) findViewById(R.id.listviewDsDiemSv);
        txtTesst1  = (TextView) findViewById(R.id.tesst1) ;
        arraySinhVien = new ArrayList<>();
        adapter = new DsSVAdapter(this, R.layout.item_sinhvien1, arraySinhVien);
        lvDsSvDiem.setAdapter(adapter);
//        Intent intent = getIntent();
//        MaLop = (intent.getStringExtra("malop"));
//        MaMh = (intent.getStringExtra("mamonhoc"));
//        txtTesst1.setText("DANH SÁCH LỚP : " + (intent.getStringExtra("malop")));
        MaLop = ActivityDiem.malop;
        MaMh = ActivityDiem.mamh;
        txtTesst1.setText("Danh sách lớp: " + MaLop);



        TimKiem(urlinsert);
    }

    private void TimKiem(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response1) {
//                        Toast.makeText(SearchSinhVien.this, response1.toString() , Toast.LENGTH_LONG).show();
                        try {

                            JSONArray array = new JSONArray(response1);
                            arraySinhVien.clear();
                            for (int i = 0; i < array.length(); i++){
                                JSONObject object = array.getJSONObject(i);
                                arraySinhVien.add(new DsSinhVien(
                                        object.getString("MaSV"),
                                        object.getString("HoTen"),
                                        MaMh
                                ));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
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
                params.put("id",MaLop);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
