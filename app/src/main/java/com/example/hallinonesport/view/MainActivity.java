package com.example.hallinonesport.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.hallinonesport.R;
import com.example.hallinonesport.tools.Useful;
import com.example.hallinonesport.view.account.AccountFragment;
import com.example.hallinonesport.view.home.HomeFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_account_circle));
        bottomNavigation.show(1, true);
        loadFragement(new HomeFragment());

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()) {
                    case 1 :
                        fragment = new HomeFragment();
                        getSupportActionBar().setTitle("Choisissez vos équipements");
                        break;

                    case 2 :
                        fragment = new AccountFragment();
                        getSupportActionBar().setTitle("Mon profil");
                        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                        getSupportActionBar().setDisplayShowHomeEnabled(false);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        onBackPressed();
        return true;
    }

    private void loadFragement(Fragment fragment) {
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.commit();
    }
}