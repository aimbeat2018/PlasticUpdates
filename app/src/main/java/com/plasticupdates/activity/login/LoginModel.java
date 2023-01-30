package com.plasticupdates.activity.login;

import static android.content.ContentValues.TAG;

import static com.plasticupdates.network.RetrofitService.APIKEY;

import android.util.Log;

import com.plasticupdates.model.MainModel;
import com.plasticupdates.network.ApiClient;
import com.plasticupdates.network.ApiInterface;
import com.plasticupdates.network.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.model {
    @Override
    public void getLogin(OnFinishedListener onFinishedListener, String email, String password) {
        ApiInterface apiService = RetrofitService.createService(ApiInterface.class,"admin","1234");
        Call<MainModel> getLogindetails = apiService.loginUser(APIKEY,email,password);
        getLogindetails.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {

                if (response.isSuccessful()) {

                    try {
                     //   JSONObject jsonObject = new JSONObject(response.body());
                        onFinishedListener.onFinished(response.body());
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }


            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
