package com.mycompany.challengeme;

/**
 * Created by joshua on 5/23/2016.
 */
public class User {
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String Email;
    private String Password;

    public User(){}

    public User(String F, String L, String P, String E, String Pass){

        FirstName = F;
        LastName = L;
        PhoneNumber = P;
        Email = E;
        Password = Pass;

    }
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
