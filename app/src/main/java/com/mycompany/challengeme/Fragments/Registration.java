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
    private Button bSubmit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, parent, false);
        Firebase.setAndroidContext(getActivity());
        if (fbRef == null) {
            fbRef = new Firebase(FIREBASE_URL);
        }
        final Firebase userRef = fbRef.child("users");

        etFirstName = (EditText) v.findViewById(R.id.etFirst);
        etLastName = (EditText) v.findViewById(R.id.etLast);
        etPhoneNumber = (EditText) v.findViewById(R.id.etPhoneNumber);
        bSubmit = (Button) v.findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String First;
                String Last;
                String Phone;

                First = etFirstName.getText().toString();
                Last = etLastName.getText().toString();
                Phone = etPhoneNumber.getText().toString();

                if(!First.equals("") || !Last.equals("") || !Phone.equals("")) {

                    User user = new User(First,Last,Phone);
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
                } else {
                    //Do some sort of alert to tell user to input all fields.
                }

                Toast toast = Toast.makeText(getActivity(),"Registration Successful!",Toast.LENGTH_LONG);
                toast.show();

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
