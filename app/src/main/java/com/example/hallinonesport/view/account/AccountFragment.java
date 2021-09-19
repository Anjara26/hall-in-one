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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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