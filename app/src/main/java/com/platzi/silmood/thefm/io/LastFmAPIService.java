package com.platzi.silmood.thefm.io;

import com.platzi.silmood.thefm.io.model.HypedArtistsResponse;
import com.platzi.silmood.thefm.io.model.TopArtistsResponse;

import retrofit.Callback;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by diseno_01 on 10/07/15.
 */
public interface LastFmAPIService {

    @GET(APIConstants.URL_HYPED_ARTISTS)
    void getHypedArtists(Callback<HypedArtistsResponse> serverResponse);


    @GET(APIConstants.URL_TOP_ARTISTS)
    Observable<TopArtistsResponse> getTopArtists();

}
