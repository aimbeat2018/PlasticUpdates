package com.plasticupdates.activity.profile;

import android.content.Context;

import com.plasticupdates.R;
import com.plasticupdates.activity.register.RegisterContract;
import com.plasticupdates.activity.register.RegisterModel;
import com.plasticupdates.model.LoginRequestModel;
import com.plasticupdates.model.MainModel;

import org.json.JSONObject;

public class ProfilePresenter implements ProfileContract.Presenter, ProfileContract.model.OnFinishedListener{
    Context context;
    ProfileContract.View view;
    LoginRequestModel model;
    private ProfileContract.model profilemodel;

    public ProfilePresenter(Context context, ProfileContract.View view) {
        model = new LoginRequestModel();
        profilemodel = new ProfileModel();
        this.context = context;
        this.view = view;
    }

    @Override
    public void onFinished(JSONObject jsonObject) {
        try {
            if (view != null) {
                view.hideProgress();
            }
            view.profileUpdateSuccess(jsonObject);

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
    public void updateProfileData(String firstname, String lastname, String email, String phone, String companyname,
                                  String cphone, String companyaddr,
                                  String country, String state, String dept, String job,String turnover,String category) {
        if (email == null) {
            view.showError(context.getString(R.string.email), 0);
        }  else {
            if (view != null) {
                view.showProgress();
            }
            profilemodel.updateProfile(this, firstname,lastname,email,phone,companyname,cphone,companyaddr,
                    country,state,dept,job,turnover,category);
//            context.startActivity(new Intent(context, MainActivity.class));
        }
    }
}
