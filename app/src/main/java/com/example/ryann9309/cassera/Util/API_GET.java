package com.example.ryann9309.cassera.Util;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class API_GET {

    //region Public
    public static boolean getSubscriptions(final Context context, final String username, final String password, final JSONResponse jsonResponse) {
        RequestQueue queue =  Volley.newRequestQueue(context);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                "https://caasera.azurewebsites.net/api/1.0/student",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        jsonResponse.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String credentials = username + ":" + password;
                String auth = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headers.put("Authorization", auth);
                return headers;
            }
        };
        queue.add(jsonRequest);
        return false;
    }
    //endregion

    //region Sub-Classes
    public interface JSONResponse {
        void onSuccess(JSONObject object);
    }
    //endregion
}
