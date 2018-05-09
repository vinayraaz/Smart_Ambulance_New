package com.smart_ambulance.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_ambulance.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 07-Apr-18.
 */

public class New_Equipment_Activity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences.Editor editor;
    String amu_id,amu_city,amu_loc,amu_dist,EquipmentName;
    TextView ambulance_id,ambulance_city,ambulance_location,ambulance_dist;
    ListView RvContacts;
    private List<String> equipment_name_list;

    Button Equ_Submit;
    CheckBox All_Available;
    CheckedTextView ctv;
    ImageView Back_Button;
    View Toolbar_custom;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_equipment_list);

        Toolbar_custom = findViewById(R.id.toolbar_id);

        Back_Button = (ImageView) Toolbar_custom.findViewById(R.id.back_image);
        Back_Button.setOnClickListener(this);

        SharedPreferences prefs = getSharedPreferences("ambulance_register", MODE_PRIVATE);

        ambulance_id = (TextView) findViewById(R.id.amb_id);
        ambulance_city = (TextView) findViewById(R.id.amb_city);
        ambulance_location = (TextView) findViewById(R.id.amb_loc);
        ambulance_dist = (TextView) findViewById(R.id.amb_dist);
        RvContacts = (ListView) findViewById(R.id.rvContacts1);
        Equ_Submit = (Button) findViewById(R.id.equ_submit);
        All_Available = (CheckBox) findViewById(R.id.check_all);


        amu_id =prefs.getString("AMBULANCE_ID","");
        amu_city =prefs.getString("AMBULANCE_CITY","");
        amu_loc =prefs.getString("AMBULANCE_LOC","");
        amu_dist =prefs.getString("AMBULANCE_DIST","");
        System.out.println("amu_id****"+amu_id);

        ambulance_id.setText(amu_id);
        ambulance_city.setText(amu_city);
        ambulance_location.setText(amu_loc);
        ambulance_dist.setText(amu_dist);

        equipment_name_list = Arrays.asList(getResources().getStringArray(R.array.new_equipment_list));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.new_equipment_list, android.R.layout.simple_list_item_multiple_choice);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RvContacts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        RvContacts.setAdapter(adapter);

        Equ_Submit.setOnClickListener(this);
        All_Available.setOnClickListener(this);
        RvContacts.setOnItemClickListener(new CheckBoxClick());

        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.equ_submit:
                Toast.makeText(New_Equipment_Activity.this,"Successfully submit data",Toast.LENGTH_SHORT).show();
                break;
            case R.id.check_all:
                CheckBox chk = (CheckBox) v;
                int itemCount = RvContacts.getCount();
                for(int i=0 ; i < itemCount ; i++){
                    RvContacts.setItemChecked(i, chk.isChecked());
                }
                break;
            case R.id.back_image:
                Intent back_intent = new Intent(New_Equipment_Activity.this, Home_Activity.class);
                back_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_intent);
                break;
        }

    }

    public class CheckBoxClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             ctv = (CheckedTextView)view;
            EquipmentName = parent.getItemAtPosition(position).toString();
            if(ctv.isChecked()){

                Toast.makeText(New_Equipment_Activity.this, "now it is checked"+EquipmentName, Toast.LENGTH_SHORT).show();
               // EquipmentPopDisplay();

            }else{
                Toast.makeText(New_Equipment_Activity.this, "now it is unchecked"+EquipmentName, Toast.LENGTH_SHORT).show();
            }
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
               // EquipmentListAdd();
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


}
