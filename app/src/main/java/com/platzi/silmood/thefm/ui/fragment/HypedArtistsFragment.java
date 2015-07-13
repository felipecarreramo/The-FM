package com.platzi.silmood.thefm.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.silmood.thefm.R;
import com.platzi.silmood.thefm.domain.Artist;
import com.platzi.silmood.thefm.io.LastFMAPIAdapter;
import com.platzi.silmood.thefm.io.model.HypedArtistsResponse;
import com.platzi.silmood.thefm.ui.ItemOffsetDecoration;
import com.platzi.silmood.thefm.ui.adapter.HypedArtistsAdapter;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Created by Pedro Hernández on 07/2015.
 */

public class HypedArtistsFragment extends Fragment implements Callback<HypedArtistsResponse> {

    public static final int NUM_COLUMNS = 2;

    public static final String LOG_TAG = HypedArtistsFragment.class.getName();

    private RecyclerView mHypedArtistsList;
    private HypedArtistsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new HypedArtistsAdapter(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();

        LastFMAPIAdapter.getApiService()
                .getHypedArtists(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hyped_artists, container, false);
        mHypedArtistsList = (RecyclerView) root.findViewById(R.id.hyped_artists_list);

        setupArtitsList();
       // setDummyContent();

        return root;
    }

    private void setupArtitsList(){
        mHypedArtistsList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMNS));
        mHypedArtistsList.setAdapter(this.adapter);
        mHypedArtistsList.addItemDecoration(new ItemOffsetDecoration(getActivity(),R.integer.offset));
    }

    private void setDummyContent(){

        ArrayList<Artist> artists = new ArrayList<>();
        for (int i = 0 ; i < 50; i++){
            artists.add(new Artist("Artist "+i));
        }

        this.adapter.addAll(artists);
    }

    @Override
    public void success(HypedArtistsResponse hypedArtistsResponse, Response response) {
        adapter.addAll(hypedArtistsResponse.getArtists());
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}
