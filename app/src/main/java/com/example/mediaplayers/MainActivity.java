package com.example.mediaplayers;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mediaplayers.fragments.MusicFragment;
import com.example.mediaplayers.fragments.SingerFragment;
import com.example.mediaplayers.model.MusicModel;
import com.example.mediaplayers.model.SingleModel;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SingerFragment.OnSelectedItemListener {

    private String STACK = "myStack";

    private FragmentManager manager;
    private SingerFragment singerFragment;
    private MusicFragment musicFragment;
    private ImageButton startOrPauseButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        singerFragment = new SingerFragment();
        musicFragment = new MusicFragment();

        startOrPauseButton = (ImageButton) findViewById(R.id.startButton);
        stopButton = (ImageButton) findViewById(R.id.stopButton);

        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.container, singerFragment);
        fragmentTransaction.commit();

        startOrPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlay.playOrPause();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlay.stop();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        MediaPlay.pauseOnStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MediaPlay.pauseOnStop();
    }

    @Override
    public void selectedSinger(String name) {
        musicFragment.setNameSinger(name);

        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.container, musicFragment);
        fragmentTransaction.addToBackStack(STACK);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

}
