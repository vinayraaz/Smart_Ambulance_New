package com.smart_ambulance.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.smart_ambulance.R;

import java.util.Random;

/**
 * Created by admin on 17-Apr-18.
 */

public class PCR_Form_Activity extends AppCompatActivity implements View.OnClickListener {
    View Toolbar_custom;
    ImageView Back_Button;
    TextView Next,previous;
    LinearLayout First_linear,Second_linear;
    Spinner Spinner_sex,Spinner_Social_Status,Spinner_vehicle,Spinner_Area;
    TextView Past_Illness,History_Medication;
    TextView PCR_Form_No;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pcr_form_layout);
        Toolbar_custom = findViewById(R.id.toolbar_id);
        Back_Button = (ImageView) Toolbar_custom.findViewById(R.id.back_image);
        Back_Button.setOnClickListener(this);
        PCR_Form_No=(TextView)findViewById(R.id.pcr_form_no);
        Next=(TextView)findViewById(R.id.tv_next);
        previous=(TextView)findViewById(R.id.tv_previous);
        First_linear=(LinearLayout)findViewById(R.id.first_page);
        Second_linear=(LinearLayout)findViewById(R.id.second_page);
        Spinner_sex=(Spinner)findViewById(R.id.spinner1);
        Spinner_Social_Status=(Spinner)findViewById(R.id.spinner2);
        Spinner_vehicle=(Spinner)findViewById(R.id.spinner3);
        Spinner_Area=(Spinner)findViewById(R.id.spinner4);
        Past_Illness=(TextView) findViewById(R.id.past_illness);
        History_Medication=(TextView) findViewById(R.id.history_of_medication);

        Next.setOnClickListener(this);
        previous.setOnClickListener(this);
        Past_Illness.setOnClickListener(this);
        History_Medication.setOnClickListener(this);
        ArrayAdapter<CharSequence> adapter_sex = ArrayAdapter.createFromResource(this, R.array.select_sex, android.R.layout.simple_spinner_item);
        adapter_sex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_sex.setAdapter(adapter_sex);

        ArrayAdapter<CharSequence> adapter_social_status = ArrayAdapter.createFromResource(this, R.array.select_socal_staus, android.R.layout.simple_spinner_item);
        adapter_social_status.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Social_Status.setAdapter(adapter_social_status);

        ArrayAdapter<CharSequence> adapter_vehicle = ArrayAdapter.createFromResource(this, R.array.vehicle_type, android.R.layout.simple_spinner_item);
        adapter_vehicle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_vehicle.setAdapter(adapter_vehicle);

        ArrayAdapter<CharSequence> adapter_area= ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_spinner_item);
        adapter_area.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Area.setAdapter(adapter_area);

        int min = 000000;
        int max = 999999;

        Random r = new Random();
        int i1 = r.nextInt(max - min + 1) + min;
        PCR_Form_No.setText("KAEM "+String.valueOf(i1));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.past_illness:
                PastIllnessPoP();
                break;
            case R.id.history_of_medication:
                History_of_medicationPoP();
                break;
            case R.id.back_image:
                Intent back_intent = new Intent(PCR_Form_Activity.this, Home_Activity.class);
                back_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_intent);
                break;
            case R.id.tv_next:
                First_linear.setVisibility(View.GONE);
                Second_linear.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_previous:
                First_linear.setVisibility(View.VISIBLE);
                Second_linear.setVisibility(View.GONE);
                break;
        }
    }

    private void History_of_medicationPoP() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View PromtView = inflater.inflate(R.layout.history_of_mediceane_layout_popup, null);
        final AlertDialog alertD = new AlertDialog.Builder(this).create();
        TextView Ok =(TextView)PromtView.findViewById(R.id.ok_btn);
        TextView Cancel =(TextView)PromtView.findViewById(R.id.cancel_btn);
        alertD.setCancelable(true);
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertD.dismiss();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertD.dismiss();
            }
        });
        alertD.setView(PromtView);
        alertD.show();
    }

    private void PastIllnessPoP() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View PromtView = inflater.inflate(R.layout.past_illness_layout_popup, null);
        final AlertDialog alertD = new AlertDialog.Builder(this).create();
        TextView Ok =(TextView)PromtView.findViewById(R.id.ok_btn);
        TextView Cancel =(TextView)PromtView.findViewById(R.id.cancel_btn);
        alertD.setCancelable(true);
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertD.dismiss();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertD.dismiss();
            }
        });
        alertD.setView(PromtView);
        alertD.show();
    }


}
