package com.lozano.lozano.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lozano.lozano.Model.AutoModel;

/**
 * Created by ariso on 13/05/2017.
 */

public class LozanoDatabaseHelper extends SQLiteOpenHelper{
    public static final String  DB_NAME = "mydb.db";
    public static final Integer DB_VERSION = 1;

    public LozanoDatabaseHelper (Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    private final StringBuffer SQL_CREATE_TABLE_AUTO = new StringBuffer()
            .append("CREATE TABLE IF NOT EXISTS "+ AutoModel.TABLE_NAME + "(")
            .append(AutoModel.ID_FIELD + " INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(AutoModel.MARCA_FIELD + " TEXT, ")
            .append(AutoModel.PLACA_FIELD + " TEXT ")
            .append(" )");

    private final StringBuffer SQL_DELETE_TABLE_AUTO = new StringBuffer()
            .append("DROP TABLE IF EXIST " + AutoModel.TABLE_NAME);


    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_TABLE_AUTO.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_AUTO.toString());
        onCreate(db);

    }
}
