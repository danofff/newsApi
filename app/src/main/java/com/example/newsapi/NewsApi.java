package com.example.newsapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsApi {
    @GET("top-headlines?country=us&apiKey=f1bc8761ddda4894af2dda23516d4535")
    Call<BaseObject> news ();
}