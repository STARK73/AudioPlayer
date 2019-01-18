package com.example.mediaplayers.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mediaplayers.R;
import com.example.mediaplayers.model.MusicModel;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<MusicModel> models;

    public MusicAdapter(List<MusicModel> models) {
        this.models = models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music_model, parent, false);
        return new MusicAdapter.ViewHolderHotel(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MusicAdapter.ViewHolderHotel holderHotel = (MusicAdapter.ViewHolderHotel) holder;
        MusicModel model = models.get(position);

        holderHotel.name.setText(model.getName());
        holderHotel.durability.setText(model.getDurability());

    }

    @Override
    public int getItemCount() {
        if (models != null)
            return models.size();
        return 0;
    }

    private static class ViewHolderHotel extends RecyclerView.ViewHolder {
        TextView name;
        TextView durability;


        private ViewHolderHotel(View v) {
            super(v);
            name = (TextView) itemView.findViewById(R.id.item_music_name);
            durability = (TextView) itemView.findViewById(R.id.item_music_durability);
        }
    }
}

