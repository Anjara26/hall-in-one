package com.example.hallinonesport.view.home.training;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.SettingController;
import com.example.hallinonesport.controller.TrainingController;
import com.example.hallinonesport.model.Training;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class TrainingFragment extends Fragment {

    private List<Training> trainings;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TrainingController controller;
    private SettingController settingController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.training_title);
        this.settingController = SettingController.getInstance(getContext());
        this.controller = TrainingController.getInstance(getContext(), settingController.getSetting());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training, container, false);
        this.recyclerView = view.findViewById(R.id.training_recyclerView);
        this.adapter = new TrainingAdapter(getListTraining(), getActivity());
        FlexboxLayoutManager manager = new FlexboxLayoutManager(view.getContext());
        manager.setFlexDirection(FlexDirection.ROW);
        this.recyclerView.setLayoutManager(manager);
        this.recyclerView.setAdapter(this.adapter);
        return view;
    }

    private List<Training> getListTraining() {
        trainings = controller.getListTrain(this.settingController.getSetting());
        return trainings;
    }
}