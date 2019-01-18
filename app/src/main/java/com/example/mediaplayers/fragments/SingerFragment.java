package com.example.mediaplayers.fragments;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import com.example.mediaplayers.R;
import com.example.mediaplayers.adapter.SingleAdapter;
import com.example.mediaplayers.clickListner.RecyclerItemClickListener;
import com.example.mediaplayers.model.SingleModel;

import java.util.ArrayList;

public class SingerFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<SingleModel> models;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singer, null);

        recyclerView = (RecyclerView) view.findViewById(R.id.list_singer);

        intSinger();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SingleAdapter(models));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        OnSelectedItemListener listener = (OnSelectedItemListener) getActivity();
                        listener.selectedSinger(models.get(position).getName());
                    }
                })
        );
        return view;
    }


    private void intSinger() {
        Resources res = getResources();
        String[] arrName = res.getStringArray(R.array.singerName);
        String[] arrGeners = res.getStringArray(R.array.singerGenres);
        String[] arrSize = res.getStringArray(R.array.singerSize);
        TypedArray arrIconSinger = res.obtainTypedArray(R.array.icon_singer);

        models = new ArrayList<>();
        for (int i = 0; i < arrName.length; i++) {
            models.add(new SingleModel(arrName[i], arrSize[i], arrGeners[i], arrIconSinger.getResourceId(i, -1)));
        }
    }

    public interface OnSelectedItemListener {
        void selectedSinger(String name);
    }
}
