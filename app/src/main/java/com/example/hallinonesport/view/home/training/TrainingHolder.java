package com.example.hallinonesport.view.home.training;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallinonesport.R;

import org.w3c.dom.Text;

public class TrainingHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView description;

    public TrainingHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.name_training);
        description = (TextView)itemView.findViewById(R.id.description);
    }

    public TextView getName() {
        return name;
    }

    public TextView getDescription() {
        return description;
    }
}