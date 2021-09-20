package com.example.hallinonesport.view.account;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;

import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.SettingController;
import com.example.hallinonesport.model.Setting;

public class AccountFragment extends Fragment {

    private LinearLayout background;

    private CardView preferenceCard;
    private LinearLayout preference;
    private Button savePreference;
    private ImageButton closePreference;
    private RadioButton man;
    private RadioButton woman;
    private CheckBox weightGain;
    private CheckBox weightLoss;
    private Switch notification;
    private Switch darkmode;

    private CardView accountCard;
    private LinearLayout accountModal;
    private ImageButton closeAccount;

    private SettingController settingController;

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

        this.man = view.findViewById(R.id.man);
        this.man.setChecked(true);
        this.woman = view.findViewById(R.id.woman);
        this.weightGain = view.findViewById(R.id.weightGain);
        this.weightLoss = view.findViewById(R.id.weightLoss);
        this.notification = view.findViewById(R.id.notification);
        this.darkmode = view.findViewById(R.id.darkmode);

        this.onClickPreference();

        this.accountCard = view.findViewById(R.id.accountCard);
        this.accountModal = view.findViewById(R.id.accountModal);
        this.closeAccount = view.findViewById(R.id.closeAccount);

        this.onClickAccount();

        this.settingController = SettingController.getInstance(getActivity());

        this.getSetting(view);

        return view;
    }

    public void onClickPreference(){
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

                Integer gender = 0;
                boolean weightgain = false;
                boolean weightloss = false;
                boolean notificationValue = false;
                boolean darkmodeValue = false;

                if(man.isChecked()){
                    gender = 1;
                }

                if(weightGain.isChecked()){
                    weightgain = true;
                }

                if(weightLoss.isChecked()){
                    weightloss = true;
                }

                if(notification.isChecked()){
                    notificationValue = true;
                }

                if(darkmode.isChecked()){
                    darkmodeValue = true;
                }

                setSetting(gender, weightgain, weightloss, notificationValue, darkmodeValue);

            }
        });

        this.closePreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preference.setVisibility(View.INVISIBLE);
                background.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void onClickAccount(){
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
    }

    public void setSetting(int gender, boolean weightgain, boolean weightloss, boolean notification, boolean darkmode){
        this.settingController.createSetting(gender, weightgain, weightloss, notification, darkmode, getActivity());
    }

    private void getSetting(View view){
        if(settingController.getGender() != null){
            if(settingController.getGender()==1){
                this.man.setChecked(true);
            }else{
                this.woman.setChecked(true);
            }

            this.weightGain.setChecked(settingController.isWeightgain());
            this.weightLoss.setChecked(settingController.isWeightloss());
            this.notification.setChecked(settingController.isNotification());
            this.darkmode.setChecked(settingController.isDarkmode());
            ((Button)view.findViewById(R.id.savePreference)).performClick();
        }
    }

}