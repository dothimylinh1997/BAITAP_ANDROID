package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentmanage.Adapter.KhoaAdapter;
import com.example.studentmanage.Adapter.SearchSVAdapter;
import com.example.studentmanage.Class.Khoa;
import com.example.studentmanage.Class.SinhVien;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchSinhVien extends AppCompatActivity {

    String urlinsert = "http://192.168.137.39:8080/quanlysinhvien/public/api/searchSinhVien";
    String urlDelete = "http://192.168.137.39:8080/quanlysinhvien/public/api/deleteSinhVien";

    ListView lvSearchSV;
    ArrayList<SinhVien> arraySinhVien;
    SearchSVAdapter adapter;
    Button btnSearch;
    EditText edtSvSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_sinh_vien);

        btnSearch = (Button) findViewById(R.id.buttonSearchSV);
        edtSvSearch = (EditText) findViewById(R.id.edittextSearchSV);
        lvSearchSV = (ListView) findViewById(R.id.listviewSearchSV);
        arraySinhVien = new ArrayList<>();
        adapter = new SearchSVAdapter(this, R.layout.item_sinhvien, arraySinhVien);
        lvSearchSV.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimKiem(urlinsert);
//                Toast.makeText(SearchSinhVien.this, edtSvSearch.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

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
                                arraySinhVien.add(new SinhVien(
                                        object.getString("MaSV"),
                                        object.getString("HoTen"),
                                        object.getString("NgaySinh"),
                                        object.getString("DiaChi"),
                                        object.getString("GioiTinh"),
                                        object.getString("MaLop")
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
                params.put("id",edtSvSearch.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void DeleteSinhVien(final String masv){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SearchSinhVien.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SearchSinhVien.this, "Lỗi search!", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String , String > getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", masv);       /// SAI Ở ĐÂY NÈ

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
