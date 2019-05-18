package com.example.studentmanage.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
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
import com.example.studentmanage.Adapter.ThoiKhoaBieuAdapter;
import com.example.studentmanage.Class.ThoiKhoaBieu;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityTKB extends AppCompatActivity {
    String urlGetData = ActivityLogin.url + "quanlysinhvien/public/api/getTKB";
    String urlDelete = ActivityLogin.url + "quanlysinhvien/public/api/deleteTKB";

    ListView lvTKB;
    ArrayList<ThoiKhoaBieu> arrayTKB;
    ThoiKhoaBieuAdapter thoiKhoaBieuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tkb);

        lvTKB = (ListView) findViewById(R.id.listviewTKB);
        arrayTKB = new ArrayList<>();
        thoiKhoaBieuAdapter = new ThoiKhoaBieuAdapter(this, R.layout.item_tkb, arrayTKB);
        lvTKB.setAdapter(thoiKhoaBieuAdapter);

        GetData(urlGetData);
    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrayTKB.clear();
                        for (int i = 0; i <response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayTKB.add(new ThoiKhoaBieu(
                                        object.getString("MaLop"),
                                        object.getString("MaMH"),
                                        object.getString("Thu"),
                                        object.getString("TietBD"),
                                        object.getString("PhongHoc"),
                                        object.getString("ThoiGian")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        thoiKhoaBieuAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivityTKB.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    public void DeleteTKB(final String malop, final String mamon){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ActivityTKB.this, response.toString(), Toast.LENGTH_SHORT).show();
                        GetData(urlGetData);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivityTKB.this, "Lỗi rồi đó!", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String , String > getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("MaLop", malop);
                params.put("MaMH", mamon);

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
                    startActivity(new Intent(ActivityTKB.this, AddTKB.class));
                }
                break;
            case R.id.itemTrangchu:
                if(item.getItemId() == R.id.itemTrangchu ){
                    startActivity(new Intent(ActivityTKB.this, Home.class));
                }
                break;
            case R.id.itemLogout:
                if(item.getItemId() == R.id.itemLogout  ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityTKB.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn có chắc muốn đăng xuất ?");
                    builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(ActivityTKB.this, ActivityLogin.class));
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

