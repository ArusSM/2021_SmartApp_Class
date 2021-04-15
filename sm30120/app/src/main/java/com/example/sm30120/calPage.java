package com.example.sm30120;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calPage extends AppCompatActivity implements View.OnClickListener {
    EditText num1, num2;
    Button plus, minus, multiply, division;
    int n1, n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_page);
        n1 = 0;
        n2 = 0;
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        division.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( v == plus) {
            n1 = Integer.parseInt(String.valueOf(num1.getText()));
            n2 = Integer.parseInt(String.valueOf(num2.getText()));
            Toast.makeText(this, "결과는 "+ (n1 + n2) + " 입니다.", Toast.LENGTH_SHORT).show();
        } else if (v == minus) {
            n1 = Integer.parseInt(String.valueOf(num1.getText()));
            n2 = Integer.parseInt(String.valueOf(num2.getText()));
            Toast.makeText(this, "결과는 " + (n1 - n2) + " 입니다.", Toast.LENGTH_SHORT).show();
        } else if (v == multiply) {
            n1 = Integer.parseInt(String.valueOf(num1.getText()));
            n2 = Integer.parseInt(String.valueOf(num2.getText()));
            Toast.makeText(this, "결과는 " + (n1 * n2) + " 입니다.", Toast.LENGTH_SHORT).show();
        } else if (v == division) {
            n1 = Integer.parseInt(String.valueOf(num1.getText()));
            n2 = Integer.parseInt(String.valueOf(num2.getText()));
            Toast.makeText(this, "결과는 " + (n1 / n2) + " 입니다.", Toast.LENGTH_SHORT).show();
        }
    }
}