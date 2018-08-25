package com.laioffer.tinnews;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;

import com.laioffer.tinnews.common.ContainerFragment;
import com.laioffer.tinnews.common.TinBasicActivity;
import com.laioffer.tinnews.common.TinBasicFragment;
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

        //add bottombar code from here
        bottomBar = findViewById(R.id.bottom_navigation);
        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                viewPager.setCurrentItem(ContainerFragment.getPositionById(item.getItemId()));
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getCurrentChildFramentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private FragmentManager getCurrentChildFramentManager() {
        return adapter.getItem(viewPager.getCurrentItem()).getChildFragmentManager();
    }

    @Override
    public void doFragmentTransaction(TinBasicFragment basicFragment) {
        FragmentTransaction fragmentTransaction = getCurrentChildFramentManager().beginTransaction();
        fragmentTransaction.replace(R.id.child_fragment_container, basicFragment, basicFragment.getFragmentTag())
                .addToBackStack(null).commit();
    }

    @Override
    public void showSnackBar(String message) {

    }
}
