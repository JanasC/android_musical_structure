/*
 * PROJECT LICENSE
 *
 * This project was submitted by Janas Chatkevicius as part of the Nanodegree At Udacity.
 *
 * As part of Udacity Honor code, your submissions must be your own work, hence
 * submitting this project as yours will cause you to break the Udacity Honor Code
 * and the suspension of your account.
 *
 * Me, the author of the project, allow you to check the code as a reference, but if
 * you submit it, it's your own responsibility if you get expelled.
 *
 * Copyright (c) 2018 Janas Chatkevicius
 *
 * Besides the above notice, the following license applies and this license notice
 * must be included in all works derived from this project.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaylistActivity extends AppCompatActivity {

    @BindView(R.id.playlist_title_text_view)
    public TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("categoryName");
        setContentView(R.layout.activity_playlist);

        ButterKnife.bind(this);
        titleTextView.setText(categoryName);
        setTitle(categoryName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Song> songs = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            String artistName = categoryName + "Artist ";
            String songName = categoryName + "Song ";
            songs.add(new Song(artistName + i, songName + i));
        }

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent myIntent = new Intent(view.getContext(), NowPlayingActivity.class);

                switch (position) {
                    case 0:
                        myIntent.putExtra(getString(R.string.value_name), songs.get(0).getName());
                        myIntent.putExtra(getString(R.string.value_artist), songs.get(0).getArtist());
                        startActivityForResult(myIntent, 0);
                        break;
                    case 1:
                        myIntent.putExtra(getString(R.string.value_name), songs.get(1).getName());
                        myIntent.putExtra(getString(R.string.value_artist), songs.get(1).getArtist());
                        startActivityForResult(myIntent, 0);
                        break;
                    case 2:
                        myIntent.putExtra(getString(R.string.value_name), songs.get(2).getName());
                        myIntent.putExtra(getString(R.string.value_artist), songs.get(2).getArtist());
                        startActivityForResult(myIntent, 0);
                        break;
                    case 3:
                        myIntent.putExtra(getString(R.string.value_name), songs.get(3).getName());
                        myIntent.putExtra(getString(R.string.value_artist), songs.get(3).getArtist());
                        startActivityForResult(myIntent, 0);
                        break;
                    case 4:
                        myIntent.putExtra(getString(R.string.value_name), songs.get(4).getName());
                        myIntent.putExtra(getString(R.string.value_artist), songs.get(4).getArtist());
                        startActivityForResult(myIntent, 0);
                        break;
                }
            }
        });
    }
}
