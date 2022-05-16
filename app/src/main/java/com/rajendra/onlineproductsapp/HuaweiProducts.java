package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HuaweiProducts extends AppCompatActivity {
    ImageButton ImageButton;
    ImageButton ImageButton2;
    ImageButton ImageButton7;
    ImageButton ImageButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huawei_products);

        TextView btn = findViewById(R.id.SamsungProduct1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HuaweiProducts.this, SamsungProducts.class));
            }
        });

        TextView btn2 = findViewById(R.id.AppleProduct1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HuaweiProducts.this, AppleProducts.class));
            }
        });

        TextView btn3 = findViewById(R.id.OtherProduct1);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HuaweiProducts.this, OtherProducts.class));
            }
        });

        Button button1 = (Button)findViewById(R.id.MainBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HuaweiProducts.this, MainActivity.class);
                finish();
                startActivity(i);
            }
        });

        ImageButton = (ImageButton) findViewById(R.id.imageButton);

        ImageButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent HuaweiPhone = new  Intent(HuaweiProducts.this, HuaweiPhone.class);
                startActivity(HuaweiPhone);
            }


        });

        ImageButton2 = (ImageButton) findViewById(R.id.imageButton2);

        ImageButton2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent HuaweiLaptop = new  Intent(HuaweiProducts.this, HuaweiLaptop.class);
                startActivity(HuaweiLaptop);
            }


        });

        ImageButton7 = (ImageButton) findViewById(R.id.imageButton7);

        ImageButton7.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent HuaweiWatch = new  Intent(HuaweiProducts.this, HuaweiWatch.class);
                startActivity(HuaweiWatch);
            }


        });

        ImageButton8 = (ImageButton) findViewById(R.id.imageButton8);

        ImageButton8.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent HuaweiTablet = new  Intent(HuaweiProducts.this, HuaweiTablet.class);
                startActivity(HuaweiTablet);
            }


        });


    }
}