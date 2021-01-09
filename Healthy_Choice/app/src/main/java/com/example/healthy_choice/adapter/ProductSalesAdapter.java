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

import com.example.healthy_choice.List_Product_Sales;
import com.example.healthy_choice.R;
import com.example.healthy_choice.Update_Product_Sales;
import com.example.healthy_choice.model.FoodSales;
import com.example.healthy_choice.model.ProductSales;

import java.util.ArrayList;

public class ProductSalesAdapter extends RecyclerView.Adapter<ProductSalesAdapter.ProductSalesVH> {

    ArrayList<ProductSales> productSales;
    Context context;

    public ProductSalesAdapter(ArrayList<ProductSales> productSales ,Context context ) {
        this.productSales = productSales;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductSalesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_product_sales, parent, false);
        ProductSalesVH productSalesVH = new ProductSalesVH(view);


        return productSalesVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSalesVH holder, int position) {


        ProductSales ps = productSales.get(position);

        holder.tvDate.setText(ps.getDate());
        holder.tvProduct_name.setText(ps.getProduct_name());
        holder.tvProduct_code.setText(ps.getProduct_code());
        holder.tvQuantity_sales.setText(ps.getQuantity_sales());
        holder.tvTotal_sales.setText("Php" + " " + ps.getTotal_sales());

        holder.manage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_update_psales = new Intent(context, Update_Product_Sales.class);
                to_update_psales.putExtra("PRODUCTSALES", ps);
                context.startActivity(to_update_psales);

            }
        });

    }

    @Override
    public int getItemCount() {

        return productSales.size();
    }

    class ProductSalesVH extends RecyclerView.ViewHolder{
        TextView textViewTotal, tvDate, tvProduct_name, tvProduct_code, tvQuantity_sales, tvTotal_sales;
        Button manage_btn;

        public ProductSalesVH(@NonNull View v) {
            super(v);

            tvDate = v.findViewById(R.id.tvDate);
            tvProduct_code = v.findViewById(R.id.tv_product_code);
            tvProduct_name = v.findViewById(R.id.tv_product_name);
            tvQuantity_sales = v.findViewById(R.id.tv_quantity_sales);
            tvTotal_sales = v.findViewById(R.id.tv_total_sales);
            textViewTotal = v.findViewById(R.id.tv_total);

            manage_btn = v.findViewById(R.id.manage_information_btn);
        }



    }
}