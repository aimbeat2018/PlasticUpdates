package com.plasticupdates.network;

import com.plasticupdates.model.MainModel;

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
    Call<MainModel> loginUser(@Header("x-api-key") String ApiKey,
                              @Field("email") String email,
                              @Field("password") String password);
    @FormUrlEncoded
    @POST("register")
    Call<MainModel> registerUser(@Header("x-api-key") String ApiKey,
                              @Field("email") String email,@Field("password") String password,
                                 @Field("fname") String fname,@Field("lname") String lname,
                                 @Field("phone") String phone,@Field("cname") String cname,
                                 @Field("cphone") String cphone,@Field("caddress") String caddress,
                                 @Field("country") String country,@Field("state") String state,@Field("city") String city);
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> updateuser(@Header("x-api-key") String ApiKey,
                                 @Field("user_id") String userid,@Field("firstname") String firstname,
                                 @Field("lastname") String lastname,@Field("c_name") String c_name,
                                 @Field("c_phone") String c_phone,@Field("c_address") String c_address,
                                 @Field("country") String country,@Field("state") String state,
                                 @Field("city") String city,@Field("department") String department,
                                  @Field("job_function") String job_function, @Field("yearly_turnover") String yearly_turnover,
                                  @Field("company_category") String company_category);


}
