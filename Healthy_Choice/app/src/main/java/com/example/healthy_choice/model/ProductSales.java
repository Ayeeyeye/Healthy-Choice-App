package com.example.healthy_choice.model;

import java.io.Serializable;
import java.util.Comparator;

public class    ProductSales implements Serializable {

    int id;
    String date;
    String product_code;
    String product_name;
    String quantity_sales;
    String total_sales;

    public ProductSales(int id, String date, String product_code, String product_name, String quantity_sales, String total_sales) {
        this.id = id;
        this.date = date;
        this.product_code = product_code;
        this.product_name = product_name;
        this.quantity_sales = quantity_sales;
        this.total_sales = total_sales;
    }

    public ProductSales(String date, String product_code, String product_name, String quantity_sales, String total_sales) {
        this.date = date;
        this.product_code = product_code;
        this.product_name = product_name;
        this.quantity_sales = quantity_sales;
        this.total_sales = total_sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getQuantity_sales() {
        return quantity_sales;
    }

    public void setQuantity_sales(String quantity_sales) {
        this.quantity_sales = quantity_sales;
    }

    public String getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(String total_sales) {
        this.total_sales = total_sales;
    }


}
