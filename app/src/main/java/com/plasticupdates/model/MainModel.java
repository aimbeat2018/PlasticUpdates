package com.plasticupdates.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.plasticupdates.network.Log;

import java.util.List;

public class MainModel {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<LoginResponseModel> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LoginResponseModel> getData() {
        return data;
    }

    public void setData(List<LoginResponseModel> data) {
        this.data = data;
    }
    @Override
    public String toString(){
        return
                "LoginRequestModel{" +
                        "data = '" + data + '\'' +
                        "}";
    }

}
