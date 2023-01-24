package com.plasticupdates.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.plasticupdates.MainActivity;
import com.plasticupdates.R;
import com.plasticupdates.databinding.ActivityChangePasswordBinding;

public class ChangePasswordActivity extends AppCompatActivity {
    ActivityChangePasswordBinding changePasswordBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changePasswordBinding = DataBindingUtil.setContentView(this,R.layout.activity_change_password);
        getSupportActionBar().hide();

    }
}