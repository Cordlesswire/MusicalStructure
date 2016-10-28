package com.udacity.musicalstructure.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.udacity.musicalstructure.R;

/**
 * Created by geovani on 27/10/16.
 */

public class DetailActivity extends AppCompatActivity {


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //
        showHeaderBackgroud();
        setupToolbar();
    }


    private void setupToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //
        Bundle args = getIntent().getExtras();
        String name = "";
        if (args != null) {
            name = args.getString("theme");
        }
        Log.i("TAG", name);
        getSupportActionBar().setTitle(name);
    }


    public void showHeaderBackgroud() {
        try {
            Glide.with(this).load(R.drawable.music_header).into((ImageView) findViewById(R.id.image));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
