package com.example.android.musicstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Gospel extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);

        //Create a string Array List of Gospel Songs
        final ArrayList<SongList> songs = new ArrayList<SongList>();

        songs.add(new SongList("There'll be peace in", "Elvis Presley", "05:20"));
        songs.add(new SongList("Take my Hand precious Lord", "Elvis Presley", "04:33"));
        songs.add(new SongList("I'll fly away", "Allison Krauss", "06:34"));
        songs.add(new SongList("Move On Up A Little Higher", "Marian Anderson", "04:19"));
        songs.add(new SongList("Down By The Riverside", "Nat King Cole", "06:44"));
        songs.add(new SongList("Touch The Hem Of His Garment", "Sam Cooke", "03:00"));
        songs.add(new SongList("Morning Has Broken", "Cat Stevens", "04:55"));
        songs.add(new SongList("Bridge Over Troubled Water", "Simon & Garfunkel", "05:33"));
        songs.add(new SongList("O Mary Don’t You Weep", "Bruce Springsteen", "08:30"));
        songs.add(new SongList("Nobody Knows The Trouble I’ve Seen", "Louis Armstrong", "02:34"));
        songs.add(new SongList("I’d Rather Have Jesus", "Alison Krauss", "08:00"));
        songs.add(new SongList("Up To The Mountain", "Patty Griffin", "03:35"));
        songs.add(new SongList("Sinnerman", "Nina Simone", "08:01"));
        songs.add(new SongList("There Is A Fountain Filled With Blood", "Aretha Franklin", "05:30"));

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
                Intent playIntent = new Intent(Gospel.this, PlaySong.class);
                playIntent.putExtras(bundle);
                startActivity(playIntent);


            }
        });
    }


}
