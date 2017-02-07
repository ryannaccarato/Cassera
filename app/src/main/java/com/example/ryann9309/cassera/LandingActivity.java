package com.example.ryann9309.cassera;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LandingActivity extends AppCompatActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private Button mLogin, mFreeTrial;
    private ImageView mDot1, mDot2, mDot3, mDot4, mDot5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        setupUI();
    }

    private void setupUI() {
        mPager = (ViewPager) findViewById(R.id.viewPager_LandingActivity_Main);
        mPager.addOnPageChangeListener(new SimpleViewPagerChangeListener() {
            @Override
            public void onPageSelected(int position) { setDot(position); }
        });
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mDot1 = (ImageView)findViewById(R.id.imageView_LandingActivity_Dot_1);
        mDot2 = (ImageView)findViewById(R.id.imageView_LandingActivity_Dot_2);
        mDot3 = (ImageView)findViewById(R.id.imageView_LandingActivity_Dot_3);
        mDot4 = (ImageView)findViewById(R.id.imageView_LandingActivity_Dot_4);
        mDot5 = (ImageView)findViewById(R.id.imageView_LandingActivity_Dot_5);
        setDot(0);
        mLogin = (Button)findViewById(R.id.button_LandingActivity_Login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
        mFreeTrial = (Button)findViewById(R.id.button_LandingActivity_FreeTrial);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Landing_1_Fragment();
                case 1:
                    return new Landing_2_Fragment();
                case 2:
                    return new Landing_3_Fragment();
                case 3:
                    return new Landing_4_Fragment();
                case 4:
                    return new Landing_5_Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    private void setDot(int page) {
        int lightDot = R.drawable.light_grey_dot;
        int darkDot = R.drawable.dark_grey_dot;
        mDot1.setImageResource(lightDot);
        mDot2.setImageResource(lightDot);
        mDot3.setImageResource(lightDot);
        mDot4.setImageResource(lightDot);
        mDot5.setImageResource(lightDot);
        switch (page) {
            case 0:
                mDot1.setImageResource(darkDot);
                break;
            case 1:
                mDot2.setImageResource(darkDot);
                break;
            case 2:
                mDot3.setImageResource(darkDot);
                break;
            case 3:
                mDot4.setImageResource(darkDot);
                break;
            case 4:
                mDot5.setImageResource(darkDot);
                break;
        }
    }
}
