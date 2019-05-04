package com.example.android.musicstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SongAdapter extends ArrayAdapter<SongList> {

    public SongAdapter(Activity context, ArrayList<SongList> song) {
        super(context, 0, song);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View lisItemView = convertView;
        if (lisItemView == null) {
            lisItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_song, parent, false);
        }

        // Get the {@link SongList} object located at this position in the list
        SongList currentName = getItem(position);

        // Find the TextView in the list_song.xml layout with the ID default text view
        TextView nameTextView = (TextView) lisItemView.findViewById(R.id.name);

        // Get the name from the current SongAdapter object and
        // set this text on the default TextView
        nameTextView.setText(currentName.getDefaultName());

        // Get the {@link SongList} object located at this position in the list
        SongList currentTitle = getItem(position);

        // Find the TextView in the list_song.xml layout with the ID default text view
        TextView titleTextView = (TextView) lisItemView.findViewById(R.id.title);

        // Get the title from the current SongAdapter object and
        // set this text on the default TextView
        titleTextView.setText(currentTitle.getDefaultTitle());

        // Get the {@link SongList} object located at this position in the list
        SongList currentDuration = getItem(position);

        // Find the TextView in the list_song.xml layout with the ID default text view
        TextView durationTextView = (TextView) lisItemView.findViewById(R.id.duration);

        // Get the title from the current SongAdapter object and
        // set this text on the default TextView
        durationTextView.setText(currentDuration.getDefaultDuration());

        return lisItemView;
    }
}
