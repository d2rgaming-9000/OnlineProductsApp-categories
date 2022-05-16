package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SamsungProducts extends AppCompatActivity {

    android.widget.ImageButton ImageButton9;
    ImageButton ImageButton10;
    ImageButton ImageButton11;
    ImageButton ImageButton12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung_products);

        TextView btn = findViewById(R.id.SamsungProduct1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SamsungProducts.this, HuaweiProducts.class));
            }
        });

        TextView btn2 = findViewById(R.id.AppleProduct1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SamsungProducts.this, AppleProducts.class));
            }
        });

        TextView btn3 = findViewById(R.id.OtherProduct1);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SamsungProducts.this, OtherProducts.class));
            }
        });

        Button button1 = (Button)findViewById(R.id.MainBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SamsungProducts.this, MainActivity.class);
                finish();
                startActivity(i);
            }
        });

        ImageButton9 = (ImageButton) findViewById(R.id.imageButton9);

        ImageButton9.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent AppleIphone = new  Intent(SamsungProducts.this, SamsungPhone.class);
                startActivity(AppleIphone);
            }


        });

        ImageButton10 = (ImageButton) findViewById(R.id.imageButton10);

        ImageButton10.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent AppleMacBook = new  Intent(SamsungProducts.this, SamsungTV.class);
                startActivity(AppleMacBook);
            }


        });

        ImageButton11 = (ImageButton) findViewById(R.id.imageButton11);

        ImageButton11.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent AppleWatch = new  Intent(SamsungProducts.this, SamsungWatches.class);
                startActivity(AppleWatch);
            }


        });

        ImageButton12 = (ImageButton) findViewById(R.id.imageButton12);

        ImageButton12.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent AppleOther = new  Intent(SamsungProducts.this, SamsungTablets.class);
                startActivity(AppleOther);
            }


        });
    }
}