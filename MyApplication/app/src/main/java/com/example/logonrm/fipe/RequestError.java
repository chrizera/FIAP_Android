package com.example.logonrm.fipe;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by logonrm on 11/05/2017.
 */

public class RequestError implements Response.ErrorListener {
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("FIPE", "Erro: " + error.getMessage());
    }
}
