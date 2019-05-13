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
import com.example.studentmanage.Adapter.LopAdapter;
import com.example.studentmanage.Class.Lop;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityLop extends AppCompatActivity {

    String urlGetData = "http://192.168.43.253:8080/quanlysinhvien/public/api/getLop";
    String urlDelete = "http://192.168.43.253:8080/quanlysinhvien/public/api/deleteLop";

    ListView lvLop;
    ArrayList<Lop> arrayLop;
    LopAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop);

        lvLop = (ListView) findViewById(R.id.listviewLop);
        arrayLop = new ArrayList<>();

        adapter = new LopAdapter(this, R.layout.item_lop, arrayLop);
        lvLop.setAdapter(adapter);



        GetData(urlGetData);
    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        arrayLop.clear();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayLop.add(new Lop(
                                        object.getString("MaLop"),
                                        object.getString("TenLop"),
                                        object.getString("MaKhoa")
                                ));
                            } catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityLop.this, "Lỗi show lop !", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void DeleteLop(final String malop){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ActivityLop.this, response.toString(), Toast.LENGTH_SHORT).show();
                        GetData(urlGetData);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivityLop.this, "Lỗi rồi đó!", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String , String > getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("deleteid", malop);       /// SAI Ở ĐÂY NÈ

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
            startActivity(new Intent(ActivityLop.this, AddLop.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
