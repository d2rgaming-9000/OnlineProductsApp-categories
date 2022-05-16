package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class AppleProducts extends AppCompatActivity {
     ImageButton ImageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple_products);

        TextView btn = findViewById(R.id.SamsungProduct1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AppleProducts.this, SamsungProducts.class));
            }
        });

        TextView btn2 = findViewById(R.id.AppleProduct1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AppleProducts.this, HuaweiProducts.class));
            }
        });

        TextView btn3 = findViewById(R.id.OtherProduct1);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AppleProducts.this, OtherProducts.class));
            }
        });

        Button button1 = (Button)findViewById(R.id.MainBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(AppleProducts.this, MainActivity.class);
                finish();
                startActivity(i);
            }
        });

        ImageButton3 = (ImageButton) findViewById(R.id.imageButton3);

                ImageButton3.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View v) {
                        Intent AppleIphone = new  Intent(AppleProducts.this, AppleIphone.class);
                        startActivity(AppleIphone);
                    }


                });

                ImageButton3 = (ImageButton) findViewById(R.id.imageButton4);

                ImageButton3.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View v) {
                        Intent AppleMacBook = new  Intent(AppleProducts.this, AppleMacbook.class);
                        startActivity(AppleMacBook);
                    }


                });

                ImageButton3 = (ImageButton) findViewById(R.id.imageButton5);

                ImageButton3.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View v) {
                        Intent AppleWatch = new  Intent(AppleProducts.this, AppleWatch.class);
                startActivity(AppleWatch);
            }


        });

        ImageButton3 = (ImageButton) findViewById(R.id.imageButton6);

        ImageButton3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent AppleOther = new  Intent(AppleProducts.this, AppleOther.class);
                startActivity(AppleOther);
            }


        });

















    }

    }
