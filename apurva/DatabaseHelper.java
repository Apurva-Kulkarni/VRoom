package com.example.apurva26.keep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Apurva26 on 13-11-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_UNAME = "USERNAME";
    private static final String COLUMN_GENDER = "GENDER";
    private static final String COLUMN_AGE = "AGE";
    private static final String COLUMN_PASS = "PASSWORD";
    private static final String COLUMN_SURNAME = "SURNAME";

    SQLiteDatabase db ;
    private static final String TABLE_CREATE = "create table contacts(id integer primary key not null , age integer not null "+"name text not null , uname text not null , gender text not null , pass text not null ; ";

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }


    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_AGE,c.getAge());
        values.put(COLUMN_SURNAME, c.getSurname());
        values.put(COLUMN_PASS,c.getPass());
        values.put(COLUMN_GENDER,c.getGender());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname , pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "Not Found !";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return  b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
