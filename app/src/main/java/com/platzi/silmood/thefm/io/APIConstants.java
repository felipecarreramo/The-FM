package com.platzi.silmood.thefm.io;

/**
 * Created by diseno_01 on 10/07/15.
 */
public class APIConstants {

    public static final String URL_BASE = "http://ws.audioscrobbler.com";
    public static final String API_KEY = "4c8ab7a3e9b99fe4834bf6aeb7594b82";
    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_API_KEY = "api_key";

    public static final String VALUE_HYPED_ARTISTS_METHOD = "chart.gethypedartists";
    public static final String VALUE_JSON = "json";

    public static final String URL_HYPED_ARTISTS = PATH_VERSION+"?" + PARAM_API_KEY + "="+API_KEY+"&"+
            PARAM_METHOD + "="+VALUE_HYPED_ARTISTS_METHOD+"&"+
            PARAM_FORMAT + "="+VALUE_JSON;

}
