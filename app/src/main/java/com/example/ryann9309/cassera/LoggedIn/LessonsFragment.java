package com.example.ryann9309.cassera.LoggedIn;

import android.app.Fragment;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ryann9309.cassera.Model.AvailableLessonsItem;
import com.example.ryann9309.cassera.Model.CurrentLesson;
import com.example.ryann9309.cassera.Model.StudentInfo;
import com.example.ryann9309.cassera.R;

import java.util.ArrayList;
import java.util.List;

public class LessonsFragment extends Fragment {

    StudentInfo mStudentInfo;
    CurrentLesson mCurrentLesson;
    TextView mLessonNumber, mAssignments, mIntensity;
    ListView mPreviousLessonsList;
    ArrayAdapter mPreviousLessonsAdapter;

    public static LessonsFragment build(StudentInfo studentInfo) {
        LessonsFragment lessonsFragment = new LessonsFragment();
        lessonsFragment.mStudentInfo = studentInfo;
        lessonsFragment.mCurrentLesson = studentInfo.currentSubscription.currentLesson;
        return lessonsFragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLessonNumber = (TextView) view.findViewById(R.id.textView_LessonsFragment_LessonNumber);
        mAssignments = (TextView) view.findViewById(R.id.textView_LessonsFragment_Assignments);
        mIntensity = (TextView) view.findViewById(R.id.textView_LessonsFragment_Intensity);
        mPreviousLessonsList = (ListView)view.findViewById(R.id.listView_LessonsFragment_PreviousLessons);
        setupUI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lessons, container, false);
        return view;
    }

    private void setupUI() {
        mLessonNumber.setText("Lesson: " + mStudentInfo.currentSubscription.availableLessons.size());
        mAssignments.setText((mCurrentLesson.studentAssignments.size() + 1) + " Assignments");
        mIntensity.setText("Medium Intensity");
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                mPreviousLessonsList.setAdapter(mPreviousLessonsAdapter);
            }

            @Override
            protected Void doInBackground(Void... params) {
                List<AvailableLessonsItem> availableLessons = mStudentInfo.currentSubscription.availableLessons;
                String[] names = new String[availableLessons.size()];
                for(int i = 0; i < availableLessons.size(); i++) {
                    String name = availableLessons.get(i).title;
                    names[i] = name != null ? name : "Generic Lesson " + i;
                }
                mPreviousLessonsAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1, names);
                return null;
            }
        }.execute();
    }
}
