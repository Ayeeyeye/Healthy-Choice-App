package com.example.healthy_choice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthy_choice.adapter.FoodSalesAdapter;
import com.example.healthy_choice.adapter.ProductSalesAdapter;
import com.example.healthy_choice.model.ProductSales;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class List_Product_Sales extends AppCompatActivity {

    TextView textViewTotal, tvDate, tvProduct_name, tvProduct_code, tvQuantity_sales, tvTotal_sales;
    Button manage_btn;
    ImageView add_button, sort_button;
    RecyclerView recyclerView;
    ProductSalesAdapter productSalesAdapter;
    private DBHelper dbHelper;
    ActionBar actionBar;
    ArrayList<ProductSales> productSales;
    int selectedItem;



    //String orderByNewest = db


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__product__sales);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(List_Product_Sales.this,R.color.colorPrimaryDark));
        }



        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Product Sales");

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1D8348"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewTotal = findViewById(R.id.tv_total);
        tvDate = findViewById(R.id.tvDate);
        tvProduct_name = findViewById(R.id.tv_product_name);
        tvProduct_code = findViewById(R.id.tv_product_code);
        tvQuantity_sales = findViewById(R.id.tv_quantity_sales);
        tvTotal_sales = findViewById(R.id.tv_total_sales);

        add_button = findViewById(R.id.img_add_btn);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _toAdd_Product_Sales = new Intent(getApplicationContext(),Add_Product_Sales.class);
                startActivity(_toAdd_Product_Sales);
                finish();
            }
        });

        sort_button = findViewById(R.id.img_sort_btn);
        sort_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String [] sort = getApplicationContext().getResources().getStringArray(R.array.sort);

                AlertDialog.Builder builder = new AlertDialog.Builder(List_Product_Sales.this);

                builder.setTitle("Sort Items");
                builder.setIcon(R.drawable.ic_baseline_sort_24);

                builder.setItems(sort, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (which == 0){
                            PSalesAscending();

                        }
                        else if (which == 1){
                            PSalesDescending();
                        }


                    }
                });

                builder.show();

            }
        });

        recyclerView = findViewById(R.id.product_sales_recyclerView);



        //textViewTotal.setText("Total Items: " + productSales.size());

        dbHelper = new DBHelper(this);

    }


    @Override
    protected void onStart() {
        super.onStart();

        productSales = dbHelper.getAllProductSales();

        productSalesAdapter = new ProductSalesAdapter(productSales, this);
        recyclerView.setAdapter(productSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void PSalesAscending(){

        productSales = dbHelper.getAllProductSalesAsc();

        productSalesAdapter = new ProductSalesAdapter(productSales, this);
        recyclerView.setAdapter(productSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void PSalesDescending(){

        productSales = dbHelper.getAllProductSalesDesc();

        productSalesAdapter = new ProductSalesAdapter(productSales, this);
        recyclerView.setAdapter(productSalesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}