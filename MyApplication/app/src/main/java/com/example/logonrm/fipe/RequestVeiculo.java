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

public class RequestVeiculo implements Response.Listener<JSONArray> {

    private ArrayAdapter<Veiculo> adpVeiculo;

    public RequestVeiculo(ArrayAdapter<Veiculo> adpVeiculo) {
        this.adpVeiculo = adpVeiculo;
    }

    @Override
    public void onResponse(JSONArray response) {
        Log.i("FIPE", response.toString());

        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject objeto = response.getJSONObject(i);
                Veiculo veiculo = new Veiculo(objeto.getString("fipe_name"), objeto.getInt("id"));
                adpVeiculo.add(veiculo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
