package com.mycompany.challengeme;

/**
 * Created by joshua on 5/23/2016.
 */
public class User {

    String FirstName;
    String LastName;
    String PhoneNumber;

    public User(String F, String L, String P){

        FirstName = F;
        LastName = L;
        PhoneNumber = P;

    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
