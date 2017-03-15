package com.example.ryann9309.cassera.LoggedIn;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.ryann9309.cassera.Model.CurrentLesson;
import com.example.ryann9309.cassera.Model.StudentAssignmentsItem;
import com.example.ryann9309.cassera.Model.StudentInfo;
import com.example.ryann9309.cassera.R;
import com.example.ryann9309.cassera.Util.GenericExpandableListAdapter;

import java.util.List;

public class FeedbackFragment extends Fragment {

    TextView mCurrentLessonNumber, mAssignments;
    Button mAssignmentFeedback;
    StudentInfo mStudentInfo;
    ExpandableListView mExpandableListView;
    GenericExpandableListAdapter mGenericExpandableListAdapter;
    CurrentLesson mCurrentLesson;

    public static FeedbackFragment build(StudentInfo studentInfo) {
        FeedbackFragment fragment = new FeedbackFragment();
        fragment.mStudentInfo = studentInfo;
        fragment.mCurrentLesson = studentInfo.currentSubscription.currentLesson;
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feedback, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCurrentLessonNumber = (TextView) view.findViewById(R.id.textView_FeedbackFragment_CurrentLessonNumber);
        mAssignments = (TextView) view.findViewById(R.id.textView_FeedbackFragment_NumberOfAssignments);
        mAssignmentFeedback = (Button)view.findViewById(R.id.button_FeedbackFragment_AssignmentFeedback);
        mExpandableListView = (ExpandableListView)view.findViewById(R.id.expandableListView_FeedbackFragment_PreviousFeedback);
        setupUI();
    }

    private void setupUI() {
        mCurrentLessonNumber.setText(String.format("Lesson %1$s Feedback", (mStudentInfo.currentSubscription.availableLessons.size() + 1)));
        if (mCurrentLesson != null) {
            List<StudentAssignmentsItem> assignments = mCurrentLesson.studentAssignments;
            mAssignments.setText((assignments == null ? 0 : assignments.size()) + " Assignments");
            mGenericExpandableListAdapter = new GenericExpandableListAdapter(getActivity(), mCurrentLesson);
            mExpandableListView.setAdapter(mGenericExpandableListAdapter);
        }
    }
}
