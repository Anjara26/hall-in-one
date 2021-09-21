package com.example.hallinonesport.view.account;

import android.graphics.Color;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.SettingController;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.Arrays;

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
    private TextView goal;

    private CircleImageView profil;
    private TextView profilName;

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
        profilName = (TextView) view.findViewById(R.id.profil_name);
        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("email", "public_profile"));
        // If using in a fragment
        loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                Log.d("Erro:facebook", exception.getMessage());
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
        this.goal = view.findViewById(R.id.goal_text);

        this.onClickAccount();

        this.settingController = SettingController.getInstance(getActivity());

        this.getSetting(view);

        if(this.settingController.isDarkmode()) {
            this.preference.setBackgroundColor(Color.GRAY);
            this.accountModal.setBackgroundColor(Color.GRAY);
        }

        if(this.settingController.isWeightgain() && this.settingController.isWeightloss()) {
            this.goal.setText("Vos objectifs : Prise de masse, Perte de poids");
        } else if(this.settingController.isWeightgain()) {
            this.goal.setText("Vos objectifs : Prise de masse");
        } else if (this.settingController.isWeightloss()) {
            this.goal.setText("Vos objectifs : Perte de poids");
        }

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
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                if(settingController.isWeightgain() && settingController.isWeightloss()) {
                    goal.setText("Vos objectifs : Prise de masse, Perte de poids");
                } else if(settingController.isWeightgain()) {
                    goal.setText("Vos objectifs : Prise de masse");
                } else if (settingController.isWeightloss()) {
                    goal.setText("Vos objectifs : Perte de poids");
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

    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            accountModal.setVisibility(View.INVISIBLE);
            background.setVisibility(View.INVISIBLE);
            if(currentAccessToken != null) {
                loadUserProfile(currentAccessToken);
            }
        }
    };

    private void loadUserProfile(AccessToken accessToken) {
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String firstName = object.getString("first_name");
                    String lastName = object.getString("last_name");
                    String id = object.getString("id");
                    String imageUrl = "https://graph.facebook.com" + id + "/picture?type=normal";

                    profilName.setText(firstName + " " + lastName);
                    profil.setImageURI(Uri.parse(imageUrl));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name, last_name, id");
        request.setParameters(parameters);
        request.executeAsync();
    }
}