package com.example.safra.tools;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonResponse {
    private  final int statusCode;
    private JsonObject json;
    private JsonArray jsonArray;

    JsonResponse(JsonObject json, int statusCode){
        this.statusCode = statusCode;
        this.json = json;
    }
    JsonResponse(JsonArray json, int statusCode){
        this.statusCode = statusCode;
        this.jsonArray = json;
    }
    public int getStatusCode(){
        return  statusCode;
    }
    public JsonObject getJson(){
        return  json;
    }
    public JsonArray getJsonArray(){return  jsonArray;}
}
