package com.platzi.silmood.thefm;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import com.platzi.silmood.thefm.ui.fragment.TopArtistsFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new TopArtistsFragment())
                    .commit();
        }
    }
}
