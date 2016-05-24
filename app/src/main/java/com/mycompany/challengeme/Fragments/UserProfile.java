package com.mycompany.challengeme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mycompany.challengeme.R;
import com.mycompany.challengeme.User;

import java.util.ArrayList;

/**
 * Created by joshua on 5/21/2016.
 */
public class UserProfile extends Fragment {

    TextView tvName;
    private ArrayList<User> mUserArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_profile,parent,false);

        //User user = mUserArrayList.get() <---Here we need to get the application user...
        //...the user who is currently using the application.


        //You can use the bottom code, it'll only crash if you try logging in without registering first.

        // mUserArrayList = Singleton.get(getActivity()).getUsers();
        //  tvName = (TextView)v.findViewById(R.id.tvName);
        // tvName.setText(mUserArrayList.get(0).getFirstName());

        // This isn't right get(0) will always give the first user.
        //Other users would end up viewing profiles who are in front of the arraylist



        return v;




    }

}
