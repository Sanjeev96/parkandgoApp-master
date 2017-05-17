package com.dhillon.parkandgo.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.dhillon.parkandgo.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "ParkGoDB.db";

    // Table names
    private static final String TABLE_USER = "user";





    // user table columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
   private static final String COLUMN_USER_CARDNUM = "card_num";
   private static final String COLUMN_USER_EXPIRYDATE = "expiry_date";
   private static final String COLUMN_USER_SECURITYCODE = "security_code";



    // create table user sql query
    private String CREATE_USER_TABLE = "CREATE TABLE "
            + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT"
            + COLUMN_USER_CARDNUM + " TEXT"
            + COLUMN_USER_EXPIRYDATE + " TEXT"
            + COLUMN_USER_SECURITYCODE + " TEXT"
            + ")";

            //+ COLUMN_PAYDEATILS_ID + " INTEGER,"
            //+ " FOREIGN KEY ("+COLUMN_PAYDEATILS_ID+") REFERENCES "+TABLE_PAYDETAILS+"("+COLUMN_PAYDEATILS_ID+"));";







    // drop user table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;




     // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creates tables
            db.execSQL(CREATE_USER_TABLE);

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drops Table if they exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }


    //  This method is to create user record


    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_CARDNUM, user.getCardnum());
        values.put(COLUMN_USER_EXPIRYDATE, user.getExpirydate());
        values.put(COLUMN_USER_SECURITYCODE, user.getSecuritycode());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }





     //Checks Email against ID

    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition

         //Here query function is used to fetch records from user table this function works like we use sql query.
        //SQL query equivalent to this query function is
        //SELECT user_id FROM user WHERE user_email = '...@..com';

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    //Checks email and password match to User_ID
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
