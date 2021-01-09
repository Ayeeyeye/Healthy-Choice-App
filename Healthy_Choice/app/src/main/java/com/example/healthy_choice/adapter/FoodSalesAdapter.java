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
import com.example.healthy_choice.Update_Food_Sales;
import com.example.healthy_choice.Update_Product_Sales;
import com.example.healthy_choice.model.FoodSales;
import com.example.healthy_choice.model.ProductSales;

import java.util.ArrayList;

public class FoodSalesAdapter extends RecyclerView.Adapter<FoodSalesAdapter.FoodSalesVH> {

    ArrayList<FoodSales> foodSales;
    Context context;


    public FoodSalesAdapter(ArrayList<FoodSales> foodSales, Context context) {
        this.foodSales = foodSales;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodSalesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_food_sales, parent, false);
        FoodSalesVH foodSalesVH = new FoodSalesVH(view);


        return foodSalesVH;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodSalesVH holder, int position) {

        FoodSales fs = foodSales.get(position);

        holder.fs_tvDate.setText(fs.getDate());
        holder.fs_tvCategory.setText(fs.getCategory());
        holder.fs_tvProductCode.setText(fs.getProduct_code());
        holder.fs_tvFoodName.setText(fs.getFood_name());
        holder.fs_tvSize.setText(fs.getSize());
        holder.fs_tvQuantitySales.setText(fs.getQuantity_sales());
        holder.fs_tvTotalSales.setText("Php" + " " + fs.getTotal_sales());

        holder.manage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_update_fsales = new Intent(context, Update_Food_Sales.class);
                to_update_fsales.putExtra("FOODSALES", fs);
                context.startActivity(to_update_fsales);
            }
        });


    }

    @Override
    public int getItemCount() {
        return foodSales.size();
    }

    class FoodSalesVH extends RecyclerView.ViewHolder{

       TextView fs_tvDate, fs_tvCategory, fs_tvFoodName, fs_tvProductCode, fs_tvSize, fs_tvQuantitySales, fs_tvTotalSales;
       Button manage_button;

       public FoodSalesVH(@NonNull View v) {
           super(v);

           fs_tvDate = v.findViewById(R.id.tvDate_fs);
           fs_tvCategory = v.findViewById(R.id.tv_category_fs);
           fs_tvFoodName = v.findViewById(R.id.tv_food_name_fs);
           fs_tvProductCode = v.findViewById(R.id.tv_product_code_fs);
           fs_tvSize = v.findViewById(R.id.tv_food_size);
           fs_tvQuantitySales = v.findViewById(R.id.tv_quantity_sales_fs);
           fs_tvTotalSales = v.findViewById(R.id.tv_total_sales_fs);

           manage_button = v.findViewById(R.id.fs_manage_information_btn);
       }
   }
}
