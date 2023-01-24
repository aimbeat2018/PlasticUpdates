package com.plasticupdates.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.plasticupdates.MainActivity;
import com.plasticupdates.R;
import com.plasticupdates.databinding.ActivityEditProfileBinding;

public class EditProfileActivity extends AppCompatActivity {
    ActivityEditProfileBinding editProfileBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editProfileBinding = DataBindingUtil.setContentView(this,R.layout.activity_edit_profile);
        getSupportActionBar().hide();
        editProfileBinding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}