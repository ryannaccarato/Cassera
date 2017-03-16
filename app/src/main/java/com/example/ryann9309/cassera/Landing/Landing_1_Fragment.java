package com.example.ryann9309.cassera.Landing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import com.example.ryann9309.cassera.R;

public class Landing_1_Fragment extends Fragment {

    //region Public
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_landing_1, container, false);
        return rootView;
    }
    //endregion
}
