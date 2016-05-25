package com.mycompany.challengeme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.mycompany.challengeme.R;
import com.mycompany.challengeme.Singleton;
import com.mycompany.challengeme.User;

import java.util.ArrayList;

/**
 * Created by joshua on 5/23/2016.
 */
public class Registration extends Fragment {

    private final String FIREBASE_URL="https://challengeme2.firebaseio.com/";
    public Firebase fbRef1;
    private ArrayList<User> mUserArrayList;

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPhoneNumber;
    private  Button bSubmit;

    private void Register(){

        String First;
        String Last;
        String Phone;

        First = etFirstName.getText().toString();
        Last = etLastName.getText().toString();
        Phone = etPhoneNumber.getText().toString();

        if(!First.equals("") || !Last.equals("") ||! Phone.equals("")) {
            User user = new User(First, Last, Phone);

            //Push into Firebase.
            fbRef1.push().setValue(user);
            etFirstName.setText("");
            etLastName.setText("");
            etPhoneNumber.setText("");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_register,parent,false);

        Firebase.setAndroidContext(getActivity());

        if(fbRef1 == null) {
            fbRef1 = new Firebase(FIREBASE_URL);
        }
        mUserArrayList = Singleton.get(getActivity()).getUsers();


        etFirstName = (EditText)v.findViewById(R.id.etFirst);
        etLastName = (EditText)v.findViewById(R.id.etLast);
        etPhoneNumber = (EditText)v.findViewById(R.id.etPhoneNumber);
        bSubmit = (Button)v.findViewById(R.id.bSubmit);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
                //Db shtuff should go in here(I think). For now...static.
                Login loginFrag = new Login();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fContainer, loginFrag)
                        .commit();



                }
         });
        return v;
    }

}
