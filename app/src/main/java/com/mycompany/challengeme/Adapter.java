package com.mycompany.challengeme;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.challengeme.Fragments.Challenges;
import com.mycompany.challengeme.Fragments.UserProfile;
import com.mycompany.challengeme.Fragments.Versus;

/**
 * Created by joshua on 5/21/2016.
 */
public class Adapter extends FragmentPagerAdapter{

    private String Fragment[] = {"Challenges" , "VS Friend" , "Profile"};
    public Adapter(FragmentManager fm){
        super (fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new Challenges();
            case 1:
                return new Versus();
            case 2:
                return new UserProfile();

            default:
                return null;
        }

    }

    @Override
    public int getCount(){return Fragment.length;}

@Override
public CharSequence getPageTitle(int position) {
    return Fragment[position];
}

}
