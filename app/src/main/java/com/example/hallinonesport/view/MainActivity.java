package com.example.hallinonesport.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.os.Bundle;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.SettingController;
import com.example.hallinonesport.view.account.AccountFragment;
import com.example.hallinonesport.view.home.HomeFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    SettingController settingController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.settingController = SettingController.getInstance(this.getBaseContext());

        if(this.settingController.isDarkmode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_account));
        bottomNavigation.show(1, true);
        loadFragement(new HomeFragment());

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()) {
                    case 1 :
                        fragment = new HomeFragment();
                        getSupportActionBar().setTitle(R.string.home_title);
                        break;

                    case 2 :
                        fragment = new AccountFragment();
                        getSupportActionBar().setTitle(R.string.profil_title);
                        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                        break;
                }

                loadFragement(fragment);
                return null;
            }
        });
    }

    /**
     * Run on navigation back called
     * @return boolean
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        // note: you can also use 'getSupportFragmentManager()'
        FragmentManager mgr = getFragmentManager();
        if (mgr.getBackStackEntryCount() == 0) {
            // No backstack to pop, so calling super
            super.onBackPressed();
        } else {
            mgr.popBackStack();
        }
    }

    private void loadFragement(Fragment fragment) {
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.commit();
    }
}