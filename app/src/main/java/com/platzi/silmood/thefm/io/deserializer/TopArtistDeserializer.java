package com.platzi.silmood.thefm.io.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.platzi.silmood.thefm.domain.Artist;
import com.platzi.silmood.thefm.io.model.JsonKeys;
import com.platzi.silmood.thefm.io.model.TopArtistsResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Felipe Carrera on 13/07/15.
 */
public class TopArtistDeserializer implements JsonDeserializer<TopArtistsResponse> {

    @Override
    public TopArtistsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        TopArtistsResponse response = gson.fromJson(json, TopArtistsResponse.class);
        JsonObject artistsResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULTS);
        JsonArray artistsArray = artistsResponseData.getAsJsonArray(JsonKeys.ARTISTS_ARRAY);
        response.setArtists(extractArtistsFromJsonArray(artistsArray));

        return response;
    }

    private ArrayList<Artist> extractArtistsFromJsonArray(JsonArray array){

        ArrayList<Artist> artists = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JsonObject artistData =  array.get(i).getAsJsonObject();
            Artist currentArtist = new Artist();
            String name =  artistData.get(JsonKeys.ARTIST_NAME).getAsString();
            String playcount =  artistData.get(JsonKeys.ARTISTS_PLAYCOUNT).getAsString();
            String listeners =  artistData.get(JsonKeys.ARTISTS_LISTENERS).getAsString();



            JsonArray imagesArray = artistData.getAsJsonArray(JsonKeys.ARTISTS_IMAGES);
            String[] images = extractArtistImagesFromJsonArray(imagesArray);

            currentArtist.setName(name);
            currentArtist.setPlaycount(playcount);
            currentArtist.setListeners(listeners);
            currentArtist.setUrlMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            artists.add(currentArtist);
        }

        return artists;
    }


    private String[] extractArtistImagesFromJsonArray(JsonArray imagesArrays){

        String[] images = new String[2];
        for (int i = 0; i < imagesArrays.size(); i++) {
            JsonObject imagesData = imagesArrays.get(i).getAsJsonObject();

            String size = imagesData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = imagesData.get(JsonKeys.IMAGE_URL).getAsString();

            if (url.isEmpty())
                url = null;
            else
                url.replaceAll("\\/","/");

            if (size.matches(JsonKeys.IMAGE_MEDIUM))
                images[0] = url;
            else if (size.matches(JsonKeys.IMAGE_LARGE))
                images[1] = url;
        }

        return images;
    }
}