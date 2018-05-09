package com.smart_ambulance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.smart_ambulance.R;
import com.smart_ambulance.adapter.Stock_Medical_RegisterAdapter;
import com.smart_ambulance.adapter.VahicleListAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 04-Apr-18.
 */

public class Ambulance_check_Activity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView ambulance_check_list_view;
    List<String> vahicle_name_list;
    VahicleListAdapter vahicleListAdapter;
    View Toolbar_custom;
    ImageView Back_Button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ambulance_check_list);
        ambulance_check_list_view = (RecyclerView) findViewById(R.id.vihicle_list);
        Toolbar_custom = findViewById(R.id.toolbar_id);

        Back_Button = (ImageView) Toolbar_custom.findViewById(R.id.back_image);
        Back_Button.setOnClickListener(this);

        vahicle_name_list = Arrays.asList(getResources().getStringArray(R.array.vahicle_list));
        vahicleListAdapter = new VahicleListAdapter(this, vahicle_name_list);
        ambulance_check_list_view.setLayoutManager(new LinearLayoutManager(this));
        ambulance_check_list_view.setAdapter(vahicleListAdapter);


    }

    @Override
    public void onClick(View v) {
        Intent back_intent = new Intent(Ambulance_check_Activity.this, Home_Activity.class);
        back_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(back_intent);

    }
}
