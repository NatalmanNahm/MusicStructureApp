package com.example.android.musicstructureapp;


import android.os.Parcel;
import android.os.Parcelable;

public class SongList implements Parcelable {

    public static final Parcelable.Creator<SongList> CREATOR = new Parcelable.Creator<SongList>() {
        @Override
        public SongList createFromParcel(Parcel source) {
            return new SongList(source);
        }

        @Override
        public SongList[] newArray(int size) {
            return new SongList[size];
        }
    };
    /**
     * Default title of the song
     */
    private String mTitle;
    /**
     * Default name of the Artist
     */
    private String mName;
    /**
     * Default Duration of the song
     */
    private String mDuration;

    /**
     * Creating a constructor for the song
     */
    public SongList(String defaultTitle, String defaultName, String defaultDuration) {
        mTitle = defaultTitle;
        mName = defaultName;
        mDuration = defaultDuration;
    }

    protected SongList(Parcel in) {
        this.mTitle = in.readString();
        this.mName = in.readString();
        this.mDuration = in.readString();
    }

    /**
     * Method to get the song Title
     */
    public String getDefaultTitle() {
        return mTitle;
    }

    /**
     * Method to get the name of the artist
     */
    public String getDefaultName() {
        return mName;
    }

    /**
     * Method to get the duration of the song
     */
    public String getDefaultDuration() {
        return mDuration;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mName);
        dest.writeString(this.mDuration);
    }
}
