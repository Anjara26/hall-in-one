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
import com.example.hallinonesport.model.Equipment;

import java.util.List;

public class EquipmentAdapter extends RecyclerView.Adapter<CardEquipmentHolder> {

    private List<Equipment> equipments;
    private FragmentActivity activity;

    public EquipmentAdapter(List<Equipment> equipments, FragmentActivity activity) {
        this.equipments = equipments;
        this.activity = activity;
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
        int imageResource = resources.getIdentifier(equipment.getImage(), null, activity.getPackageName());
        Drawable res = resources.getDrawable(imageResource, activity.getTheme());
        holder.getImage().setImageDrawable(res);
        holder.getCardView().setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                equipment.setSelected(!equipment.isSelected());
                holder.getCardView().setBackgroundColor(equipment.isSelected() ? Color.rgb(224,224,224) : Color.WHITE);
                holder.getCheckImage().setVisibility(equipment.isSelected() ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return equipments == null ? 0 : equipments.size();
    }

}
