package com.plasticupdates.activity.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.plasticupdates.MainActivity;
import com.plasticupdates.R;
import com.plasticupdates.activity.register.RegisterContract;
import com.plasticupdates.databinding.ActivityEditProfileBinding;
import com.plasticupdates.model.MainModel;

import org.json.JSONException;
import org.json.JSONObject;

public class EditProfileActivity extends AppCompatActivity implements ProfileContract.View {
    ActivityEditProfileBinding editProfileBinding;
    ProfileContract.Presenter profilePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editProfileBinding = DataBindingUtil.setContentView(this,R.layout.activity_edit_profile);
        getSupportActionBar().hide();
        profilePresenter=new ProfilePresenter(this,this);
        editProfileBinding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
        editProfileBinding.imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void saveProfileData(View view)
    {
        profilePresenter.updateProfileData(editProfileBinding.edtFirsttname.getText().toString(),editProfileBinding.edtName.getText().toString(),
                editProfileBinding.edtEmail.getText().toString(), editProfileBinding.edtPhone.getText().toString(),
                editProfileBinding.edtCompanyname.getText().toString(),  editProfileBinding.edtCompanyphone.getText().toString(),
                editProfileBinding.edtCompanyaddress.getText().toString(), "India","Maharashtra",
                editProfileBinding.edtCity.getText().toString(),editProfileBinding.edtDepart.getText().toString(),
                editProfileBinding.edtJob.getText().toString(),editProfileBinding.edtTurnover.getText().toString());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void profileUpdateSuccess(JSONObject jsonObject) {
        try {
            String message = jsonObject.getString("message");
            String code = jsonObject.getString("code");
            if (code.equals("200")) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            }
            else if (code.equals("201")) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            }
        }
        catch (JSONException exception)
        {

        }


    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showError(String error, int forEdit) {

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }
}