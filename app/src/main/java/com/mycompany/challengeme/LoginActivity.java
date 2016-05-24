package com.mycompany.challengeme;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.mycompany.challengeme.Fragments.Login;

/**
 * Created by joshua on 5/21/2016.
 */

public class LoginActivity extends FragmentActivity {

   // Button bLogin;
   // Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

// Check that the activity is using the layout version with the fragment_container FrameLayout
        if(findViewById(R.id.fContainer) != null) {
            // if we are being restored from a previous state, then we dont need to do anything and should
            // return or else we could end up with overlapping fragments.
            if (savedInstanceState != null)
                return;

            // Create an instance of editorFrag
            Login loginFrag = new Login();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fContainer, loginFrag)
                    .commit();
        }



/*
        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/
/*

        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment newFragment = new Registration();
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.fFragmentContainer, newFragment)
                        .commit();
            }
        });
*/
    }




}
