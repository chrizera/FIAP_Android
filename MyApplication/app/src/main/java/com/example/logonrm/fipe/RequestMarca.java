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

public class RequestMarca implements Response.Listener<JSONArray> {

    private ArrayAdapter<Marca> adpMarca;

    public RequestMarca(ArrayAdapter<Marca> adpMarca) {
        this.adpMarca = adpMarca;
    }

    @Override
    public void onResponse(JSONArray response) {
        Log.i("FIPE", response.toString());

        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject objeto = response.getJSONObject(i);
                Marca marca = new Marca(objeto.getString("fipe_name"), objeto.getInt("id"));
                adpMarca.add(marca);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
