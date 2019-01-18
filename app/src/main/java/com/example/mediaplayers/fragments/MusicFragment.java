package com.example.mediaplayers.fragments;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mediaplayers.MediaPlay;
import com.example.mediaplayers.R;
import com.example.mediaplayers.adapter.MusicAdapter;
import com.example.mediaplayers.clickListner.RecyclerItemClickListener;
import com.example.mediaplayers.model.MusicModel;

import java.util.ArrayList;

public class MusicFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<MusicModel> models;
    private static String nameLoadSinger = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, null);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_music);
        intSinger(nameLoadSinger);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MusicAdapter(models));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        MediaPlay.setAudioRes(models.get(position).getUrl());
                    }
                })
        );
        return view;
    }

    public void setNameSinger(String name){
        nameLoadSinger = name;
    }


    private void intSinger(String nameSinger) {
        Resources res = getResources();

        String[] arrName = null;
        String[] arrDurability = null;
        TypedArray arrUrl = null;

        switch (nameSinger){
            case "AC/DC":
                arrName = res.getStringArray(R.array.musicAcDcName);
                arrDurability = res.getStringArray(R.array.musicAcDcDurability);
                arrUrl = res.obtainTypedArray(R.array.music_acdc);
                break;
            case "David Guetta":
                arrName = res.getStringArray(R.array.musicDavidGuettaName);
                arrDurability = res.getStringArray(R.array.musicDavidGuettaDurability);
                arrUrl = res.obtainTypedArray(R.array.music_david_guetta);
                break;
            case "Imagine Dragons":
                arrName = res.getStringArray(R.array.musicImagineDragonsName);
                arrDurability = res.getStringArray(R.array.musicImagineDragonsDurability);
                arrUrl = res.obtainTypedArray(R.array.music_imagine_dragons);
                break;
        }

        models = new ArrayList<>();
        for (int i = 0; i < arrName.length; i++) {
            models.add(new MusicModel(arrName[i], arrDurability[i], arrUrl.getResourceId(i, -1)));
        }
        recyclerView.setAdapter(new MusicAdapter(models));
    }
}
