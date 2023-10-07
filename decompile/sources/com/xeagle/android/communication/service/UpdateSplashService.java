package com.xeagle.android.communication.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.flypro.core.util.e;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.beans.SplashBeans;
import com.xeagle.android.login.download.DownloadListener;
import com.xeagle.android.login.download.DownloadRetrofitManager;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.prefs.a;
import java.io.File;
import java.util.Locale;
import kx.d;
import le.b;
import ok.h;

public class UpdateSplashService extends Service {

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f22469a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("wifi_state", -1);
                if (intExtra == 1 || intExtra == 3) {
                    UpdateSplashService.this.a();
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private e f22470b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f22471c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f22472d;

    /* access modifiers changed from: private */
    public void a() {
        if (this.f22470b.a(getApplicationContext())) {
            new DownloadRetrofitManager(UserGlobal.DOWNLOAD_LINK_URL, new DownloadListener() {
                public void onFail(String str) {
                }

                public void onFinishDownload() {
                }

                public void onProgress(long j2) {
                }

                public void onStartDownload(long j2) {
                }
            }).parseSplashJson(c.a().equals(Locale.CHINA.getCountry()) ? "upload/splash/cn/app_splash.json" : "upload/splash/en/app_splash.json", new h<SplashBeans>() {
                /* renamed from: a */
                public void onNext(SplashBeans splashBeans) {
                    UpdateSplashService updateSplashService;
                    String image_url;
                    StringBuilder sb;
                    UpdateSplashService.this.f22471c.k(splashBeans.getImage_url());
                    UpdateSplashService.this.f22471c.l(splashBeans.getTarget_url());
                    if (!UpdateSplashService.this.f22471c.A().equalsIgnoreCase(splashBeans.getUpdate_time())) {
                        UpdateSplashService.this.f22471c.j(splashBeans.getUpdate_time());
                        updateSplashService = UpdateSplashService.this;
                        image_url = splashBeans.getImage_url();
                        sb = new StringBuilder();
                    } else {
                        if (!new File(d.h(UpdateSplashService.this.getApplicationContext()) + com.flypro.core.util.d.b(splashBeans.getImage_url())).exists()) {
                            updateSplashService = UpdateSplashService.this;
                            image_url = splashBeans.getImage_url();
                            sb = new StringBuilder();
                        } else {
                            return;
                        }
                    }
                    sb.append(d.h(UpdateSplashService.this.getApplicationContext()));
                    sb.append(com.flypro.core.util.d.b(splashBeans.getImage_url()));
                    updateSplashService.a(image_url, sb.toString());
                }

                public void onCompleted() {
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        new le.d(UserGlobal.DOWNLOAD_LINK_URL, new b() {
            public void onFail(String str) {
            }

            public void onFinishDownload() {
            }

            public void onProgress(int i2) {
            }

            public void onStartDownload() {
            }
        }).a(str, str2, (c.C0151c) new c.C0151c() {
            public void writeFail(String str) {
            }

            public void writeSuccess() {
            }
        });
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f22470b = new e(getApplicationContext());
        this.f22471c = ((XEagleApp) getApplicationContext()).j();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f22472d) {
            unregisterReceiver(this.f22469a);
            this.f22472d = false;
        }
        stopSelf();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.f22472d = true;
        registerReceiver(this.f22469a, intentFilter);
        return 2;
    }
}
