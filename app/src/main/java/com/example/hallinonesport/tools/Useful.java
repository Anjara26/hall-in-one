package com.example.hallinonesport.tools;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


public class Useful {

    public static void loadFragment (Fragment fragment, FragmentActivity activity, int idFrameLayout) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(idFrameLayout,fragment);
        transaction.commit();
    }

    public static Drawable getDrawable (Resources resources, String uri, String packageName, Resources.Theme theme) {
        int imageResource = resources.getIdentifier(uri, null, packageName);
        return resources.getDrawable(imageResource, theme);
    }
}
