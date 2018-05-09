package com.smart_ambulance.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import com.smart_ambulance.R;
import com.smart_ambulance.extra.Main_SharePreferance;


/**
 * Created by admin on 30-Mar-18.
 */

public class Ambulance_Register extends AppCompatActivity implements View.OnClickListener {
    EditText ambulance_id,ambulance_city,ambulance_location,ambulance_dist;
    AppCompatButton Ambulance_Register;
    Main_SharePreferance main_sharePreferance;
    SharedPreferences.Editor editor;
    String amu_id,amu_city,amu_loc,amu_dist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ambulance_register);
        main_sharePreferance = new Main_SharePreferance(this);


        ambulance_id = (EditText) findViewById(R.id.input_amb_id);
        ambulance_city = (EditText) findViewById(R.id.input_amb_city);
        ambulance_location = (EditText) findViewById(R.id.input_amb_location);
        ambulance_dist = (EditText) findViewById(R.id.input_amb_dist);
        Ambulance_Register = (AppCompatButton) findViewById(R.id.btn_signup);

        Ambulance_Register.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        amu_id  = ambulance_id.getText().toString();
        amu_city  = ambulance_city.getText().toString();
        amu_loc  = ambulance_location.getText().toString();
        amu_dist  = ambulance_dist.getText().toString();
        editor = getSharedPreferences("ambulance_register", MODE_PRIVATE).edit();
        editor.putString("AMBULANCE_ID",amu_id);
        editor.putString("AMBULANCE_CITY",amu_city);
        editor.putString("AMBULANCE_LOC",amu_loc);
        editor.putString("AMBULANCE_DIST",amu_dist);
        editor.commit();

        Intent equpiment_intent = new Intent(Ambulance_Register.this,Home_Activity.class);
        startActivity(equpiment_intent);

    }
}
