package com.xeagle.android.login.download;

import com.xeagle.android.login.beans.ApkVersion;
import com.xeagle.android.login.beans.SplashBeans;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import le.e;
import ok.h;
import okhttp3.u;
import okhttp3.x;
import os.a;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DownloadRetrofitManager {
    private static final int DEFAULT_TIMEOUT = 10;
    private String baseUrl;
    private DownloadListener listener;

    /* renamed from: retrofit  reason: collision with root package name */
    private Retrofit f23800retrofit;

    public DownloadRetrofitManager(String str, DownloadListener downloadListener) {
        this.baseUrl = str;
        this.listener = downloadListener;
        x a2 = new x.a().a((u) new ListenerInterceptor(downloadListener)).a(true).a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).a();
        this.f23800retrofit = new Retrofit.Builder().baseUrl(str).client(a2).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).callbackExecutor(Executors.newFixedThreadPool(1)).build();
    }

    public void parseApkVersion(String str, h<ApkVersion> hVar) {
        ((e) this.f23800retrofit.create(e.class)).c(str).b(a.b()).a(om.a.a()).b(hVar);
    }

    public void parseSplashJson(String str, h<SplashBeans> hVar) {
        ((e) this.f23800retrofit.create(e.class)).d(str).b(a.b()).a(om.a.a()).b(hVar);
    }
}
