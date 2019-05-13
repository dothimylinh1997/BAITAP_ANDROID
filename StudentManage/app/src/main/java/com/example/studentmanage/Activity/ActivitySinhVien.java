package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.studentmanage.Adapter.SinhVienAdapter;
import com.example.studentmanage.Class.Lop;
import com.example.studentmanage.Class.SinhVien;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivitySinhVien extends AppCompatActivity {

    String urlGetData = "http://192.168.43.253:8080/quanlysinhvien/public/api/getSinhVien";
    String urlDelete = "http://192.168.43.253:8080/quanlysinhvien/public/api/deleteSinhVien";

    ListView lvSinhvien;
    ArrayList<SinhVien> arraySinhVien;
    SinhVienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);

        lvSinhvien = (ListView) findViewById(R.id.listviewSinhVien);
        arraySinhVien = new ArrayList<>();

        adapter = new SinhVienAdapter(this, R.layout.item_sinhvien, arraySinhVien);
        lvSinhvien.setAdapter(adapter);


        GetData(urlGetData);
    }

    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        arraySinhVien.clear();
                        for (int i = 0; i <response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arraySinhVien.add(new SinhVien(
                                        object.getString("MaSV"),
                                        object.getString("HoTen"),
                                        object.getString("NgaySinh"),
                                        object.getString("DiaChi"),
                                        object.getString("GioiTinh"),
                                        object.getString("MaLop")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivitySinhVien.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void DeleteSinhVien(final String masv){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ActivitySinhVien.this, response.toString(), Toast.LENGTH_SHORT).show();
                        GetData(urlGetData);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivitySinhVien.this, "Lỗi rồi đó!", Toast.LENGTH_SHORT).show();
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
        getMenuInflater().inflate(R.menu.add_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menuAdd){
            startActivity(new Intent(ActivitySinhVien.this, AddSinhVien.class));
        }
        return super.onOptionsItemSelected(item);
    }
}