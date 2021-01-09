package com.example.healthy_choice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthy_choice.model.ProductSales;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Update_Product_Sales extends AppCompatActivity {

    EditText _date, _productCode, _productName, _quantitySales, _totalSales;
    Button update_btn, delete_btn;
    int id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__product__sales);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(Update_Product_Sales.this,R.color.colorPrimaryDark));
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

        ProductSales ps  = (ProductSales) getIntent().getExtras().getSerializable("PRODUCTSALES");

        id = ps.getId();
        _date = findViewById(R.id.et_date);
        _productCode = findViewById(R.id.et_productCode);
        _productName = findViewById(R.id.et_productName);
        _quantitySales = findViewById(R.id.et_quantitySales);
        _totalSales = findViewById(R.id.et_totalSales);

        update_btn = findViewById(R.id.update_btn);
        delete_btn = findViewById(R.id.delete_btn);

        _date.setText(ps.getDate());
        _productCode.setText(ps.getProduct_code());
        _productName.setText(ps.getProduct_name());
        _quantitySales.setText(ps.getQuantity_sales());
        _totalSales.setText(ps.getTotal_sales());


    }

    public void Update(View view) {

        String date = _date.getText().toString().trim();
        String product_code = _productCode.getText().toString().trim();
        String product_name = _productName.getText().toString().trim();
        String quantity_sales = _quantitySales.getText().toString().trim();
        String total_sales = _totalSales.getText().toString().trim();

        ProductSales ps  = new ProductSales(id, date, product_code, product_name, quantity_sales,total_sales);

        DBHelper dbHelper = new DBHelper(this);
        int result = dbHelper.updateProductSales(ps);

        if ( result > 0){
            Toast.makeText(this, "Product Sales Updated!", Toast.LENGTH_LONG).show();
            Intent go_to_list = new Intent(getApplicationContext(), List_Product_Sales.class);
            startActivity(go_to_list);
            finish();

        }
        else {
            Toast.makeText(this, "Product Sales Update Failed!", Toast.LENGTH_LONG).show();

        }


    }


    public void Delete(View view) {

        String date = _date.getText().toString().trim();
        String product_code = _productCode.getText().toString().trim();
        String product_name = _productName.getText().toString().trim();
        String quantity_sales = _quantitySales.getText().toString().trim();
        String total_sales = _totalSales.getText().toString().trim();

        ProductSales ps  = new ProductSales(id, date, product_code, product_name, quantity_sales, total_sales);
        AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);

        builder.setTitle("Confirm!");
        builder.setMessage("Are you sure you want to delete this item?");
        builder.setIcon(R.drawable.ic_baseline_notification_important_24);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelper dbHelper = new DBHelper(Update_Product_Sales.this);

                int result  = dbHelper.deleteProductSales(ps);

                if ( result > 0){
                    Toast.makeText(Update_Product_Sales.this, "One item deleted!", Toast.LENGTH_LONG).show();
                    Intent go_to_list = new Intent(getApplicationContext(), List_Product_Sales.class);
                    startActivity(go_to_list);
                    finish();

                }
                else {
                    Toast.makeText(Update_Product_Sales.this, "Deletion Failed!", Toast.LENGTH_LONG).show();

                }
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }


}