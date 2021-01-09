package com.example.healthy_choice.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthy_choice.R;
import com.example.healthy_choice.Update_Drink_Sales;
import com.example.healthy_choice.Update_Food_Sales;
import com.example.healthy_choice.model.DrinkSales;
import com.example.healthy_choice.model.FoodSales;

import java.util.ArrayList;

public class DrinkSalesAdapter extends RecyclerView.Adapter<DrinkSalesAdapter.DrinkSalesVH> {

    ArrayList<DrinkSales> drinkSales;
    Context context;

    public DrinkSalesAdapter(ArrayList<DrinkSales> drinkSales, Context context) {
        this.drinkSales = drinkSales;
        this.context = context;
    }

    @NonNull
    @Override
    public DrinkSalesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_drink_sales, parent, false);
        DrinkSalesVH drinkSalesVH = new DrinkSalesVH(view);

        return drinkSalesVH;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkSalesVH holder, int position) {

        DrinkSales ds = drinkSales.get(position);

        holder.ds_tvDate.setText(ds.getDate());
        holder.ds_tvCategory.setText(ds.getCategory());
        holder.ds_tvDrinkName.setText(ds.getDrink_name());
        holder.ds_tvProductCode.setText(ds.getProduct_code());
        holder.ds_tvSize.setText(ds.getSize());
        holder.ds_tvQuantitySales.setText(ds.getQuantity_sales());
        holder.ds_tvTotalSales.setText("Php" + " " + ds.getTotal_sales());

        holder.manage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_update_dsales = new Intent(context, Update_Drink_Sales.class);
                to_update_dsales.putExtra("DRINKSALES", ds);
                context.startActivity(to_update_dsales);
            }
        });


    }

    @Override
    public int getItemCount() {
        return drinkSales.size();
    }

    class DrinkSalesVH extends RecyclerView.ViewHolder{

        TextView ds_tvDate, ds_tvCategory, ds_tvDrinkName, ds_tvProductCode, ds_tvSize, ds_tvQuantitySales, ds_tvTotalSales;
        Button manage_button;

        public DrinkSalesVH(@NonNull View v) {
            super(v);

            ds_tvDate = v.findViewById(R.id.tvDate_ds);
            ds_tvCategory= v.findViewById(R.id.tv_category_ds);
            ds_tvDrinkName = v.findViewById(R.id.tv_drink_name_ds);
            ds_tvProductCode = v.findViewById(R.id.tv_product_code_ds);
            ds_tvSize = v.findViewById(R.id.tv_food_size_ds);
            ds_tvQuantitySales = v.findViewById(R.id.tv_quantity_sales_ds);
            ds_tvTotalSales = v.findViewById(R.id.tv_total_sales_ds);

            manage_button = v.findViewById(R.id.ds_manage_information_btn);


        }
    }
}
