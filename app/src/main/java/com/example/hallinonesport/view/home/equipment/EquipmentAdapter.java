package com.example.hallinonesport.view.home.equipment;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallinonesport.R;
import com.example.hallinonesport.model.Equipment;

import java.util.List;

public class EquipmentAdapter extends RecyclerView.Adapter<CardEquipmentHolder> {

    private List<Equipment> equipments;

    public EquipmentAdapter(List<Equipment> equipments) {
        this.equipments = equipments;
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
        holder.getCardView().setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                equipment.setSelected(!equipment.isSelected());
                holder.getCardView().setBackgroundColor(equipment.isSelected() ? Color.rgb(224,224,224) : Color.WHITE);
                holder.getImage().setVisibility(equipment.isSelected() ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return equipments == null ? 0 : equipments.size();
    }

}
