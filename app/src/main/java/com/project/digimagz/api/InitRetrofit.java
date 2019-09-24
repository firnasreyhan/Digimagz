package com.project.digimagz.api;

import android.util.Log;

import com.project.digimagz.model.DefaultStructureNews;
import com.project.digimagz.model.NewsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InitRetrofit {

    //API
    private Retrofit retrofit;
    private ApiInterface apiInterface;

    //Interface
    private OnRetrofitSuccess onRetrofitSuccess;

    public InitRetrofit() {
        retrofit = ApiClient.getRetrofit();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public void getNewsFromApi() {
        apiInterface.getHomeNews().enqueue(new Callback<DefaultStructureNews>() {
            @Override
            public void onResponse(Call<DefaultStructureNews> call, Response<DefaultStructureNews> response) {
                ArrayList<NewsModel> list = response.body().getData();
                if (!list.isEmpty()) {
                    onRetrofitSuccess.onSuccessGetNewsTranding(list);
                }
            }

            @Override
            public void onFailure(Call<DefaultStructureNews> call, Throwable t) {
                Log.e("getNewsFromApi", t.getMessage());
            }
        });
    }

    //Interface
    public interface OnRetrofitSuccess {
        void onSuccessGetNewsTranding(ArrayList arrayList);
    }

    public void setOnRetrofitSuccess(OnRetrofitSuccess onRetrofitSuccess) {
        this.onRetrofitSuccess = onRetrofitSuccess;
    }
}
