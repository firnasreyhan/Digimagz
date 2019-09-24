package com.project.digimagz.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.project.digimagz.R;
import com.project.digimagz.adapter.RecyclerViewNewsAdapter;
import com.project.digimagz.model.NewsModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetailNewsActivity extends AppCompatActivity {

    private TextView textViewTitle, textViewDate, textViewContent;

    private NewsModel newsModel;
    private Object object;

    private SimpleDateFormat simpleDateFormat;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        object = getIntent().getSerializableExtra(RecyclerViewNewsAdapter.INTENT_PARAM_KEY_NEWS_DATA);
        newsModel = (NewsModel) object;

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewDate = findViewById(R.id.textViewDate);
        textViewContent = findViewById(R.id.textViewContent);

        try {
            date = simpleDateFormat.parse(newsModel.getDateNews());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        textViewTitle.setText(newsModel.getTitleNews());
        textViewDate.setText(DateFormat.getDateInstance(DateFormat.LONG, new Locale("in", "ID")).format(date));
        textViewContent.setText(Html.fromHtml(Html.fromHtml(newsModel.getContentNews()).toString()));
    }
}
