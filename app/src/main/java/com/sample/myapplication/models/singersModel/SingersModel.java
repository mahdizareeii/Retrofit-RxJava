package com.sample.myapplication.models.singersModel;

import com.google.gson.annotations.SerializedName;
import com.sample.myapplication.models.Response;

import java.util.List;

public class SingersModel extends Response {

    @SerializedName("data")
    private List<SingerData> singers;

    public List<SingerData> getSingers() {
        return singers;
    }

    public void setSingers(List<SingerData> singers) {
        this.singers = singers;
    }
}
