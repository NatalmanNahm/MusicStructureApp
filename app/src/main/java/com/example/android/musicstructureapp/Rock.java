package com.example.android.musicstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Rock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);

        //Create a string Array List of Gospel Songs
        final ArrayList<SongList> songs = new ArrayList<SongList>();

        songs.add(new SongList("Natural", "Imagine Dragons", "05:20"));
        songs.add(new SongList("Bohemian Rhapsody", "Queen", "04:33"));
        songs.add(new SongList("Broken", "lovelytheband", "06:34"));
        songs.add(new SongList("Another One Bites The Dust", "Queen", "04:19"));
        songs.add(new SongList("We Will Rock You", "Queen", "06:44"));
        songs.add(new SongList("11 Minutes", "Yungblud, Halsey & Travis Barker", "03:00"));
        songs.add(new SongList("Bad Liar", "Imagine Dragons", "04:55"));
        songs.add(new SongList("Don't Stop Me Now", "Queen", "05:33"));
        songs.add(new SongList("Somebody To Love", "Queen", "08:30"));
        songs.add(new SongList("We Are The Champions", "Queen", "02:344"));
        songs.add(new SongList("Under Pressure", "Queen & David Bowie", "08:00"));
        songs.add(new SongList("Shotgun", "George Ezra", "03:35"));
        songs.add(new SongList("Killer Queen", "Queen", "08:01"));
        songs.add(new SongList("Chlorine", "twenty one pilots", "05:30"));


        //Find the root view of the whole layout
        SongAdapter itemAdapter =
                new SongAdapter(this, songs);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Getting data at the current position
                SongList s = songs.get(position);
                String name = s.getDefaultName();
                String title = s.getDefaultTitle();
                String duration = s.getDefaultDuration();

                //Declaring array of name, title, and duration of song
                String[] nameArray = new String[songs.size()];
                String[] titleArray = new String[songs.size()];
                String[] durationArray = new String[songs.size()];

                //storing each elements in the listview and storing them into array to be passed
                //to the next intent
                for (int i = 0; i < songs.size(); i++) {

                    SongList allName = songs.get(i);
                    nameArray[i] = allName.getDefaultName();
                    titleArray[i] = allName.getDefaultTitle();
                    durationArray[i] = allName.getDefaultDuration();
                }

                //Creating a bundle to save data and transfer them to the PlaySong activity
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("title", title);
                bundle.putString("duration", duration);
                bundle.putStringArray("nameArray", nameArray);
                bundle.putStringArray("titleArray", titleArray);
                bundle.putStringArray("durationArray", durationArray);

                //Creating intent and sending data to the PlaySong activity
                Intent playIntent = new Intent(Rock.this, PlaySong.class);
                playIntent.putExtras(bundle);
                startActivity(playIntent);

            }
        });
    }
}
