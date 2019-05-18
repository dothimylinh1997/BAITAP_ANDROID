package com.example.gamedanhbai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gamedanhbai.R;
import com.example.gamedanhbai.model.Card;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Card> cardArrayList;
    ImageView imgOne, imgTwo, imgThree;
    TextView txtScore;
    Button btnSubmit, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgOne = findViewById(R.id.imgOne);
        imgTwo = findViewById(R.id.imgTwo);
        imgThree = findViewById(R.id.imgThree);
        txtScore = findViewById(R.id.txtScore);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);

        btnSubmit.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClear.setEnabled(false);
        data();
    }

    public void toProcessSubmit() {

        imgOne.animate().alpha(0f).setDuration(500);
        imgOne.setImageResource(R.drawable.at_bich);
        imgOne.animate().alpha(1f).setDuration(500);
        ArrayList<Card> temp = new ArrayList<>();
        while (true) {
            for (int i = 0; i < cardArrayList.size(); i++) {
                Random random = new Random();
                int j = random.nextInt(cardArrayList.size());
                if (!temp.contains(cardArrayList.get(j))) {
                    temp.add(cardArrayList.get(j));
                }
                if (temp.size() == 3) {
                    break;
                }
            }
            break;
        }
//            Toast.makeText(MainActivity.this, temp.get(i).getName() + " ", Toast.LENGTH_SHORT).show();
        //  imgOne.animate().alpha(0f).setDuration(200);
        imgOne.setImageResource(temp.get(0).getImage());
        // imgOne.animate().alpha(1f).setDuration(200);

        //   imgTwo.animate().alpha(0f).setDuration(200);
        imgTwo.setImageResource(temp.get(1).getImage());
        //  imgTwo.animate().alpha(1f).setDuration(200);

        // imtThree.animate().alpha(0f).setDuration(200);
        imgThree.setImageResource(temp.get(2).getImage());
        // imtThree.animate().alpha(1f).setDuration(200);
        int sum = temp.get(0).getScore() + temp.get(1).getScore() + temp.get(2).getScore();
        sum %= 10;
        txtScore.setText(sum + "");
        btnClear.setEnabled(true);
        //btnSubmit.setEnabled(false);

    }

    public void toProcessClear() {
        imgOne.setImageResource(R.drawable.none);
        imgThree.setImageResource(R.drawable.none);
        imgTwo.setImageResource(R.drawable.none);
        txtScore.setText("0");
        btnSubmit.setEnabled(true);
        btnClear.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.imgOne:
//                toProcessSubmit();
//                break;
//            case R.id.imgTwo:
//                toProcessSubmit();
//                break;
//            case R.id.imgThree:
//                toProcessSubmit();
//                break;
            case R.id.btnSubmit:
                toProcessSubmit();
                break;
            case R.id.btnClear:
                toProcessClear();
                break;
        }

    }

    public void data() {
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card(1, "Át Cơ", 1, R.drawable.at_co));
        cardArrayList.add(new Card(2, "Át Rô", 1, R.drawable.at_ro));
        cardArrayList.add(new Card(3, "Át Chuồng", 1, R.drawable.at_chuong));
        cardArrayList.add(new Card(4, "Át Bích", 1, R.drawable.at_bich));

        cardArrayList.add(new Card(5, "Hai Cơ", 2, R.drawable.hai_co));
        cardArrayList.add(new Card(6, "Hai Rô", 2, R.drawable.hai_ro));
        cardArrayList.add(new Card(7, "Hai Chuồng", 2, R.drawable.hai_chuong));
        cardArrayList.add(new Card(8, "Hai Bích", 2, R.drawable.hai_bich));

        cardArrayList.add(new Card(9, "Ba Cơ", 3, R.drawable.ba_co));
        cardArrayList.add(new Card(10, "Ba Rô", 3, R.drawable.ba_ro));
        cardArrayList.add(new Card(13, "Ba Chuồng", 3, R.drawable.ba_chuong));
        cardArrayList.add(new Card(12, "Ba Bích", 3, R.drawable.ba_bich));

        cardArrayList.add(new Card(13, "Bốn Cơ", 4, R.drawable.bon_co));
        cardArrayList.add(new Card(14, "Bốn Rô", 4, R.drawable.bon_ro));
        cardArrayList.add(new Card(15, "Bốn Chuồng", 4, R.drawable.bon_chuong));
        cardArrayList.add(new Card(16, "Bốn Bích", 4, R.drawable.bon_bich));

        cardArrayList.add(new Card(17, "Năm Cơ", 5, R.drawable.nam_co));
        cardArrayList.add(new Card(18, "Năm Rô", 5, R.drawable.nam_ro));
        cardArrayList.add(new Card(19, "Năm Chuồng", 5, R.drawable.nam_chuong));
        cardArrayList.add(new Card(20, "Năm Bích", 5, R.drawable.nam_bich));

        cardArrayList.add(new Card(21, "Sáu Cơ", 6, R.drawable.sau_co));
        cardArrayList.add(new Card(22, "Sáu Rô", 6, R.drawable.sau_ro));
        cardArrayList.add(new Card(23, "Sáu Chuồng", 6, R.drawable.sau_chuong));
        cardArrayList.add(new Card(24, "Sáu Bích", 6, R.drawable.sau_bich));

        cardArrayList.add(new Card(25, "Bảy Cơ", 7, R.drawable.bay_co));
        cardArrayList.add(new Card(26, "Bảy Rô", 7, R.drawable.bay_ro));
        cardArrayList.add(new Card(27, "Bảy Chuồng", 7, R.drawable.bay_chuong));
        cardArrayList.add(new Card(28, "Bảy Bích", 7, R.drawable.bay_bich));

        cardArrayList.add(new Card(29, "Tám Cơ", 8, R.drawable.tam_co));
        cardArrayList.add(new Card(30, "Tám Rô", 8, R.drawable.tam_ro));
        cardArrayList.add(new Card(31, "Tám Chuồng", 8, R.drawable.tam_chuong));
        cardArrayList.add(new Card(32, "Tám Bích", 8, R.drawable.tam_bich));

        cardArrayList.add(new Card(33, "Chín Cơ", 9, R.drawable.chin_co));
        cardArrayList.add(new Card(34, "Chín Rô", 9, R.drawable.chin_ro));
        cardArrayList.add(new Card(35, "Chín Chuồng", 9, R.drawable.chin_chuong));
        cardArrayList.add(new Card(36, "Chín Bích", 9, R.drawable.chin_bich));

        cardArrayList.add(new Card(37, "Mười Cơ", 10, R.drawable.muoi_co));
        cardArrayList.add(new Card(38, "Mười Rô", 10, R.drawable.muoi_ro));
        cardArrayList.add(new Card(39, "Mười Chuồng", 10, R.drawable.muoi_chuong));
        cardArrayList.add(new Card(40, "Mười Bích", 10, R.drawable.muoi_bich));

        cardArrayList.add(new Card(41, "Bồi Cơ", 10, R.drawable.boi_co));
        cardArrayList.add(new Card(42, "Bồi Rô", 10, R.drawable.boi_ro));
        cardArrayList.add(new Card(43, "Bồi Chuồng", 10, R.drawable.boi_chuong));
        cardArrayList.add(new Card(44, "Bồi Bích", 10, R.drawable.boi_bich));

        cardArrayList.add(new Card(45, "Đầm Cơ", 10, R.drawable.dam_co));
        cardArrayList.add(new Card(46, "Đầm Rô", 10, R.drawable.dam_ro));
        cardArrayList.add(new Card(47, "Đầm Chuồng", 10, R.drawable.dam_chuong));
        cardArrayList.add(new Card(48, "Đầm Bích", 10, R.drawable.dam_bich));

        cardArrayList.add(new Card(49, "Già Cơ", 10, R.drawable.gia_co));
        cardArrayList.add(new Card(50, "Già Rô", 10, R.drawable.gia_ro));
        cardArrayList.add(new Card(51, "Già Chuồng", 10, R.drawable.gia_chuong));
        cardArrayList.add(new Card(52, "Già Bích", 10, R.drawable.gia_bich));


    }


}