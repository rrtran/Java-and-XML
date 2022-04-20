package com.example.helloandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "candyDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CANDY = "candy";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PRICE = "price";

    public DatabaseManager(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "create table " + TABLE_CANDY + "(" + ID;
        sqlCreate += " integer primary key autoincrement, " + NAME;
        sqlCreate += " text, " + PRICE + " real)";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CANDY);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CANDY);
        onCreate(db);
    }

    public void insert(Candy candy) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + TABLE_CANDY;
        sqlInsert += " values(null, '" + candy.getName();
        sqlInsert += "', '" + candy.getPrice() + "')";
        try {
            Log.w("DatabaseManager", "Hello Insert");
            db.execSQL(sqlInsert);
        }
        catch (Exception e) {
            Log.w("DatabaseManager", e.toString());
        }
        db.close();
    }

    public void deleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlDelete = "delete from " + TABLE_CANDY;
        sqlDelete += " where " + ID + " = " + id;
        db.execSQL(sqlDelete);
        db.close();
    }

    public void updateById(int id, String name, double price) {
        SQLiteDatabase db = this.getWritableDatabase();

        // update candy set name = 'Walnut chocolate', price = '2.99' where id = 4;
        String sqlUpdate = "update " + TABLE_CANDY;
        sqlUpdate += " set " + NAME + " = '" + name + "', ";
        sqlUpdate += PRICE + " = '" + price + "'";
        sqlUpdate += " where " + ID + " = " + id;
        try {
            Log.w("DatabaseManager", "Hello");
            db.execSQL(sqlUpdate);
        }
        catch (Exception e) {
            Log.w("DatabaseManager", e.toString());
        }
        db.close();
    }

    public ArrayList<Candy> selectAll() {
        String sqlQuery = "select * from " + TABLE_CANDY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<Candy> candies = new ArrayList<Candy>();
        while (cursor.moveToNext()) {
            Candy currentCandy
                    = new Candy (Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getDouble(2));
            candies.add(currentCandy);
        }
        db.close();
        return candies;
    }

    public Candy selectById(int id) {
        String sqlQuery = "select * from " + TABLE_CANDY;
        sqlQuery += " where " + ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        Candy candy = null;
        if (cursor.moveToFirst()) {
            candy = new Candy(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getDouble(2));
        }
        return candy;
    }
}
