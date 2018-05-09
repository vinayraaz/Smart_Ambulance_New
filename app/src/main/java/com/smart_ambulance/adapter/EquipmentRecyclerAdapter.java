package com.smart_ambulance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart_ambulance.R;
import com.smart_ambulance.activity.Equipment_Activity;
import com.smart_ambulance.activity.Stock_RegisterActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 30-Mar-18.
 */

public class EquipmentRecyclerAdapter extends RecyclerView.Adapter<EquipmentRecyclerAdapter.EquipmentViewHolder> {
    private Context context;
    List<String> equipment_name_list = new ArrayList<>();
    public EquipmentRecyclerAdapter(Context context, List equipment_name_list) {
        this.context = context;
        this.equipment_name_list = equipment_name_list;
        notifyDataSetChanged();
    }



    @Override
    public EquipmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_equipment_list_details,parent,false);
        EquipmentViewHolder contactViewHolder = new EquipmentViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(EquipmentViewHolder holder, final int position) {
        holder.EquipmentName.setText(equipment_name_list.get(position).toString());
        holder.Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equipment_name_list.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return equipment_name_list.size();
    }

    public class EquipmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView EquipmentName;
        public ImageView Cancel;
        public EquipmentViewHolder(View itemView) {
            super(itemView);
            EquipmentName =(TextView)itemView.findViewById(R.id.equipment_name);
            Cancel =(ImageView)itemView.findViewById(R.id.image_cancel);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
