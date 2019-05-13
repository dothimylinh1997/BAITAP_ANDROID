package com.example.weeek6;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPlayer;
    ArrayList<Player> arrayPlayer;
    PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvPlayer = (ListView) findViewById(R.id.listviewPlayer);


        arrayPlayer = new ArrayList<>();

        adapter = new PlayerAdapter(this, R.layout.list_player_row, arrayPlayer);
        lvPlayer.setAdapter(adapter);

        Khoitao();
    }


    private void Khoitao() {
        arrayPlayer.add(new Player(R.drawable.ronaldo, "C. Ronaldo","Juvetus","7"));
        arrayPlayer.add(new Player(R.drawable.messi, "L. Messi","Barcalone","10"));
        arrayPlayer.add(new Player(R.drawable.haza, "E. Hazard","Chelsea","10"));

    }
}

