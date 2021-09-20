package com.example.hallinonesport.view.account;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.hallinonesport.R;

public class AccountFragment extends Fragment {

    private LinearLayout background;

    private CardView preferenceCard;
    private LinearLayout preference;
    private Button savePreference;
    private ImageButton closePreference;

    private CardView accountCard;
    private LinearLayout accountModal;
    private ImageButton closeAccount;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        this.preferenceCard = view.findViewById(R.id.preferenceCard);
        this.preference = view.findViewById(R.id.preferenceModal);
        this.background = view.findViewById(R.id.overbox);
        this.savePreference = view.findViewById(R.id.savePreference);
        this.closePreference = view.findViewById(R.id.closePreference);

        this.preferenceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preference.setVisibility(View.VISIBLE);
                background.setVisibility(View.VISIBLE);
            }
        });

        this.savePreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preference.setVisibility(View.INVISIBLE);
                background.setVisibility(View.INVISIBLE);
            }
        });

        this.closePreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preference.setVisibility(View.INVISIBLE);
                background.setVisibility(View.INVISIBLE);
            }
        });

        this.accountCard = view.findViewById(R.id.accountCard);
        this.accountModal = view.findViewById(R.id.accountModal);
        this.closeAccount = view.findViewById(R.id.closeAccount);

        this.accountCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountModal.setVisibility(View.VISIBLE);
                background.setVisibility(View.VISIBLE);
            }
        });

        this.closeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountModal.setVisibility(View.INVISIBLE);
                background.setVisibility(View.INVISIBLE);
            }
        });


        return view;
    }
}