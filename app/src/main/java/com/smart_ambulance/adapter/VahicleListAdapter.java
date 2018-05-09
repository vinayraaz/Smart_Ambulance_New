package com.smart_ambulance.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_ambulance.R;
import com.smart_ambulance.activity.Ambulance_check_Activity;

import java.util.List;

/**
 * Created by admin on 04-Apr-18.
 */

public class VahicleListAdapter extends RecyclerView.Adapter<VahicleListAdapter.VahicleViewHolder> {
    private Context context;
    List<String> vahicle_name_list;
    String equipment_item;

 /*   public VahicleListAdapter(Context context, int simple_list_item_multiple_choice, List<String> vahicle_name_list) {
        this.context = context;
        this.vahicle_name_list = vahicle_name_list;
        notifyDataSetChanged();
    }*/
    public VahicleListAdapter(Context context, List<String> vahicle_name_list) {
        this.context = context;
        this.vahicle_name_list = vahicle_name_list;
        notifyDataSetChanged();

    }

    @Override
    public VahicleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vahicle_list_details, parent, false);
        VahicleListAdapter.VahicleViewHolder contactViewHolder = new VahicleListAdapter.VahicleViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(VahicleViewHolder holder, final int position) {

        System.out.println("equipment_item***"+equipment_item);
        holder.Equipment_Name.setText(vahicle_name_list.get(position).toString());
        holder.Equipment_Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equipment_item =vahicle_name_list.get(position).toString();
                Toast.makeText(context,"Update "+equipment_item,Toast.LENGTH_SHORT).show();

                VahicleUpdatePOP();
            }
        });

    }

    private void VahicleUpdatePOP() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View PromtView = inflater.inflate(R.layout.equipment_popup, null);
        final AlertDialog alertD = new AlertDialog.Builder(context).create();
        alertD.setCancelable(true);

        TextView EquipmentName = (TextView)PromtView.findViewById(R.id.equipment_name);
        TextView Ok_Button = (TextView)PromtView.findViewById(R.id.ok_btn);
        TextView Cancel_Button = (TextView)PromtView.findViewById(R.id.cancel_btn);
        EquipmentName.setText(equipment_item);

        Ok_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Update Successfully",Toast.LENGTH_SHORT).show();
                alertD.dismiss();
            }
        });

        Cancel_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertD.dismiss();
            }
        });


        alertD.setView(PromtView);
        alertD.show();

    }

    @Override
    public int getItemCount() {
        return vahicle_name_list.size();
    }

    public class VahicleViewHolder extends RecyclerView.ViewHolder  {
        public TextView Equipment_Name;
        private LinearLayout Vahicle_Linear;
        public VahicleViewHolder(View itemView) {
            super(itemView);
            Equipment_Name = (TextView)itemView.findViewById(R.id.equipment_name);
            Vahicle_Linear = (LinearLayout)itemView.findViewById(R.id.vahicle_list_linear);
            //itemView.setOnClickListener(this);
        }


    }
}
