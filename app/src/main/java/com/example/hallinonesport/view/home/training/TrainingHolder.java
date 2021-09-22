package com.example.hallinonesport.view.home.training;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallinonesport.R;


public class TrainingHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView name;
    private ImageView imageView;
    private TextView timer;

    public TrainingHolder(@NonNull View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.training_card);
        name = (TextView)itemView.findViewById(R.id.name_training);
        imageView = (ImageView)itemView.findViewById(R.id.image_training_card);
        timer = (TextView)itemView.findViewById(R.id.timer_card);
    }

    public TextView getName() {
        return name;
    }

    public CardView getCardView() {
        return this.cardView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTimer() {
        return timer;
    }
}
