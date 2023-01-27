package com.plasticupdates.activity.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.plasticupdates.MainActivity;
import com.plasticupdates.R;
import com.plasticupdates.constant.SharedPref;
import com.plasticupdates.model.LoginRequestModel;


import org.json.JSONException;
import org.json.JSONObject;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.model.OnFinishedListener {
    Context context;
    LoginContract.View view;
    LoginRequestModel model;
    private LoginContract.model loginModel;

    public LoginPresenter(Context context, LoginContract.View view) {
        model = new LoginRequestModel();
        loginModel = new LoginModel();
        this.context = context;
        this.view = view;
    }

    @Override
    public void Login(String email, String password) {
        if (email == null) {
            view.showError(context.getString(R.string.email), 0);
        } else if (password == null) {
            view.showError(context.getString(R.string.password), 1);
        } else {
            if (view != null) {
                view.showProgress();
            }
            loginModel.getLogin(this, email, password);
//            context.startActivity(new Intent(context, MainActivity.class));
        }
    }

    @Override
    public void forgotPassword() {
       // context.startActivity(new Intent(context, ForgotPasswordActivity.class));
    }


    @Override
    public void onFinished(JSONObject jsonObject) {
        try {
            String message=jsonObject.getString("message");
            String code=jsonObject.getString("code");
            if (code.equals("200")){
                if (message.equals("User Login Successfully")) {
                    context.startActivity(new Intent(context, MainActivity.class));
                    ((Activity) context).finish();
                    if (view != null) {
                        view.hideProgress();
                    }
                }
                else
                {
                 //   Toast.makeText(getClass(), msg, Toast.LENGTH_SHORT).show();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(Throwable t) {
        view.showError(t.getMessage(), 2);
        if (view != null) {
            view.hideProgress();
        }
    }

}
