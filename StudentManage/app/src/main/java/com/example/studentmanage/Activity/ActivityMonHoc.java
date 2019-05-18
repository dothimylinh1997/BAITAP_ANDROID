package com.example.studentmanage.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
import com.example.studentmanage.Adapter.MonHocAdapter;
import com.example.studentmanage.Class.MonHoc;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ActivityMonHoc extends AppCompatActivity {
    String urlGetData = ActivityLogin.url + "quanlysinhvien/public/api/getMonHoc";
    String urlDelete = ActivityLogin.url + "quanlysinhvien/public/api/deleteMonHoc";

    ListView lvMonHoc;
    ArrayList<MonHoc> arrayMonHoc;
    MonHocAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_hoc);

        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        arrayMonHoc = new ArrayList<>();

        adapter = new MonHocAdapter(this, R.layout.item_monhoc, arrayMonHoc);
        lvMonHoc.setAdapter(adapter);



        GetData(urlGetData);
    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        arrayMonHoc.clear();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayMonHoc.add(new MonHoc(
                                        object.getString("MaMH"),
                                        object.getString("TenMH")
                                ));
                            } catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetInvalidated();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityMonHoc.this, "Lỗi show môn học!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void DeleteMonHoc(final String mamh){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.toString().equals("Thành công")){
                            GetData(urlGetData);
                        }else {
                            Toast.makeText(ActivityMonHoc.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivityMonHoc.this, "Lỗi rồi!", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String , String > getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("deleteid", mamh);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_back_item, menu);
        Drawable drawable= getResources().getDrawable(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())

        {
            case R.id.itemThem:
                if(item.getItemId() == R.id.itemThem ){
                    startActivity(new Intent(ActivityMonHoc.this, AddMonHoc.class));
                }
                break;
            case R.id.itemTrangchu:
                if(item.getItemId() == R.id.itemTrangchu ){
                    startActivity(new Intent(ActivityMonHoc.this, Home.class));
                }
                break;
            case R.id.itemLogout:
                if(item.getItemId() == R.id.itemLogout  ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMonHoc.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn có chắc muốn đăng xuất ?");
                    builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(ActivityMonHoc.this, ActivityLogin.class));
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
