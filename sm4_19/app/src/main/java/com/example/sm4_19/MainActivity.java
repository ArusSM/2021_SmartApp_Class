package com.example.sm4_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView arrayView, simpleView, cursorView;
    String[] arrayDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayView = findViewById(R.id.main_list_array);
        simpleView = findViewById(R.id.main_list_simple);
        cursorView = findViewById(R.id.main_list_cursor);

        arrayView.setOnItemClickListener(this);

        

    }
}