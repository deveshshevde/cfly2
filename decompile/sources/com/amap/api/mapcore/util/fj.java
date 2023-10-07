package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.List;

public final class fj {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8770a = fg.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f  reason: collision with root package name */
    private static fj f8771f;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f8772b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f8773c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Context f8774d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f8775e;

    private static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<fj> f8779a;

        a(Looper looper, fj fjVar) {
            super(looper);
            this.f8779a = new WeakReference<>(fjVar);
        }

        a(fj fjVar) {
            this.f8779a = new WeakReference<>(fjVar);
        }

        public final void handleMessage(Message message) {
            fj fjVar = (fj) this.f8779a.get();
            if (fjVar != null && message != null && message.obj != null) {
                fjVar.a((String) message.obj, message.what);
            }
        }
    }

    private fj(Context context) {
        this.f8774d = context.getApplicationContext();
        this.f8775e = Looper.myLooper() == null ? new a(Looper.getMainLooper(), this) : new a(this);
    }

    public static fj a(Context context) {
        if (f8771f == null) {
            synchronized (fj.class) {
                if (f8771f == null) {
                    f8771f = new fj(context);
                }
            }
        }
        return f8771f;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(final java.lang.String r3, final int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0070 }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0070 }
            if (r0 != r1) goto L_0x0015
            com.amap.api.mapcore.util.fj$1 r0 = new com.amap.api.mapcore.util.fj$1     // Catch:{ all -> 0x0070 }
            r0.<init>(r3, r4)     // Catch:{ all -> 0x0070 }
            r0.start()     // Catch:{ all -> 0x0070 }
            monitor-exit(r2)
            return
        L_0x0015:
            java.lang.String r3 = com.amap.api.mapcore.util.fp.b((java.lang.String) r3)     // Catch:{ all -> 0x0070 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0070 }
            if (r0 != 0) goto L_0x006e
            r0 = r4 & 1
            if (r0 <= 0) goto L_0x003f
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x003e }
            r1 = 23
            if (r0 < r1) goto L_0x0035
            android.content.Context r0 = r2.f8774d     // Catch:{ Exception -> 0x003e }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x003e }
            java.lang.String r1 = r2.f8773c     // Catch:{ Exception -> 0x003e }
        L_0x0031:
            android.provider.Settings.System.putString(r0, r1, r3)     // Catch:{ Exception -> 0x003e }
            goto L_0x003f
        L_0x0035:
            android.content.Context r0 = r2.f8774d     // Catch:{ Exception -> 0x003e }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x003e }
            java.lang.String r1 = r2.f8773c     // Catch:{ Exception -> 0x003e }
            goto L_0x0031
        L_0x003e:
        L_0x003f:
            r0 = r4 & 16
            if (r0 <= 0) goto L_0x004a
            android.content.Context r0 = r2.f8774d     // Catch:{ all -> 0x0070 }
            java.lang.String r1 = r2.f8773c     // Catch:{ all -> 0x0070 }
            com.amap.api.mapcore.util.fl.a(r0, r1, r3)     // Catch:{ all -> 0x0070 }
        L_0x004a:
            r4 = r4 & 256(0x100, float:3.59E-43)
            if (r4 <= 0) goto L_0x006e
            android.content.Context r4 = r2.f8774d     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = f8770a     // Catch:{ all -> 0x0070 }
            r1 = 0
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r0, r1)     // Catch:{ all -> 0x0070 }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = r2.f8773c     // Catch:{ all -> 0x0070 }
            r4.putString(r0, r3)     // Catch:{ all -> 0x0070 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0070 }
            r0 = 9
            if (r3 < r0) goto L_0x006b
            r4.apply()     // Catch:{ all -> 0x0070 }
            monitor-exit(r2)
            return
        L_0x006b:
            r4.commit()     // Catch:{ all -> 0x0070 }
        L_0x006e:
            monitor-exit(r2)
            return
        L_0x0070:
            r3 = move-exception
            monitor-exit(r2)
            goto L_0x0074
        L_0x0073:
            throw r3
        L_0x0074:
            goto L_0x0073
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fj.a(java.lang.String, int):void");
    }

    public final void a(String str) {
        this.f8773c = str;
    }

    public final void b(String str) {
        List<String> list = this.f8772b;
        if (list != null) {
            list.clear();
            this.f8772b.add(str);
        }
        a(str, ci.a.HEADER_VIEW);
    }
}
