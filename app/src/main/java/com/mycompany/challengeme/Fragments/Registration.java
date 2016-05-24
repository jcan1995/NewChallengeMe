package com.mycompany.challengeme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mycompany.challengeme.R;
import com.mycompany.challengeme.Singleton;
import com.mycompany.challengeme.User;

import java.util.ArrayList;

/**
 * Created by joshua on 5/23/2016.
 */
public class Registration extends Fragment {


    EditText etFirstName;
    EditText etLastName;
    EditText etPhoneNumber;
    Button bSubmit;


    private ArrayList<User> mUserArrayList;


    private void Register(){

        String First;
        String Last;
        String Phone;

        First = etFirstName.getText().toString();
        Last = etLastName.getText().toString();
        Phone = etPhoneNumber.getText().toString();

        User user = new User(First,Last,Phone);
        mUserArrayList.add(user);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_register,parent,false);

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
