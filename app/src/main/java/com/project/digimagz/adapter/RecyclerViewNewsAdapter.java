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
import com.project.digimagz.view.activity.DetailNewsActivity;

import java.util.ArrayList;

public class RecyclerViewNewsAdapter extends RecyclerView.Adapter<RecyclerViewNewsAdapter.ViewHolder> {

    private ArrayList<NewsModel> newsModelArrayList;

    public static final String INTENT_PARAM_KEY_NEWS_DATA = "INTENT_PARAM_KEY_NEWS_DATA";

    public RecyclerViewNewsAdapter(ArrayList<NewsModel> newsModelArrayList) {
        this.newsModelArrayList = newsModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NewsModel newsModel = newsModelArrayList.get(position);

        holder.textViewTitle.setText(newsModel.getTitleNews());
        //holder.textViewDate.setText(newsModel.getDateNews());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailNewsActivity.class);
                intent.putExtra(INTENT_PARAM_KEY_NEWS_DATA, newsModel);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle, textViewDate, textViewComment, textViewLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewComment = itemView.findViewById(R.id.textViewComment);
            textViewLike = itemView.findViewById(R.id.textViewLike);
        }
    }
}
