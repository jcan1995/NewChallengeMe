package com.mycompany.challengeme;

/**
 * Created by joshua on 5/22/2016.
 */
public class ChallengeSet {
    private String Description;
    private String Title;

    public ChallengeSet(){}

    public ChallengeSet(String d, String t){
        Description = d;
        Title = t;
    }


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
