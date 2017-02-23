package com.example.ryann9309.cassera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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
        String json = i.getStringExtra(EXTRA_JSON_OBJECT);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, json, Toast.LENGTH_LONG).show();
    }
}
