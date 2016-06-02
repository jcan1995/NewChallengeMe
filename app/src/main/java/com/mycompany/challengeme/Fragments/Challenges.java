package com.mycompany.challengeme.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.mycompany.challengeme.ChallengeSet;
import com.mycompany.challengeme.R;
import com.mycompany.challengeme.Singleton;

import java.util.ArrayList;

import static com.mycompany.challengeme.R.layout.fragment_list_item;

/**
 * Created by joshua on 5/21/2016.
 */
public class Challenges extends ListFragment {

    private TextView tvChallenge;
    private TextView tvUserName;
    private ImageView ivUserImage;
    private Button bAddChallenge;
    private ArrayList<ChallengeSet> mChallengesArrayList;
    private final String FIREBASE_URL = "https://newchallengeme.firebaseio.com/";

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        mChallengesArrayList = Singleton.get(getActivity()).getChallenges();
        ChallengesAdapter adapter = new ChallengesAdapter(mChallengesArrayList);
        setListAdapter(adapter);

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstance){
        View v = inflater.inflate(fragment_list_item , parent , false);

        tvChallenge = (TextView) v.findViewById(R.id.tvChallenge);
        tvUserName = (TextView) v.findViewById(R.id.tvDescrip);//Actually not the user name
        ivUserImage = (ImageView) v.findViewById(R.id.ivUserImage);
        Firebase urlRef = new Firebase(FIREBASE_URL);


        return v;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){//What do we want to happen when we click an item on the List? We want to start a CrimeFragment with the proper data. This is the method we use..
        ChallengeSet t = ((ChallengesAdapter) getListAdapter()).getItem(position);

        // Intent i = new Intent(getActivity(),UserView.class);
        //  startActivity(i);
    }

    private class ChallengesAdapter extends ArrayAdapter<ChallengeSet> {

        public ChallengesAdapter(ArrayList<ChallengeSet> talker){
            super(getActivity(),android.R.layout.simple_list_item_1,talker);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_list_item,null);
            }

            ChallengeSet t = getItem(position);

           // File file = t.getF1();
           // Uri uri = Uri.fromFile(file);

            TextView tTitle = (TextView)convertView.findViewById(R.id.tvChallenge);
            tTitle.setText(t.getTitle());

            TextView tDescription = (TextView)convertView.findViewById(R.id.tvDescrip);
            tDescription.setText(t.getDescription());

           // ImageView imageView = (ImageView)convertView.findViewById(R.id.ivUserImage);
            //imageView.setImageBitmap(BitmapFactory.decodeFile(file.getPath()));
                    //setImageURI(uri);



/*
            TextView tAge = (TextView)convertView.findViewById(R.id.text_age);
            tAge.setText(String.valueOf(t.getAge()));

            TextView tEmail = (TextView)convertView.findViewById(R.id.text_email);
            tEmail.setText(t.getEmail());
    */
            return convertView;
        }


    }

}
