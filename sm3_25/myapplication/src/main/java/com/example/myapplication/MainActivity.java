package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button loginBtn;
    EditText id, password;
    String idValue, passwordValue;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);

        intent = new Intent(this, OtherActivity.class);
        loginBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        id = findViewById(R.id.id);
        password = findViewById(R.id.password);

        idValue = id.getText().toString();
        passwordValue  = password.getText().toString();
        if(idValue.equals("admin") && passwordValue.equals("1234")) {
            Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(this, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
