package com.example.newsapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BaseObject {
    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("totalResults")
    @Expose
    public int totalResults;

    @SerializedName("articles")
    @Expose
    public List<Article> articles;
}
