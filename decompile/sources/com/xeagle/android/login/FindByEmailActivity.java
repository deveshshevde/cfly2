package com.xeagle.android.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;

public class FindByEmailActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_account;
    private WebView forget_wb;

    private void initView() {
        WebView webView = (WebView) findViewById(R.id.forget_wb);
        this.forget_wb = webView;
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
        this.forget_wb.requestFocus();
        this.forget_wb.loadUrl("https://api.cfly-cn.com/password/reset");
        this.forget_wb.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.forget_wb.setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }
        });
        this.et_account = (EditText) findViewById(R.id.et_account);
        ((IImageButton) findViewById(R.id.bt_clear)).setOnClickListener(this);
        ((IButton) findViewById(R.id.bt_login_post)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_toLogin)).setOnClickListener(this);
        ((IImageButton) findViewById(R.id.iv_go_back)).setOnClickListener(this);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 != R.id.bt_clear) {
            if (id2 != R.id.iv_go_back) {
                if (id2 == R.id.tv_toLogin) {
                    startActivity(new Intent(this, LoginActivity.class));
                } else {
                    return;
                }
            }
            finish();
            return;
        }
        this.et_account.setText("");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView((int) R.layout.find_email_layout);
        initView();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.forget_wb.canGoBack() || i2 != 4) {
            finish();
            return false;
        }
        this.forget_wb.goBack();
        return true;
    }
}
