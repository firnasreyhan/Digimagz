package com.project.digimagz.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.project.digimagz.R;
import com.project.digimagz.model.NewsModel;
import com.project.digimagz.model.YoutubeDataModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerViewVideoAdapter extends RecyclerView.Adapter<RecyclerViewVideoAdapter.ViewHolder> {

    private ArrayList<YoutubeDataModel> youtubeDataModelArrayList;
    private Context context;

    public RecyclerViewVideoAdapter(ArrayList<YoutubeDataModel> youtubeDataModelArrayList, Context context) {
        this.youtubeDataModelArrayList = youtubeDataModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final YoutubeDataModel dataModel = youtubeDataModelArrayList.get(position);
        Glide.with(context)
                .load(dataModel.getThumbnail())
                .into(holder.imageViewThumbnailVideo);
        holder.textViewTitle.setText(String.valueOf(dataModel.getTitle()));
        holder.frameLayoutVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.frameLayoutVideo.setVisibility(View.GONE);
                holder.youTubePlayerView.setVisibility(View.VISIBLE);
                holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NotNull YouTubePlayer youTubePlayer) {
                        super.onReady(youTubePlayer);
                        youTubePlayer.loadVideo(dataModel.getVideoId(), 0);
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return youtubeDataModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private YouTubePlayerView youTubePlayerView;
        private TextView textViewTitle;
        private FrameLayout frameLayoutVideo;
        private ImageView imageViewThumbnailVideo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            youTubePlayerView = itemView.findViewById(R.id.youTubePlayerView);
            frameLayoutVideo = itemView.findViewById(R.id.frameLayoutVideo);
            imageViewThumbnailVideo = itemView.findViewById(R.id.imageViewThumbnailVideo);
        }
    }
}
