package com.example.sm30120;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button toastBtn, dialBtn, webBtn, calBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastBtn = findViewById(R.id.toastBtn);
        dialBtn = findViewById(R.id.dialBtn);
        webBtn = findViewById(R.id.webBtn);
        calBtn = findViewById(R.id.calBtn);


        toastBtn.setOnClickListener(this);
        dialBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        calBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == toastBtn) {
            Toast.makeText(this, "스앱수행평가입니다", Toast.LENGTH_SHORT).show();
        } else if (v == dialBtn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("알림");
            builder.setMessage("정말 종료하시겠습니까?");
            builder.setIcon(R.drawable.ic_baseline_warning);
            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setNegativeButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        } else if(v == webBtn) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.y-y.hs.kr")); startActivity(intent);
            startActivity(intent);
        } else if (v == calBtn) {
            Intent intent = new Intent(getApplicationContext(), calPage.class);
            startActivity(intent);
        }
    }
}