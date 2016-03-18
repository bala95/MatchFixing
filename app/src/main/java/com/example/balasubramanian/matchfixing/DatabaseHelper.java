package com.example.balasubramanian.matchfixing;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Logins.db";
    public static final String TABLE_NAME = "login_tables";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "PHONE";
    public static final String COL_5 = "EMAIL";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (NAME TEXT,USERNAME TEXT PRIMARY KEY,PASSWORD TEXT,PHONE INTEGER,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String username,String password,String phone,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,username);
        contentValues.put(COL_3,password);
        contentValues.put(COL_4, phone);
        contentValues.put(COL_5, email);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
public Cursor getAllData()
{
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor res = db.rawQuery("select * from "+ TABLE_NAME,null);
    return res;
}

public boolean updateData(String id,String name,String surname,String marks,String email)
{
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(COL_1,id);
    contentValues.put(COL_2,name);
    contentValues.put(COL_3,surname);
    contentValues.put(COL_4, marks);
    contentValues.put(COL_5, email);
    db.update(TABLE_NAME,contentValues,"USERNAME = ?",new String[]{id});
    return true;
}

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME,"USERNAME = ?",new String[]{id});

    }
}

