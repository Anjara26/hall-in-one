package com.example.hallinonesport.view.home.equipment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallinonesport.R;
import com.example.hallinonesport.model.Equipment;

import org.w3c.dom.Text;

import java.util.List;

public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.MyViewHolder> {

    private List<Equipment> equipments;

    public EquipmentAdapter(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private CardView cardView;
        private TextView textView;
        private ImageView imageView;
        private ImageView check;

        private MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            cardView = (CardView) itemView.findViewById(R.id.card);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView8);
            check = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }

    @NonNull
    @Override
    public EquipmentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_equipment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipmentAdapter.MyViewHolder holder, int position) {
        final Equipment equipment = equipments.get(position);
        holder.textView.setText(equipment.getname());
        holder.cardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                equipment.setSelected(!equipment.isSelected());
                holder.cardView.setBackgroundColor(equipment.isSelected() ? Color.rgb(224,224,224) : Color.WHITE);
                holder.check.setVisibility(equipment.isSelected() ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return equipments == null ? 0 : equipments.size();
    }

}
