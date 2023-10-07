package com.hoho.android.usb.usb.data_proxy.log;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected String f20281a = "HJ_SDK";

    /* renamed from: com.hoho.android.usb.usb.data_proxy.log.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20282a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hoho.android.usb.usb.data_proxy.log.LogLevel[] r0 = com.hoho.android.usb.usb.data_proxy.log.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20282a = r0
                com.hoho.android.usb.usb.data_proxy.log.LogLevel r1 = com.hoho.android.usb.usb.data_proxy.log.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20282a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hoho.android.usb.usb.data_proxy.log.LogLevel r1 = com.hoho.android.usb.usb.data_proxy.log.LogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20282a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hoho.android.usb.usb.data_proxy.log.LogLevel r1 = com.hoho.android.usb.usb.data_proxy.log.LogLevel.WARN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20282a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hoho.android.usb.usb.data_proxy.log.LogLevel r1 = com.hoho.android.usb.usb.data_proxy.log.LogLevel.NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20282a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hoho.android.usb.usb.data_proxy.log.LogLevel r1 = com.hoho.android.usb.usb.data_proxy.log.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hoho.android.usb.usb.data_proxy.log.a.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void a(LogLevel logLevel, String str, String str2) {
        if (a(logLevel)) {
            if (TextUtils.isEmpty(str)) {
                str = this.f20281a;
            }
            int i2 = AnonymousClass1.f20282a[logLevel.ordinal()];
            if (i2 == 1) {
                Log.d(str, str2);
            } else if (i2 == 2) {
                Log.i(str, str2);
            } else if (i2 == 3) {
                Log.w(str, str2);
            } else if (i2 == 5) {
                Log.e(str, str2);
            }
        }
    }

    public void a(String str, String str2, Object... objArr) {
        a(LogLevel.INFO, str, String.format(Locale.CHINA, str2, objArr));
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(LogLevel logLevel);

    public void b(String str, String str2, Object... objArr) {
        a(LogLevel.DEBUG, str, String.format(Locale.CHINA, str2, objArr));
    }

    public void c(String str, String str2, Object... objArr) {
        a(LogLevel.WARN, str, String.format(Locale.CHINA, str2, objArr));
    }

    public void d(String str, String str2, Object... objArr) {
        a(LogLevel.ERROR, str, String.format(Locale.CHINA, str2, objArr));
    }
}
