package com.example.android.musicstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finding the getting the textiew of each song genre
        TextView gospel = (TextView) findViewById(R.id.gospel);
        TextView rap = (TextView) findViewById(R.id.rap);
        TextView rnb = (TextView) findViewById(R.id.rnb);
        TextView rock = (TextView) findViewById(R.id.rock);


        // Set a click listener on each TextViews
        gospel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gospelIntent = new Intent(MainActivity.this, Gospel.class);
                startActivity(gospelIntent);
            }
        });

        rap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rapIntent = new Intent(MainActivity.this, Rap.class);
                startActivity(rapIntent);
            }
        });

        rnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rnbIntent = new Intent(MainActivity.this, Rnb.class);
                startActivity(rnbIntent);
            }
        });

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rockIntent = new Intent(MainActivity.this, Rock.class);
                startActivity(rockIntent);
            }
        });
    }
}
