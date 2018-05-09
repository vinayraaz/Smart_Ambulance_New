package com.smart_ambulance.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.smart_ambulance.R;
import com.smart_ambulance.adapter.Expiry_Stock_Adapter;
import com.smart_ambulance.adapter.Stock_DisposableAdapter;
import com.smart_ambulance.adapter.Stock_Medical_RegisterAdapter;
import com.smart_ambulance.dataBase.DBAdapter;
import com.smart_ambulance.parshingmodel.Expiry_Stock_ParshingModel;
import com.smart_ambulance.parshingmodel.Stock_Medical_ParshingModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 02-Apr-18.
 */

public class Stock_RegisterActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    LinearLayout Tab1, Tab2, Tab3, Tab4, Linear_Medical, Linear_Disposable, Linear_NonMedical, Linear_ExpiryStock;
    TextView Stock_Change_Name;
    View Tab_Details_View1, Tab_Details_View2, Tab_Details_View3, Tab_Details_View4;
    Spinner Stock_Spinner;
    ArrayAdapter<CharSequence> medical_adapter, disposable_adapter, nonmedical_disposable_adapter;
    String Material_Description;
    RecyclerView Medical_Recycler_view, Expiry_recycler, Disposable_Item_Recyclerview;
    List<String> stock_medical_name_list;
    List<String> stock_disposable_tem_list;
    List<String> stock_listno = new ArrayList<>();
    Stock_Medical_RegisterAdapter stock_medical_registerAdapter;
    Stock_DisposableAdapter stock_disposableAdapter;
    int value = 0;
    DBAdapter db;
    List<Stock_Medical_ParshingModel> stock_medical_parshingModels = new ArrayList<>();
    List<Expiry_Stock_ParshingModel> expiry_stock_parshingModels = new ArrayList<>();
    String particularname[] = {"IV Ringer Lactate 500ml", "IV Normal Saline 500ml", "Spirit Solution", "Inj Lasix Amp", "InjTramadol Amp", "Tab Disprin", "Inj Buscopam"};
    String quantity[] = {"10", "15", "22", "12", "10", "14", "17"};
    String expiry_date[] = {"15/05/2018", "20/06/2018", "12/06/2018", "25/06/2018", "12/04/2018", "18/05/2018", "18/05/2018"};
    ImageView Back_Button;
    View Toolbar_custom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_register_layout);

        db = new DBAdapter(Stock_RegisterActivity.this);
      /*  db.open();
        db.deleteAllRecords();
        db.deleteAllRecordsDisposable();
        db.close();*/
        Toolbar_custom = findViewById(R.id.toolbar_id);

        Back_Button = (ImageView) Toolbar_custom.findViewById(R.id.back_image);
        Back_Button.setOnClickListener(this);
        Tab1 = (LinearLayout) findViewById(R.id.tab1);
        Tab2 = (LinearLayout) findViewById(R.id.tab2);
        Tab3 = (LinearLayout) findViewById(R.id.tab3);
        Tab4 = (LinearLayout) findViewById(R.id.tab4);

        Linear_Medical = (LinearLayout) findViewById(R.id.linear_medical);
        Linear_Disposable = (LinearLayout) findViewById(R.id.linear_disposable);
        Linear_NonMedical = (LinearLayout) findViewById(R.id.linear_nonmedical);
        Linear_ExpiryStock = (LinearLayout) findViewById(R.id.linear_expirystock);


        Tab_Details_View3 = findViewById(R.id.tab_details3);
        Tab_Details_View4 = findViewById(R.id.tab_details4);

        Tab1.setOnClickListener(this);
        Tab2.setOnClickListener(this);
        Tab3.setOnClickListener(this);
        Tab4.setOnClickListener(this);
        Linear_Medical.setVisibility(View.VISIBLE);

        Medical_Recycler_view = (RecyclerView) findViewById(R.id.medical_rec_list);
        Disposable_Item_Recyclerview = (RecyclerView) findViewById(R.id.medical_rec_list2);
        Expiry_recycler = (RecyclerView) findViewById(R.id.expirystock_rec_list);
        System.out.println("SIZE***" + stock_medical_parshingModels.size());
        stock_medical_name_list = Arrays.asList(getResources().getStringArray(R.array.medical_search_list));
        stock_disposable_tem_list = Arrays.asList(getResources().getStringArray(R.array.disposable_search_list));


        db.open();
        Cursor c1 = db.CheckTable();
        if (c1.moveToFirst()) {
            do {
                int icount = c1.getInt(0);
                if (icount > 0) {
                    Log.i("HAve Data Class********", "" + icount);
                } else {
                    Log.i("No Data Class********", "" + icount);
                    for (int i = 0; i < stock_medical_name_list.size(); i++) {
                        value++;
                        String Meterial_dec = stock_medical_name_list.get(i).toString();
                        stock_listno.add(String.valueOf(value));
                        db.open();
                        db.insertContact("M00" + value, Meterial_dec, "", "10/04/2018", "11/04/2018", "", "", "", "", "", "15/04/2018");
                        db.close();

                    }
                }
            } while (c1.moveToNext());
        }
        db.close();


        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst()) {
            do {
                DisplayContact(c);

            } while (c.moveToNext());
        }
        db.close();

        stock_medical_registerAdapter = new Stock_Medical_RegisterAdapter(this, stock_medical_parshingModels);
        Medical_Recycler_view.setLayoutManager(new LinearLayoutManager(this));
        Medical_Recycler_view.setAdapter(stock_medical_registerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_image:
                Intent back_intent = new Intent(Stock_RegisterActivity.this, Home_Activity.class);
                back_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(back_intent);
                break;
            case R.id.tab1:
                stock_medical_parshingModels.clear();
                Tab1.setBackgroundColor(getResources().getColor(R.color.gray));
                Tab2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Linear_Medical.setVisibility(View.VISIBLE);
                Linear_Disposable.setVisibility(View.GONE);
                Linear_NonMedical.setVisibility(View.GONE);
                Linear_ExpiryStock.setVisibility(View.GONE);

                db.open();
                Cursor c = db.getAllContacts();
                if (c.moveToFirst()) {
                    do {
                        DisplayContact(c);
                    } while (c.moveToNext());
                }
                db.close();

                stock_medical_registerAdapter = new Stock_Medical_RegisterAdapter(this, stock_medical_parshingModels);
                Medical_Recycler_view.setLayoutManager(new LinearLayoutManager(this));
                Medical_Recycler_view.setAdapter(stock_medical_registerAdapter);


                break;
            case R.id.tab2:
                stock_medical_parshingModels.clear();
                Tab1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab2.setBackgroundColor(getResources().getColor(R.color.gray));
                Tab3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Linear_Medical.setVisibility(View.GONE);
                Linear_Disposable.setVisibility(View.VISIBLE);
                Linear_NonMedical.setVisibility(View.GONE);
                Linear_ExpiryStock.setVisibility(View.GONE);


                //2 nd table*****
                db.open();
                Cursor new_cursor = db.CheckDisposableTable();
                if (new_cursor.moveToFirst()) {
                    do {
                        int icount = new_cursor.getInt(0);
                        if (icount > 0) {
                            Log.i("HAve Data Class********", "" + icount);
                            GetDataFromDB();
                        } else {
                            Log.i("No Data Class********", "" + icount);
                            for (int i = 0; i < stock_disposable_tem_list.size(); i++) {
                                value++;
                                String Desposable_Des = stock_disposable_tem_list.get(i).toString();
                                stock_listno.add(String.valueOf(value));
                                db.open();
                                db.insertDisposableTable("D00" + value, Desposable_Des, "", "10/04/2018", "11/04/2018", "", "", "", "", "", "15/04/2018");
                                GetDataFromDB();
                                db.close();

                            }
                        }
                    } while (new_cursor.moveToNext());
                }

                db.close();


                stock_disposableAdapter = new Stock_DisposableAdapter(this, stock_medical_parshingModels);
                Disposable_Item_Recyclerview.setLayoutManager(new LinearLayoutManager(this));
                Disposable_Item_Recyclerview.setAdapter(stock_disposableAdapter);


                break;
            case R.id.tab3:
                Stock_Change_Name = (TextView) Tab_Details_View3.findViewById(R.id.stock_change);
                Tab1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab3.setBackgroundColor(getResources().getColor(R.color.gray));
                Tab4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Linear_Medical.setVisibility(View.GONE);
                Linear_Disposable.setVisibility(View.GONE);
                Linear_NonMedical.setVisibility(View.VISIBLE);
                Linear_ExpiryStock.setVisibility(View.GONE);
                Stock_Change_Name.setText("NON MEDICAL CONSUMABLES STATIONERY");
                Stock_Spinner = (Spinner) Tab_Details_View3.findViewById(R.id.stock_search);
                nonmedical_disposable_adapter = ArrayAdapter.createFromResource(this, R.array.non_medical_disposable_list, android.R.layout.simple_spinner_item);
                nonmedical_disposable_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Stock_Spinner.setAdapter(nonmedical_disposable_adapter);
                Stock_Spinner.setOnItemSelectedListener(this);
                break;

            case R.id.tab4:
                expiry_stock_parshingModels.clear();
                Tab1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Tab4.setBackgroundColor(getResources().getColor(R.color.gray));
                Linear_Medical.setVisibility(View.GONE);
                Linear_Disposable.setVisibility(View.GONE);
                Linear_NonMedical.setVisibility(View.GONE);
                Linear_ExpiryStock.setVisibility(View.VISIBLE);
                for (int i = 0; i < particularname.length; i++) {
                    expiry_stock_parshingModels.add(new Expiry_Stock_ParshingModel(particularname[i], quantity[i], expiry_date[i]));
                }
                Expiry_Stock_Adapter expiry_stock_adapter = new Expiry_Stock_Adapter(this, expiry_stock_parshingModels);
                Expiry_recycler.setLayoutManager(new LinearLayoutManager(this));
                Expiry_recycler.setAdapter(expiry_stock_adapter);
                break;
        }
    }

    private void GetDataFromDB() {
        db.open();
        Cursor c = db.getAllContactsDisposable();
        if (c.moveToFirst()) {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();
    }


    private void DisplayContact(Cursor c) {
        stock_medical_parshingModels.add(new Stock_Medical_ParshingModel(
                c.getString(0),
                c.getString(1),
                c.getString(2),
                c.getString(3),
                c.getString(4),
                c.getString(5),
                c.getString(6),
                c.getString(7),
                c.getString(8),
                c.getString(9),
                c.getString(10),
                c.getString(11)
        ));
        Log.i("Data****", c.getString(2));
        Log.i("Data****", c.getString(3));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Material_Description = parent.getItemAtPosition(position).toString();
        if (!Material_Description.equals("Select Material Description")) {
            Material_DescriptionPopDisplay();
            // Toast.makeText(Stock_RegisterActivity.this,"Meterial NAme:"+Material_Description,Toast.LENGTH_SHORT).show();

        } else {

        }

    }

    private void Material_DescriptionPopDisplay() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View PromtView = inflater.inflate(R.layout.meterial_description_popup, null);
        final AlertDialog alertD = new AlertDialog.Builder(this).create();
        TextView Meterial_Name = (TextView) PromtView.findViewById(R.id.meterial_des);
        Meterial_Name.setText(Material_Description);
        alertD.setCancelable(true);
        alertD.setView(PromtView);
        alertD.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
