package com.example.pokergame;

import android.util.Log;

public class Player {
    int[] result = new int[3];

    public int Score(){
        int sum =0;
        for(int s: result){
            int score = s%13;
            if(score<=10) sum += score;
        }
        return sum;
    }

    public void RandomPoker(){
        int random;
        for (int i=0; i<3; i++){
            random = (int)(Math.random() * 51 + 1); //1-52
            for(int j=0; j<3; j++){
                if(random==result[j]){
                    i--;
                    break;
                }
            }
            result[i]=random;
        }
    }

    public String test(){
        String t="";
        for(int s: result){
            t+= " - " +s;
        }
        return t;
    }
}
