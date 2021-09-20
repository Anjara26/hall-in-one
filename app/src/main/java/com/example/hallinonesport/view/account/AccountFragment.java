package com.example.hallinonesport.view.account;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;

import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.SettingController;
import com.example.hallinonesport.model.Setting;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.facebook.FacebookSdk.getApplicationContext;

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

    private CircleImageView profil;

    private CardView accountCard;
    private LinearLayout accountModal;
    private ImageButton closeAccount;
    private LoginButton loginButton;

    private SettingController settingController;
    CallbackManager callbackManager;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(getActivity());

        profil = (CircleImageView) view.findViewById(R.id.profil_image) ;
        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
        loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                accountModal.setVisibility(View.INVISIBLE);
                background.setVisibility(View.INVISIBLE);
                String profilUrl = "https://graph.facebook.com" + loginResult.getAccessToken().getUserId() + "/picture?return_ssl_resources=1";
                profil.setImageURI(Uri.parse(profilUrl));
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}