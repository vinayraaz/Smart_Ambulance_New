package com.smart_ambulance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.smart_ambulance.NavigationDrawerActivity;
import com.smart_ambulance.R;

/**
 * Created by admin on 02-Apr-18.
 */

public class Home_Activity extends NavigationDrawerActivity implements View.OnClickListener {
     LinearLayout Attandance,Daily_Equipment,Stock_Register,Ambulance_Book, Register4In1,Ambulance_checkList,IFT_Form,Referral_Form,DurgH1,PCR_Form;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Attandance = (LinearLayout)findViewById(R.id.attandance);
        Daily_Equipment = (LinearLayout)findViewById(R.id.daily_equipment);
        Stock_Register = (LinearLayout)findViewById(R.id.stock_register);
        Ambulance_Book = (LinearLayout)findViewById(R.id.ambulancelogobook);
        Register4In1 = (LinearLayout)findViewById(R.id.register4in1);
        Ambulance_checkList = (LinearLayout)findViewById(R.id.ambulancecheck);
        IFT_Form = (LinearLayout)findViewById(R.id.iftform);
        Referral_Form = (LinearLayout)findViewById(R.id.referralform);
        DurgH1 = (LinearLayout)findViewById(R.id.h1drug);
        PCR_Form = (LinearLayout)findViewById(R.id.pcr_form);

        Attandance.setOnClickListener(this);
        Daily_Equipment.setOnClickListener(this);
        Stock_Register.setOnClickListener(this);
        Ambulance_Book.setOnClickListener(this);
        Register4In1.setOnClickListener(this);
        Ambulance_checkList.setOnClickListener(this);
        IFT_Form.setOnClickListener(this);
        Referral_Form.setOnClickListener(this);
        DurgH1.setOnClickListener(this);
        PCR_Form.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.attandance:
                Intent i1 =  new Intent(Home_Activity.this,Attandance_Activity.class);
                i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i1);

                break;
            case R.id.daily_equipment:
                Intent i2 =  new Intent(Home_Activity.this,Equipment_Activity.class);
                i2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i2);

                break;
            case R.id.stock_register:
                Intent i3=  new Intent(Home_Activity.this,Stock_RegisterActivity.class);
                i3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i3);
                break;
            case R.id.ambulancelogobook:
                break;
            case R.id.register4in1:
                break;
            case R.id.ambulancecheck:
                Intent i6=  new Intent(Home_Activity.this,New_Ambulance_check_Activity.class);
                i6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i6);
                break;
            case R.id.iftform:
                Intent i7=  new Intent(Home_Activity.this,IFT_Form_Activity.class);
                i7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i7);
                break;
            case R.id.referralform:
                break;
            case R.id.h1drug:
                break;
            case R.id.pcr_form:
                Intent i10=  new Intent(Home_Activity.this,PCR_Form_Activity.class);
                i10.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i10);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
