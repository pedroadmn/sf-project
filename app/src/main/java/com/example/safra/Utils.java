package com.example.safra;

import android.content.Context;
import android.util.Base64;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, String> getHeaders(Context context) {
        SessionManager sessionManager = new SessionManager(context);
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization",
                String.format(Constants.HTTP_AUTHORIZATION_VALUE_PREFIX, sessionManager.fetchAuthToken()));
        return headers;
    }

    public static Map<String, String> getTokenRequestHeaders(String clientId, String clientSecret) {
        Map<String, String> headers = new HashMap<>();
        String base64Secret = "Basic "
                + (Base64.encodeToString((clientId
                + ":"
                + clientSecret).getBytes(), Base64.NO_WRAP));
        headers.put("Authorization", base64Secret);

        return headers;
    }
}
