package com.example.healthy_choice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.healthy_choice.model.FoodSales;
import com.example.healthy_choice.model.ProductSales;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {

        super(context," db_ProductSales.db",null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_productsales(id INTEGER PRIMARY KEY AUTOINCREMENT,date VARCHAR, product_code VARCHAR, product_name TEXT, quantity_sales VARCHAR, total_sales VARCHAR )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS tbl_productsales ");

        onCreate(db);
    }



    public long addProductSales(ProductSales ps) {

        SQLiteDatabase dd = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("date",ps.getDate());
        cv.put("product_code", ps.getProduct_code());
        cv.put("product_name", ps.getProduct_name());
        cv.put("quantity_sales", ps.getQuantity_sales());
        cv.put("total_sales", ps.getTotal_sales());

        return dd.insert("tbl_productsales", null, cv);
    }

    public ArrayList<ProductSales> getAllProductSales(){

        ArrayList<ProductSales> productSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_productsales ", null);


         if (cursor.moveToFirst()){

             do {
                 int id  = cursor.getInt(0);
                 String date = cursor.getString(1);
                 String product_code = cursor.getString(2);
                 String food_name = cursor.getString(3);
                 String quantity_sales = cursor.getString(4);
                 String total_sales = cursor.getString(5);

                 ProductSales ps = new ProductSales(id, date, product_code, food_name, quantity_sales, total_sales);
                 productSales.add(ps);

             }while (cursor.moveToNext());
         }
        return productSales;

    }

    public ArrayList<ProductSales> getAllProductSalesDesc(){

        ArrayList<ProductSales> productSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_productsales ORDER BY total_sales DESC ", null);


        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String product_code = cursor.getString(2);
                String food_name = cursor.getString(3);
                String quantity_sales = cursor.getString(4);
                String total_sales = cursor.getString(5);

                ProductSales ps = new ProductSales(id, date, product_code, food_name, quantity_sales, total_sales);
                productSales.add(ps);

            }while (cursor.moveToNext());
        }
        return productSales;

    }

    public ArrayList<ProductSales> getAllProductSalesAsc(){

        ArrayList<ProductSales> productSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_productsales ORDER BY total_sales ASC ", null);


        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String product_code = cursor.getString(2);
                String food_name = cursor.getString(3);
                String quantity_sales = cursor.getString(4);
                String total_sales = cursor.getString(5);

                ProductSales ps = new ProductSales(id, date, product_code, food_name, quantity_sales, total_sales);
                productSales.add(ps);

            }while (cursor.moveToNext());
        }
        return productSales;

    }
    public int updateProductSales(ProductSales ps) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("date", ps.getDate());
        cv.put("product_code",ps.getProduct_code());
        cv.put("product_name", ps.getProduct_name());
        cv.put("quantity_sales",ps.getQuantity_sales());
        cv.put("total_sales", ps.getTotal_sales());

        return db.update("tbl_productsales", cv, "id = ?" , new String[]{String.valueOf(ps.getId())});
    }



    public int deleteProductSales(ProductSales ps) {
        SQLiteDatabase db = getWritableDatabase();

        return db.delete("tbl_productsales", "id = ?", new String[] {String.valueOf(ps.getId())});
    }





}
