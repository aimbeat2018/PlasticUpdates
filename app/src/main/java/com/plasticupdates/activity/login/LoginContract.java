package com.plasticupdates.activity.login;

import org.json.JSONObject;

public interface LoginContract {

    interface model {
        interface OnFinishedListener {
            void onFinished(JSONObject jsonObject);

            void onFailure(Throwable t);
        }

        void getLogin(OnFinishedListener onFinishedListener,String email,String password);
    }

    interface View {
        void showProgress();

        void hideProgress();

        void showMessage(String message);

        void showError(String error, int forEdit);

        void onResponseFailure(Throwable throwable);
    }

    interface Presenter {
        void Login(String email, String password);

        void forgotPassword();
    }
}
