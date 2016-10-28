package com.udacity.musicalstructure.model;

/**
 * Created by geovani on 23/10/16.
 */

public class Theme {

    private String mName;
    private int mNumOfSongs;
    private int mImage;


    public Theme(String name, int numOfSongs, int image) {
        this.mName       = name;
        this.mNumOfSongs = numOfSongs;
        this.mImage      = image;
    }


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getNumOfSongs() {
        return mNumOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        mNumOfSongs = numOfSongs;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }



}
