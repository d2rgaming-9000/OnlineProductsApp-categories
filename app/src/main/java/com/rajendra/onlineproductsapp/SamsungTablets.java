package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SamsungTablets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung_tablets);


        TextView btn = findViewById(R.id.SamsungProduct1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SamsungTablets.this, HuaweiProducts.class));
            }
        });

        TextView btn2 = findViewById(R.id.AppleProduct1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SamsungTablets.this, AppleProducts.class));
            }
        });

        TextView btn3 = findViewById(R.id.OtherProduct1);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SamsungTablets.this, OtherProducts.class));
            }
        });

        Button button1 = (Button)findViewById(R.id.MainBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SamsungTablets.this, MainActivity.class);
                finish();
                startActivity(i);
            }
        });
    }
}