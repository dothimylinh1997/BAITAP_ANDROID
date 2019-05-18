package com.example.studentmanage.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
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

import static android.R.layout.simple_list_item_1;
import static android.R.layout.simple_list_item_2;
import static android.R.layout.simple_spinner_dropdown_item;
import static android.R.layout.simple_spinner_item;

public class ActivityDiem extends AppCompatActivity {

    String urlGetLop = ActivityLogin.url + "quanlysinhvien/public/api/getLop";
    String urlGetMonHoc = ActivityLogin.url + "quanlysinhvien/public/api/getMonHoc";

    public static String mamh;
    public static String malop;

    Spinner spinnerChonLop, spinnerChonMonHoc;
    Button btnNhapDiem, btnXemDiem;
    EditText edtNhapMaSv;
    ArrayList<String> arrayMaLop  = new ArrayList<String>();
    ArrayList<String> arrayMaMonHoc  = new ArrayList<String>();
    String masv ="" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem);

        spinnerChonLop    = (Spinner) findViewById(R.id.spinnerChonLop);
        spinnerChonMonHoc = (Spinner) findViewById(R.id.spinnerChonMonHoc);
        btnNhapDiem       = (Button) findViewById(R.id.buttonNhapDiem);
        btnXemDiem        = (Button) findViewById(R.id.buttonXemDiem);
        edtNhapMaSv       = (EditText) findViewById(R.id.edittextMaSvXemDiem);


        if(ActivityLogin.rolename == "sinhvien"){
            Intent intent = new Intent(ActivityDiem.this, XemDiem.class);
            intent.putExtra("masinhvien",ActivityLogin.username);
            ActivityDiem.this.startActivity(intent);
        }


        btnNhapDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDiem.this, ActivityNhapDiem.class));

            }
        });
        btnXemDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masv = edtNhapMaSv.getText().toString();
                Intent intent = new Intent(ActivityDiem.this, XemDiem.class);
                intent.putExtra("masinhvien",masv);
                ActivityDiem.this.startActivity(intent);
            }
        });


        GetDataLop(urlGetLop);
        GetDataMonhoc(urlGetMonHoc);

    }

    private void GetDataMonhoc(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);

                                arrayMaMonHoc.add(object.getString("MaMH"));
                                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(ActivityDiem.this, simple_spinner_item, arrayMaMonHoc);
                                spinnerArrayAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
                                spinnerChonMonHoc.setAdapter(spinnerArrayAdapter);
                                spinnerChonMonHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        mamh = arrayMaMonHoc.get(position);
//                                        Toast.makeText(ActivityDiem.this,mamh,Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
//                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityDiem.this, "Lỗi get môn học!", Toast.LENGTH_SHORT).show();
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
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                       for(int i = 0; i < response.length(); i++){
                           try {
                               JSONObject object = response.getJSONObject(i);

                               arrayMaLop.add(object.getString("MaLop"));
                               ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(ActivityDiem.this, simple_spinner_item, arrayMaLop);
                               spinnerArrayAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
                               spinnerChonLop.setAdapter(spinnerArrayAdapter);
                               spinnerChonLop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                   @Override
                                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                       malop = arrayMaLop.get(position);
//                                       Toast.makeText(ActivityDiem.this,malop,Toast.LENGTH_SHORT).show();
                                   }

                                   @Override
                                   public void onNothingSelected(AdapterView<?> parent) {

                                   }
                               });

                           } catch (JSONException e) {
                               e.printStackTrace();
                           }

                       }
//                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityDiem.this, "Lỗi get tên lớp!", Toast.LENGTH_SHORT).show();
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
                    startActivity(new Intent(ActivityDiem.this, Home.class));
                }
                break;
            case R.id.itemLogout:
                if(item.getItemId() == R.id.itemLogout  ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityDiem.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Bạn có chắc muốn đăng xuất ?");
                    builder.setMessage("Hãy lựa chọn bên dưới để xác nhận!");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(ActivityDiem.this, ActivityLogin.class));
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
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.studentmanage.Class.SinhVien;
//import com.example.studentmanage.R;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//import static android.R.layout.simple_spinner_item;
//
//public class ActivityDiem extends AppCompatActivity {
//
//    private String URLstring = "https://demonuts.com/Demonuts/JsonTest/Tennis/json_parsing.php";
//    private static ProgressDialog mProgressDialog;
//    private ArrayList<SinhVien> goodModelArrayList;
//    private ArrayList<String> names = new ArrayList<String>();
//    private Spinner spinner;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        spinner = findViewById(R.id.spCompany);
//
//        retrieveJSON();
//
//    }
//
//    private void retrieveJSON() {
//
//        showSimpleProgressDialog(this, "Loading...","Fetching Json",false);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        Log.d("strrrrr", ">>" + response);
//
//                        try {
//
//                            JSONObject obj = new JSONObject(response);
//                            if(obj.optString("status").equals("true")){
//
//                                goodModelArrayList = new ArrayList<>();
//                                JSONArray dataArray  = obj.getJSONArray("data");
//
//                                for (int i = 0; i < dataArray.length(); i++) {
//
//                                    GoodModel playerModel = new GoodModel();
//                                    JSONObject dataobj = dataArray.getJSONObject(i);
//
//                                    playerModel.setName(dataobj.getString("name"));
//                                    playerModel.setCountry(dataobj.getString("country"));
//                                    playerModel.setCity(dataobj.getString("city"));
//                                    playerModel.setImgURL(dataobj.getString("imgURL"));
//
//                                    goodModelArrayList.add(playerModel);
//
//                                }
//
//                                for (int i = 0; i < goodModelArrayList.size(); i++){
//                                    names.add(goodModelArrayList.get(i).getName().toString());
//                                }
//
//                                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(MainActivity.this, simple_spinner_item, names);
//                                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
//                                spinner.setAdapter(spinnerArrayAdapter);
//                                removeSimpleProgressDialog();
//
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        //displaying the error in toast if occurrs
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//        // request queue
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        requestQueue.add(stringRequest);
//
//
//    }
//
//    public static void removeSimpleProgressDialog() {
//        try {
//            if (mProgressDialog != null) {
//                if (mProgressDialog.isShowing()) {
//                    mProgressDialog.dismiss();
//                    mProgressDialog = null;
//                }
//            }
//        } catch (IllegalArgumentException ie) {
//            ie.printStackTrace();
//
//        } catch (RuntimeException re) {
//            re.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void showSimpleProgressDialog(Context context, String title,
//                                                String msg, boolean isCancelable) {
//        try {
//            if (mProgressDialog == null) {
//                mProgressDialog = ProgressDialog.show(context, title, msg);
//                mProgressDialog.setCancelable(isCancelable);
//            }
//
//            if (!mProgressDialog.isShowing()) {
//                mProgressDialog.show();
//            }
//
//        } catch (IllegalArgumentException ie) {
//            ie.printStackTrace();
//        } catch (RuntimeException re) {
//            re.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
