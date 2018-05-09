package com.smart_ambulance.extra;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 30-Mar-18.
 */

public class Main_SharePreferance {
    public static SharedPreferences pref;
    public static SharedPreferences prefArray;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editorArray;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared pref file name
    public static final String PREF_NAME = "ambulance_register";
    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    String f_time ="0";

    // Constructor
    public Main_SharePreferance(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
}
