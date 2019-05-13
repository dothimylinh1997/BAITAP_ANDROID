package com.example.tuan5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setEvent();
//        setControl();
        List<Country> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // Khi người dùng click vào các ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Country country = (Country) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + country, Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<Country> getListData() {
        List<Country> list = new ArrayList<Country>();
        Country vietnam = new Country("Vietnam", "vietnam1", 98000000);
        Country usa = new Country("United States", "usa1", 320000000);
        Country russia = new Country("Russia", "russia1", 142000000);


        list.add(vietnam);
        list.add(usa);
        list.add(russia);

        return list;
    }
}


