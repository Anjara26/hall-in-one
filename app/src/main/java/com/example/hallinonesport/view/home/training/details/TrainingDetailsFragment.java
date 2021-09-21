package com.example.hallinonesport.view.home.training.details;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.asura.library.posters.DrawableImage;
import com.asura.library.posters.Poster;
import com.asura.library.posters.RemoteVideo;
import com.asura.library.views.PosterSlider;
import com.example.hallinonesport.R;
import com.example.hallinonesport.controller.SettingController;
import com.example.hallinonesport.controller.TrainingController;
import com.example.hallinonesport.model.Equipment;
import com.example.hallinonesport.model.Training;
import com.example.hallinonesport.tools.Useful;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TrainingDetailsFragment extends Fragment {

    private PosterSlider posterSlider;
    private Button startButton;
    private TextView title;
    private TextView description;
    private TextView timerText;
    private Training training;
    private TrainingController controller;
    private SettingController  settingController;
    private boolean start = false;

    public TrainingDetailsFragment(Training training) {
        this.settingController = SettingController.getInstance(getContext());
        this.controller = TrainingController.getInstance(getContext(), this.settingController.getSetting());
        this.training = training;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training_details, container, false);
        ActionBar actionBar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle(training.getName());
        this.startButton = (Button) view.findViewById(R.id.startButton);
        this.title = (TextView) view.findViewById(R.id.training_details_title);
        this.description = (TextView) view.findViewById(R.id.training_details_description);
        this.timerText = (TextView) view.findViewById(R.id.training_details_timer);

        this.timerText.setText(Useful.doubleToMinuteSecondString(training.getDuration()));

        this.title.setText(training.getName());
        this.description.setText(training.getDescription());
        this.posterSlider = (PosterSlider) view.findViewById(R.id.poster_slider);
        Resources resources = getResources();
        List<Poster> posters=new ArrayList<>();
        if(this.training.getVideo() != null && this.training.getVideo() != "") {
            posters.add(new RemoteVideo(Uri.parse(this.training.getVideo())));
        }
        int imageResource = resources.getIdentifier(training.getImage(), null, getActivity().getPackageName());
        posters.add(new DrawableImage(imageResource));
        posterSlider.setPosters(posters);

        this.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!start) {
                    start = true;
                    long duration = TimeUnit.MINUTES.toMillis((long) (training.getDuration()  + 1));
                    startButton.setText("Stop");
                    new CountDownTimer(duration, 1000) {
                        @Override
                        public void onTick(long l) {
                            String sDuration = String.format(Locale.ENGLISH, "%02d:%02d",
                                    TimeUnit.MICROSECONDS.toMinutes(l),
                                    TimeUnit.MILLISECONDS.toSeconds(l) -
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                            timerText.setText(sDuration);
                        }

                        @Override
                        public void onFinish() {
                            startButton.setText("Go");
                            Toast.makeText(getContext(), "Félicitation vous l'avez fait", Toast.LENGTH_LONG).show();
                            start = false;
                        }
                    }.start();
                }
            }
        });

        return view;
    }
}