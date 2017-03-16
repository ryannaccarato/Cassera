package com.example.ryann9309.cassera.LoggedIn;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.example.ryann9309.cassera.Model.AvailableLessonsItem;
import com.example.ryann9309.cassera.Model.CurrentLesson;
import com.example.ryann9309.cassera.Model.StudentAssignmentsItem;
import com.example.ryann9309.cassera.Model.StudentInfo;
import com.example.ryann9309.cassera.R;
import com.example.ryann9309.cassera.Util.FeedbackExpandableListAdapter;
import java.util.List;

public class FeedbackFragment extends Fragment {

    //region Fields
    private TextView mCurrentLessonNumber, mAssignments;
    private Button mAssignmentFeedback;
    private StudentInfo mStudentInfo;
    private ExpandableListView mExpandableListView;
    private FeedbackExpandableListAdapter mFeedbackExpandableListAdapter;
    private CurrentLesson mCurrentLesson;
    //endregion

    //region Constructor
    public static FeedbackFragment build(StudentInfo studentInfo) {
        FeedbackFragment fragment = new FeedbackFragment();
        fragment.mStudentInfo = studentInfo;
        fragment.mCurrentLesson = studentInfo.currentSubscription.currentLesson;
        return fragment;
    }
    //endregion

    //region Public
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
    //endregion

    //region Private
    private void setupUI() {
        List<AvailableLessonsItem> availableLessonsItems = mStudentInfo.currentSubscription.availableLessons;
        if (availableLessonsItems == null)
            mCurrentLessonNumber.setText(String.format("Lesson %1$s Feedback", 1));
        else {
            mCurrentLessonNumber.setText(String.format("Lesson %1$s Feedback", (availableLessonsItems.size() + 1)));
            mFeedbackExpandableListAdapter = new FeedbackExpandableListAdapter(getActivity(), availableLessonsItems);
            mExpandableListView.setAdapter(mFeedbackExpandableListAdapter);
        }

        mCurrentLessonNumber.setText(String.format("Lesson %1$s Feedback", (availableLessonsItems.size() + 1)));
        if (mCurrentLesson != null) {
            List<StudentAssignmentsItem> assignments = mCurrentLesson.studentAssignments;
            mAssignments.setText((assignments == null ? 0 : assignments.size()) + " Assignments");
        }
    }
    //endregion
}
