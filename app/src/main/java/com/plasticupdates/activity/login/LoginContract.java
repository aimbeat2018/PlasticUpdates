package com.plasticupdates.activity.login;

import com.plasticupdates.model.MainModel;

import org.json.JSONObject;

public interface LoginContract {

    interface model {
        interface OnFinishedListener {
            void onFinished(MainModel mainModel);

            void onFailure(Throwable t);
        }

        void getLogin(OnFinishedListener onFinishedListener,String email,String password);
    }

    interface View {
        void showProgress();

        void hideProgress();

        void showMessage(String message);

        void showError(String error, int forEdit);

        void loginSuccess(MainModel mainModel);
        void onResponseFailure(Throwable throwable);
    }

    interface Presenter {
        void Login(String email, String password);

        void forgotPassword();
    }
}
