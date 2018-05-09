package com.smart_ambulance.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_ambulance.R;
import com.smart_ambulance.adapter.EquipmentRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 30-Mar-18.
 */

public class Equipment_Activity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    SharedPreferences.Editor editor;
    String amu_id,amu_city,amu_loc,amu_dist,EquipmentName;
    TextView ambulance_id,ambulance_city,ambulance_location,ambulance_dist;
    RecyclerView rvContacts;
    private List<String> equipment_name_list = new ArrayList<>();
    EquipmentRecyclerAdapter equipmentRecyclerAdapter;
    Button Equ_Submit;

    Spinner spinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_equipment_checklist);

        SharedPreferences prefs = getSharedPreferences("ambulance_register", MODE_PRIVATE);
        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        ambulance_id = (TextView) findViewById(R.id.amb_id);
        ambulance_city = (TextView) findViewById(R.id.amb_city);
        ambulance_location = (TextView) findViewById(R.id.amb_loc);
        ambulance_dist = (TextView) findViewById(R.id.amb_dist);
        Equ_Submit = (Button) findViewById(R.id.equ_submit);


        amu_id =prefs.getString("AMBULANCE_ID","");
        amu_city =prefs.getString("AMBULANCE_CITY","");
        amu_loc =prefs.getString("AMBULANCE_LOC","");
        amu_dist =prefs.getString("AMBULANCE_DIST","");
        System.out.println("amu_id****"+amu_id);

        ambulance_id.setText(amu_id);
        ambulance_city.setText(amu_city);
        ambulance_location.setText(amu_loc);
        ambulance_dist.setText(amu_dist);

         spinner = (Spinner) findViewById(R.id.spinner_search);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.equipment_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Equ_Submit.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         EquipmentName = parent.getItemAtPosition(position).toString();
       // EquipmentPopDisplay();
        if (!EquipmentName.equals("Select equipment")){
           // EquipmentPopDisplay();
            EquipmentListAdd();
        }else {

        }

    }

    private void EquipmentPopDisplay() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View PromtView = inflater.inflate(R.layout.equipment_popup, null);
        final AlertDialog alertD = new AlertDialog.Builder(this).create();
        alertD.setCancelable(true);
        TextView Cancel_Btn = (TextView) PromtView.findViewById(R.id.cancel_btn);
        TextView Ok_Btn = (TextView) PromtView.findViewById(R.id.ok_btn);
        TextView Equip_Name = (TextView) PromtView.findViewById(R.id.equipment_name);
        Equip_Name.setText(EquipmentName);
        Ok_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertD.dismiss();
              //  EquipmentListAdd();
            }
        });
        Cancel_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertD.dismiss();
            }
        });


        alertD.setView(PromtView);
        alertD.show();


    }

    private void EquipmentListAdd() {
        equipment_name_list.add(EquipmentName);
        System.out.println("equipment_name_list"+equipment_name_list);

        loadlistMethod();
    }

    private void loadlistMethod() {


        equipmentRecyclerAdapter = new EquipmentRecyclerAdapter(this,equipment_name_list);
        rvContacts.setLayoutManager(new GridLayoutManager(Equipment_Activity.this,2));
        rvContacts.setHasFixedSize(true);
        rvContacts.setAdapter(equipmentRecyclerAdapter);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(Equipment_Activity.this,"Successfully submit data",Toast.LENGTH_SHORT).show();
    }
}
