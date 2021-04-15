package com.example.sm3_29;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class mission1_result extends AppCompatActivity {
    TextView nameView, phoneView, emailView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission1_result);

        nameView = findViewById(R.id.label_name);
        phoneView = findViewById(R.id.label_phone);
        emailView = findViewById(R.id.label_email);


        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select name, phone, email from contactDB order by _id desc limit 1", null);

        while(cursor.moveToNext()) {
            nameView.setText("Name : " + cursor.getString(0));
            phoneView.setText("Phone : " + cursor.getString(1));
            emailView.setText("Email : " + cursor.getString(2));
        }   
    db.close();
    }
}