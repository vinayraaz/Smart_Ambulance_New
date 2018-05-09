package com.smart_ambulance.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_ambulance.R;
import com.smart_ambulance.activity.Stock_RegisterActivity;
import com.smart_ambulance.dataBase.DBAdapter;
import com.smart_ambulance.parshingmodel.Stock_Medical_ParshingModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 03-Apr-18.
 */

public class Stock_Medical_RegisterAdapter extends RecyclerView.Adapter<Stock_Medical_RegisterAdapter.StockMedicalViewHolder> {
    private Context context;
    String m_name,open_bal_qty,rec_good_qty,rec_damage_qty,total_aval_qty,total_cons_qty,close_bal_qty,Sl_no,meterail_no,open_date,receive_date,close_date;
    List<Stock_Medical_ParshingModel> stock_medical_parshingModels = new ArrayList<>();
    DBAdapter db;
    public Stock_Medical_RegisterAdapter(Context context, List<Stock_Medical_ParshingModel> stock_medical_parshingModels) {
        this.context = context;
        this.stock_medical_parshingModels = stock_medical_parshingModels;
        notifyDataSetChanged();
    }

    @Override
    public Stock_Medical_RegisterAdapter.StockMedicalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meterial_des_list_details, parent, false);
        Stock_Medical_RegisterAdapter.StockMedicalViewHolder contactViewHolder = new Stock_Medical_RegisterAdapter.StockMedicalViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(Stock_Medical_RegisterAdapter.StockMedicalViewHolder holder, final int position) {

        holder.Sl_No.setText(stock_medical_parshingModels.get(position).getSlNo());
        holder.Meterial_No.setText(stock_medical_parshingModels.get(position).getMeterialId());
        holder.Meterial_Name.setText(stock_medical_parshingModels.get(position).getMeterialDesc());
        holder.Open_Qty.setText(stock_medical_parshingModels.get(position).getOpeningbalQty());
        holder.Open_Date.setText(stock_medical_parshingModels.get(position).getOpeningDate());
        holder.Rec_Date.setText(stock_medical_parshingModels.get(position).getReceivingDate());
        holder.Good_Qty.setText(stock_medical_parshingModels.get(position).getGoodQty());
        holder.Damag_Qty.setText(stock_medical_parshingModels.get(position).getDamageqty());
        holder.Aval_Qty.setText(stock_medical_parshingModels.get(position).getTotalavlqty());
        holder.Consume_Qty.setText(stock_medical_parshingModels.get(position).getTotalConsumedQty());
        holder.Close_Bal_Qty.setText(stock_medical_parshingModels.get(position).getClosebalQty());
        holder.Close_Date.setText(stock_medical_parshingModels.get(position).getCloseDate());

        holder.Edit_Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context,"Position "+stock_medical_parshingModels.get(position).getMeterialId().toString(),Toast.LENGTH_SHORT).show();
                 m_name = stock_medical_parshingModels.get(position).getMeterialDesc().toString();
                open_bal_qty = stock_medical_parshingModels.get(position).getOpeningbalQty().toString();
                rec_good_qty = stock_medical_parshingModels.get(position).getGoodQty().toString();
                rec_damage_qty = stock_medical_parshingModels.get(position).getDamageqty().toString();
                total_aval_qty = stock_medical_parshingModels.get(position).getTotalavlqty().toString();
                total_cons_qty = stock_medical_parshingModels.get(position).getTotalConsumedQty().toString();
                close_bal_qty = stock_medical_parshingModels.get(position).getClosebalQty().toString();

                Sl_no = stock_medical_parshingModels.get(position).getSlNo().toString();
                meterail_no = stock_medical_parshingModels.get(position).getMeterialId().toString();
                open_date = stock_medical_parshingModels.get(position).getOpeningDate().toString();
                receive_date = stock_medical_parshingModels.get(position).getReceivingDate().toString();
                close_date = stock_medical_parshingModels.get(position).getCloseDate().toString();



               UpdateStockDetailsPop();
            }
        });


    }

    private void UpdateStockDetailsPop() {

       final EditText Open_qty,damage_qty,aval_qty,close_qty;
        TextView Medicene_name;
        final AppCompatEditText good_qty,cons_qty;

        LayoutInflater inflater = LayoutInflater.from(context);
        View PromtView = inflater.inflate(R.layout.stock_update_pop, null);
        final AlertDialog alertD = new AlertDialog.Builder(context).create();
        alertD.setCancelable(true);
         Medicene_name = (TextView)PromtView.findViewById(R.id.pop_meterial_des);

        Open_qty = (EditText)PromtView.findViewById(R.id.ed_bal_qty);
        good_qty = (AppCompatEditText)PromtView.findViewById(R.id.ed_good_qty);
        damage_qty = (EditText)PromtView.findViewById(R.id.ed_damage_qty);
        aval_qty = (EditText)PromtView.findViewById(R.id.ed_aval_qty);
        cons_qty = (AppCompatEditText)PromtView.findViewById(R.id.ed_cons_qty);
        close_qty = (EditText)PromtView.findViewById(R.id.ed_close_qty);

        db = new DBAdapter(context);

         Button Submit_Data = (Button) PromtView.findViewById(R.id.Submit_data);

        Medicene_name.setText(m_name);
        Open_qty.setText(open_bal_qty);
        good_qty.setText(rec_good_qty);
        damage_qty.setText(rec_damage_qty);
        aval_qty.setText(total_aval_qty);
        cons_qty.setText(total_cons_qty);
        close_qty.setText(close_bal_qty);

        good_qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0){
                   // Toast.makeText(context,"Insert qty",Toast.LENGTH_SHORT).show();
                }else {
                    int Total_aval_qty = (Integer.parseInt(Open_qty.getText().toString().trim()))+(Integer.parseInt(good_qty.getText().toString().trim()));
                    aval_qty.setText(String.valueOf(Total_aval_qty));
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cons_qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0){
                    // Toast.makeText(context,"Insert qty",Toast.LENGTH_SHORT).show();
                }else {
                    int Total_close_qty = (Integer.parseInt(aval_qty.getText().toString().trim()))- (Integer.parseInt(cons_qty.getText().toString().trim()));
                    close_qty.setText(String.valueOf(Total_close_qty));
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Submit_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                if (db.updateContact
                        (Integer.parseInt(Sl_no.toString()),meterail_no,m_name, Open_qty.getText().toString(),open_date,receive_date, good_qty.getText().toString(),
                                damage_qty.getText().toString(),aval_qty.getText().toString(),cons_qty.getText().toString(),close_qty.getText().toString(),close_date)) {
                    Toast.makeText(context, "Update successful", Toast.LENGTH_LONG).show();
                    Intent update_intent= new Intent(context,Stock_RegisterActivity.class);
                    update_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(update_intent);
                    notifyDataSetChanged();
                }

                else
                    Toast.makeText(context, "Update failed.", Toast.LENGTH_LONG).show();
                alertD.dismiss();
                db.close();

            }
        });

        alertD.setView(PromtView);
        alertD.show();
    }

    @Override
    public int getItemCount() {
        return stock_medical_parshingModels.size();
    }

    public class StockMedicalViewHolder extends RecyclerView.ViewHolder {
        public TextView Sl_No,Meterial_No, Meterial_Name,Open_Qty,Open_Date,Rec_Date,Good_Qty,Damag_Qty,Aval_Qty,Consume_Qty,Close_Bal_Qty,Close_Date;
        public ImageView Edit_Icon;


        public StockMedicalViewHolder(View itemView) {
            super(itemView);
            Sl_No = (TextView) itemView.findViewById(R.id.slno);
            Meterial_No = (TextView) itemView.findViewById(R.id.meterial_id);
            Meterial_Name = (TextView) itemView.findViewById(R.id.meterial_des);
            Open_Qty = (TextView) itemView.findViewById(R.id.open_qty);
            Open_Date = (TextView) itemView.findViewById(R.id.open_date);
            Rec_Date = (TextView) itemView.findViewById(R.id.rec_date);
            Good_Qty = (TextView) itemView.findViewById(R.id.good_qty);
            Damag_Qty = (TextView) itemView.findViewById(R.id.damage_qty);
            Aval_Qty = (TextView) itemView.findViewById(R.id.tot_qty);
            Consume_Qty = (TextView) itemView.findViewById(R.id.con_qty);
            Close_Bal_Qty = (TextView) itemView.findViewById(R.id.cls_qty);
            Close_Date = (TextView) itemView.findViewById(R.id.cls_date);

            Edit_Icon = (ImageView) itemView.findViewById(R.id.edit_icon);

        }
    }
}
