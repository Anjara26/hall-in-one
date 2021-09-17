package com.example.hallinonesport.tools;

import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.hallinonesport.R;

public class Useful {

    public static void loadFragment (Fragment fragment, FragmentActivity activity, int idFrameLayout) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(idFrameLayout,fragment);
        transaction.commit();
    }
}
