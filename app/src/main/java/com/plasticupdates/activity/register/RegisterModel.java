package com.plasticupdates.activity.register;

import static android.content.ContentValues.TAG;
import static com.plasticupdates.network.RetrofitService.APIKEY;

import android.util.Log;

import com.plasticupdates.activity.login.LoginContract;
import com.plasticupdates.model.MainModel;
import com.plasticupdates.network.ApiInterface;
import com.plasticupdates.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterModel implements RegisterContract.model {
    @Override
    public void registerData(RegisterContract.model.OnFinishedListener onFinishedListener, String email, String password, String fname, String lname, String phone, String cname, String cphone, String caddress,
                             String country, String state, String city) {
        {
            ApiInterface apiService = RetrofitService.createService(ApiInterface.class, "admin", "1234");
            Call<MainModel> getLogindetails = apiService.registerUser(APIKEY, email, password, fname, lname, phone, cname, cphone,
                    caddress, country, state, city);
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
}
