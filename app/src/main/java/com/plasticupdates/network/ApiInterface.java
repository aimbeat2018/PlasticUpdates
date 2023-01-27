package com.plasticupdates.network;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
//    @FormUrlEncoded
//    @POST("login")
//    Call<ResponseBody> loginUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginUser(@Header("x-api-key") String ApiKey,
                                 @Field("email") String email,
                                 @Field("password") String password);



}
