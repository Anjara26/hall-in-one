package com.example.hallinonesport.view.home.training;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hallinonesport.R;
import com.example.hallinonesport.model.Equipment;
import com.example.hallinonesport.model.Training;
import com.example.hallinonesport.view.home.equipment.EquipmentAdapter;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Training> trainings;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public TrainingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrainingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrainingFragment newInstance(String param1, String param2) {
        TrainingFragment fragment = new TrainingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Vos entraînements");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        trainings = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            Training training = new Training()
                    .setId(i)
                    .setName("Kickback")
                    .setDescription("Pour muscler les triceps")
                    .setDuration(3.4f);
            trainings.add(training);
        }
        return trainings;
    }
}