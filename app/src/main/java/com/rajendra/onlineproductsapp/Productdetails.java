package com.rajendra.onlineproductsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rajendra.onlineproductsapp.adapter.CustomAdapter;

import java.util.ArrayList;

public class Productdetails extends AppCompatActivity {

    int count = 0, instock;
    TextView change;;
    ImageView addition, remove, img_string;
    Button addcart;
    Intent openSetPin;

    String range_string, type_string, qty_string, id_string, specifier_string;
    TextView range, type, qty;
    
    ImageView empty_imageview, img;
    TextView no_data;
    DBHelper myDB;
    
    String product_id;
    ArrayList<String> product_type;
    String product_specifier;
    ArrayList<String> product_ranges;
    ArrayList<String> prod_qty;
    ArrayList<Integer> prod_img;
    CustomAdapter customAdapter;
    ConstraintLayout con_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        //declare variables from view
        img = findViewById(R.id.img_src_details);
        range = findViewById(R.id.price);
        type = findViewById(R.id.product_name_details);
        qty = findViewById(R.id.available);

        //get intent of the recycler openned *clicked*
        Intent intent_CusAdapter = getIntent();
        /*
        intent.putExtra("id", String.valueOf(product_id.get(i)));
                intent.putExtra("type", String.valueOf(product_type.get(i)));
                intent.putExtra("specifier", String.valueOf(product_specifier.get(i)));
                intent.putExtra("range", String.valueOf(product_range.get(i)));
                intent.putExtra("prod_qty", String.valueOf(prod_qty.get(i)));
                intent.putExtra("prod_img", String.valueOf(prod_img.get(i)));
         */
        //get data from previous intent class
        id_string = intent_CusAdapter.getStringExtra("product_id");
        specifier_string = intent_CusAdapter.getStringExtra("product_specifier");
        qty_string = intent_CusAdapter.getStringExtra("prod_qty");
        type_string = intent_CusAdapter.getStringExtra("type");
        range_string = intent_CusAdapter.getStringExtra("range");
        img_string = intent_CusAdapter.getParcelableExtra("prod_img");

        //set images and texts from data
        try {
            type.setText("" + type_string);
            range.setText("" + range_string);
            qty.setText("In stock: "+qty_string);

            img.setImageDrawable(img_string.getDrawable());

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Could not load product details.", Toast.LENGTH_SHORT).show();
        }


        //declare buttons
        addition = findViewById(R.id.addition);
        remove = findViewById(R.id.remove);
        change = findViewById(R.id.qtychange);
        addcart = findViewById(R.id.addCart);
        //Shown description is generic

        //when user adds or removes item change number of counts shown
        instock = Integer.valueOf(qty_string);
        addition.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (count < instock ) {
                    count = count + 1;
                    change.setText("" + count);
                }
                else
                    return;
            } });

        //REMOVES
        remove.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                if (count <= 0 )
                    return;

                else
                count = count - 1;
                change.setText(""+count);
            }
        });

        //When adds to cart
        addcart.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
            instock += count - instock;


            if (count <= 0 ){
                    return;}

                //the else statement adds the count of products
                //to the cart, that will ONLY update the values in the DB
                //when the user finalises purchase at the purchase page
            else{
                    openSetPin = new Intent(Productdetails.this, MainActivity.class);

                    String countasstring = String.valueOf(count);
                    openSetPin.putExtra("items", countasstring);
                    openSetPin.putExtra("items_instock", instock);

                    startActivity(openSetPin);
                }
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
}