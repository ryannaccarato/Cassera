package com.example.ryann9309.cassera;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LessonActivity extends AppCompatActivity {

    public static final String EXTRA_JSON_OBJECT = "jsonObject";
    private ListView mListView;
    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        setupUI();
    }

    private void setupUI() {
        mListView = (ListView)findViewById(R.id.listView_Lessons);
        Intent i = getIntent();
        final String json = i.getStringExtra(EXTRA_JSON_OBJECT);
        final ObjectMapper mapper = new ObjectMapper();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    StudentInfo info = mapper.readValue(json, StudentInfo.class);
                    mAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, info.getAvailableSubscriptions()) {
                    };
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (mAdapter != null)
                    mListView.setAdapter(mAdapter);
            }
        }.execute();
    }
}
