package com.mycompany.challengeme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mycompany.challengeme.ChallengeSet;
import com.mycompany.challengeme.R;
import com.mycompany.challengeme.Singleton;

import java.util.ArrayList;

/**
 * Created by joshua on 5/21/2016.
 */
public class AddChallenge extends Fragment {

    EditText etName;
    EditText etDes;
    Button bSubmit;
    ArrayList<ChallengeSet> mChallengesArrayList;

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_add_challenge, container,false);
        mChallengesArrayList = Singleton.get(getActivity()).getChallenges();

        bSubmit = (Button) v.findViewById(R.id.bSubmit);
        etName = (EditText) v.findViewById(R.id.etChallengeName);
        etDes = (EditText) v.findViewById(R.id.etDes);


        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String challengeTitle = etName.getText().toString();
                String challengeDes= etDes.getText().toString();

               // String title = "Title"; //added
              //  Bundle args = new Bundle(); //added
              //  args.putString(title, challengeTitle); // added
                Fragment newFragment = new CameraAdd();
               // newFragment.setArguments(args);// added
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.fFragmentContainer, newFragment)
                        .commit();


                ChallengeSet challenge = new ChallengeSet(challengeDes,challengeTitle);
                mChallengesArrayList.add(challenge);
                //change to add photo challenge here.


            }
        });



        return v;
    }
}