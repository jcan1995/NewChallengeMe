package com.mycompany.challengeme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mycompany.challengeme.Fragments.AddChallenge;

public class MainActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    FloatingActionButton bAddChallenge;

    Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bAddChallenge = (FloatingActionButton) findViewById(R.id.bAddChallenge);

        mAdapter = new Adapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.vPager);
        mViewPager.setAdapter(mAdapter);
        mTabLayout = (TabLayout) findViewById(R.id.tlTabLayout);

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
        });

        bAddChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bAddChallenge.hide();
                Fragment newFragment = new AddChallenge();
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.fFragmentContainer, newFragment)
                        .commit();

            }
        });
    }






}
