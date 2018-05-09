package com.smart_ambulance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.smart_ambulance.R;

/**
 * Created by admin on 04-Apr-18.
 */

public class IFT_Form_Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView Down_Image1, Up_Image1, Down_Image2, Up_Image2, Down_Image3, Up_Image3, Down_Image4, Up_Image4;
    LinearLayout Referring_Details, High_Risk_Linear, Declaration, Enroute_diversion_linear;
    View Toolbar_custom;
    ImageView Back_Button;
    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6, radioGroup7, radioGroup8, radioGroup9, radioGroup10;
    int pos,pos1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ift_form_layout);
        Toolbar_custom = findViewById(R.id.toolbar_id);
        Back_Button = (ImageView) Toolbar_custom.findViewById(R.id.back_image);
        Back_Button.setOnClickListener(this);

        Down_Image1 = (ImageView) findViewById(R.id.down_image_icon1);
        Up_Image1 = (ImageView) findViewById(R.id.up_image_icon1);

        Down_Image2 = (ImageView) findViewById(R.id.down_image_icon2);
        Up_Image2 = (ImageView) findViewById(R.id.up_image_icon2);

        Down_Image3 = (ImageView) findViewById(R.id.down_image_icon3);
        Up_Image3 = (ImageView) findViewById(R.id.up_image_icon3);

        Down_Image4 = (ImageView) findViewById(R.id.down_image_icon4);
        Up_Image4 = (ImageView) findViewById(R.id.up_image_icon4);

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.rd);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup5);
        radioGroup6 = (RadioGroup) findViewById(R.id.radioGroup6);
        radioGroup7 = (RadioGroup) findViewById(R.id.radioGroup7);
        radioGroup8 = (RadioGroup) findViewById(R.id.radioGroup8);
        radioGroup9 = (RadioGroup) findViewById(R.id.radioGroup9);
        radioGroup10 = (RadioGroup) findViewById(R.id.radioGroup10);

        Down_Image1.setOnClickListener(this);
        Up_Image1.setOnClickListener(this);

        Down_Image2.setOnClickListener(this);
        Up_Image2.setOnClickListener(this);

        Down_Image3.setOnClickListener(this);
        Up_Image3.setOnClickListener(this);

        Down_Image4.setOnClickListener(this);
        Up_Image4.setOnClickListener(this);


        Enroute_diversion_linear = (LinearLayout) findViewById(R.id.enroute_diversion_linear);
        Declaration = (LinearLayout) findViewById(R.id.declaration_linear);
        Referring_Details = (LinearLayout) findViewById(R.id.referring_linear);
        High_Risk_Linear = (LinearLayout) findViewById(R.id.high_risk_linear);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup1.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos1 = radioGroup2.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup3.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup4.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup5.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup6.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup7.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup8.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup9.indexOfChild(findViewById(checkedId));
            }
        });
        radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                pos = radioGroup10.indexOfChild(findViewById(checkedId));
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back_image:
                Intent back_intent = new Intent(IFT_Form_Activity.this, Home_Activity.class);
                back_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_intent);
                break;

            case R.id.down_image_icon1:
                Down_Image1.setVisibility(View.GONE);
                Up_Image1.setVisibility(View.VISIBLE);
                Enroute_diversion_linear.setVisibility(View.VISIBLE);
                break;
            case R.id.up_image_icon1:
                Down_Image1.setVisibility(View.VISIBLE);
                Up_Image1.setVisibility(View.GONE);
                Enroute_diversion_linear.setVisibility(View.GONE);

                break;
            case R.id.down_image_icon2:
                Down_Image2.setVisibility(View.GONE);
                Up_Image2.setVisibility(View.VISIBLE);
                Declaration.setVisibility(View.VISIBLE);
                break;
            case R.id.up_image_icon2:
                Down_Image2.setVisibility(View.VISIBLE);
                Up_Image2.setVisibility(View.GONE);
                Declaration.setVisibility(View.GONE);

                break;
            case R.id.down_image_icon3:
                Down_Image3.setVisibility(View.GONE);
                Up_Image3.setVisibility(View.VISIBLE);
                Referring_Details.setVisibility(View.VISIBLE);
                break;
            case R.id.up_image_icon3:
                Down_Image3.setVisibility(View.VISIBLE);
                Up_Image3.setVisibility(View.GONE);
                Referring_Details.setVisibility(View.GONE);

                break;
            case R.id.down_image_icon4:
                Down_Image4.setVisibility(View.GONE);
                Up_Image4.setVisibility(View.VISIBLE);
                High_Risk_Linear.setVisibility(View.VISIBLE);
                break;
            case R.id.up_image_icon4:
                Down_Image4.setVisibility(View.VISIBLE);
                Up_Image4.setVisibility(View.GONE);
                High_Risk_Linear.setVisibility(View.GONE);
                break;
        }
    }
}
