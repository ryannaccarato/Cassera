package com.example.ryann9309.cassera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class LessonActivity extends AppCompatActivity {

    public static final String EXTRA_JSON_OBJECT = "jsonObject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        setupUI();
    }

    private void setupUI() {
        Intent i = getIntent();
        try {
            JSONObject object = new JSONObject(i.getStringExtra(EXTRA_JSON_OBJECT));
            Toast.makeText(this, object.toString(), Toast.LENGTH_LONG).show();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
