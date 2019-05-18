package com.example.tuan6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    ArrayList<MonHoc> data = new ArrayList<>();
    MonHocAdapter adapter = null;
    Button btnInsert, btnDelete, btnSearch, btnUpdate;
    EditText mamh, tenmh, sotiet;
    int index = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert=(Button) findViewById(R.id.btnInsert);
        btnDelete=(Button) findViewById(R.id.btnDelete);
        btnSearch=(Button) findViewById(R.id.btnSearch);
        btnUpdate=(Button) findViewById(R.id.btnUpdate);

        mamh=(EditText) findViewById(R.id.mamh);
        tenmh=(EditText) findViewById(R.id.tenmh);
        sotiet =(EditText) findViewById(R.id.sotiet);

       listView1=(ListView) findViewById(R.id.listView1);


        adapter = new MonHocAdapter(this, R.layout.listview_item_row, data);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonHoc mh = data.get(position);
                index=position;
                mamh.setText(mh.getMa());

        tenmh.setText(mh.getTen());
        sotiet.setText(mh.getSotiet());
        }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
               InsertMH();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                DeleteMH();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                updateMH();
            }
        });
    }

    private MonHoc getMonHoc() {
        MonHoc monHoc = new MonHoc();
        monHoc.setMa(mamh.getText().toString());
        monHoc.setTen(tenmh.getText().toString());
        monHoc.setSotiet(sotiet.getText().toString());
        return monHoc;
    }

    public void InsertMH() {
        MonHoc monHoc = getMonHoc();
        data.add(monHoc);
        adapter.notifyDataSetChanged();

    }

    public void DeleteMH() {

        if (index >= 0) {
            data.remove(index);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(this, "Xóa không thành công", Toast.LENGTH_SHORT).show();


    }

    public void updateMH() {
        String ma = mamh.getText().toString();
        String ten = tenmh.getText().toString();
        String st = sotiet.getText().toString();

        data.get(index).setMa(ma);
        data.get(index).setTen(ten);
        data.get(index).setSotiet(st);
        Toast.makeText(this, "Update Thành Công!", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }



}


