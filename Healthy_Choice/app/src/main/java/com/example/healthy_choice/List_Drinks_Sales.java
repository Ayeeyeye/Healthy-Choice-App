package com.example.healthy_choice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthy_choice.adapter.DrinkSalesAdapter;
import com.example.healthy_choice.adapter.FoodSalesAdapter;
import com.example.healthy_choice.db.DBHelper_Three;
import com.example.healthy_choice.model.DrinkSales;
import com.example.healthy_choice.model.FoodSales;

import java.util.ArrayList;

public class List_Drinks_Sales extends AppCompatActivity {


    TextView ds_tvDate, ds_tvCategory, ds_tvDrinkName, ds_tvProductCode, ds_tvSize, ds_tvQuantitySales, ds_tvTotalSales;
    Button manage_button;
    ImageView add_button, sort_btn;
    RecyclerView ds_recyclerView;
    ArrayList<DrinkSales> drinkSales;
    DrinkSalesAdapter drinkSalesAdapter;
    DBHelper_Three dbHelper_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__drinks__sales);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(List_Drinks_Sales.this,R.color.colorPrimaryDark));
        }


        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1D8348"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ds_tvDate = findViewById(R.id.tvDate_ds);
        ds_tvCategory= findViewById(R.id.tv_category_ds);
        ds_tvDrinkName = findViewById(R.id.tv_drink_name_ds);
        ds_tvProductCode = findViewById(R.id.tv_product_code_ds);
        ds_tvSize = findViewById(R.id.tv_food_size_ds);
        ds_tvQuantitySales = findViewById(R.id.tv_quantity_sales_ds);
        ds_tvTotalSales = findViewById(R.id.tv_total_sales_ds);

        manage_button = findViewById(R.id.ds_manage_information_btn);

        add_button = findViewById(R.id.img_add_btn);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_add_drinks_sale = new Intent(getApplicationContext(), Add_Drinks_Sale.class);
                startActivity(to_add_drinks_sale);
            }
        });

        ds_recyclerView = findViewById(R.id.drinks_sales_recyclerView);

        dbHelper_three = new DBHelper_Three(this);

        sort_btn = findViewById(R.id.img_sort_btn_ds);
        sort_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] sort = getApplicationContext().getResources().getStringArray(R.array.sort_drinksales);

                AlertDialog.Builder builder = new AlertDialog.Builder(List_Drinks_Sales.this);

                builder.setTitle("Filter Items");
                builder.setIcon(R.drawable.ic_baseline_sort_24);

                builder.setItems(sort, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (which == 0){
                            DSalesDescending();

                        }
                        else if (which == 1){
                            DSalesAscending();
                        }

                        else if (which == 2){
                            DSalesCatGuiltFree();
                        }

                        else if (which == 3){
                            DSalesCatHotDrinks();
                        }

                        else if (which == 4){
                            DSalesCatNonDairy();
                        }

                        else if (which == 5){
                            DSalesCatBananaSmoothies();
                        }

                        else if (which == 6){
                            DSalesCatFreshAndPure();
                        }

                        else if (which == 7){
                            DSalesSizeGrande();
                        }

                        else if (which == 8){
                            DSalesSizeVenti();
                        }

                        else if (which == 9){
                            DSalesSizeRegular();
                        }

                    }
                });

                builder.show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        drinkSales = dbHelper_three.getAllDrinkSales();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void DSalesDescending(){

        drinkSales = dbHelper_three.getAllDrinkSalesDesc();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void DSalesAscending(){

        drinkSales = dbHelper_three.getAllDrinkSalesAsc();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void DSalesCatGuiltFree(){

        drinkSales = dbHelper_three.getAllDrinkSalesGuiltFree();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void DSalesCatHotDrinks(){

        drinkSales = dbHelper_three.getAllDrinkSalesCatHotDrinks();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void DSalesCatNonDairy(){

        drinkSales = dbHelper_three.getAllDrinkSalesCatNonDairy();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void DSalesCatBananaSmoothies(){

        drinkSales = dbHelper_three.getAllDrinkSalesBananaSmoothies();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void DSalesCatFreshAndPure(){

        drinkSales = dbHelper_three.getAllDrinkSalesFreshAndPure();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void DSalesSizeGrande(){

        drinkSales = dbHelper_three.getAllDrinkSalesSizeGrande();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void DSalesSizeVenti(){

        drinkSales = dbHelper_three.getAllDrinkSalesSizeVenti();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }


    public void DSalesSizeRegular(){

        drinkSales = dbHelper_three.getAllDrinkSalesSizeRegular();
        drinkSalesAdapter =  new DrinkSalesAdapter(drinkSales, this);

        ds_recyclerView.setAdapter(drinkSalesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ds_recyclerView.setLayoutManager(linearLayoutManager);



    }


}