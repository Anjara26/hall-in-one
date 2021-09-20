package com.example.hallinonesport.view.home.equipment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.EquipmentController;
import com.example.hallinonesport.model.Equipment;
import com.example.hallinonesport.model.LocaleDbAccess;
import com.example.hallinonesport.view.home.training.TrainingFragment;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

public class EquipmentFragment extends Fragment {

    private List<Equipment> equipments;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Button button;
    private EquipmentController controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.controller = EquipmentController.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment, container, false);
        setHasOptionsMenu(true);

        this.recyclerView = view.findViewById(R.id.recycler_view);
        this.adapter = new EquipmentAdapter(this.controller.getListEquipment(), getActivity());
        FlexboxLayoutManager manager = new FlexboxLayoutManager(view.getContext());
        manager.setFlexDirection(FlexDirection.ROW);
        manager.setFlexWrap(FlexWrap.WRAP);
        manager.setJustifyContent(JustifyContent.SPACE_AROUND);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(manager);
        this.recyclerView.setAdapter(this.adapter);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ActionBar actionBar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(R.string.home_title);
        this.button = view.findViewById(R.id.button_equipment);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction.replace(R.id.frame_home_layout, new TrainingFragment());
                transaction.addToBackStack(null);
                ActionBar actionBar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
                actionBar.setDisplayHomeAsUpEnabled(true);

                transaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Recherche");

        super.onCreateOptionsMenu(menu,inflater);
    }

}