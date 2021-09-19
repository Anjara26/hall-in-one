package com.example.hallinonesport.tools;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


public class Useful {

    public static void loadFragment (Fragment fragment, FragmentActivity activity, int idFrameLayout) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(idFrameLayout,fragment);
        transaction.commit();
    }
}
