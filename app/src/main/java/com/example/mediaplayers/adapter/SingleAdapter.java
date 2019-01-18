package com.example.mediaplayers.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mediaplayers.R;
import com.example.mediaplayers.model.SingleModel;

import java.util.List;

public class SingleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<SingleModel> models;

    public SingleAdapter(List<SingleModel> models) {
        this.models = models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single_model, parent, false);
        return new ViewHolderHotel(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderHotel holderHotel = (ViewHolderHotel) holder;
        SingleModel model = models.get(position);

        holderHotel.name.setText(model.getName());
        holderHotel.countTrack.setText(model.getCountTrack());
        holderHotel.genres.setText(model.getGenres());
        holderHotel.image.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        if (models != null)
            return models.size();
        return 0;
    }

    private static class ViewHolderHotel extends RecyclerView.ViewHolder {
        TextView name;
        TextView genres;
        TextView countTrack;
        ImageView image;


        private ViewHolderHotel(View v) {
            super(v);
            name = (TextView) itemView.findViewById(R.id.item_singer_name);
            genres = (TextView) itemView.findViewById(R.id.item_singer_genres);
            countTrack = (TextView) itemView.findViewById(R.id.item_singer_count);
            image = (ImageView) itemView.findViewById(R.id.item_image_singer);
        }
    }
}

