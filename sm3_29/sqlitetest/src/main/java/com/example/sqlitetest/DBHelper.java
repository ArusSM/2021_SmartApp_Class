package com.example.sqlitetest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VER = 1;

    public DBHelper(@Nullable Context context) {
        super(context, "tb_memo", null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tb_memo(_id INTEGER PRIMARY KEY AUTOINCREMENT, title, content)";
        db.execSQL(sql);

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DB_VER) {
            String sql = "DROP TABLE tb_memo";
            db.execSQL(sql);

            onCreate(db);
        }
    }
}
