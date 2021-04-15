package com.example.sm3_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button alarm1, alarm2, alarm3, alarm4, alarm5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarm1 = findViewById(R.id.alarm1);
        alarm2 = findViewById(R.id.alarm2);
        alarm3 = findViewById(R.id.alarm3);
        alarm4 = findViewById(R.id.alarm4);
        alarm5 = findViewById(R.id.alarm5);

        alarm1.setOnClickListener(this);
        alarm2.setOnClickListener(this);
        alarm3.setOnClickListener(this);
        alarm4.setOnClickListener(this);
        alarm5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.alarm1) {
            Toast.makeText(this, "토스트입니다", Toast.LENGTH_SHORT).show();
        } else if(v.getId() == R.id.alarm2) {
            Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_SHORT).show();
        } else if(v.getId() == R.id.alarm3) {
            Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_SHORT).setAction("닫기", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            }).setActionTextColor(Color.RED).show();
        } else if(v.getId() == R.id.alarm4) {
            new AlertDialog.Builder(this)
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle("Dialog")
                    .setMessage("메시지를 보여줍니다!!")
                    .setNeutralButton("닫기", null)
                    .setPositiveButton("네", null)
                    .setNegativeButton("아니오",null)
                    .show();
        } else {
            new AlertDialog.Builder(this)
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle("Dialog")
                    .setMessage("메시지를 보여줍니다!!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "다이얼로그를 닫습니다.", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }
    }
}
