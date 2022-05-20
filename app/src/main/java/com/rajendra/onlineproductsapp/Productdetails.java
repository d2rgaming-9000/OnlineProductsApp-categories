package com.rajendra.onlineproductsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajendra.onlineproductsapp.adapter.CustomAdapter;
import com.rajendra.onlineproductsapp.adapter.ProductDetailAdapter;

import java.util.ArrayList;

public class Productdetails extends AppCompatActivity {

    int count = 0;
    TextView change;;
    ImageView addition;
    ImageView remove;
    Button addcart;
    Intent openSetPin;

    ImageView empty_imageview;
    TextView no_data;
    DBHelper myDB;

    ArrayList<String> product_id;
    ArrayList<String> product_type;
    ArrayList<String> product_specifier;
    ArrayList<String> product_ranges;
    ArrayList<String> prod_qty;
    ArrayList<Integer> prod_img;
    CustomAdapter customAdapter;

    ConstraintLayout con_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);

        addition = findViewById(R.id.addition);
        remove = findViewById(R.id.remove);
        change = findViewById(R.id.qtychange);
        addcart = findViewById(R.id.addCart);

        con_layout = findViewById(R.id.con_layout);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

        myDB = new DBHelper(Productdetails.this);
        product_id = new ArrayList<>();
        product_type = new ArrayList<>();
        product_specifier = new ArrayList<>();
        product_ranges = new ArrayList<>();
        prod_img = new ArrayList<Integer>();

        //storeDataInArrays();

        customAdapter = new CustomAdapter(Productdetails.this,this,
                product_id, product_type,
                product_specifier, product_ranges, prod_qty, prod_img);
        //Shown image is equivalant to the ID of the image in the DB

        // Values of price and quantity shown equivalant to product ID in DB

        //Shown description is generic
        // (manually it would be assosciated to each product ID in the DB)


        //when user adds or removes item change number of counts shown
        addition.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                count = count +1;
                    change.setText(""+count);
            } });

        //REMOVES
        remove.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                if (count <= 0 ) count = 0;

                else
                count = count - 1;
                change.setText(""+count);
            }
        });

        //When adds to cart
        addcart.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                if (count <= 0 )
                    return;

                //the else statement adds the count of products
                //to the cart, that will ONLY update the values in the DB
                //when the user finalises purchase at the purchase page
            else
                openSetPin = new Intent(Productdetails.this, checkout.class);
                openSetPin = new Intent(Productdetails.this, MainActivity.class);

                String countasstring = String.valueOf(count);
                openSetPin.putExtra("items", countasstring);
                startActivity(openSetPin);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    //stores data in arrays
    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                product_id.add(cursor.getString(0));
                product_type.add(cursor.getString(1));
                product_specifier.add(cursor.getString(2));
                product_ranges.add(cursor.getString(3));
//                prod_qty.add(cursor.getString(4));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }
}