package com.example.studentmanage.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    String url = "http://192.168.1.165:8080/quanlysinhvien/public/api/getLop";
    String url1 = "http://192.168.1.165:8080/quanlysinhvien/public/api/getSinhVien";
    Spinner spinnerChonLop;
    ListView lvName;
    ArrayList<String> arrayTenLop  = new ArrayList<String>();
    ArrayList<String> arrayTenSv  = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem);

        spinnerChonLop = findViewById(R.id.spinnerChonLop);
        lvName = findViewById(R.id.listviewNameDiem);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, simple_list_item_1, arrayTenSv);
        lvName.setAdapter(arrayAdapter);
        GetData(url);
        GetData1(url1);

    }


    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                       for(int i = 0; i < response.length(); i++){
                           try {
                               JSONObject object = response.getJSONObject(i);

                               arrayTenLop.add(object.getString("TenLop"));
                               ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(ActivityDiem.this, simple_spinner_item, arrayTenLop);
                               spinnerArrayAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
                               spinnerChonLop.setAdapter(spinnerArrayAdapter);
                               spinnerChonLop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                   @Override
                                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                       Toast.makeText(ActivityDiem.this,arrayTenLop.get(position),Toast.LENGTH_SHORT).show();
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
                Toast.makeText(ActivityDiem.this, "Lỗi show khoa!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    private void GetData1(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);

                                arrayTenSv.add(object.getString("HoTen"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityDiem.this, "Lỗi show khoa!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
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
