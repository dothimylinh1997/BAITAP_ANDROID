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
import com.example.studentmanage.Adapter.ThoiKhoaBieuSVAdapter;
import com.example.studentmanage.Class.ThoiKhoaBieu;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

public class ActivityTKBSV extends AppCompatActivity {
    String urlGetData = ActivityLogin.url + "quanlysinhvien/public/api/getTKBSV";

    ListView lvTKB;
    ArrayList<ThoiKhoaBieu> arrayTKBSV;
    ThoiKhoaBieuSVAdapter thoiKhoaBieuSVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tkbsv);

        lvTKB = (ListView) findViewById(R.id.listviewTKBsv);
        arrayTKBSV = new ArrayList<>();
        thoiKhoaBieuSVAdapter = new ThoiKhoaBieuSVAdapter(this, R.layout.item_tkb_sv, arrayTKBSV);
        lvTKB.setAdapter(thoiKhoaBieuSVAdapter);

        GetData(urlGetData);
    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(ActivityTKBSV.this, response.toString(), Toast.LENGTH_SHORT).show();

                        JSONArray array = null;
                        try {
                            array = new JSONArray(response);
                            arrayTKBSV.clear();
                            for (int i = 0; i <response.length(); i++){
                                try {

                                    JSONObject object = array.getJSONObject(i);
                                    arrayTKBSV.add(new ThoiKhoaBieu(
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
                            thoiKhoaBieuSVAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivityTKBSV.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            protected Map<String , String > getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("MaSV", ActivityLogin.username);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
