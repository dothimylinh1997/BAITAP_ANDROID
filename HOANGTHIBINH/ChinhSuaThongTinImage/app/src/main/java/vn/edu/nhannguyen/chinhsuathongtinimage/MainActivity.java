package vn.edu.nhannguyen.chinhsuathongtinimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.nhannguyen.chinhsuathongtinimage.model.Card;

public class MainActivity extends AppCompatActivity  {
    private ArrayList<Card> cardArrayList;
    CheckBox chkHair, chkDress, chkBag, chkShoe;
    ImageView imgPicture;
    Button btnChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvents();
    }

     private void addEvents() {
         btnChoose.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (chkHair.isChecked()) {
                     imgPicture.setImageResource(R.drawable.hair);
                     //Toast.makeText(MainActivity.this, "ahihi ", Toast.LENGTH_SHORT).show();
                 }
                 if (chkDress.isChecked()) {
                     imgPicture.setImageResource(R.drawable.dress);
                 }
                 if (chkBag.isChecked()) {
                     imgPicture.setImageResource(R.drawable.bag);
                 }
                 if (chkShoe.isChecked()) {
                     imgPicture.setImageResource(R.drawable.shoe);
                 }
                 if (chkHair.isChecked() && chkDress.isChecked()) {
                     imgPicture.setImageResource(R.drawable.hair_dress);
                 }
                 if (chkHair.isChecked() && chkBag.isChecked()) {
                     imgPicture.setImageResource(R.drawable.hair_bag);
                 }
                 if (chkHair.isChecked() && chkShoe.isChecked()) {
                     imgPicture.setImageResource(R.drawable.hair_shoe);
                 }
                 if (chkDress.isChecked() && chkBag.isChecked()) {
                     imgPicture.setImageResource(R.drawable.dress_bag);
                 }
                 if (chkDress.isChecked() && chkShoe.isChecked()) {
                     imgPicture.setImageResource(R.drawable.dress_shoe);
                 }
                 if (chkBag.isChecked() && chkShoe.isChecked()) {
                     imgPicture.setImageResource(R.drawable.shoe_bag);
                 }
                 if (chkHair.isChecked() && chkDress.isChecked() && chkBag.isChecked()) {
                     imgPicture.setImageResource(R.drawable.hair_dress_bag);
                 }
                 if (chkHair.isChecked() && chkDress.isChecked() && chkShoe.isChecked()) {
                     imgPicture.setImageResource(R.drawable.hair_dress_shoe);
                 }
                 if (chkBag.isChecked() && chkDress.isChecked() && chkShoe.isChecked()) {
                     imgPicture.setImageResource(R.drawable.dress_bag_shoe);
                 }
                 if (chkHair.isChecked() && chkDress.isChecked() && chkBag.isChecked() && chkShoe.isChecked()) {
                     imgPicture.setImageResource(R.drawable.hair_dress_bag_shoe);
                 }
             }
         });
    }

             private void addControl() {
                 chkHair = (CheckBox) findViewById(R.id.chkHair);
                 chkDress = (CheckBox) findViewById(R.id.chkDress);
                 chkBag = (CheckBox) findViewById(R.id.chkBag);
                 chkShoe = (CheckBox) findViewById(R.id.chkShoe);
                 imgPicture = (ImageView) findViewById(R.id.imgPicture);
                 btnChoose = (Button) findViewById(R.id.btnChoose);
             }





}
