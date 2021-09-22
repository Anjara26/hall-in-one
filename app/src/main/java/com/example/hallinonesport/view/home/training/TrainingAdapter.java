package com.example.hallinonesport.view.home.training;

import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallinonesport.R;
import com.example.hallinonesport.model.Training;
import com.example.hallinonesport.tools.Useful;
import com.example.hallinonesport.view.home.training.details.TrainingDetailsFragment;

import java.util.List;


public class TrainingAdapter extends RecyclerView.Adapter<TrainingHolder> {

    private List<Training> trainings;
    private FragmentActivity activity;

    public TrainingAdapter(List<Training> trainings, FragmentActivity activity) {
        this.trainings = trainings;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TrainingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_training, parent, false);
        return new TrainingHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull TrainingHolder holder, int position) {
        final Training training = trainings.get(position);
        holder.getName().setText(training.getName());
        Resources resources = holder.itemView.getResources();
        holder.getImageView().setImageDrawable(Useful.getDrawable(
                resources,
                training.getImage(),
                activity.getPackageName(),
                activity.getTheme()
        ));
        holder.getTimer().setText(Useful.doubleToMinuteSecondString(training.getDuration()));
        FragmentTransaction transaction = this.activity.getSupportFragmentManager().beginTransaction();
        ActionBar actionBar =  ((AppCompatActivity)activity).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction.replace(R.id.frame_home_layout, new TrainingDetailsFragment(training));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainings == null ? 0 : trainings.size();
    }
}
