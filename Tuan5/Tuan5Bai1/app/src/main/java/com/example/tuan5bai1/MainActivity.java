package com.example.tuan5bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView1;
    ArrayList<SocialNetwork> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();


    }
    private  void setControl(){

        listView1 = findViewById(R.id.listView1);
    }

    private  void setEvent(){
        KhoiTao();
        //ArrayAdapter<SocialNetwork> arrayAdapter = new ArrayAdapter<SocialNetwork>(this, android.R.layout.simple_list_item_1, data);
        SocialNetworkAdapter adapter = new SocialNetworkAdapter(this, R.layout.activity_listview_item_row,data);
        listView1.setAdapter(adapter);
    }
    void KhoiTao(){
        data.add(new SocialNetwork(R.mipmap.vi, "Vietnam"));
        data.add(new SocialNetwork(R.mipmap.us, "United States"));
        data.add(new SocialNetwork(R.mipmap.ru, "Russia"));

    }
}
