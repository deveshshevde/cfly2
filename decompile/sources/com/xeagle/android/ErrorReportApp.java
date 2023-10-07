package com.xeagle.android;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.multidex.MultiDexApplication;
import androidx.multidex.a;
import com.xeagle.android.utils.file.IO.b;
import java.lang.Thread;

public class ErrorReportApp extends MultiDexApplication {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f12200a;

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f12201b = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable th) {
            new b(ErrorReportApp.this.a(), th).a(ErrorReportApp.this.getApplicationContext());
            ErrorReportApp.this.f12200a.uncaughtException(thread, th);
        }
    };

    /* access modifiers changed from: private */
    public String a() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public void onCreate() {
        super.onCreate();
        this.f12200a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this.f12201b);
    }
}
