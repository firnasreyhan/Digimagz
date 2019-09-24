package com.project.digimagz.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.digimagz.R;
import com.project.digimagz.model.NewsModel;
import com.project.digimagz.view.activity.DetailStoryActivity;

import java.util.ArrayList;

public class RecyclerViewStoryAdapter extends RecyclerView.Adapter<RecyclerViewStoryAdapter.ViewHolder> {

    private ArrayList<NewsModel> newsModelArrayList;

    public RecyclerViewStoryAdapter(ArrayList<NewsModel> newsModelArrayList) {
        this.newsModelArrayList = newsModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cover_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), DetailStoryActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
