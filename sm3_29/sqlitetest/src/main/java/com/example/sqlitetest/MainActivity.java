package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText title, content;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String titleV = title.getText().toString();
        String contentV = content.getText().toString();
     /*   if(titleV.equals("") || titleV.isEmpty() || titleV == null) {

            } else {*/
                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("insert into tb_memo(title, content) values(?, ?)", new String[]{titleV, contentV});
                db.close();
                Toast.makeText(this, "메모가 등록되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, resultPage.class);
                startActivity(intent);
            }
    }
//}