package com.carvalho.githubjava.helper;

public class U {
    public static final String BASE_URL = "https://api.github.com";

    public static String checkNull(String value) {
        if (value.equals("null"))
            return "";
        else return value;

    }
}
