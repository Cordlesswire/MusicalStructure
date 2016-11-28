package com.udacity.musicalstructure.model;

/**
 * Created by geovani on 23/10/16.
 */

public class Theme {

    private String mName;
    private int mNumOfSongs;
    private int mImageId;


    public Theme(String name, int numOfSongs, int imageId) {
        this.mName       = name;
        this.mNumOfSongs = numOfSongs;
        this.mImageId    = imageId;
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


    public int getImageId() {
        return mImageId;
    }


}
