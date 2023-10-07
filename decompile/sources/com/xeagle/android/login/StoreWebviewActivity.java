package com.xeagle.android.login;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.UI;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;

public class StoreWebviewActivity extends UI implements View.OnClickListener {
    private IImageButton ib_back;
    /* access modifiers changed from: private */
    public IButton ib_reconnect;
    /* access modifiers changed from: private */
    public ImageView iv_wifi_disconnected;
    private WebView store_wb;
    private String targetUrl;
    /* access modifiers changed from: private */
    public TextView tv_wifi_disconnected;

    private void initView() {
        this.store_wb = (WebView) findViewById(R.id.store_wb);
        this.ib_back = (IImageButton) findViewById(R.id.ib_back);
        this.ib_reconnect = (IButton) findViewById(R.id.ib_wifi_connect);
        this.iv_wifi_disconnected = (ImageView) findViewById(R.id.iv_wifi_disconnected);
        this.tv_wifi_disconnected = (TextView) findViewById(R.id.tv_wifi_disconnected);
        WebSettings settings = this.store_wb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAppCacheEnabled(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setLightTouchEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        this.store_wb.requestFocus();
        reconnected();
        this.store_wb.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        this.ib_back.setColorFilter(R.color.gray);
        this.ib_back.setOnClickListener(this);
        this.ib_reconnect.setOnClickListener(this);
    }

    private void reconnected() {
        if (this.function.a(getApplicationContext())) {
            runOnUiThread(new Runnable() {
                public void run() {
                    StoreWebviewActivity.this.tv_wifi_disconnected.setVisibility(8);
                    StoreWebviewActivity.this.iv_wifi_disconnected.setVisibility(8);
                    StoreWebviewActivity.this.ib_reconnect.setVisibility(8);
                }
            });
            this.store_wb.loadUrl(this.targetUrl);
            return;
        }
        this.tv_wifi_disconnected.setVisibility(0);
        this.iv_wifi_disconnected.setVisibility(0);
        this.ib_reconnect.setVisibility(0);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.ib_back) {
            finish();
        } else if (id2 == R.id.ib_wifi_connect) {
            reconnected();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.store_webview_layout);
        this.targetUrl = getIntent().getStringExtra("target_url");
        initView();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.store_wb.canGoBack() || i2 != 4) {
            finish();
            return false;
        }
        this.store_wb.goBack();
        return true;
    }
}
