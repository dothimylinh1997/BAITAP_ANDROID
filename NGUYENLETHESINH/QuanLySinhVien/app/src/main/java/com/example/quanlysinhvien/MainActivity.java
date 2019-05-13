package com.example.quanlysinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlGetData = "http://192.168.1.165:8080/quanlysinhvien/public/api/testmodel2";

    ListView lvSinhvien;
    ArrayList<SinhVien> arraySinhVien;
    SinhVienAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvSinhvien = (ListView) findViewById(R.id.listviewSinhVien);
        arraySinhVien = new ArrayList<>();

        adapter = new SinhVienAdapter(this, R.layout.dong_sinh_vien, arraySinhVien);
        lvSinhvien.setAdapter(adapter);


        GetData(urlGetData);

//        ReadJSON("http://192.168.1.84/androidwebservice/demo.php");// Phải thay thế local host băng ip nó mới hiểu
    }

    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                          for (int i = 0; i <response.length(); i++){
                              try {
                                  JSONObject object = response.getJSONObject(i);
                                  arraySinhVien.add(new SinhVien(
                                          object.getString("MaSV"),
                                          object.getString("HoTen"),
                                          object.getString("NgaySinh"),
                                          object.getString("MaLop"),
                                          object.getString("DiaChi"),
                                          object.getString("GioiTinh")
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
                        Toast.makeText(MainActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
     }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_sinhvien, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    //    private void ReadJSON(String url){
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT);
//                    }
//                }
//        );
//        requestQueue.add(jsonArrayRequest);
//    }
}
