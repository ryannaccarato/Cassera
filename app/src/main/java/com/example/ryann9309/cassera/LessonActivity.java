package com.example.ryann9309.cassera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LessonActivity extends AppCompatActivity {

    ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        setupUI();
    }

    private void setupUI() {
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, new String[] { getString(R.string.lessonActivity_EmptyLessonsList) });
        ListView listView = (ListView)findViewById(R.id.listView_LessonActivity);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), R.string.lessonActivity_ItemClickedToast, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
