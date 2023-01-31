package com.plasticupdates.activity.profile;

import com.plasticupdates.activity.register.RegisterContract;
import com.plasticupdates.model.MainModel;

import org.json.JSONObject;

public interface ProfileContract {
    interface model {
        interface OnFinishedListener {
            void onFinished(JSONObject jsonObject);

            void onFailure(Throwable t);
        }

        void updateProfile(ProfileContract.model.OnFinishedListener onFinishedListener, String firstname, String lastname,
                           String email, String phone, String companyname,   String cphone,String companyaddr,
                          String country, String state, String dept, String job,String turnover,String category);
    }

    interface View {
        void showProgress();

        void hideProgress();

        void profileUpdateSuccess(JSONObject jsonObject);

        void showMessage(String message);

        void showError(String error, int forEdit);

        void onResponseFailure(Throwable throwable);


    }

    interface Presenter {
        void updateProfileData(String firstname, String lastname, String email, String phone, String companyname, String cphone,
                               String companyaddr, String country, String state, String dept, String job,String turnover,String category);


    }
}
