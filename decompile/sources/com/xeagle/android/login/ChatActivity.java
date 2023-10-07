package com.xeagle.android.login;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.UI;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class ChatActivity extends UI implements View.OnClickListener {
    private WebView chat_wb;
    private TextView tv_chatter;

    private void showWebViewLoad() {
        this.chat_wb.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return true;
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_chatter) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.chat_web_layout);
        this.chat_wb = (WebView) findViewById(R.id.chat_wb);
        TextView textView = (TextView) findViewById(R.id.tv_chatter);
        this.tv_chatter = textView;
        textView.setOnClickListener(this);
        this.chat_wb.setHorizontalScrollBarEnabled(false);
        this.chat_wb.setVerticalScrollBarEnabled(false);
        WebSettings settings = this.chat_wb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.supportMultipleWindows();
        settings.setAppCacheMaxSize(26214400);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSavePassword(true);
        settings.setAppCacheEnabled(true);
        settings.setSaveFormData(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(-1);
        this.chat_wb.loadUrl(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        showWebViewLoad();
    }
}
