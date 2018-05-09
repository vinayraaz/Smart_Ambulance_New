package com.smart_ambulance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_ambulance.R;
import com.smart_ambulance.activity.Stock_RegisterActivity;
import com.smart_ambulance.parshingmodel.Expiry_Stock_ParshingModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 17-Apr-18.
 */

public class Expiry_Stock_Adapter extends RecyclerView.Adapter<Expiry_Stock_Adapter.ExpiryViewHolder> {
    private Context context;
    List<Expiry_Stock_ParshingModel> expiry_stock_parshingModels = new ArrayList<>();
    public Expiry_Stock_Adapter(Context context, List<Expiry_Stock_ParshingModel> expiry_stock_parshingModels) {
        this.context = context;
        this.expiry_stock_parshingModels = expiry_stock_parshingModels;
        notifyDataSetChanged();
    }

    @Override
    public ExpiryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.expiry_stock_list_details, parent, false);
        Expiry_Stock_Adapter.ExpiryViewHolder contactViewHolder = new Expiry_Stock_Adapter.ExpiryViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ExpiryViewHolder holder, int position) {
        holder.Particuler_Name.setText(expiry_stock_parshingModels.get(position).getParticularName());
        holder.Quantity.setText(expiry_stock_parshingModels.get(position).getQuantity());
        holder.Expiry_Date.setText(expiry_stock_parshingModels.get(position).getExpiryDate());

    }

    @Override
    public int getItemCount() {
        return expiry_stock_parshingModels.size();
    }

    public class ExpiryViewHolder extends RecyclerView.ViewHolder {
        public TextView Particuler_Name,Quantity,Expiry_Date;
        public ExpiryViewHolder(View itemView) {
            super(itemView);
            Particuler_Name = (TextView)itemView.findViewById(R.id.particuler_name);
            Quantity = (TextView)itemView.findViewById(R.id.quantity);
            Expiry_Date = (TextView)itemView.findViewById(R.id.expiry_date);
        }
    }
}
