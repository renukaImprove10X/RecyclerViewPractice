package com.improve10x.recyclerviewpractice.filmDiary.series;

import com.google.gson.annotations.SerializedName;

public class Series {
    public String imageUrl;
    @SerializedName("id")
    public String seriesId;
    public String title;

    public Series() {
    }

    public Series(String seriesId, String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.seriesId = seriesId;
        this.title = title;
    }
}
