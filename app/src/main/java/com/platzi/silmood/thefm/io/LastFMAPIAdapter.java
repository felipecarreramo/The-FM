package com.platzi.silmood.thefm.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.platzi.silmood.thefm.io.deserializer.HypedArtistDeserializer;
import com.platzi.silmood.thefm.io.deserializer.TopArtistDeserializer;
import com.platzi.silmood.thefm.io.model.HypedArtistsResponse;
import com.platzi.silmood.thefm.io.model.TopArtistsResponse;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by diseno_01 on 10/07/15.
 */
public class LastFMAPIAdapter {


    private static LastFmAPIService API_SERVICE;
    public static LastFmAPIService getApiService(){

        if (API_SERVICE == null){

            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(APIConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFMApiGsonConverter())
                    .build();

            API_SERVICE = adapter.create(LastFmAPIService.class);
        }

        return API_SERVICE;
    }

    private static GsonConverter buildLastFMApiGsonConverter() {

        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(HypedArtistsResponse.class, new HypedArtistDeserializer())
                .registerTypeAdapter(TopArtistsResponse.class, new TopArtistDeserializer())
                .create();

        return new GsonConverter(gsonConf);
    }


}
