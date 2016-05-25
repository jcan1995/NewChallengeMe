package com.mycompany.challengeme;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joshua on 5/22/2016.
 */
public class Singleton {

    private ArrayList<ChallengeSet> mChallenges;
  //  private ArrayList<User> mUsers;

    private HashMap<String, User> mUsers;

    private static Singleton sSingleton = null;

    private Context mAppContext;

    private Singleton(Context appContext){
        mAppContext = appContext;

        mChallenges = new ArrayList<ChallengeSet>();
       // mUsers = new ArrayList<User>();
        mUsers = new HashMap<String, User>();

    }

    public ArrayList<ChallengeSet> getChallenges(){
        return mChallenges;
    }
 //   public ArrayList<User> getUsers(){
   //     return mUsers;
  //  }

    public HashMap<String, User> getUsers(){
        return mUsers;
    }


    public static Singleton get(Context c){
        if(sSingleton == null){
            sSingleton = new Singleton(c.getApplicationContext());
        }
        return sSingleton;
    }


}
