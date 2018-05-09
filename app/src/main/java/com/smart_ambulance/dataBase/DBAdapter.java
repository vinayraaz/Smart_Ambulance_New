package com.smart_ambulance.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by admin on 13-Apr-18.
 */

public class DBAdapter {

    private static final String TAG = "DBAdapter";
    private static final String DATABASE_NAME = "MyDB";
    private static final String DATABASE_TABLE = "stock_medical_register";
    private static final String DATABASE_TABLE_DISPOSABLE = "stock_disposable";

    public static final String KEY_ROWID = "_id";
    public static final String KEY_Meterial_id = "meterial_id";
    public static final String KEY_Meterial_desc = "meterial_desc";
    public static final String KEY_Open_qty = "open_qty";
    public static final String KEY_Open_date = "open_date";
    public static final String KEY_Rec_qty_date = "rec_qty_date ";
    public static final String KEY_Rec_good_qty = "rec_good_qty";
    public static final String KEY_Rec_damage_qty = "rec_damage_qty ";
    public static final String KEY_Total_aval_qty = "total_aval_qty";
    public static final String KEY_Total_cons_qty = "total_cons_qty";
    public static final String KEY_Close_qty = "close_qty";
    public static final String KEY_Close_Date = "close_date";

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_CREATE =
            "create table stock_medical_register(_id integer primary key autoincrement," +
                    " meterial_id text not null, meterial_desc text not null, open_qty text not null, open_date text not null," +
                    "rec_qty_date text not null,rec_good_qty text not null, rec_damage_qty text not null, total_aval_qty text not null," +
                    "total_cons_qty text not null, close_qty text not null,close_date text not null); ";

    private static final String DATABASE_CREATE_DISPOSABLE =
            "create table stock_disposable(_id integer primary key autoincrement," +
                    " meterial_id text not null, meterial_desc text not null, open_qty text not null, open_date text not null," +
                    "rec_qty_date text not null,rec_good_qty text not null, rec_damage_qty text not null, total_aval_qty text not null," +
                    "total_cons_qty text not null, close_qty text not null,close_date text not null);";


    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
                db.execSQL(DATABASE_CREATE_DISPOSABLE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS stock_medical_register");
            db.execSQL("DROP TABLE IF EXISTS stock_disposable");
            onCreate(db);
        }
    }

    //---opens the database---
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close() {
        DBHelper.close();
    }

    /*INSERT TABLE*/

    //---insert a contact into the database for stock register---
    public long insertContact(String meterial_id, String meterial_desc, String open_qty, String open_date, String rec_qty_date, String rec_good_qty
            , String rec_damage_qty, String total_aval_qty, String total_cons_qty, String close_qty, String close_date) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_Meterial_id, meterial_id);
        initialValues.put(KEY_Meterial_desc, meterial_desc);
        initialValues.put(KEY_Open_qty, open_qty);
        initialValues.put(KEY_Open_date, open_date);
        initialValues.put(KEY_Rec_qty_date, rec_qty_date);
        initialValues.put(KEY_Rec_good_qty, rec_good_qty);
        initialValues.put(KEY_Rec_damage_qty, rec_damage_qty);
        initialValues.put(KEY_Total_aval_qty, total_aval_qty);
        initialValues.put(KEY_Total_cons_qty, total_cons_qty);
        initialValues.put(KEY_Close_qty, close_qty);
        initialValues.put(KEY_Close_Date, close_date);
        System.out.println("DATA Insert Successfully******");
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---insert a contact into the database for stock disposable---
    public long insertDisposableTable(String meterial_id, String meterial_desc, String open_qty, String open_date, String rec_qty_date, String rec_good_qty
            , String rec_damage_qty, String total_aval_qty, String total_cons_qty, String close_qty, String close_date) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_Meterial_id, meterial_id);
        initialValues.put(KEY_Meterial_desc, meterial_desc);
        initialValues.put(KEY_Open_qty, open_qty);
        initialValues.put(KEY_Open_date, open_date);
        initialValues.put(KEY_Rec_qty_date, rec_qty_date);
        initialValues.put(KEY_Rec_good_qty, rec_good_qty);
        initialValues.put(KEY_Rec_damage_qty, rec_damage_qty);
        initialValues.put(KEY_Total_aval_qty, total_aval_qty);
        initialValues.put(KEY_Total_cons_qty, total_cons_qty);
        initialValues.put(KEY_Close_qty, close_qty);
        initialValues.put(KEY_Close_Date, close_date);
        System.out.println("DATA Insert Successfully******");
        return db.insert(DATABASE_TABLE_DISPOSABLE, null, initialValues);
    }

    //---deletes a particular contact---
    public boolean deleteContact(long rowId) {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }
    public boolean deleteContactDisposable(long rowId) {
        return db.delete(DATABASE_TABLE_DISPOSABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }
    //-----------deletes alss row----------
    public int deleteAllRecords() {
        return db.delete(DATABASE_TABLE, null, null);
    }
    public int deleteAllRecordsDisposable() {
        return db.delete(DATABASE_TABLE_DISPOSABLE, null, null);
    }
    //---retrieves all the contacts---
    public Cursor getAllContacts() {
        return db.query(DATABASE_TABLE, new String[]{KEY_ROWID, KEY_Meterial_id, KEY_Meterial_desc, KEY_Open_qty, KEY_Open_date, KEY_Rec_qty_date, KEY_Rec_good_qty,
                        KEY_Rec_damage_qty, KEY_Total_aval_qty, KEY_Total_cons_qty, KEY_Close_qty, KEY_Close_Date},
                null, null, null, null, null);
    }

    public Cursor getAllContactsDisposable() {
        return db.query(DATABASE_TABLE_DISPOSABLE, new String[]{KEY_ROWID, KEY_Meterial_id, KEY_Meterial_desc, KEY_Open_qty, KEY_Open_date, KEY_Rec_qty_date, KEY_Rec_good_qty,
                        KEY_Rec_damage_qty, KEY_Total_aval_qty, KEY_Total_cons_qty, KEY_Close_qty, KEY_Close_Date},
                null, null, null, null, null);
    }

    //---retrieves a particular contact---
    public Cursor getContact(long rowId) throws SQLException {
        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[]{KEY_ROWID, KEY_Meterial_id, KEY_Meterial_desc, KEY_Open_qty, KEY_Open_date, KEY_Rec_qty_date, KEY_Rec_good_qty,
                        KEY_Rec_damage_qty, KEY_Total_aval_qty, KEY_Total_cons_qty, KEY_Close_qty, KEY_Close_Date}, KEY_ROWID + "=" + rowId, null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getContactDisposable(long rowId) throws SQLException {
        Cursor mCursor = db.query(true, DATABASE_TABLE_DISPOSABLE, new String[]{KEY_ROWID, KEY_Meterial_id, KEY_Meterial_desc, KEY_Open_qty, KEY_Open_date, KEY_Rec_qty_date, KEY_Rec_good_qty,
                        KEY_Rec_damage_qty, KEY_Total_aval_qty, KEY_Total_cons_qty, KEY_Close_qty, KEY_Close_Date}, KEY_ROWID + "=" + rowId, null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a contact---
    public boolean updateContact(long rowId, String meterial_id, String meterial_desc, String open_qty, String open_date, String rec_qty_date, String rec_good_qty
            , String rec_damage_qty, String total_aval_qty, String total_cons_qty, String close_qty, String close_date) {
        ContentValues args = new ContentValues();
        args.put(KEY_Meterial_id, meterial_id);
        args.put(KEY_Meterial_desc, meterial_desc);
        args.put(KEY_Open_qty, open_qty);
        args.put(KEY_Open_date, open_date);
        args.put(KEY_Rec_qty_date, rec_qty_date);
        args.put(KEY_Rec_good_qty, rec_good_qty);
        args.put(KEY_Rec_damage_qty, rec_damage_qty);
        args.put(KEY_Total_aval_qty, total_aval_qty);
        args.put(KEY_Total_cons_qty, total_cons_qty);
        args.put(KEY_Close_qty, close_qty);
        args.put(KEY_Close_Date, close_date);
        System.out.println("Update Success fully");
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }

    public boolean updateContactDisposable(long rowId, String meterial_id, String meterial_desc, String open_qty, String open_date, String rec_qty_date, String rec_good_qty
            , String rec_damage_qty, String total_aval_qty, String total_cons_qty, String close_qty, String close_date) {
        ContentValues args = new ContentValues();
        args.put(KEY_Meterial_id, meterial_id);
        args.put(KEY_Meterial_desc, meterial_desc);
        args.put(KEY_Open_qty, open_qty);
        args.put(KEY_Open_date, open_date);
        args.put(KEY_Rec_qty_date, rec_qty_date);
        args.put(KEY_Rec_good_qty, rec_good_qty);
        args.put(KEY_Rec_damage_qty, rec_damage_qty);
        args.put(KEY_Total_aval_qty, total_aval_qty);
        args.put(KEY_Total_cons_qty, total_cons_qty);
        args.put(KEY_Close_qty, close_qty);
        args.put(KEY_Close_Date, close_date);
        System.out.println("Update Success fully");
        return db.update(DATABASE_TABLE_DISPOSABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }

    public Cursor CheckTable() {
        String count = "SELECT count(*) FROM stock_medical_register";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) {
            System.out.println("HAve Data********"+icount);
        }
//leave
        else {
            System.out.println("No Data**********"+icount);
        }
//populate table
        return mcursor;
    }
    public Cursor CheckDisposableTable() {
        String count = "SELECT count(*) FROM stock_disposable";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) {
            System.out.println("HAve Data********"+icount);
        }
//leave
        else {
            System.out.println("No Data**********"+icount);
        }
//populate table
        return mcursor;
    }
}
