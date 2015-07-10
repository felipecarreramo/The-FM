package com.platzi.silmood.thefm.io;

import com.platzi.silmood.thefm.io.model.HypedArtistsResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by diseno_01 on 10/07/15.
 */
public interface LastFmAPIService {

    @GET(APIConstants.URL_HYPED_ARTISTS)
    void getHypedArtists(Callback<HypedArtistsResponse> serverResponse);

}
