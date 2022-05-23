package com.rajendra.onlineproductsapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlineproductsapp.Productdetails;
import com.rajendra.onlineproductsapp.R;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Intent setValue;
    private Context context;
    private Activity activity;
    private ArrayList product_id, product_type, product_specifier, product_range, prod_qty;
    private ArrayList _img_src;
    ImageView img1;

    public CustomAdapter(Activity activity, Context context, ArrayList product_id,
                         ArrayList product_type, ArrayList product_specifier,
                         ArrayList product_range, ArrayList prod_qty, ArrayList _img_src){
        this.activity = activity;
        this.context = context;
        this.product_id = product_id;
        this.product_type = product_type;
        this.product_specifier = product_specifier;
        this.product_range = product_range;
        this.prod_qty = prod_qty;
        this._img_src = _img_src;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {
        holder.product_id_txt.setText(String.valueOf(product_id.get(i)));
        holder.product_type_txt.setText(String.valueOf(product_type.get(i)));
        holder.product_specifier_txt.setText(String.valueOf(product_specifier.get(i)));
        holder.product_range_txt.setText(String.valueOf(product_range.get(i)));
        holder.product_qty_txt.setText(String.valueOf(prod_qty.get(i)));

        //call a try method to catch if no images are found
        try {

            //inserting images
            if (i == 0)
            {
                holder.product_img_src.setImageResource(R.drawable.prod);
            }

            if (i == 1)
            {
                holder.product_img_src.setImageResource(R.drawable.prod1);
                img1.getDrawable();
            }
            if (i == 2)
            {
                holder.product_img_src.setImageResource(R.drawable.prod2);
            }
            if (i == 3)
            {
                holder.product_img_src.setImageResource(R.drawable.prod3);
            }

            if (i == 4)
            {
                holder.product_img_src.setImageResource(R.drawable.prod4);
            }
            if (i == 5)
            {
                holder.product_img_src.setImageResource(R.drawable.prod5);
            }

            if (i == 6)
            {
                holder.product_img_src.setImageResource(R.drawable.prod6);
            }
            if (i == 7)
            {
                holder.product_img_src.setImageResource(R.drawable.prod7);
            }
            if (i == 8)
            {
                holder.product_img_src.setImageResource(R.drawable.prod8);
            }
            if (i == 9)
            {
                holder.product_img_src.setImageResource(R.drawable.prod9);
            }
            if (i == 10)
            {
                holder.product_img_src.setImageResource(R.drawable.prod10);
            }
            if (i == 11)
            {
                holder.product_img_src.setImageResource(R.drawable.prod11);
            }
            if (i == 12)
            {
                holder.product_img_src.setImageResource(R.drawable.prod12);
            }
            if (i == 13)
            {
                holder.product_img_src.setImageResource(R.drawable.prod13);
            }
            if (i == 14)
            {
                holder.product_img_src.setImageResource(R.drawable.prod14);
            }
            if (i == 15)
            {
                holder.product_img_src.setImageResource(R.drawable.prod15);
            }
            if (i == 16)
            {
                holder.product_img_src.setImageResource(R.drawable.prod16);
                img1.getDrawable();
            }

        //catch if no images are found, app does not crash
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Unable to load images.", Toast.LENGTH_SHORT).show();
        }

        //Recyclerview onClickListenerة
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setValue = new Intent(activity, Productdetails.class);

                setValue.putExtra("id", String.valueOf(product_id.get(i)));
                setValue.putExtra("type", String.valueOf(product_type.get(i)));
                setValue.putExtra("specifier", String.valueOf(product_specifier.get(i)));
                setValue.putExtra("range", String.valueOf(product_range.get(i)));
                setValue.putExtra("prod_qty", String.valueOf(prod_qty.get(i)));
                try {
                    img1.getDrawable();
                    setValue.putExtra("prod_img", (Parcelable) img1.getDrawable());
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

                activity.startActivityForResult(setValue, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return product_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_img_src;
        TextView product_id_txt, product_type_txt, product_specifier_txt, product_range_txt, product_qty_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            product_id_txt = itemView.findViewById(R.id.product_id_txt);
            product_type_txt = itemView.findViewById(R.id.product_type_txt);
            product_specifier_txt = itemView.findViewById(R.id.product_specifier_txt);
            product_range_txt = itemView.findViewById(R.id.product_ranges_txt);
            product_qty_txt = itemView.findViewById(R.id.product_qty_txt);
            product_img_src = itemView.findViewById(R.id.product_img_src);


            mainLayout = itemView.findViewById(R.id.mainLayout);
             //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}