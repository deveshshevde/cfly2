package lf;

import android.content.Intent;
import android.net.Uri;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public ValueCallback<Uri> f30813a;

    /* renamed from: b  reason: collision with root package name */
    public ValueCallback<Uri[]> f30814b;

    /* renamed from: c  reason: collision with root package name */
    AppCompatActivity f30815c;

    public b(AppCompatActivity appCompatActivity) {
        this.f30815c = appCompatActivity;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.f30814b = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.f30815c.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
        return true;
    }
}
