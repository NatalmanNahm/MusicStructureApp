package com.example.android.musicstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Rap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);


        //Create a string Array List of Gospel Songs
        final ArrayList<SongList> songs = new ArrayList<SongList>();

        songs.add(new SongList("Please me", "Cardi B & Bruno Mars", "05:20"));
        songs.add(new SongList("Sicko Mode", "Travis Scott", "04:33"));
        songs.add(new SongList("Wow.", "Post Malone", "06:34"));
        songs.add(new SongList("Middle Child", "J. Cole", "04:19"));
        songs.add(new SongList("Thotiana", "Blueface", "06:44"));
        songs.add(new SongList("Murder On My Mind", "YNW Melly", "03:00"));
        songs.add(new SongList("Going Bad", "Meek Mill & Drake", "04:55"));
        songs.add(new SongList("Money", "Cardi B", "05:33"));
        songs.add(new SongList("A Lot", "21 Savage", "08:30"));
        songs.add(new SongList("Drip Too Hard", "Lil Baby & Gunna", "02:344"));
        songs.add(new SongList("ZEZE", "Kodak Black,Travis Scott & Offset", "08:00"));
        songs.add(new SongList("Robbery", "Juice WRLD", "03:35"));
        songs.add(new SongList("Leave Me Alone", "Flipp Dinero", "08:01"));
        songs.add(new SongList("Wake Up In The Sky", "Gucci Mane X Bruno Mars X Kodak Black", "05:30"));

        //Find the root view of the whole layout
        SongAdapter itemAdapter =
                new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);
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
                Intent playIntent = new Intent(Rap.this, PlaySong.class);
                playIntent.putExtras(bundle);
                startActivity(playIntent);


            }
        });
    }
}
