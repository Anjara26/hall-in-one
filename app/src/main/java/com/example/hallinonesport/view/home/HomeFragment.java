package com.example.hallinonesport.view.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hallinonesport.R;
import com.example.hallinonesport.tools.Useful;
import com.example.hallinonesport.view.home.equipment.EquipmentFragment;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Useful.loadFragment(new EquipmentFragment(), getActivity(), R.id.frame_home_layout);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}