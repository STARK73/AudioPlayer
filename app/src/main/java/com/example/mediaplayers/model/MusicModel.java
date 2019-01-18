package com.example.mediaplayers.model;


import android.os.Parcel;
import android.os.Parcelable;

public class MusicModel implements Parcelable {

    private String name;
    private String durability;
    private int url;


    protected MusicModel(Parcel in) {
        name = in.readString();
        durability = in.readString();
        url = in.readInt();
    }

    public MusicModel(String name, String durability, int url) {
        this.name = name;
        this.durability = durability;
        this.url = url;
    }

    public static final Creator<MusicModel> CREATOR = new Creator<MusicModel>() {
        @Override
        public MusicModel createFromParcel(Parcel in) {
            return new MusicModel(in);
        }

        @Override
        public MusicModel[] newArray(int size) {
            return new MusicModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(durability);
        parcel.writeInt(url);
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }
}
