package com.example.healthy_choice.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.healthy_choice.model.DrinkSales;
import com.example.healthy_choice.model.FoodSales;

import java.util.ArrayList;

public class DBHelper_Three extends SQLiteOpenHelper {

    public DBHelper_Three(Context context) {

        super(context, "db_DrinkSales.db", null,  1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tbl_drinksales(id INTEGER PRIMARY KEY AUTOINCREMENT,date VARCHAR, category VARCHAR,  product_code VARCHAR, drink_name TEXT,size VARCHAR, quantity_sales VARCHAR, total_sales VARCHAR )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tbl_drinksales");
        onCreate(db);

    }

    public long addDrinkSales(DrinkSales ds) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("date", ds.getDate());
        cv.put("category", ds.getCategory());
        cv.put("drink_name", ds.getDrink_name());
        cv.put("product_code", ds.getProduct_code());
        cv.put("size", ds.getSize());
        cv.put("quantity_sales", ds.getQuantity_sales());
        cv.put("total_sales", ds.getTotal_sales());
        cv.put("quantity_sales", ds.getQuantity_sales());

        return db.insert("tbl_drinksales", null,cv);

    }


    public ArrayList<DrinkSales> getAllDrinkSales() {
        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;
    }

    public long updateDrinkSales(DrinkSales ds) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("date", ds.getDate());
        cv.put("category", ds.getCategory());
        cv.put("drink_name", ds.getDrink_name());
        cv.put("product_code", ds.getProduct_code());
        cv.put("size", ds.getSize());
        cv.put("quantity_sales", ds.getQuantity_sales());
        cv.put("total_sales", ds.getTotal_sales());
        cv.put("quantity_sales", ds.getQuantity_sales());

        return db.update("tbl_drinksales",cv,"id = ?", new String[]{String.valueOf(ds.getId())});

    }

    public int deleteProductSales(DrinkSales ds) {

        SQLiteDatabase db = getWritableDatabase();

        return db.delete("tbl_drinksales","id = ?", new String[]{String.valueOf(ds.getId())});
    }

    public ArrayList<DrinkSales> getAllDrinkSalesDesc() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales ORDER BY total_sales DESC ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;


    }

    public ArrayList<DrinkSales> getAllDrinkSalesAsc() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales ORDER BY total_sales ASC ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;



    }

    public ArrayList<DrinkSales> getAllDrinkSalesGuiltFree() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales WHERE category LIKE 'g%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;


    }

    public ArrayList<DrinkSales> getAllDrinkSalesCatHotDrinks() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales WHERE category LIKE 'h%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;


    }

    public ArrayList<DrinkSales> getAllDrinkSalesCatNonDairy() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales WHERE category LIKE 'n%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;



    }

    public ArrayList<DrinkSales> getAllDrinkSalesBananaSmoothies() {
        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales WHERE category LIKE 'b%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;


    }

    public ArrayList<DrinkSales> getAllDrinkSalesFreshAndPure() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales WHERE category LIKE 'f%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;


    }

    public ArrayList<DrinkSales> getAllDrinkSalesSizeGrande() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales WHERE size LIKE 'g%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;



    }

    public ArrayList<DrinkSales> getAllDrinkSalesSizeVenti() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales WHERE size LIKE 'v%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;


    }

    public ArrayList<DrinkSales> getAllDrinkSalesSizeRegular() {

        ArrayList<DrinkSales> drinkSales = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM tbl_drinksales WHERE size LIKE 'r%' ", null);

        if (cursor.moveToFirst()){

            do {
                int id  = cursor.getInt(0);
                String date = cursor.getString(1);
                String category = cursor.getString(2);
                String product_code = cursor.getString(3);
                String drink_name = cursor.getString(4);
                String size = cursor.getString(5);
                String quantity_sales = cursor.getString(6);
                String total_sales = cursor.getString(7);

                DrinkSales ds = new DrinkSales (id, date, category, product_code, drink_name, size, quantity_sales, total_sales);
                drinkSales.add(ds);

            }while (cursor.moveToNext());
        }

        return drinkSales;


    }
}
