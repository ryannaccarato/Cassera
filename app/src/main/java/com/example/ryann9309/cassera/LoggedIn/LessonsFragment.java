package com.example.ryann9309.cassera.LoggedIn;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryann9309.cassera.R;

public class LessonsFragment extends Fragment {

    public static LessonsFragment build() {
        LessonsFragment lessonsFragment = new LessonsFragment();
        return lessonsFragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lessons, container, false);
        return view;
    }
}
