package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.*;
import android.widget.*;
import android.view.*;
import androidx.swiperefreshlayout.widget.*;

public class Nopeople extends AppCompatActivity {

    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nopeople);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        miVisorWeb = (WebView) findViewById(R.id.vistaweb);

        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");

    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(Nopeople.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };
}