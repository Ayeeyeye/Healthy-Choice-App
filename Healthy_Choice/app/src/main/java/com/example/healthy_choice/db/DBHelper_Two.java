package com.example.healthy_choice.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.healthy_choice.model.FoodSales;
import com.example.healthy_choice.model.ProductSales;

import java.util.ArrayList;

public class DBHelper_Two extends SQLiteOpenHelper {

    public DBHelper_Two(Context context) {

        super(context, "db_FoodSales.db", null,  1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tbl_foodsales(id INTEGER PRIMARY KEY AUTOINCREMENT,date VARCHAR, category VARCHAR,  product_code VARCHAR, food_name TEXT,size VARCHAR, quantity_sales VARCHAR, total_sales VARCHAR )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tbl_foodsales");
        onCreate(db);

    }

    public long addFoodSales(FoodSales fs) {
        SQLiteDatabase dd = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("date", fs.getDate());
        cv.put("category", fs.getCategory());
        cv.put("product_code", fs.getProduct_code());
        cv.put("food_name", fs.getFood_name());
        cv.put("size", fs.getSize());
        cv.put("quantity_sales",fs.getQuantity_sales());
        cv.put("total_sales", fs.getTotal_sales());

        return dd.insert("tbl_foodsales", null,cv);
    }


    public ArrayList<FoodSales> getAllFoodSales() {
        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;
    }

    public ArrayList<FoodSales> getAllFoodSalesDesc() {
        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales ORDER BY total_sales DESC", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;
    }

    public int updateFoodSales(FoodSales fs) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("date", fs.getDate());
        cv.put("category", fs.getCategory());
        cv.put("product_code", fs.getProduct_code());
        cv.put("food_name", fs.getFood_name());
        cv.put("size", fs.getSize());
        cv.put("quantity_sales",fs.getQuantity_sales());
        cv.put("total_sales", fs.getTotal_sales());

        return db.update("tbl_foodsales", cv, "id = ?", new String[]{String.valueOf(fs.getId())});
    }

    public int deleteProductSales(FoodSales fs) {

        SQLiteDatabase db = getWritableDatabase();

        return db.delete("tbl_foodsales", "id = ?", new String[] {String.valueOf(fs.getId())});
    }

    public ArrayList<FoodSales> getAllFoodSalesAsc() {

        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales ORDER BY total_sales ASC", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;


    }

    public ArrayList<FoodSales> getAllFoodSalesCatAllTime() {

        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales WHERE category LIKE 'a%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;


    }

    public ArrayList<FoodSales> getAllFoodSalesCatHf() {

        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales WHERE category LIKE 'h%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;


    }

    public ArrayList<FoodSales> getAllFoodSalesCatVegan() {

        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales WHERE category LIKE 'v%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;


    }

    public ArrayList<FoodSales> getAllFoodSalesSizeRegularOrder() {

        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales WHERE size LIKE 'r%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;



    }

    public ArrayList<FoodSales> getAllFoodSalesSizeOverload() {

        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales WHERE size LIKE 'o%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;



    }

    public ArrayList<FoodSales> getAllFoodSalesSizeSpecial() {

        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales WHERE size LIKE 's%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;

    }

    public ArrayList<FoodSales> getAllFoodSalesSizeBarkada() {

        ArrayList<FoodSales> foodSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        //String selectQuery = "SELECT * FROM tbl_foodsales ORDER BY ";

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_foodsales WHERE size LIKE 'b%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String food_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                FoodSales fs = new FoodSales(id, date, category, product_code, food_name, size, quantity_sales, total_sales);
                foodSales.add(fs);

            }while (cursor.moveToNext());
        }

        return foodSales;



    }
}
