package com.example.studentmanage.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    String urlinsert = ActivityLogin.url + "quanlysinhvien/public/api/searchSinhVien";
    String urlDelete = ActivityLogin.url + "quanlysinhvien/public/api/deleteSinhVien";

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back_item, menu);
        Drawable drawable= getResources().getDrawable(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itemTrangchu:
                if(item.getItemId() == R.id.itemTrangchu ){
                    startActivity(new Intent(SearchSinhVien.this, Home.class));
                }
                break;
            case R.id.itemLogout:
                if(item.getItemId() == R.id.itemLogout  ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(SearchSinhVien.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn có chắc muốn đăng xuất?");
                    builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(SearchSinhVien.this, ActivityLogin.class));
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
                break;

            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
