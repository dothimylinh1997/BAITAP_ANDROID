package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private static String DB_NAME = "dbMon.db";
    private static int DB_VERSION = 2;
    // Define table MonHoc
    private static final String TB_MONHOCS = "tbMonHoc";
    private static final String COL_MONHOC_ID = "monhoc_id";
    private static final String COL_MONHOC_MA = "monhoc_ma";
    private static final String COL_MONHOC_TEN = "monhoc_ten";
    private static final String COL_MONHOC_SOTIET = "monhoc_sotiet";

    public MyDatabase( Context context ){
        super(context, DB_NAME,null, DB_VERSION);
    }
    public void onCreate( SQLiteDatabase db ) {
        // Script to create table
        String scriptTBMonHocs = "CREATE TABLE " + TB_MONHOCS + "(" +
                COL_MONHOC_ID + " INTERGER PRIMARY KEY AUTOINCREMENT NOT NULL," +

                COL_MONHOC_TEN + " NVARCHAR," +
                COL_MONHOC_SOTIET + " INTEGER)";

        // Execute script.
        db.execSQL(scriptTBMonHocs);
    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_MONHOCS);
        onCreate(db);
    }

    public void getMonHocs( ArrayList<MonHoc> monHocs ) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TB_MONHOCS,
                new String[]{COL_MONHOC_MA,COL_MONHOC_TEN,COL_MONHOC_SOTIET}, null, null, null, null, null);
        if(cursor.moveToFirst()) {
            do {
                MonHoc monHoc = new MonHoc();
                monHoc.setTenMH(cursor.getString(cursor.getColumnIndex(COL_MONHOC_TEN)));
                monHoc.setSotiet(cursor.getInt(cursor.getColumnIndex(COL_MONHOC_SOTIET)));
                monHocs.add(monHoc);
            }while(cursor.moveToNext());
        }
    }

    public void saveMonHocs(MonHoc monHoc) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_MONHOC_TEN,monHoc.getTenMH());
        values.put(COL_MONHOC_SOTIET,monHoc.getSotiet());
        db.insert(TB_MONHOCS, null, values);
        db.close();
    }
}
