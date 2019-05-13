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
    String urlGetData = "http://192.168.137.39:8080/quanlysinhvien/public/api/getTKB";
    String urlDelete = "http://192.168.137.39:8080/quanlysinhvien/public/api/deleteTKB";

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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menuAdd){
            startActivity(new Intent(ActivityTKB.this, AddTKB.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
