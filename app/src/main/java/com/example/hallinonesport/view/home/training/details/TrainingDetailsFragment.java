package com.example.hallinonesport.view.home.training.details;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.asura.library.posters.DrawableImage;
import com.asura.library.posters.Poster;
import com.asura.library.posters.RemoteVideo;
import com.asura.library.views.PosterSlider;
import com.example.hallinonesport.R;

import java.util.ArrayList;
import java.util.List;

public class TrainingDetailsFragment extends Fragment {

    private PosterSlider posterSlider;
    private Button startButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training_details, container, false);
        posterSlider = (PosterSlider) view.findViewById(R.id.poster_slider);
        List<Poster> posters=new ArrayList<>();
        posters.add(new DrawableImage(R.drawable.fitness));
        posters.add(new RemoteVideo(Uri.parse("https://firebasestorage.googleapis.com/v0/b/hall-in-one.appspot.com/o/Bicycle%20crunch.mp4?alt=media")));
        Log.d("poster", String.valueOf(posters.size()));
        posterSlider.setPosters(posters);

        this.startButton = (Button) view.findViewById(R.id.startButton);

        return view;
    }
}