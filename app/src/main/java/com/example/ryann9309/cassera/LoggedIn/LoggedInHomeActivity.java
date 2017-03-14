package com.example.ryann9309.cassera.LoggedIn;


import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.ryann9309.cassera.R;
import com.example.ryann9309.cassera.Model.StudentInfo;
import com.example.ryann9309.cassera.Util.SimpleViewPagerChangeListener;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class LoggedInHomeActivity extends Activity {

    private TextView mLessons, mExercises, mFeedback;

    public static final String EXTRA_JSON_OBJECT = "jsonObject";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private boolean mSetPageManual = false;
    private StudentInfo mStudentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_home);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewPager_LoggedInHomeFragment_Main);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        setupUI();
    }

    private void setupUI() {
        Intent i = getIntent();
        final String json = i.getStringExtra(EXTRA_JSON_OBJECT);
        final ObjectMapper mapper = new ObjectMapper();
        try {
            mStudentInfo = mapper.readValue(json, StudentInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mViewPager.addOnPageChangeListener(new SimpleViewPagerChangeListener() {
            @Override
            public void onPageSelected(int position) { setPage(position); }
        });
        mLessons = (TextView) findViewById(R.id.textView_LoggedInHomeFragment_Lessons);
        mExercises = (TextView) findViewById(R.id.textView_LoggedInHomeFragment_Exercises);
        mFeedback = (TextView) findViewById(R.id.textView_LoggedInHomeFragment_Feedback);
        mLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { setPage(mLessons); }
        });
        mExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { setPage(mExercises); }
        });
        mFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { setPage(mFeedback); }
        });
        setPage(mLessons);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logged_in_home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) { super(fm); }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return LessonsFragment.build(mStudentInfo);
                case 1:
                    return ExercisesFragment.build();
                case 2:
                    return FeedbackFragment.build();
            }
            return null;
        }
        @Override
        public int getCount() { return 3; }
    }

    private void setPage(View view) {
        mSetPageManual = true;
        if (view == mLessons) {
            mViewPager.setCurrentItem(0);
            mLessons.setTypeface(Typeface.DEFAULT_BOLD);
            mExercises.setTypeface(Typeface.DEFAULT);
            mFeedback.setTypeface(Typeface.DEFAULT);
        }
        else if (view == mExercises) {
            mViewPager.setCurrentItem(1);
            mLessons.setTypeface(Typeface.DEFAULT);
            mExercises.setTypeface(Typeface.DEFAULT_BOLD);
            mFeedback.setTypeface(Typeface.DEFAULT);
        }
        else {
            mViewPager.setCurrentItem(2);
            mLessons.setTypeface(Typeface.DEFAULT);
            mExercises.setTypeface(Typeface.DEFAULT);
            mFeedback.setTypeface(Typeface.DEFAULT_BOLD);
        }
        mSetPageManual = false;
    }

    private void setPage(int i) {
        if (!mSetPageManual) {
            if (i == 0) setPage(mLessons);
            else if (i == 1) setPage(mExercises);
            else setPage(mFeedback);
        }
    }
}
