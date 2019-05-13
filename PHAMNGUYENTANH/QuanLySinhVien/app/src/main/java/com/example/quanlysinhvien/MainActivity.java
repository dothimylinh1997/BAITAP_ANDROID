package com.example.quanlysinhvien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;


public class MainActivity extends AppCompatActivity {

    private ImageButton btnKhoa;
    private ImageButton btnLop;
    private ImageButton btnSinhVien;

   String urlGetData = "http://192.168.1.165:8080/quanlysinhvien/public/api/testmodel2";
   //String urlGetData = "http://192.168.1.165:8080/quanlysinhvien/public/api/getKhoa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        lvKhoa = (ListView) findViewById(R.id.listviewKhoa);
//        arrayKhoa = new ArrayList<>();
//
//        adapter = new KhoaAdapter(this, R.layout.dong_khoa, arrayKhoa);
//        lvKhoa.setAdapter(adapter);

        GetData(urlGetData);

        btnKhoa = findViewById(R.id.btnKhoa);
        btnKhoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityKhoa.class);
                startActivity(intent);
            }
        });
        btnLop = findViewById(R.id.btnLop);
        btnLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityLop.class);
                startActivity(intent);
            }
        });
        btnSinhVien = findViewById(R.id.btnSinhVien);
        btnSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitySinhVien.class);
                startActivity(intent);
            }
        });
    }

    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        for (int i = 0; i <response.length(); i++){
//                            try {
//                                JSONObject object = response.getJSONObject(i);
//                                arrayKhoa.add(new Khoa(
//                                        object.getString("MaKhoa"),
//                                        object.getString("TenKhoa")
//                                ));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        adapter.notifyDataSetChanged();
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.add_khoa, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

