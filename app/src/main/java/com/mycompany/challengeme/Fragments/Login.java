package com.mycompany.challengeme.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mycompany.challengeme.MainActivity;
import com.mycompany.challengeme.R;

/**
 * Created by joshua on 5/23/2016.
 */
public class Login extends Fragment {

    EditText etPhoneNumber;
    EditText etPassword;
    Button bLogin;
    Button bRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_login, parent,false);
        //Buttons from "fragment_login".
        bLogin = (Button)v.findViewById(R.id.bLogin);
        bRegister = (Button)v.findViewById(R.id.bRegister);

        //EditTexts from "fragment_login".
        etPassword = (EditText)v.findViewById(R.id.etPassWord);
        etPhoneNumber = (EditText)v.findViewById(R.id.etPhoneNumber);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Registration regisFrag = new Registration();
                FragmentManager fm =  getFragmentManager();
                        fm.beginTransaction()
                                .replace(R.id.fContainer, regisFrag)
                                .commit();
            }
        });


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);


            }
        });


        return v;

    }
}
