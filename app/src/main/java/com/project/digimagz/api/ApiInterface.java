package com.project.digimagz.api;

import com.project.digimagz.R;
import com.project.digimagz.model.DefaultStructureNews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("dummy/news")
    Call<DefaultStructureNews> getHomeNews();

    
}
