package com.sample.myapplication.models.singersModel;

import com.google.gson.annotations.SerializedName;

public class SingerData {

    @SerializedName("id")
    private int id;

    @SerializedName("singer_id")
    private String singerId;

    @SerializedName("singer_name")
    private String singerName;

    @SerializedName("pic")
    private String pic;

    @SerializedName("slider_pic")
    private String sliderPic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSliderPic() {
        return sliderPic;
    }

    public void setSliderPic(String sliderPic) {
        this.sliderPic = sliderPic;
    }
}
