package com.example.hallinonesport.view.home.equipment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.hallinonesport.R;
import com.example.hallinonesport.model.Equipment;
import com.example.hallinonesport.view.home.training.TrainingFragment;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EquipmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EquipmentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Equipment> equipments;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private RecyclerView.Adapter adapter;
    private ImageView imageView;

    public EquipmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EquipmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EquipmentFragment newInstance(String param1, String param2) {
        EquipmentFragment fragment = new EquipmentFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment, container, false);
        this.recyclerView = view.findViewById(R.id.recycler_view);
        this.adapter = new EquipmentAdapter(getListEquipment());
        FlexboxLayoutManager manager = new FlexboxLayoutManager(view.getContext());
        manager.setFlexDirection(FlexDirection.ROW);
        manager.setFlexWrap(FlexWrap.WRAP);
        manager.setJustifyContent(JustifyContent.SPACE_EVENLY);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(manager);
        this.recyclerView.setAdapter(this.adapter);

        this.imageView = view.findViewById(R.id.imageView3);
        this.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                TrainingFragment trainingFragment = (TrainingFragment) fragmentManager.findFragmentByTag("training");
                if(trainingFragment==null){
                    trainingFragment = new TrainingFragment();
                    fragmentManager.beginTransaction().replace(R.id.equipment, trainingFragment, "training").commit();
                }
            }
        });

        return view;
    }

    private List<Equipment> getListEquipment() {
        equipments = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            equipments.add(new Equipment("@drawable/skipping_rope_", "Corde à sauter"));
        }
        return equipments;
    }
}