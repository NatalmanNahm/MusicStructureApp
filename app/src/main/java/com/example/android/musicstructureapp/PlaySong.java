package com.example.android.musicstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlaySong extends AppCompatActivity {

    Boolean pause = true;
    int indexNext = 1;
    String nextName;
    String nextTitle;
    String nextDuration;

    String[] nameArray;
    String[] titleArray;
    String[] durationArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        //Getting textviews to import name, title and duration on
        TextView artistName = (TextView) findViewById(R.id.artist_name);
        TextView songTitle = (TextView) findViewById(R.id.song_name);
        TextView duration = (TextView) findViewById(R.id.duration_song);

        //Transfer data from the list to the song player
        Bundle allSongCont = getIntent().getExtras();
        String title = allSongCont.getString("title");
        String name = allSongCont.getString("name");
        String songDuration = allSongCont.getString("duration");

        // set each textView to its value
        artistName.setText(name);
        songTitle.setText(title);
        duration.setText(songDuration);


        //Getting array of name, title, and duration of songs
        nameArray = allSongCont.getStringArray("nameArray");
        titleArray = allSongCont.getStringArray("titleArray");
        durationArray = allSongCont.getStringArray("durationArray");


    }

    /**
     * @param v this method is to change image of the play when it's clicked to pause
     */
    public void playMusic(View v) {
        ImageView play = (ImageView) findViewById(R.id.play);

        if (pause) {
            play.setImageResource(R.drawable.pause);
            pause = false;
        } else if (!pause) {
            play.setImageResource(R.drawable.play);
            pause = true;
        }
    }

    /**
     * @param v this method is to go to the next song
     */
    public void playNext(View v) {
        TextView artistName = (TextView) findViewById(R.id.artist_name);
        TextView songTitle = (TextView) findViewById(R.id.song_name);
        TextView duration = (TextView) findViewById(R.id.duration_song);

        String name = artistName.getText().toString();
        String title = songTitle.getText().toString();

        for (int i = 0; i < nameArray.length-1; i++) {
            if (nameArray[i].equalsIgnoreCase(name) && titleArray[i].equalsIgnoreCase(title)) {

                int next = i + 1;
                artistName.setText(nameArray[next]);
                songTitle.setText(titleArray[next]);
                duration.setText(durationArray[next]);
            }
        }

    }

    /**
     * @param v this method is to go to the previous song
     */
    public void playPrevious(View v) {
        TextView artistName = (TextView) findViewById(R.id.artist_name);
        TextView songTitle = (TextView) findViewById(R.id.song_name);
        TextView duration = (TextView) findViewById(R.id.duration_song);

        String name = artistName.getText().toString();
        String title = songTitle.getText().toString();

        for (int i = 0; i < nameArray.length; i++) {
            if (nameArray[i].equalsIgnoreCase(name) && titleArray[i].equalsIgnoreCase(title)) {

                if (i == 0){
                    return;
                }

                int next = i - 1;
                artistName.setText(nameArray[next]);
                songTitle.setText(titleArray[next]);
                duration.setText(durationArray[next]);
            }
        }
    }


}
