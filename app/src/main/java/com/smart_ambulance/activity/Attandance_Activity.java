package com.smart_ambulance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.smart_ambulance.R;

/**
 * Created by admin on 02-Apr-18.
 */

public class Attandance_Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView Back_Button;
    View Toolbar_custom;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attandance);
        Toolbar_custom = findViewById(R.id.toolbar_id);

        Back_Button = (ImageView) Toolbar_custom.findViewById(R.id.back_image);
        Back_Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent back_intent = new Intent(Attandance_Activity.this, Home_Activity.class);
        back_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(back_intent);
    }
}
