package com.plasticupdates.activity.register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.plasticupdates.MainActivity;
import com.plasticupdates.R;
import com.plasticupdates.constant.SharedPref;
import com.plasticupdates.model.LoginRequestModel;
import com.plasticupdates.model.LoginResponseModel;
import com.plasticupdates.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class RegisterPresenter implements RegisterContract.Presenter, RegisterContract.model.OnFinishedListener{
    Context context;
    RegisterContract.View view;
    LoginRequestModel model;
    private RegisterContract.model registerModel;

    public RegisterPresenter(Context context, RegisterContract.View view) {
        model = new LoginRequestModel();
        registerModel = new RegisterModel();
        this.context = context;
        this.view = view;
    }

    @Override
    public void onFinished(MainModel mainModel) {
        try {
            if (view != null) {
                view.hideProgress();
            }
            view.registeredUser(mainModel);

        } catch (Exception e) {
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


    @Override
    public void registerData(String email, String password, String fname, String lname, String phone, String cname, String cphone, String caddress, String country, String state, String city) {
        if (email == null) {
            view.showError(context.getString(R.string.email), 0);
        } else if (password == null) {
            view.showError(context.getString(R.string.password), 1);
        } else {
            if (view != null) {
                view.showProgress();
            }
            registerModel.registerData(this, email, password,fname,lname,phone,cname,cphone,
                    caddress,country,state,city);
//            context.startActivity(new Intent(context, MainActivity.class));
        }
    }
}
