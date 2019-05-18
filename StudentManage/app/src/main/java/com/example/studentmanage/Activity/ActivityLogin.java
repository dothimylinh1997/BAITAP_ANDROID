package com.example.studentmanage.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.studentmanage.R;

import java.util.HashMap;
import java.util.Map;

public class ActivityLogin extends AppCompatActivity {

    public static String url = "http://192.168.1.95:8080/";
    Button btnDangNhap, btnDangKyTaiKhoan, btnThoatDangNhap;
    EditText edtUserDN, edtPasswordDN;
    public static String username;
    public static String rolename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();

        ControlButton();
    }

    private void AnhXa() {
        edtUserDN           = (EditText) findViewById(R.id.edtUserDN);
        edtPasswordDN       = (EditText) findViewById(R.id.edtPasswordDN);
        btnDangNhap         = (Button) findViewById(R.id.btnDangNhap);
//        btnDangKyTaiKhoan   = (Button) findViewById(R.id.btnDangKyTaiKhoan);
        btnThoatDangNhap    = (Button) findViewById(R.id.btnThoatDangNhap);
    }

    private void ControlButton() {
//        btnDangKyTaiKhoan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ActivityLogin.this, ActivityDangKy.class);
//                startActivity(intent);
//            }
//        });



        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urllogin = url + "quanlysinhvien/public/api/login";
                Login(urllogin);


            }
        });

        btnThoatDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityLogin.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát khỏi app ?");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }


    private void Login(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String role = response.toString();


                        if(role.equals("sinhvien")){
//                            Toast.makeText(ActivityLogin.this, "Sinh vien", Toast.LENGTH_LONG).show();
                            rolename = "sinhvien";
                            username = edtUserDN.getText().toString().trim();
                            Intent intent = new Intent(ActivityLogin.this, Homesv.class);
                            startActivity(intent);
                        }
                        else if(role.equals("admin")){
                            rolename = "admin";
//                            Toast.makeText(ActivityLogin.this, "admin", Toast.LENGTH_LONG).show();
                            username = edtUserDN.getText().toString().trim();
                            Intent intent = new Intent(ActivityLogin.this, Home.class);
                            startActivity(intent);
                        }
                        else if(role.equals("giangvien")){
                            rolename = "giangvien";
//                            Toast.makeText(ActivityLogin.this, "giao vien", Toast.LENGTH_LONG).show();
                            username = edtUserDN.getText().toString().trim();
                            Intent intent = new Intent(ActivityLogin.this, Homegv.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(ActivityLogin.this, response.toString(), Toast.LENGTH_LONG).show();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("username",edtUserDN.getText().toString().trim());
                params.put("password",edtPasswordDN.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
