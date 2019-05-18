package com.example.studentmanage.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentmanage.Class.Thongbao;
import com.example.studentmanage.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UpdateThongBao extends AppCompatActivity {

    ListView lvThongBao;
    ArrayList<String> mangthongbao;
    ArrayAdapter arrayAdapter = null;
    DatabaseReference mData;
    EditText NoiDung, TieuDe;
    TextView txtThongBao;
    Button ThemThongBao, HuyThongBao;
    String txtRole;

    public static String ttieude;
    public static String nnoidung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_thong_bao);


        txtRole = ActivityLogin.rolename.toString();


        lvThongBao = findViewById(R.id.lvtb);
        mangthongbao = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter( this,android.R.layout.simple_list_item_1,mangthongbao);
        lvThongBao.setAdapter(arrayAdapter);

        txtThongBao = findViewById(R.id.txtNoiDung);
        ThemThongBao = findViewById(R.id.btnThemThongBao);
        HuyThongBao = findViewById(R.id.BtnHuyThongBao);
        NoiDung = findViewById(R.id.editNoiDung);
        TieuDe = findViewById(R.id.editTieuDe);



        mData = FirebaseDatabase.getInstance().getReference();
        ThemThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtRole == "sinhvien"){
//                    NoiDung.setEnabled(false);
//                    TieuDe.setEnabled(false);  Ỏ ĐÂY NHAAAA!!!!!
                    Toast.makeText(UpdateThongBao.this, "SINH VIÊN KHÔNG CÓ QUYỀN!!", Toast.LENGTH_SHORT).show();
                }else {
                    Thongbao thongbao = new Thongbao(TieuDe.getText().toString()  ,NoiDung.getText().toString());
                    mData.child("Thongbao").push().setValue(thongbao);
                }


            }
        });
        HuyThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mData.child("Thongbao").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Thongbao tb = dataSnapshot.getValue(Thongbao.class);
                Toast.makeText(UpdateThongBao.this, tb.TieuDe+ "          " + tb.NoiDung, Toast.LENGTH_SHORT).show();
                ttieude = tb.TieuDe;
                nnoidung = tb.NoiDung;
                mangthongbao.add(tb.TieuDe + "          " + tb.NoiDung);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
