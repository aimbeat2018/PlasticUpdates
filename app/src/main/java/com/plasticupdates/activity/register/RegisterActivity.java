package com.plasticupdates.activity.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.plasticupdates.MainActivity;
import com.plasticupdates.R;
import com.plasticupdates.activity.login.LoginActivity;
import com.plasticupdates.activity.login.LoginContract;
import com.plasticupdates.activity.login.LoginPresenter;
import com.plasticupdates.constant.SharedPref;
import com.plasticupdates.databinding.ActivityRegisterBinding;
import com.plasticupdates.model.LoginResponseModel;
import com.plasticupdates.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    ActivityRegisterBinding registerBinding;
    RegisterContract.Presenter registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerBinding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        registerPresenter = new RegisterPresenter(this, this);
        getSupportActionBar().hide();
        registerBinding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        /*registerBinding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

    }
    public void onRegisterData(View view)
    {
        registerPresenter.registerData(registerBinding.edtEmail.getText().toString(),registerBinding.edtPassword.getText().toString(),
                registerBinding.edtName.getText().toString(), registerBinding.edtLastname.getText().toString(),
                registerBinding.edtPhone.getText().toString(),registerBinding.edtCompanyname.getText().toString(),
                registerBinding.edtCphone.getText().toString(),registerBinding.edtCompanyaddress.getText().toString(),
                "India",registerBinding.edtState.getText().toString(),registerBinding.edtCity.getText().toString());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void registeredUser(MainModel mainModel) {

        String message,code,userid="0";
        message= mainModel.getMessage();
        code= String.valueOf(mainModel.getCode());
        if (code.equals("200")){
         //   if (message.equals("User Login Successfully")) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                List<LoginResponseModel> loginResponseModelList=new ArrayList<>();
                loginResponseModelList.addAll( mainModel.getData());
                userid=  loginResponseModelList.get(0).getUserId();
                SharedPref.putVal(getApplicationContext(), SharedPref.user_id, String.valueOf(userid));
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
           // }

        }
        else  if (code.equals("201"))
        {
               Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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