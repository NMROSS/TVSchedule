package com.example.nick.tvschedule;


import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 14/03/17.
 */

public class tvAPI extends MainActivity{
    private RequestQueue request;
    private Activity activity;
    private String url = "https://api.thetvdb.com/login";
    private String apiKey = "";
    private String userKey = "";
    private String userName = "";



    // Constructor
    public tvAPI(Activity activity) {
        this.activity = activity;
        request = getVolleyRequest();

        getToken(apiKey, userKey, userName);
    }

    /***
     * Volley Request queue singelton
     * @return Volley request queue
     */
    private RequestQueue getVolleyRequest(){
        if (request == null){
            request = Volley.newRequestQueue(activity);
        }
        return request;
    }

    /***
     *
     * @param data
     * @param request
     */
    private void newRequest(final JSONObject data, RequestQueue request, Response.Listener<Season> a) {

    }


    private void getToken(String apiKey, String userKey, String username) {
        String token = "";

        // create authentication JSON obj
        JSONObject authDetails = new JSONObject();
        try {
            authDetails.put("apikey", apiKey);
            authDetails.put("username", username);
            authDetails.put("userkey", userKey);
        } catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest requestJSON = new JsonObjectRequest(Request.Method.POST, url, authDetails, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Success", response.toString());
                try {
                    Log.d("Success", response.getString("token"));
                } catch (JSONException e){
                    Log.e("J Fail", e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("FAIL", error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders(){
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        request.add(requestJSON);
    }

    public String getShowInfo(String showName) {
        String result = "";

        return result;
    }
}
