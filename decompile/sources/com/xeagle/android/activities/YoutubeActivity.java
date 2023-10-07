package com.xeagle.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cfly.uav_pro.R;

public class YoutubeActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f22359a;

    /* renamed from: b  reason: collision with root package name */
    private int f22360b;

    /* renamed from: c  reason: collision with root package name */
    private int f22361c;

    /* renamed from: d  reason: collision with root package name */
    private String f22362d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_youtube);
        this.f22359a = (WebView) findViewById(R.id.webview);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f22362d = getIntent().getStringExtra("open_video");
        this.f22359a.requestFocus();
        this.f22359a.setScrollBarStyle(0);
        WebSettings settings = this.f22359a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSavePassword(true);
        settings.setLightTouchEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        this.f22359a.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Log.i("Listener", "shouldOverrideUrlLoading:---- " + str);
                try {
                    if (!str.startsWith("http:")) {
                        if (!str.startsWith("https:")) {
                            YoutubeActivity.this.startActivity(str.startsWith("bilibili://") ? new Intent("android.intent.action.VIEW", Uri.parse(str)) : new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        }
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f22360b = displayMetrics.widthPixels;
        this.f22361c = displayMetrics.heightPixels;
        this.f22359a.loadData(("<html><body><iframe width=\"1120\" height=\"630\" src=\"" + this.f22362d + "\" frameborder=\"1\" allowfullscreen></iframe></body></html>").replace("?", "%3f"), "text/html", "utf-8");
    }
}
