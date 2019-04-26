package com.example.newsapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {
    @SerializedName("id")
    @Expose
    public String id = null;

    @SerializedName("name")
    @Expose
    public String name;
}
