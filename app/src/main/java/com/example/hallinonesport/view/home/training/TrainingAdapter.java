package com.example.hallinonesport.view.home.training;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallinonesport.R;
import com.example.hallinonesport.model.Equipment;
import com.example.hallinonesport.model.Training;
import com.example.hallinonesport.view.home.equipment.CardEquipmentHolder;

import java.util.List;


public class TrainingAdapter extends RecyclerView.Adapter<TrainingHolder> {

    private List<Training> trainings;

    public TrainingAdapter(List<Training> trainings) {
        this.trainings = trainings;
    }

    @NonNull
    @Override
    public TrainingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_training, parent, false);
        return new TrainingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingHolder holder, int position) {
        final Training training = trainings.get(position);
        holder.getName().setText(training.getName());
        holder.getDescription().setText(training.getDescription());
    }

    @Override
    public int getItemCount() {
        return trainings == null ? 0 : trainings.size();
    }
}
