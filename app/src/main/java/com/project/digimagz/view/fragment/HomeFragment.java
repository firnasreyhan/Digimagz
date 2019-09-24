package com.project.digimagz.view.fragment;

import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;
import com.project.digimagz.R;
import com.project.digimagz.adapter.RecyclerViewNewsAdapter;
import com.project.digimagz.adapter.RecyclerViewStoryAdapter;
import com.project.digimagz.api.InitRetrofit;
import com.project.digimagz.model.NewsModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private InitRetrofit initRetrofit;

    private RecyclerView recyclerViewTranding, recylcerViewCoverStory, recylcerViewNews;
    private ShimmerFrameLayout shimmerFrameLayoutTranding, shimmerFrameLayoutCoverStory, shimmerFrameLayoutNews;
    private MaterialButton materialButtonMoreTranding;
    private NestedScrollView nestedScrollViewHome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initRetrofit = new InitRetrofit();
        initRetrofit.getNewsFromApi();

        recyclerViewTranding = view.findViewById(R.id.recylerViewTranding);
        recylcerViewCoverStory = view.findViewById(R.id.recylcerViewCoverStory);
        recylcerViewNews = view.findViewById(R.id.recylcerViewNews);
        nestedScrollViewHome = view.findViewById(R.id.nestedScrollViewHome);

        shimmerFrameLayoutTranding = view.findViewById(R.id.shimmerFrameLayoutTranding);
        shimmerFrameLayoutCoverStory = view.findViewById(R.id.shimmerFrameLayoutCoverStory);
        shimmerFrameLayoutNews = view.findViewById(R.id.shimmerFrameLayoutNews);

        materialButtonMoreTranding = view.findViewById(R.id.materialButtonMoreTranding);

        initRetrofit.setOnRetrofitSuccess(new InitRetrofit.OnRetrofitSuccess() {
            @Override
            public void onSuccessGetNewsTranding(ArrayList newsModelArrayList) {
                Log.i("Size", String.valueOf(newsModelArrayList.size()));
                showRecyclerListViewTranding(newsModelArrayList);
                showRecyclerListViewCoverStory(newsModelArrayList);
                showRecyclerListViewNews(newsModelArrayList);
                materialButtonMoreTranding.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void showRecyclerListViewTranding(ArrayList<NewsModel> newsModelArrayList) {
        recyclerViewTranding.setHasFixedSize(true);
        recyclerViewTranding.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerViewNewsAdapter recyclerViewNewsAdapter = new RecyclerViewNewsAdapter(newsModelArrayList);
        recyclerViewTranding.setAdapter(recyclerViewNewsAdapter);
        shimmerFrameLayoutTranding.stopShimmer();
        shimmerFrameLayoutTranding.setVisibility(View.GONE);
    }

    private void showRecyclerListViewCoverStory(ArrayList<NewsModel> newsModelArrayList) {
        recylcerViewCoverStory.setHasFixedSize(true);
        recylcerViewCoverStory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //Dummy
        ArrayList<NewsModel> list = new ArrayList<>();
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));
        list.add(new NewsModel("", "", "", "", 0, 0, "", ""));

        RecyclerViewStoryAdapter recyclerViewStoryAdapter = new RecyclerViewStoryAdapter(list);
        recylcerViewCoverStory.setAdapter(recyclerViewStoryAdapter);

        shimmerFrameLayoutCoverStory.stopShimmer();
        shimmerFrameLayoutCoverStory.setVisibility(View.GONE);
    }

    private void showRecyclerListViewNews(ArrayList<NewsModel> newsModelArrayList) {
        recylcerViewNews.setHasFixedSize(true);
        recylcerViewNews.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerViewNewsAdapter recyclerViewNewsAdapter = new RecyclerViewNewsAdapter(newsModelArrayList);
        recylcerViewNews.setAdapter(recyclerViewNewsAdapter);

        shimmerFrameLayoutNews.stopShimmer();
        shimmerFrameLayoutNews.setVisibility(View.GONE);
    }

    public void scrollUp(){
        nestedScrollViewHome.smoothScrollTo(0,0);
    }

    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayoutTranding.startShimmer();
        shimmerFrameLayoutCoverStory.startShimmer();
        shimmerFrameLayoutNews.startShimmer();
    }

    @Override
    public void onPause() {
        shimmerFrameLayoutTranding.stopShimmer();
        shimmerFrameLayoutCoverStory.stopShimmer();
        shimmerFrameLayoutNews.stopShimmer();
        super.onPause();
    }
}
