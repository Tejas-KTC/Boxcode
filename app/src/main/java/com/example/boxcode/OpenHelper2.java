package com.example.boxcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OpenHelper2 extends SQLiteOpenHelper {
    private static final String DB_NAME = "taskdb1";
    private static final int DB_VERSION = 1;
    public static final String DB_TABLE_NAME2 ="mytask1";
    public static final String ID_COL = "id";
    private static final String NAME_COL = "taskname";
    private static final String DES_COL = "taskdes";
    private static final String STARTTIME_COL ="starttime";
    private static final String ENDTIME_COL ="endtime";
    public OpenHelper2(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DB_TABLE_NAME2
                + " (" + ID_COL + " INTEGER PRIMARY KEY ,"
                + NAME_COL + " TEXT,"
                + DES_COL + " TEXT,"
                + STARTTIME_COL + " TEXT,"
                + ENDTIME_COL + " TEXT)";
        db.execSQL(query);
    }

    public void addNewCourse(String coursename, String coursedes, String starttime, String endtime){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL,coursename);
        values.put(DES_COL,coursedes);
        values.put(STARTTIME_COL,starttime);
        values.put(ENDTIME_COL,endtime);

        db.insert(DB_TABLE_NAME2,null,values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_NAME2);
        onCreate(db);
    }
}
