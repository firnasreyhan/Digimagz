package com.project.digimagz.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NewsModel implements Serializable {

    @SerializedName("ID_NEWS")
    private String idNews;
    @SerializedName("ID_CATEGORY")
    private String idCategory;
    @SerializedName("TITLE_NEWS")
    private String titleNews;
    @SerializedName("CONTENT_NEWS")
    private String contentNews;
    @SerializedName("VIEWS_COUNT")
    private int viewsCount;
    @SerializedName("SHARES_COUNT")
    private int sharesCount;
    @SerializedName("DATE_NEWS")
    private String dateNews;
    @SerializedName("NEWS_IMAGE")
    private String newsImage;

    public NewsModel(String idNews, String idCategory, String titleNews, String contentNews, int viewsCount, int sharesCount, String dateNews, String newsImage) {
        this.idNews = idNews;
        this.idCategory = idCategory;
        this.titleNews = titleNews;
        this.contentNews = contentNews;
        this.viewsCount = viewsCount;
        this.sharesCount = sharesCount;
        this.dateNews = dateNews;
        this.newsImage = newsImage;
    }

    public String getIdNews() {
        return idNews;
    }

    public void setIdNews(String idNews) {
        this.idNews = idNews;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public void setTitleNews(String titleNews) {
        this.titleNews = titleNews;
    }

    public String getContentNews() {
        return contentNews;
    }

    public void setContentNews(String contentNews) {
        this.contentNews = contentNews;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public int getSharesCount() {
        return sharesCount;
    }

    public void setSharesCount(int sharesCount) {
        this.sharesCount = sharesCount;
    }

    public String getDateNews() {
        return dateNews;
    }

    public void setDateNews(String dateNews) {
        this.dateNews = dateNews;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }
}
