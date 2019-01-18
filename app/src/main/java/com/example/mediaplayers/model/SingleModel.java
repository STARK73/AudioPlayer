package com.example.mediaplayers.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SingleModel implements Parcelable {

    private String name;
    private String countTrack;
    private int image;
    private String genres;

    public SingleModel(String name, String count, String genres, int image) {
        this.name = name;
        this.countTrack = count;
        this.image = image;
        this.genres = genres;
    }

    protected SingleModel(Parcel in) {
        name = in.readString();
        countTrack = in.readString();
        image = in.readInt();
        genres = in.readString();
    }

    public static final Creator<SingleModel> CREATOR = new Creator<SingleModel>() {
        @Override
        public SingleModel createFromParcel(Parcel in) {
            return new SingleModel(in);
        }

        @Override
        public SingleModel[] newArray(int size) {
            return new SingleModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(countTrack);
        parcel.writeInt(image);
        parcel.writeString(genres);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountTrack() {
        return countTrack;
    }

    public void setCountTrack(String countTrack) {
        this.countTrack = countTrack;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
