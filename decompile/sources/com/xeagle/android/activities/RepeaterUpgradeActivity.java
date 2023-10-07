package com.xeagle.android.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;
import java.io.File;
import lf.a;
import lf.b;

public class RepeaterUpgradeActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public b f22327a = new b(this);

    /* renamed from: b  reason: collision with root package name */
    private WebView f22328b;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (this.f22327a.f30813a != null) {
                Uri data = (intent == null || i3 != -1) ? null : intent.getData();
                if (data != null) {
                    String a2 = a.a(getApplicationContext(), data);
                    Log.i("CmdChannel", "onActivityResult:-- " + a2);
                    this.f22327a.f30813a.onReceiveValue(Uri.fromFile(new File(a2)));
                } else {
                    this.f22327a.f30813a.onReceiveValue((Object) null);
                }
            }
            if (this.f22327a.f30814b != null) {
                Uri data2 = (intent == null || i3 != -1) ? null : intent.getData();
                if (data2 != null) {
                    String a3 = a.a(getApplicationContext(), data2);
                    Log.i("CmdChannel", "onActivityResult: --------" + a3);
                    this.f22327a.f30814b.onReceiveValue(new Uri[]{Uri.fromFile(new File(a3))});
                } else {
                    this.f22327a.f30814b.onReceiveValue((Object) null);
                }
            }
            this.f22327a.f30813a = null;
            this.f22327a.f30814b = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.repeater_upgrade_activity);
        WebView webView = (WebView) findViewById(R.id.repeater_webView);
        this.f22328b = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAppCacheEnabled(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setLightTouchEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        this.f22328b.requestFocus();
        this.f22328b.loadUrl("http://172.50.10.254/cgi-bin/luci/admin/system/flashops");
        this.f22328b.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.f22328b.setWebChromeClient(this.f22327a);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.f22328b.canGoBack() || i2 != 4) {
            finish();
            return false;
        }
        this.f22328b.goBack();
        return true;
    }
}
