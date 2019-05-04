package com.example.android.musicstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Rnb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);

        //Create a string Array List of Gospel Songs
        final ArrayList<SongList> songs = new ArrayList<SongList>();

        songs.add(new SongList("Talk", "Khalid", "05:20"));
        songs.add(new SongList("Lost In The Fire", "Gesaffelstein & The Weeknd", "04:33"));
        songs.add(new SongList("Undecided", "Chris Brown", "06:34"));
        songs.add(new SongList("Nights Like This", "Kehlani Featuring Ty Dolla $ign", "04:19"));
        songs.add(new SongList("Shot Clock", "Ella Mai", "06:44"));
        songs.add(new SongList("Arms Around You", "Lil Pump, Maluma & Swae Lee", "03:00"));
        songs.add(new SongList("Saturday Nights", "Khalid & Kane Brown", "04:55"));
        songs.add(new SongList("You", "Jacquees", "05:33"));
        songs.add(new SongList("Talk To Me", "Tory Lanez & Rich The Kid", "08:30"));
        songs.add(new SongList("Karma", "Queen Naija", "02:344"));
        songs.add(new SongList("Could've Been", "H.E.R. & Bryson Tiller", "08:00"));
        songs.add(new SongList("OTW", "Khalid, Ty Dolla $ign & 6LACK", "03:35"));
        songs.add(new SongList("Ride Good", "LightSkinKeisha & BSmyth", "08:01"));
        songs.add(new SongList("Girls Need Love", "Summer Walker", "05:30"));

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
                Intent playIntent = new Intent(Rnb.this, PlaySong.class);
                playIntent.putExtras(bundle);
                startActivity(playIntent);

            }
        });
    }
}
