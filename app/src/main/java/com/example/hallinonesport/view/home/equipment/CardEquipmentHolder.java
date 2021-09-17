package com.example.hallinonesport.view.home.equipment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallinonesport.R;

public class CardEquipmentHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView name;
    private ImageView image;
    private ImageView check;

    public CardEquipmentHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card);
        name = (TextView) itemView.findViewById(R.id.equipment_name);
        image = (ImageView) itemView.findViewById(R.id.equipment_image);
        check = (ImageView) itemView.findViewById(R.id.chek_image);
    }

    public CardView getCardView() {
        return cardView;
    }

    public TextView getName() {
        return name;
    }

    public ImageView getImage() {
        return image;
    }

    public ImageView getCheck() {
        return check;
    }
}
