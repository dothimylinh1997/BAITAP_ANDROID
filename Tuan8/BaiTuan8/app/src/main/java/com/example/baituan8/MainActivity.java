package com.example.baituan8;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends App {
    String TAG = "Message";
    DatabaseReference msg = null;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFireBase();
    }

    private void setFireBase() {
        // Write a message to the database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        msg = database.getReference(TAG);

//        myRef.setValue("Hello, World!");
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, "Value is: " + value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });
        EditText txt = findViewById(R.id.txt);
        msg.setValue(txt.getText().toString());
        Button btn = findViewById(R.id.btn);
        msg.setValue(txt.getText().toString());
    }

}
