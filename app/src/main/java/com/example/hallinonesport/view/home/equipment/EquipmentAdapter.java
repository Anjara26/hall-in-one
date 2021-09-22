package com.example.hallinonesport.view.home.equipment;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.EquipmentController;
import com.example.hallinonesport.controller.SettingController;
import com.example.hallinonesport.model.Equipment;
import com.example.hallinonesport.tools.Useful;

import java.util.ArrayList;
import java.util.List;

public class EquipmentAdapter extends RecyclerView.Adapter<CardEquipmentHolder> {

    private List<Equipment> equipments;
    private FragmentActivity activity;
    private EquipmentController controller;
    private SettingController  settingController;

    public EquipmentAdapter(List<Equipment> equipments, FragmentActivity activity, EquipmentController controller) {
        this.equipments = equipments;
        this.activity = activity;
        this.controller = controller;
        this.settingController = SettingController.getInstance(activity.getBaseContext());
    }

    public void filterList(ArrayList<Equipment> filterllist) {
        equipments = filterllist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardEquipmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_equipment, parent, false);
        return new CardEquipmentHolder(view);
    }

    @Override
    public void onBindViewHolder(CardEquipmentHolder holder, int position) {
        final Equipment equipment = equipments.get(position);
        holder.getName().setText(equipment.getname());
        Resources resources = holder.itemView.getResources();
        holder.getImage().setImageDrawable(Useful.getDrawable(
                resources,
                equipment.getImage(),
                activity.getPackageName(),
                activity.getTheme()
        ));
        if(this.settingController.isDarkmode()) {
            holder.getCardView().setBackgroundColor(equipment.isSelected() ? Color.rgb(224,224,224) : Color.GRAY);
        } else {
            holder.getCardView().setBackgroundColor(equipment.isSelected() ? Color.rgb(224,224,224) : Color.WHITE);
        }
        holder.getCheckImage().setVisibility(equipment.isSelected() ? View.VISIBLE : View.INVISIBLE);

        holder.getCardView().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                equipment.setSelected(!equipment.isSelected());
                controller.setSelected(equipment.getId(), equipment.isSelected());
                if(settingController.isDarkmode()) {
                    holder.getCardView().setBackgroundColor(equipment.isSelected() ? Color.rgb(224,224,224) : Color.GRAY);
                } else {
                    holder.getCardView().setBackgroundColor(equipment.isSelected() ? Color.rgb(224,224,224) : Color.WHITE);
                }
                holder.getCheckImage().setVisibility(equipment.isSelected() ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return equipments == null ? 0 : equipments.size();
    }

}
