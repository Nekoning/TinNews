package com.laioffer.tinnews;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.laioffer.tinnews.common.TinBasicActivity;
import com.laioffer.tinnews.common.TinFragmentPagerAdapter;

public class MainActivity extends TinBasicActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomBar;
    private TinFragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link view pager with view
        viewPager = findViewById(R.id.viewpager);
        adapter = new TinFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(TinFragmentPagerAdapter.FRAGMENT_NUMBER);
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showSnackBar(String message) {

    }
}
