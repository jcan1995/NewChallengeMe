package com.mycompany.challengeme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.mycompany.challengeme.ChallengeSet;
import com.mycompany.challengeme.R;

import java.util.ArrayList;

/**
 * Created by joshua on 5/21/2016.
 */
public class AddChallenge extends Fragment {




    private final String FIREBASE_URL="https://newchallengeme.firebaseio.com/";//sets path to DB
    public Firebase fbRef1;
    EditText etName;
    EditText etDestination;
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

        //Validates that the user input something before sending it to the DB
        Firebase.setAndroidContext(getActivity());

        fbRef1 = new Firebase(FIREBASE_URL);




        //  mChallengesArrayList = Singleton.get(getActivity()).getChallenges();

        bSubmit = (Button) v.findViewById(R.id.bSubmit);
        etName = (EditText) v.findViewById(R.id.etChallengeName);
        etDestination = (EditText) v.findViewById(R.id.etDes);



        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String challengeTitle = etName.getText().toString();
                String challengeDes= etDestination.getText().toString();
                ChallengeSet challenge = new ChallengeSet(challengeDes,challengeTitle);



                /**
                 * Following block contains the code to send the information to the database
                 * Once successfull, the toast will appear
                 */
                //////////////////////////////////////////////////////////////////////
                fbRef1.push().setValue(challenge); //will send the challenge to the DB
                String message = "Congrats MotherFucker";

                if ( fbRef1 != null){
                Toast success = Toast.makeText(getActivity(),message , Toast.LENGTH_LONG);
                success.show();}
                else{
                    Toast fail = Toast.makeText(getActivity(),message , Toast.LENGTH_LONG);
                    fail.show();
                }
                //////////////////////////////////////////////////////////////////////


                Fragment newFragment = new CameraAdd();
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.fFragmentContainer, newFragment)
                        .commit();


            }
        });



        return v;
    }
}