package com.example.tuan4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class Activity7 extends AppCompatActivity {
    private ListView lv;
    private  ArrayList<String> ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);

        lv= (ListView) findViewById(R.id.lvKetqua);
        ketqua = new ArrayList<String>();

        ketqua.add("Câu 1 : 1 câu đúng");
        ketqua.add("Câu 2 : 2 câu đúng");
        ketqua.add("Câu 3 : 2 câu đúng");
        ketqua.add("Câu 4 : 1 câu đúng");
        ketqua.add("Câu 5 : 1 câu đúng");
        ketqua.add("Câu 6 : 1 câu đúng");

        ArrayAdapter adapter = new ArrayAdapter(Activity7.this, android.R.layout.simple_list_item_1,ketqua);
        lv.setAdapter(adapter);

    }
    }

