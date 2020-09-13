package com.example.safra.tools;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class HTTPRequest{
    private final String urlString;
    private List<Params> params = null;
    private final int timeOut;
    private int statusCode = 0;
    private JsonObject json = null;
    private JsonArray jsonArray = null;
    private final String method;

    public HTTPRequest(String urlString, List<Params> params, int timeOut, String method){
        this.urlString = urlString;
        this.params = params;
        this.timeOut = timeOut;
        this.method = method;
    }
    public HTTPRequest(String urlString, int timeOut, String method){
        this.urlString = urlString;
        this.timeOut = timeOut;
        this.method = method;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public JsonResponse getResponse(String body) {
        try {
            StringBuilder requestUrl = new StringBuilder(urlString);
            if(params != null && params.size() > 0) {
                requestUrl.append("?");
                for (int i = 0; i < params.size(); i++) {
                    if (i > 0) {
                        requestUrl.append("&");
                    }
                    requestUrl.append(params.get(i).getValues());
                }
            }
            URL url = new URL(requestUrl.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(method);
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(timeOut);
            con.setReadTimeout(timeOut);
            if(!body.isEmpty()){
                try(OutputStream os = con.getOutputStream()) {
                    byte[] input = body.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
            }

            int status = con.getResponseCode();
            statusCode = status;
            if (status == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                String read = content.toString();
                json = new JsonParser().parse(read).getAsJsonObject();
            }
            con.disconnect();
        } catch (Exception e) {
            System.out.println("deu ruim"+e);
        }
        return new JsonResponse(json, statusCode);
    }

    public JsonResponse getResponseArray() {
        try {
            StringBuilder requestUrl = new StringBuilder(urlString);
            if(params != null && params.size() > 0) {
                requestUrl.append("?");
                for (int i = 0; i < params.size(); i++) {
                    if (i > 0) {
                        requestUrl.append(",");
                    }
                    requestUrl.append(params.get(i).getValues());
                }
            }
            URL url = new URL(requestUrl.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(timeOut);
            con.setReadTimeout(timeOut);

            int status = con.getResponseCode();
            statusCode = status;
            if (status == 200) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                String read = content.toString();
                jsonArray = new JsonParser().parse(read).getAsJsonArray();
            }
            con.disconnect();
        } catch (Exception e) {
            System.out.println("deu ruim"+e);
        }
        return new JsonResponse(jsonArray, statusCode);
    }
}