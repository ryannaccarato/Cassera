package com.example.ryann9309.cassera.LoggedIn;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.example.ryann9309.cassera.Model.AvailableLessonsItem;
import com.example.ryann9309.cassera.Model.CurrentLesson;
import com.example.ryann9309.cassera.Model.StudentAssignmentsItem;
import com.example.ryann9309.cassera.Model.StudentInfo;
import com.example.ryann9309.cassera.R;
import com.example.ryann9309.cassera.Util.LessonsExpandableListAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.List;

public class LessonsFragment extends Fragment implements View.OnClickListener {

    //region Fields
    private StudentInfo mStudentInfo;
    private CurrentLesson mCurrentLesson;
    private TextView mLessonNumber, mAssignments, mIntensity;
    private ExpandableListView mPreviousLessons;
    private LessonsExpandableListAdapter mLessonsExpandableListAdapter;
    //endregion

    //region Constructor
    public static LessonsFragment build(StudentInfo studentInfo) {
        LessonsFragment lessonsFragment = new LessonsFragment();
        lessonsFragment.mStudentInfo = studentInfo;
        lessonsFragment.mCurrentLesson = studentInfo.currentSubscription.currentLesson;
        return lessonsFragment;
    }
    //endregion

    //region Public
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLessonNumber = (TextView) view.findViewById(R.id.textView_LessonsFragment_LessonNumber);
        mAssignments = (TextView) view.findViewById(R.id.textView_LessonsFragment_Assignments);
        mIntensity = (TextView) view.findViewById(R.id.textView_LessonsFragment_Intensity);
        mPreviousLessons = (ExpandableListView) view.findViewById(R.id.expandableListView_LessonsFragment_PreviousLessons);
        setupUI();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lessons, container, false);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity(), LessonAssignmentsActivity.class);
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(mStudentInfo);
            i.putExtra(LessonAssignmentsActivity.EXTRA_JSON_OBJECT, json);
        }
        catch (Exception e) { e.printStackTrace(); }
        startActivity(i);
    }
    //endregion

    //region Private
    private void setupUI() {
        if (mCurrentLesson != null) {
            List<StudentAssignmentsItem> assignments = mCurrentLesson.studentAssignments;
            mAssignments.setText((assignments == null ? 0 : assignments.size()) + " Assignments");
            mIntensity.setText("Medium Intensity");
        }
        List<AvailableLessonsItem> availableLessonsItems = mStudentInfo.currentSubscription.availableLessons;
        if (availableLessonsItems == null)
            mLessonNumber.setText("Lesson: " + 1);
        else {
            mLessonNumber.setText("Lesson: " + (availableLessonsItems.size() + 1));
            mLessonsExpandableListAdapter = new LessonsExpandableListAdapter(getActivity(), availableLessonsItems);
            mPreviousLessons.setAdapter(mLessonsExpandableListAdapter);
        }
        mAssignments.setOnClickListener(this);
        mIntensity.setOnClickListener(this);
        mLessonNumber.setOnClickListener(this);
    }
    //endregion
}
