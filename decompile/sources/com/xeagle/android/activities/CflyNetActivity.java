package com.xeagle.android.activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;

public class CflyNetActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f22091a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.webview_more_layout);
        WebView webView = (WebView) findViewById(R.id.cfly_webView);
        this.f22091a = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAppCacheEnabled(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setLightTouchEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        this.f22091a.requestFocus();
        this.f22091a.loadUrl("http://www.cfly-cn.com");
        this.f22091a.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.f22091a.setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.f22091a.canGoBack() || i2 != 4) {
            finish();
            return false;
        }
        this.f22091a.goBack();
        return true;
    }
}
