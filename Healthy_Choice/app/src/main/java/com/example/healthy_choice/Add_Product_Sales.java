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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthy_choice.db.DBHelper_Two;
import com.example.healthy_choice.model.FoodSales;
import com.example.healthy_choice.model.ProductSales;

import static java.lang.Integer.parseInt;

public class Add_Product_Sales extends AppCompatActivity {

    EditText _date, _productCode, _productName, _quantitySales, _totalSales;
    Button _saveButton;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__product__sales);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(Add_Product_Sales.this,R.color.colorPrimaryDark));
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

        _date = findViewById(R.id.et_date);
        _productCode = findViewById(R.id.et_productCode);
        _productName = findViewById(R.id.et_productName);
        _quantitySales = findViewById(R.id.et_quantitySales);
        _totalSales = findViewById(R.id.et_totalSales);

        _saveButton = findViewById(R.id.save_btn);
        dbHelper = new DBHelper(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void Save(View view) {

        String date = _date.getText().toString().trim();
        String product_code = _productCode.getText().toString().trim();
        String product_name = _productName.getText().toString().trim();
        String quantity_sales = _quantitySales.getText().toString().trim();
        String total_sales = _totalSales.getText().toString().trim();


        DBHelper dbHelper = new DBHelper(Add_Product_Sales.this);
        ProductSales ps = new ProductSales(date,product_code, product_name, quantity_sales, total_sales );
        long result = dbHelper.addProductSales(ps);

        if ( result > 0){
            Toast.makeText(this, "Product Sales Created!", Toast.LENGTH_LONG).show();
            Intent go_to_list = new Intent(getApplicationContext(),List_Product_Sales.class);
            startActivity(go_to_list);
            finish();

        }
        else {
            Toast.makeText(this, "Product Sales Creation Failed!", Toast.LENGTH_LONG).show();

        }
    }
}