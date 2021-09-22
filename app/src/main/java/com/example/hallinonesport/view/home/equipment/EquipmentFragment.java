package com.example.hallinonesport.view.home.equipment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.EquipmentController;
import com.example.hallinonesport.model.Equipment;
import com.example.hallinonesport.model.LocaleDbAccess;
import com.example.hallinonesport.view.home.training.TrainingFragment;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

public class EquipmentFragment extends Fragment {

    private List<Equipment> equipments;
    private RecyclerView recyclerView;
    private EquipmentAdapter adapter;
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
        this.equipments = this.controller.getListEquipment();
        this.adapter = new EquipmentAdapter(this.controller.getListEquipment(), getActivity(), controller);
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
                List<Integer> listIds = controller.getSelectedIds();

                if(listIds.size() > 0) {
                    transaction.replace(R.id.frame_home_layout, new TrainingFragment());
                    transaction.addToBackStack(null);
                    ActionBar actionBar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
                    actionBar.setDisplayHomeAsUpEnabled(true);

                    transaction.commit();
                } else {
                    Toast.makeText(getActivity(), "Selectionez au moins un équipement", Toast.LENGTH_SHORT).show();
                }
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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });

        super.onCreateOptionsMenu(menu,inflater);
    }

    private void filter(String text) {
        ArrayList<Equipment> filteredlist = new ArrayList<>();

        for (Equipment item : equipments) {
            if (item.getname().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(getActivity(), "Aucun élément trouvé", Toast.LENGTH_SHORT).show();
        } else {
            this.adapter.filterList(filteredlist);
        }
    }

}