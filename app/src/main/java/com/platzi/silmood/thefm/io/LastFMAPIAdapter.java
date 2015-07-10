package com.platzi.silmood.thefm.io;

import retrofit.RestAdapter;

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
                    .build();

            API_SERVICE = adapter.create(LastFmAPIService.class);
        }

        return API_SERVICE;
    }


}
