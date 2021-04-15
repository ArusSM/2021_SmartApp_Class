package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btn1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.3799224,127.1410424"));
            startActivity(intent);
        } else if (v == btn2) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://y-y.hs.kr"));
            startActivity(intent);
        } else if (v == btn3) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:031-114"));
            startActivity(intent);
        }
    }
}