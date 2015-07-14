package com.platzi.silmood.thefm;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.platzi.silmood.thefm.ui.adapter.PagerAdapter;
import com.platzi.silmood.thefm.ui.fragment.HypedArtistsFragment;
import com.platzi.silmood.thefm.ui.fragment.TopArtistsFragment;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


        setupViewPager();

       if (toolbar != null)
            setSupportActionBar(toolbar);


    }

    private void setupViewPager() {
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), buildFragments()));
        tabLayout.setupWithViewPager(viewPager);

          tabLayout.getTabAt(0).setIcon(R.drawable.ic_hyped_artists);
          tabLayout.getTabAt(1).setIcon(R.drawable.ic_top_artists);

    }

    private ArrayList<Fragment> buildFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new HypedArtistsFragment());
        fragments.add(new TopArtistsFragment());

        return fragments;
    }
}
