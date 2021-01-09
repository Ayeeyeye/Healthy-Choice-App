package com.example.healthy_choice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, user;
    Button signOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        //androidx.appcompat.widget.Toolbar toolbar= findViewById(R.id._toolbar);
        //setSupportActionBar(toolbar);

        CardView cardView_sales_product = findViewById(R.id.product_sales_cardView);
        cardView_sales_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sales = new Intent(getApplicationContext(), List_Product_Sales.class);
                startActivity(sales);

            }
        });

        CardView cardView_food_sales = findViewById(R.id.food_sales_cardView);
        cardView_food_sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food_sales = new Intent(getApplicationContext(), List_Food_Sales.class);
                startActivity(food_sales);



            }
        });

        CardView cardView_drinks_sales = findViewById(R.id.drinks_sales_cardView);
        cardView_drinks_sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent drinks_sales = new Intent(getApplicationContext(), List_Drinks_Sales.class);
                startActivity(drinks_sales);

            }
        });

        user = findViewById(R.id.add_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent food_sales = new Intent(getApplicationContext(), AddUser.class);
                //startActivity(food_sales);
            }
        });

        signOut = findViewById(R.id.signOutBtn);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(logout);
                finish();
            }
        });
    }


}
