package com.example.hallinonesport.view.home.training.details;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

public class TrainingDetailsFragment extends Fragment {

    private PosterSlider posterSlider;
    private Button startButton;
    private TextView title;
    private TextView description;
    private Training training;
    private TrainingController controller;
    private SettingController  settingController;

    public TrainingDetailsFragment(Training training) {
        this.settingController = SettingController.getInstance(getContext());
        this.controller = TrainingController.getInstance(getContext(), this.settingController.getSetting());
        this.training = training;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training_details, container, false);
        this.startButton = (Button) view.findViewById(R.id.startButton);
        this.title = (TextView) view.findViewById(R.id.training_details_title);
        this.description = (TextView) view.findViewById(R.id.training_details_description);

        this.title.setText(training.getName());
        this.description.setText(training.getDescription());
        this.posterSlider = (PosterSlider) view.findViewById(R.id.poster_slider);
        Resources resources = getResources();
        List<Poster> posters=new ArrayList<>();
        int imageResource = resources.getIdentifier(training.getImage(), null, getActivity().getPackageName());
        posters.add(new DrawableImage(imageResource));
        if(this.training.getVideo() != null && this.training.getVideo() != "") {
            posters.add(new RemoteVideo(Uri.parse(this.training.getVideo())));
        }
        posterSlider.setPosters(posters);

        return view;
    }
}