package com.example.frasesinspiradoras.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.example.frasesinspiradoras.controller.AppController;
import com.example.frasesinspiradoras.model.Frase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FraseData {

    ArrayList<Frase> fraseArrayList = new ArrayList<>();

    public void getFrases(final QuoteListAsyncResponse callback){
        String url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20";

        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i<response.length(); i++){
                    try {
                        JSONObject quoteObject = response.getJSONObject(i);
                        Frase frase = new Frase();
                        frase.setFrase(quoteObject.getString("quote"));
                        frase.setAutor(quoteObject.getString("name"));

                        Log.d("STUFF::", quoteObject.getString("name"));
                        fraseArrayList.add(frase);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (null !=callback) callback.processFinished(fraseArrayList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }

}
