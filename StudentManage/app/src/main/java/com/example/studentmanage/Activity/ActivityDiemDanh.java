package com.example.studentmanage.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentmanage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.layout.simple_spinner_dropdown_item;
import static android.R.layout.simple_spinner_item;

public class ActivityDiemDanh extends AppCompatActivity {

    String urlGetLop = ActivityLogin.url + "quanlysinhvien/public/api/getLop";
    String urlGetMonHoc = ActivityLogin.url + "quanlysinhvien/public/api/getMonHoc";

    String mamh;
    String malop;
    String ngay;

    Spinner spinnerChonLop, spinnerChonMonHoc;
    Button btnDiemDanh, btnSuaDiemDanh;
    EditText edtNhapNgay;
    ArrayList<String> arrayMaLop  = new ArrayList<String>();
    ArrayList<String> arrayMaMonHoc  = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_danh);
        AnhXa();
        GetDataLop(urlGetLop);
        GetDataMonhoc(urlGetMonHoc);
        btnDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDiemDanh.this, DiemDanhSV.class);
                intent.putExtra("maMH", mamh);
                intent.putExtra("maLop", malop);
                intent.putExtra("ngay", edtNhapNgay.getText().toString());
                startActivity(intent);

            }
        });
        btnSuaDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDiemDanh.this, XemDiemDanh.class);
                intent.putExtra("maMH", mamh);
                intent.putExtra("maLop", malop);
                intent.putExtra("ngay", edtNhapNgay.getText().toString());
                startActivity(intent);

            }
        });
    }

    private void AnhXa() {
        spinnerChonLop     = (Spinner) findViewById(R.id.spinnerChonLop1);
        spinnerChonMonHoc  = (Spinner) findViewById(R.id.spinnerChonMonHoc1);
        btnDiemDanh        = (Button) findViewById(R.id.buttonDiemDanh);
        btnSuaDiemDanh     = (Button) findViewById(R.id.buttonXemDiemDanh);
        edtNhapNgay        = (EditText) findViewById(R.id.edittextNhapNgayDiemDanh);
    }

    private void GetDataMonhoc(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for(int i = 0; i < response.length(); i++){
                        try {
                            JSONObject object = response.getJSONObject(i);
                            arrayMaMonHoc.add(object.getString("MaMH"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(ActivityDiemDanh.this, simple_spinner_item, arrayMaMonHoc);
                        spinnerArrayAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
                        spinnerChonMonHoc.setAdapter(spinnerArrayAdapter);
                        spinnerChonMonHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                mamh = arrayMaMonHoc.get(position);
                                Log.e("Ma MH: ", mamh);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(ActivityDiemDanh.this, "Lỗi get môn học!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void GetDataLop(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for(int i = 0; i < response.length(); i++){
                        try {
                            JSONObject object = response.getJSONObject(i);
                            arrayMaLop.add(object.getString("MaLop"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(ActivityDiemDanh.this, simple_spinner_item, arrayMaLop);
                    spinnerArrayAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
                    spinnerChonLop.setAdapter(spinnerArrayAdapter);
                    spinnerChonLop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            malop = arrayMaLop.get(position);
                            Log.e("Ma lop: ", malop);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityDiemDanh.this, "Lỗi get lớp!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
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
                    startActivity(new Intent(ActivityDiemDanh.this, Home.class));
                }
                break;
            case R.id.itemLogout:
                if(item.getItemId() == R.id.itemLogout  ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityDiemDanh.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn có chắc muốn đăng xuất ?");
                    builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(ActivityDiemDanh.this, ActivityLogin.class));
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
