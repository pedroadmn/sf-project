package com.example.safra;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private SharedPreferences prefs;
    private String USER_TOKEN = "user_token";

    public SessionManager(Context context) {
        this.prefs = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    /**
     * Function to save auth token
     */
    public void saveAuthToken(String token) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_TOKEN, token);
        editor.apply();
    }

    /**
     * Function to fetch auth token
     */
    public String fetchAuthToken() {
        return prefs.getString(USER_TOKEN, null);
    }
}
