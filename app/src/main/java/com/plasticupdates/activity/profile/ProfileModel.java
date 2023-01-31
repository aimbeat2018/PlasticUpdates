package com.plasticupdates.activity.profile;

import static android.content.ContentValues.TAG;
import static com.plasticupdates.network.RetrofitService.APIKEY;

import android.util.Log;

import com.plasticupdates.activity.register.RegisterContract;
import com.plasticupdates.model.MainModel;
import com.plasticupdates.network.ApiInterface;
import com.plasticupdates.network.RetrofitService;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileModel implements ProfileContract.model{
    @Override
    public void updateProfile(ProfileContract.model.OnFinishedListener onFinishedListener, String firstname, String lastname,
                              String email, String phone, String companyname, String companyaddr,
                              String cphone, String country, String state, String dept, String job,String turnover,String category) {
        {
            ApiInterface apiService = RetrofitService.createService(ApiInterface.class, "admin", "1234");
            Call<ResponseBody> getLogindetails = apiService.updateuser(APIKEY, firstname,lastname,email,phone,companyname,cphone,companyaddr,
                    country,state,dept,job,turnover,category);
            getLogindetails.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccessful()) {

                        try {
                               JSONObject jsonObject = new JSONObject(response.body().toString());
                               onFinishedListener.onFinished(jsonObject);
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }


                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e(TAG, t.toString());
                    onFinishedListener.onFailure(t);
                }
            });
        }
    }
}
