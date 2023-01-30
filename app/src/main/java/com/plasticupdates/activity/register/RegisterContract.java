package com.plasticupdates.activity.register;

import com.plasticupdates.activity.login.LoginContract;
import com.plasticupdates.model.MainModel;

public interface RegisterContract {
    interface model {
        interface OnFinishedListener {
            void onFinished(MainModel mainModel);

            void onFailure(Throwable t);
        }

        void registerData(RegisterContract.model.OnFinishedListener onFinishedListener, String email, String password,
                          String fname, String lname, String phone, String cname, String cphone, String caddress,
                          String country, String state, String city);
    }

    interface View {
        void showProgress();

        void hideProgress();

        void registeredUser(MainModel mainModel);

        void showMessage(String message);

        void showError(String error, int forEdit);

        void onResponseFailure(Throwable throwable);


    }

    interface Presenter {
        void registerData(String email, String password,String fname,String lname,String phone,
                          String cname,String cphone,String caddress, String country,String state,String city);


    }
}
