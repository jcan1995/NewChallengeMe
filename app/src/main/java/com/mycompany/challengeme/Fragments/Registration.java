package com.mycompany.challengeme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.mycompany.challengeme.R;
import com.mycompany.challengeme.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joshua on 5/23/2016.
 */
public class Registration extends Fragment {

    private final String FIREBASE_URL = "https://challengeme2.firebaseio.com/";
    private Firebase fbRef;
    private HashMap<String, User> mUsers;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPhoneNumber;
    private EditText etEmail;

    private EditText etPassword;
    private EditText etConfirmPass;

    private Button bSubmit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, parent, false);
        Firebase.setAndroidContext(getActivity());
        if (fbRef == null) {
            fbRef = new Firebase(FIREBASE_URL);
        }
        final Firebase userRef = fbRef.child("users");

        etPassword = (EditText)v.findViewById(R.id.etPassword);
        etEmail = (EditText)v.findViewById(R.id.etEmail);
        etFirstName = (EditText) v.findViewById(R.id.etFirst);
        etLastName = (EditText) v.findViewById(R.id.etLast);
        etPhoneNumber = (EditText) v.findViewById(R.id.etPhoneNumber);
        etConfirmPass = (EditText) v.findViewById(R.id.etConfirmPass);

        bSubmit = (Button) v.findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String First;
                String Last;
                String Phone;
                String Email;
                String Password;
                String ConfirmPass;

                First = etFirstName.getText().toString();
                Last = etLastName.getText().toString();
                Phone = etPhoneNumber.getText().toString();
                Email = etEmail.getText().toString();

                Password = etPassword.getText().toString();
                ConfirmPass = etConfirmPass.getText().toString();
/*
                if(!Password.equals(ConfirmPass)){

                    Toast toast = Toast.makeText(getActivity(), "Need first name.", Toast.LENGTH_LONG);
                    toast.show();

                    Registration regisFrag = new Registration();
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fContainer, regisFrag)
                            .commit();


                }
*/
                if(First.equals("") || Last.equals("") || Phone.equals("")|| Email.equals("")) {

                    if(First.equals("")) {
                        Toast toast = Toast.makeText(getActivity(), "Need first name.", Toast.LENGTH_LONG);
                        toast.show();
                    }

                    else if(Last.equals("")){
                        Toast toast = Toast.makeText(getActivity(),"Need last name",Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else if(Email.equals("")){
                        Toast toast = Toast.makeText(getActivity(),"Need email",Toast.LENGTH_LONG);
                        toast.show();
                    }

                    else if(Phone.equals("")){
                        Toast toast = Toast.makeText(getActivity(),"Need phone number",Toast.LENGTH_LONG);
                        toast.show();
                    }

                    //Do some sort of alert to tell user to input all fields.
                }

                else {

                    User user = new User(First,Last,Phone,Email,Password);
                    Map<String, User> users = new HashMap<>();
                    users.put(Phone,user);

                    if (userRef == null) {
                        userRef.setValue(users);
                    } else
                        userRef.push().setValue(users);
                    //Push into Firebase.

                    etFirstName.setText("");
                    etLastName.setText("");
                    etPhoneNumber.setText("");
                    etEmail.setText("");

                    Toast toast = Toast.makeText(getActivity(),"Registration Successful!",Toast.LENGTH_LONG);
                    toast.show();

                    Login loginFrag = new Login();
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fContainer, loginFrag)
                            .commit();

                }



            }
        });
        return v;
    }
}
