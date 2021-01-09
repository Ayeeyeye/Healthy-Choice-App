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

import com.example.healthy_choice.adapter.FoodSalesAdapter;
import com.example.healthy_choice.db.DBHelper_Two;
import com.example.healthy_choice.model.FoodSales;

import java.util.ArrayList;
import java.util.Collections;

public class List_Food_Sales extends AppCompatActivity {

    TextView fs_tvDate, fs_tvCategory, fs_tvFoodName, fs_tvProductCode, fs_tvSize, fs_tvQuantitySales, fs_tvTotalSales;
    Button manage_button, sortBtn;
    RecyclerView fs_recyclerView;
    ArrayList<FoodSales> foodSales;
    FoodSalesAdapter foodSalesAdapter;
    DBHelper_Two dbHelper_two;
    ImageView add_button, sort_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__food__sales);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(List_Food_Sales.this,R.color.colorPrimaryDark));
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

        fs_tvDate = findViewById(R.id.tvDate_fs);
        fs_tvCategory = findViewById(R.id.tv_category_fs);
        fs_tvFoodName = findViewById(R.id.tv_food_name_fs);
        fs_tvProductCode = findViewById(R.id.tv_product_code_fs);
        fs_tvSize = findViewById(R.id.tv_fsize);
        fs_tvQuantitySales = findViewById(R.id.tv_quantity_sales_fs);
        fs_tvTotalSales = findViewById(R.id.tv_total_sales_fs);

        add_button = findViewById(R.id.img_add_btn);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _toAdd_Food_Sales = new Intent(getApplicationContext(),Add_Food_Sales.class);
                startActivity(_toAdd_Food_Sales);
            }
        });

        sort_btn  = findViewById(R.id.img_sort_btn_fs);
        sort_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] sort = getApplicationContext().getResources().getStringArray(R.array.sort_foodsales);

                AlertDialog.Builder builder = new AlertDialog.Builder(List_Food_Sales.this);

                builder.setTitle("Filter Items");
                builder.setIcon(R.drawable.ic_baseline_sort_24);

                builder.setItems(sort, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (which == 0){
                            FSalesDescending();

                        }
                        else if (which == 1){
                            FSalesAscending();
                        }

                        else if (which == 2){
                            FSalesCatAllTime();
                        }

                        else if (which == 3){
                            FSalesCatHeartFriendly();
                        }

                        else if (which == 4){
                            FSalesCatVegan();
                        }

                        else if (which == 5){
                            FSalesSizeRegularOrder();
                        }

                        else if (which == 6){
                            FSalesSizeOverload();
                        }

                        else if (which == 7){
                            FSalesSizeSpecial();
                        }

                        else if (which == 8){
                            FSalesSizeBarkada();
                        }
                    }
                });

                builder.show();
            }
        });






        fs_recyclerView = findViewById(R.id.food_sales_recyclerView);

        //declare dbhelper
        dbHelper_two = new DBHelper_Two(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        foodSales = dbHelper_two.getAllFoodSales();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void FSalesDescending(){

        foodSales = dbHelper_two.getAllFoodSalesDesc();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void FSalesAscending(){

        foodSales = dbHelper_two.getAllFoodSalesAsc();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void FSalesCatAllTime(){

        foodSales = dbHelper_two.getAllFoodSalesCatAllTime();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void FSalesCatHeartFriendly(){

        foodSales = dbHelper_two.getAllFoodSalesCatHf();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void FSalesCatVegan(){

        foodSales = dbHelper_two.getAllFoodSalesCatVegan();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void FSalesSizeRegularOrder(){

        foodSales = dbHelper_two.getAllFoodSalesSizeRegularOrder();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void FSalesSizeOverload(){

        foodSales = dbHelper_two.getAllFoodSalesSizeOverload();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void FSalesSizeSpecial(){

        foodSales = dbHelper_two.getAllFoodSalesSizeSpecial();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void FSalesSizeBarkada(){

        foodSales = dbHelper_two.getAllFoodSalesSizeBarkada();

        foodSalesAdapter = new FoodSalesAdapter(foodSales, this);
        fs_recyclerView.setAdapter(foodSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        fs_recyclerView.setLayoutManager(linearLayoutManager);


    }



}