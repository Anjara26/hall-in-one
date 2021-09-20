package com.example.hallinonesport.tools;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String doubleToMinuteSecondString (double d) {
        Duration duration = Duration.ofSeconds((long) (d * 60));
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%02d:%02d",
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
}
