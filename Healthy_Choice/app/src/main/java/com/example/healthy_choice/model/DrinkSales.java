package com.example.healthy_choice.model;

import com.example.healthy_choice.List_Drinks_Sales;

import java.io.Serializable;
import java.util.ArrayList;

public class DrinkSales implements Serializable {

    int id;
    String date;
    String category;
    String product_code;
    String drink_name;
    String size;
    String quantity_sales;
    String total_sales;

    public DrinkSales(int id, String date, String category, String product_code, String drink_name, String size, String quantity_sales, String total_sales) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.drink_name = drink_name;
        this.product_code = product_code;
        this.size = size;
        this.quantity_sales = quantity_sales;
        this.total_sales = total_sales;
    }

    public DrinkSales(String date, String category, String product_code, String drink_name, String size, String quantity_sales, String total_sales) {
        this.date = date;
        this.category = category;
        this.drink_name = drink_name;
        this.product_code = product_code;
        this.size = size;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
