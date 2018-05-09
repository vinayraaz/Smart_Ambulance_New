package com.smart_ambulance.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_ambulance.R;
import com.smart_ambulance.adapter.VahicleListAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 07-Apr-18.
 */

public class New_Ambulance_check_Activity extends AppCompatActivity implements View.OnClickListener {
    ListView ambulance_check_list_view;
    List<String> vahicle_name_list;

    View Toolbar_custom;
    ImageView Back_Button;
    CheckBox All_Available;
    CheckedTextView ctv;
    String Vihacle_Name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_ambulance_check_list);

        ambulance_check_list_view = (ListView) findViewById(R.id.vihicle_list);
        Toolbar_custom = findViewById(R.id.toolbar_id);

        Back_Button = (ImageView) Toolbar_custom.findViewById(R.id.back_image);
        Back_Button.setOnClickListener(this);

        vahicle_name_list = Arrays.asList(getResources().getStringArray(R.array.vahicle_list));
        All_Available = (CheckBox) findViewById(R.id.check_all);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vahicle_list, android.R.layout.simple_list_item_multiple_choice);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ambulance_check_list_view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ambulance_check_list_view.setAdapter(adapter);
        All_Available.setOnClickListener(this);
        ambulance_check_list_view.setOnItemClickListener(new New_Ambulance_check_Activity.CheckBoxClick());

    }

    public class CheckBoxClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ctv = (CheckedTextView)view;
            Vihacle_Name = parent.getItemAtPosition(position).toString();
            if(ctv.isChecked()){

                Toast.makeText(New_Ambulance_check_Activity.this, "now it is checked"+Vihacle_Name, Toast.LENGTH_SHORT).show();
                EquipmentPopDisplay();

            }else{
                Toast.makeText(New_Ambulance_check_Activity.this, "now it is unchecked"+Vihacle_Name, Toast.LENGTH_SHORT).show();
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
        Equip_Name.setText(Vihacle_Name);
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




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_image:
                Intent back_intent = new Intent(New_Ambulance_check_Activity.this, Home_Activity.class);
                back_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_intent);
                break;

            case R.id.check_all:
                CheckBox chk = (CheckBox) v;
                int itemCount = ambulance_check_list_view.getCount();
                for(int i=0 ; i < itemCount ; i++){
                    ambulance_check_list_view.setItemChecked(i, chk.isChecked());
                }
                break;
        }


    }
}
