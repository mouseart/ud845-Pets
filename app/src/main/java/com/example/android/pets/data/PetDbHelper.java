package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mouse on 2017/11/7.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pet.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " (" +
                    PetContract.PetEntry._ID + " INTEGER PRIMARY KEY," +
                    PetContract.PetEntry.COLUMN_PET_NAME + TEXT_TYPE + COMMA_SEP +
                    PetContract.PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP +
                    PetContract.PetEntry.COLUMN_PET_GENDER + INTEGER_TYPE + COMMA_SEP +
                    PetContract.PetEntry.COLUMN_PET_WEIGHT + INTEGER_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetContract.PetEntry.TABLE_NAME;


    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }
}
