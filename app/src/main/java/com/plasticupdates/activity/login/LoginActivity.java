package com.plasticupdates.activity.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.plasticupdates.MainActivity;
import com.plasticupdates.R;
import com.plasticupdates.activity.BaseActivity;
import com.plasticupdates.activity.RegisterActivity;

import com.plasticupdates.databinding.ActivityLoginBinding;
import com.plasticupdates.model.LoginRequestModel;

public class LoginActivity extends AppCompatActivity implements LoginContract.View  {
    ActivityLoginBinding binding;
    LoginContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        getSupportActionBar().hide();
        presenter = new LoginPresenter(this, this);
        binding.setPresenter(presenter);
        binding.setViewModel(new LoginRequestModel());
        BaseActivity.progressDialog(this);
        onTextChanged();
        /*binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
        binding.txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
*/

    }
    private void onTextChanged() {
        binding.email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              /*  if (binding.txtMobileError.getVisibility() == View.VISIBLE) {
                    binding.txtMobileError.setVisibility(View.GONE);
                }*/
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               /* if (binding.txtPasswordError.getVisibility() == View.VISIBLE) {
                    binding.txtPasswordError.setVisibility(View.GONE);
                }*/
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void showProgress() {
        BaseActivity.showProgress();
    }

    @Override
    public void hideProgress() {
        BaseActivity.hideProgress();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showError(String error, int forEdit) {
        if (forEdit == 0) {
            binding.email.setVisibility(View.VISIBLE);
            binding.email.setText(error);
        } else if (forEdit == 1) {
            binding.pass.setVisibility(View.VISIBLE);
            binding.pass.setText(error);
        } else {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }
}