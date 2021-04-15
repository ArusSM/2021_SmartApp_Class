package com.example.sm3_29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit_name, edit_phone, edit_email;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name = findViewById(R.id.edit_name);
        edit_phone = findViewById(R.id.edit_phone);
        edit_email = findViewById(R.id.edit_email);

        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == addBtn) {
            String name = edit_name.getText().toString();
            String phone = edit_phone.getText().toString();
            String email = edit_email.getText().toString();

            if(name == null || name.equals("")) {
                Toast.makeText(this, "아이디를 입력해주세요~", Toast.LENGTH_LONG).show();
            } else {
                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("insert into contactDB(name, phone, email) values(?,?,?)", new  String[]{name, phone, email});
                Toast.makeText(this, "새로운 주소록이 등록되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, mission1_result.class);
                startActivity(intent);
            }
        }
    }
}