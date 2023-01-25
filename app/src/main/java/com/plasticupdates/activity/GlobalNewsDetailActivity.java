package com.plasticupdates.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.plasticupdates.R;
import com.plasticupdates.databinding.ActivityGlobalNewsDetailBinding;

public class GlobalNewsDetailActivity extends AppCompatActivity {
    ActivityGlobalNewsDetailBinding globalNewsDetailBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        globalNewsDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_global_news_detail);
        getSupportActionBar().hide();
        globalNewsDetailBinding.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GlobalNewsDetailActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        globalNewsDetailBinding.imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}