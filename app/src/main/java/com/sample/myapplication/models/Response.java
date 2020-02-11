package com.sample.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
