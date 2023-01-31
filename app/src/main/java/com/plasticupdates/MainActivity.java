package com.plasticupdates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;

import com.plasticupdates.Adapter.ViewPagerAdapter;
import com.plasticupdates.activity.ChangePasswordActivity;
import com.plasticupdates.activity.profile.EditProfileActivity;
import com.plasticupdates.activity.GlobalNewsDetailActivity;
import com.plasticupdates.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    // creating object of ViewPager
    ViewPager mViewPager;
    final Handler handler = new Handler();
    Runnable runnable = null;
    Runnable finalRunnable = runnable;
    int page=0;

            // images array
    String[] heading = {"Crude Oil Prices Slip On Wednesday","Crude Oil Prices Slip On Wednesday",
            "Crude Oil Prices Slip On Wednesday"};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        getSupportActionBar().hide();


        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        mViewPager.setPageMargin(10);
        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(MainActivity.this, heading);
        startAutoSlider(mViewPagerAdapter.getCount());


        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);



        mainBinding.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( mainBinding.homeDrawer.isDrawerOpen(GravityCompat.START)) {
                    mainBinding.homeDrawer.closeDrawer(GravityCompat.START);
                } else {
                    mainBinding.homeDrawer.openDrawer(Gravity.LEFT);
                }
            }
        });

        mainBinding.homeDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        mainBinding.imgGlobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GlobalNewsDetailActivity.class);
                startActivity(intent);
            }
        });


    }
    public void onEditProfileClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
        startActivity(intent);
    }
    public void onchanePassClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, ChangePasswordActivity.class);
        startActivity(intent);
    }
    private void startAutoSlider(final int count) {

        final Handler mHandler = new Handler();
        final Runnable mUpdateResults = new Runnable() {
            public void run() {
                int numPages = mViewPagerAdapter.getCount();
                page = (page + 1) % numPages;
                mViewPager.setCurrentItem(page);
            //    mViewPager.setCurrentItem(page++);

            }
        };

        int delay = 1000; // delay for 1 sec.

        int period = 4000; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);

    }
    @Override
    public void onDestroy() {
        if (runnable != null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}