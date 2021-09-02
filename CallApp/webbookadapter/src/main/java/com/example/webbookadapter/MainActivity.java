package com.example.webbookadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button btnAdd;
    ArrayList<WebBookVO> datas;
    WebBookAdapter adapter;

    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_list);
        datas = new ArrayList<>();

        helper = new DBHelper(this);
        db=helper.getWritableDatabase();
        cursor = db.rawQuery("select _id, title, date, size from tb_webbook", null);

        while(cursor.moveToNext()){
            WebBookVO vo = new WebBookVO();
            vo.id = cursor.getInt(0);
            vo.title = cursor.getString(1);
            vo.date = cursor.getString(2);
            vo.size = cursor.getString(3);
            datas.add(vo);
        }
        db.close();

        adapter = new WebBookAdapter(this, R.layout.main_list_item, datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), book_setting_page.class);
                startActivity(intent);
            }
        });
    }
}