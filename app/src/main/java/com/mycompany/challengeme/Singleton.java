package com.mycompany.challengeme;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by joshua on 5/22/2016.
 */
public class Singleton {

    private ArrayList<ChallengeSet> mChallenges;

    private static Singleton sSingleton = null;

    private Context mAppContext;

    private Singleton(Context appContext){
        mAppContext = appContext;
        mChallenges = new ArrayList<ChallengeSet>();

    }

    public ArrayList<ChallengeSet> getChallenges(){
        return mChallenges;
    }


    public static Singleton get(Context c){
        if(sSingleton == null){
            sSingleton = new Singleton(c.getApplicationContext());
        }
        return sSingleton;
    }


}
