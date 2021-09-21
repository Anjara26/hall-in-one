package com.example.hallinonesport.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hallinonesport.R;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        getSupportActionBar().hide();

        fragmentManager = getSupportFragmentManager();
        start = findViewById(R.id.button_onboarding);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnBoardingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataForOnBoarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.onBoarding, paperOnboardingFragment);
        fragmentTransaction.commit();
    }

    private ArrayList<PaperOnboardingPage> getDataForOnBoarding() {
        PaperOnboardingPage equipment = new PaperOnboardingPage("Vos équipements", "Choisissez les " +
                "équipements en fonction de ceux que vous en avez chez vous", Color.parseColor("#ffb174"), R.drawable.equipment, R.drawable.image6);
        PaperOnboardingPage setting = new PaperOnboardingPage("Vos préférences", "Configurez " +
                "les paramètres selon vos préférences.", Color.parseColor("#22eaaa"), R.drawable.setting, R.drawable.image3);
        PaperOnboardingPage welcome = new PaperOnboardingPage("Bienvenue", "Réveille-toi " +
                "avec détermination, endors-toi avec satisfaction", Color.parseColor("#ee5a5a"), R.drawable.fitness, R.drawable.image12);

        ArrayList<PaperOnboardingPage> pages = new ArrayList<>();
        pages.add(equipment);
        pages.add(setting);
        pages.add(welcome);



        return pages;
    }
}