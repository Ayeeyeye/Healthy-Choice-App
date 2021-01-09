package com.example.healthy_choice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthy_choice.db.DBHelper_Two;
import com.example.healthy_choice.model.FoodSales;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class Add_Food_Sales extends AppCompatActivity {

    EditText date_, productCode_, foodName_, quantitySales_, totalSales_;
    MaterialSpinner category, size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__food__sales);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(Add_Food_Sales.this,R.color.colorPrimaryDark));
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

        date_ = findViewById(R.id.food_sales_etDate);
        productCode_ = findViewById(R.id.food_sales_etProductCode);
        foodName_ = findViewById(R.id.food_sales_etFoodName);
        quantitySales_ = findViewById(R.id.food_sales_etQuantitySales);
        totalSales_ = findViewById(R.id.food_sales_etTotalSales);

        size = findViewById(R.id.select_size);
        size.setItems("Select Size","Regular", "Overload", "Special", "Solo", "Barkada", "Family Supreme", "Regular Plate Meal");

        category = findViewById(R.id.select_category);
        category.setItems("Select Category","All-Time Favorite Snacks", "All-Time Healthy Breakfast", "Hearty", "Healthy", "Heart-Friendly", "Vegan A La Carte");

    }

    public void Save(View view) {

        String date = date_.getText().toString().trim();
        String product_code = productCode_.getText().toString().trim();
        String food_name = foodName_.getText().toString().trim();
        String quantity_sales = quantitySales_.getText().toString().trim();
        String total_sales = totalSales_.getText().toString().trim();
        String size_ = size.getText().toString().trim();
        String category_ = category.getText().toString().trim();

        DBHelper_Two dbHelper_two = new DBHelper_Two(Add_Food_Sales.this);
        FoodSales fs = new FoodSales(date, category_, product_code, food_name, size_, quantity_sales, total_sales );
        long result = dbHelper_two.addFoodSales(fs);

        if ( result > 0){
            Toast.makeText(this, "Food Sales Created!", Toast.LENGTH_LONG).show();
            Intent go_to_list = new Intent(getApplicationContext(),List_Food_Sales.class);
            startActivity(go_to_list);
            finish();

        }
        else {
            Toast.makeText(this, "Food Sales Creation Failed!", Toast.LENGTH_LONG).show();

        }


    }


}