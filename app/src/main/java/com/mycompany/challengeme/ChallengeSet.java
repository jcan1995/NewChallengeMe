package com.mycompany.challengeme;

import android.widget.ImageView;

import java.io.File;

/**
 * Created by joshua on 5/22/2016.
 */
public class ChallengeSet {
    private String Description;
    private String Title;
    private ImageView firstImage;
    private ImageView lastImage;
    private String pathOne;
    private File f1;

    public File getF1() {
        return f1;
    }

    public void setF1(File f1) {
        this.f1 = f1;
    }

    public ImageView getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(ImageView firstImage) {
        this.firstImage = firstImage;
    }

    public ImageView getLastImage() {

        return lastImage;
    }

    public void setLastImage(ImageView lastImage) {
        this.lastImage = lastImage;
    }

    public ChallengeSet(String d, String t){

        Description = d;
        Title = t;

    }

    public ChallengeSet(){}


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
