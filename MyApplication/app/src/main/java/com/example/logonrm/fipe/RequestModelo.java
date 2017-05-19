package com.example.logonrm.fipe;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by logonrm on 11/05/2017.
 */

public class RequestModelo implements Response.Listener<JSONArray> {

    private ArrayAdapter<Modelo> adpModelo;

    public RequestModelo(ArrayAdapter<Modelo> adpModelo) {
        this.adpModelo = adpModelo;
    }

    @Override
    public void onResponse(JSONArray response) {
        Log.i("FIPE", response.toString());

        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject objeto = response.getJSONObject(i);
                Modelo modelo = new Modelo(objeto.getString("fipe_name"), objeto.getInt("id"));
                adpModelo.add(modelo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
