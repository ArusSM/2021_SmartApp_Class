package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class resultPage extends AppCompatActivity {
    TextView titleV, contentV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);


        titleV = findViewById(R.id.titleV);
        contentV = findViewById(R.id.contentV);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select title, content from tb_memo order by _id desc limit 1", null);

        while(cursor.moveToNext()) {
            titleV.setText("title : " + cursor.getString(0));
            contentV.setText("content : " + cursor.getString(1));
        }
        db.close();

    }
    }