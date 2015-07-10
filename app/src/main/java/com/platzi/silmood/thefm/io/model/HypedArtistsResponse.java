package com.platzi.silmood.thefm.io.model;

import com.google.gson.annotations.SerializedName;
import com.platzi.silmood.thefm.domain.Artist;

import java.util.ArrayList;

/**
 * Created by diseno_01 on 10/07/15.
 */
public class HypedArtistsResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResults results;

    private class HypedArtistsResults {

        @SerializedName(JsonKeys.ARTISTS_ARRAY)
        ArrayList<Artist> artists;

    }

    public ArrayList<Artist> getArtists() {
        return results.artists;
    }
}
