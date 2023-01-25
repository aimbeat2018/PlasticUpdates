package com.plasticupdates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.plasticupdates.activity.ChangePasswordActivity;
import com.plasticupdates.activity.EditProfileActivity;
import com.plasticupdates.activity.GlobalNewsDetailActivity;
import com.plasticupdates.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        getSupportActionBar().hide();

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

}