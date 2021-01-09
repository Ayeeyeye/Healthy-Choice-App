package com.example.healthy_choice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthy_choice.db.DBHelper_Three;
import com.example.healthy_choice.model.DrinkSales;
import com.example.healthy_choice.model.FoodSales;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class Update_Drink_Sales extends AppCompatActivity {

    EditText _etDate, _etProductCode, _etDrinkName, _etQuantitySales, _etTotalSales;
    MaterialSpinner select_category, select_size, select_extra;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__drink__sales);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(Update_Drink_Sales.this,R.color.colorPrimaryDark));
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

        DrinkSales ds  = (DrinkSales) getIntent().getExtras().getSerializable("DRINKSALES");

        id = ds.getId();
        _etDate = findViewById(R.id.drinks_sales_etDate);
        _etProductCode = findViewById(R.id.drinks_sales_etProductCode);
        _etDrinkName = findViewById(R.id.drinks_sales_etFoodName);
        _etQuantitySales = findViewById(R.id.drinks_sales_etQuantitySales);
        _etTotalSales = findViewById(R.id.drinks_sales_etTotalSales);

        select_category = findViewById(R.id.ds_select_category);
        select_category.setItems("Select Category","Guilt-Free (Milktea)", "Hot Drinks", "Non-Dairy", "Banana Smoothies", "Fresh & Pure Detox Juices", "Heart-Warming");

        select_size = findViewById(R.id.ds_select_size);
        select_size.setItems("Select Size","Grande", "Venti", "Regular Size");

        _etDate.setText(ds.getDate());
        _etProductCode.setText(ds.getProduct_code());
        select_category.setText(ds.getCategory());
        _etDrinkName.setText(ds.getDrink_name());
        select_size.setText(ds.getSize());
        _etQuantitySales.setText(ds.getQuantity_sales());
        _etTotalSales.setText(ds.getTotal_sales());



    }

    public void Update(View view) {

        String date = _etDate.getText().toString().trim();
        String product_code = _etProductCode.getText().toString().trim();
        String drink_name = _etDrinkName.getText().toString().trim();
        String quantity_sales = _etQuantitySales.getText().toString().trim();
        String total_sales = _etTotalSales.getText().toString().trim();
        String _size = select_size.getText().toString().trim();
        String _category = select_category.getText().toString().trim();

        DBHelper_Three dbHelper_three = new DBHelper_Three(Update_Drink_Sales.this);
        DrinkSales ds = new DrinkSales (id, date, _category, product_code, drink_name,_size, quantity_sales, total_sales );

        long result = dbHelper_three.updateDrinkSales(ds);

        if ( result > 0){
            Toast.makeText(this, "Drink Sales Updated!", Toast.LENGTH_LONG).show();
            Intent go_to_list = new Intent(getApplicationContext(),List_Drinks_Sales.class);
            startActivity(go_to_list);
            finish();

        }
        else {
            Toast.makeText(this, "Drink Sales Update Failed!", Toast.LENGTH_LONG).show();

        }




    }

    public void Delete(View view) {

        String date = _etDate.getText().toString().trim();
        String product_code = _etProductCode.getText().toString().trim();
        String drink_name = _etDrinkName.getText().toString().trim();
        String quantity_sales = _etQuantitySales.getText().toString().trim();
        String total_sales = _etTotalSales.getText().toString().trim();
        String _size = select_size.getText().toString().trim();
        String _category = select_category.getText().toString().trim();

        DBHelper_Three dbHelper_three = new DBHelper_Three(Update_Drink_Sales.this);
        DrinkSales ds = new DrinkSales (id, date, _category, product_code, drink_name,_size, quantity_sales, total_sales );

        AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);

        builder.setTitle("Confirm!");
        builder.setMessage("Are you sure you want to delete this item?");
        builder.setIcon(R.drawable.ic_baseline_notification_important_24);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelper_Three dbHelperThree = new DBHelper_Three(Update_Drink_Sales.this);

                int result  = dbHelperThree.deleteProductSales(ds);

                if ( result > 0){
                    Toast.makeText(Update_Drink_Sales.this, "One item deleted!", Toast.LENGTH_LONG).show();
                    Intent go_to_list = new Intent(getApplicationContext(), List_Drinks_Sales.class);
                    startActivity(go_to_list);
                    finish();

                }
                else {
                    Toast.makeText(Update_Drink_Sales.this, "Deletion Failed!", Toast.LENGTH_LONG).show();

                }
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();

    }


}