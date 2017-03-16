package com.example.ryann9309.cassera.LoggedIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.ryann9309.cassera.Model.StudentAssignmentsItem;
import com.example.ryann9309.cassera.Model.StudentInfo;
import com.example.ryann9309.cassera.R;
import com.example.ryann9309.cassera.Util.LessonAssignmentsExpandableListAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class LessonAssignmentsActivity extends AppCompatActivity {

    //region Fields
    public static final String EXTRA_JSON_OBJECT = "jsonObject";
    private LessonAssignmentsExpandableListAdapter mLessonAssignmentsExpandableListAdapter;
    private ExpandableListView mExpandableListView;
    //endregion

    //region Protected
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_assignments);
        setupUI();
    }
    //endregion

    //region Private
    private void setupUI() {
        mExpandableListView = (ExpandableListView)findViewById(R.id.expandableListView_LessonAssignmentsActivity_Main);
        Intent i = getIntent();
        String json = i.getStringExtra(EXTRA_JSON_OBJECT);
        ObjectMapper mapper = new ObjectMapper();
        try {
            StudentInfo studentInfo = mapper.readValue(json, StudentInfo.class);
            if (studentInfo != null && studentInfo.currentSubscription != null && studentInfo.currentSubscription.currentLesson != null) {
                List<StudentAssignmentsItem> list = studentInfo.currentSubscription.currentLesson.studentAssignments;
                if (list != null) {
                    mLessonAssignmentsExpandableListAdapter = new LessonAssignmentsExpandableListAdapter(this, list);
                    mExpandableListView.setAdapter(mLessonAssignmentsExpandableListAdapter);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //endregion
}
