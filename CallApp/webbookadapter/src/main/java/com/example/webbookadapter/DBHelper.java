package com.example.webbookadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "webbookDB", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql = "create table tb_webbook (" +
                "_id integer primary key autoincrement," +
                "title text," +
                "date text," +
                "size text)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_webbook (title, date,size) values ('김비서가 왜 그럴까? 32','2021-05-01','0.25M')");
        db.execSQL("insert into tb_webbook (title, date,size) values ('김비서가 왜 그럴까? 32','2021-05-01','0.25M')");
        db.execSQL("insert into tb_webbook (title, date,size) values ('김비서가 왜 그럴까? 42','2021-05-11','0.25M')");
        db.execSQL("insert into tb_webbook (title, date,size) values ('김비서가 왜 그럴까? 14','2021-05-12','0.25M')");
        db.execSQL("insert into tb_webbook (title, date,size) values ('김비서가 왜 그럴까? 44','2021-05-11','0.25M')");
        db.execSQL("insert into tb_webbook (title, date,size) values ('김비서가 왜 그럴까? 46','2021-06-01','0.25M')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_webbook");
            onCreate(db);
        }

    }
}