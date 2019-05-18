package com.example.studentmanage.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.studentmanage.Adapter.DiemAdapter;
import com.example.studentmanage.Adapter.SearchSVAdapter;
import com.example.studentmanage.Class.Diem;
import com.example.studentmanage.Class.SinhVien;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XemDiem extends AppCompatActivity {

    String urltimkiem = ActivityLogin.url + "quanlysinhvien/public/api/getDiem";

    ListView lvDiemSv;
    ArrayList<Diem> arrayDiem;
    DiemAdapter adapter;
    TextView txtshowMaSV;
    String MaSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_diem);

        txtshowMaSV = (TextView) findViewById(R.id.tesst2);
        lvDiemSv = (ListView) findViewById(R.id.listviewDiemSv);
        arrayDiem = new ArrayList<>();
        adapter = new DiemAdapter(this, R.layout.item_diem, arrayDiem);
        lvDiemSv.setAdapter(adapter);


        Intent intent = getIntent();
        MaSV = intent.getStringExtra("masinhvien");

        txtshowMaSV.setText("Điểm Sinh Viên : " +MaSV);
        TimKiem(urltimkiem);
    }

    private void TimKiem(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response1) {
//                        Toast.makeText(XemDiem.this, response1.toString(), Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray array = new JSONArray(response1);
                            arrayDiem.clear();
                            for (int i = 0; i < array.length(); i++){
                                JSONObject object = array.getJSONObject(i);
                                arrayDiem.add(new Diem(
                                        object.getString("MaMH"),
                                        object.getString("DiemCC"),
                                        object.getString("DiemKT"),
                                        object.getString("DiemCK"),
                                        object.getString("TK")
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
                        Toast.makeText(XemDiem.this, "Lỗi cmnr", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("MaSV",MaSV);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.done_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(ActivityLogin.rolename == "sinhvien"){
            if(item.getItemId() == R.id.menuDone){
                startActivity(new Intent(XemDiem.this, Homesv.class));
            }
        }else {
            startActivity(new Intent(XemDiem.this, ActivityDiem.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
