package com.platzi.silmood.thefm.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.silmood.thefm.R;
import com.platzi.silmood.thefm.io.LastFMAPIAdapter;
import com.platzi.silmood.thefm.io.model.TopArtistsResponse;
import com.platzi.silmood.thefm.ui.adapter.TopArtistsAdapter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopArtistsFragment extends Fragment {


    public TopArtistsFragment() {
        // Required empty public constructor
    }

    private RecyclerView topArtistsList;
    private TopArtistsAdapter topArtistsAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topArtistsAdapter = new TopArtistsAdapter(getActivity());


    }

    @Override
    public void onResume() {
        super.onResume();
        LastFMAPIAdapter.getApiService()
                .getTopArtists()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TopArtistsResponse>() {
                    @Override
                    public void call(TopArtistsResponse topArtistsResponse) {
                       topArtistsAdapter.addAll(topArtistsResponse.getArtists());
                    }
                });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_top_artists, container, false);
        topArtistsList = (RecyclerView) root.findViewById(R.id.top_artist_list);

        // Inflate the layout for this fragment
        return root;
    }

    public void setupList(){

        topArtistsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        topArtistsList.setAdapter(this.topArtistsAdapter);


    }


}
