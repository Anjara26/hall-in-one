package com.example.hallinonesport.tools;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.hallinonesport.R;

public class Useful {

    public static void loadFragment (Fragment fragment, FragmentActivity activity) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_home_layout,fragment);
        transaction.commit();
    }
}
