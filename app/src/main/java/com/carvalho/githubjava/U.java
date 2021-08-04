package com.carvalho.githubjava;

public class U {
    public static final String BASE_URL = "https://api.github.com";

    public static String checkNull(String value) {
        if (value.equals("null"))
            return "";
        else return value;

    }
}
