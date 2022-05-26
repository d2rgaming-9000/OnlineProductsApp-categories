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

    int count = 0, instock, var;
    TextView change;;
    ImageView addition, remove;
    Button addcart;
    Intent openSetPin;
    int in_cart;
    Intent intent_Cart = getIntent();

    String range_string;
    String type_string;
    String qty_string;
    String id_string;
    String specifier_string;
    int img_string, img_as_int;
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

        //get data from previous intent class
        id_string = intent_CusAdapter.getStringExtra("product_id");
        specifier_string = intent_CusAdapter.getStringExtra("product_specifier");
        qty_string = intent_CusAdapter.getStringExtra("prod_qty");
        type_string = intent_CusAdapter.getStringExtra("type");
        range_string = intent_CusAdapter.getStringExtra("range");
        img_string = intent_CusAdapter.getIntExtra("prod_img", img_as_int);

        img_as_int = Integer.valueOf(img_string);
        //set images and texts from data, but check for data avlbility and not crash app if no data
        try {
            type.setText("" + type_string);
            range.setText("" + range_string);
            qty.setText("In stock: "+qty_string);

            //check for image availablity and not crash app
            try {
                if (img_as_int == 0) {
                    img.setImageResource(R.drawable.prod);
                }
                if (img_as_int == 1) {
                    img.setImageResource(R.drawable.prod1);
                }
                if (img_as_int == 2) {
                    img.setImageResource(R.drawable.prod2);
                }
                if (img_as_int == 3) {
                    img.setImageResource(R.drawable.prod3);
                }
                if (img_as_int == 4) {
                    img.setImageResource(R.drawable.prod4);
                }
                if (img_as_int == 5) {
                    img.setImageResource(R.drawable.prod5);
                }
                if (img_as_int == 6) {
                    img.setImageResource(R.drawable.prod6);
                }
                if (img_as_int == 7) {
                    img.setImageResource(R.drawable.prod7);
                }
                if (img_as_int == 8) {
                    img.setImageResource(R.drawable.prod8);
                }
                if (img_as_int == 9) {
                    img.setImageResource(R.drawable.prod9);
                }
                if (img_as_int == 10) {
                    img.setImageResource(R.drawable.prod10);
                }
                if (img_as_int == 11) {
                    img.setImageResource(R.drawable.prod11);
                }
                if (img_as_int == 12) {
                    img.setImageResource(R.drawable.prod12);
                }
                if (img_as_int == 13) {
                    img.setImageResource(R.drawable.prod13);
                }
                if (img_as_int == 14) {
                    img.setImageResource(R.drawable.prod14);
                }
                if (img_as_int == 15) {
                    img.setImageResource(R.drawable.prod15);
                }
                if (img_as_int == 16) {
                    img.setImageResource(R.drawable.prod16);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Could not load product details.", Toast.LENGTH_SHORT).show();
        }
        try {
            in_cart = intent_Cart.getIntExtra("items_incart", var);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Toast.makeText(Productdetails.this, "in cart: " + in_cart, Toast.LENGTH_SHORT).show();



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


                //stored items in cart (from main) passed to .this class
                if(in_cart != 0) {
                    count += in_cart;
                }
                Toast.makeText(Productdetails.this, "" + in_cart + count, Toast.LENGTH_SHORT).show();


                if (in_cart != 0)
                {
                    Toast.makeText(Productdetails.this, "" + count, Toast.LENGTH_SHORT).show();
                }

                instock += count - instock;

            if (count <= 0 ){
                    return;}
                //the else statement adds the count of products
                //to the cart, that will ONLY update the values in the DB
                //when the user finalises purchase at the purchase page
            else{
                    openSetPin = new Intent(Productdetails.this, MainActivity.class);

                    String countasstring = String.valueOf(count) + in_cart;

                        openSetPin.putExtra("items", count);
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