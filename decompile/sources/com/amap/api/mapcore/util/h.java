package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.mapcore.util.i;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.lang.ref.WeakReference;

public final class h extends Thread {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static int f9006c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static int f9007d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static long f9008e = 30000;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static boolean f9009g = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f9010a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IAMapDelegate f9011b;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f9012f = null;

    /* renamed from: h  reason: collision with root package name */
    private Handler f9013h = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!h.f9009g) {
                if (h.this.f9012f == null) {
                    h hVar = h.this;
                    a unused = hVar.f9012f = new a(hVar.f9011b, h.this.f9010a == null ? null : (Context) h.this.f9010a.get());
                }
                dj.a().a(h.this.f9012f);
            }
        }
    };

    static class a extends ie {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<IAMapDelegate> f9015a = null;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<Context> f9016b = null;

        /* renamed from: c  reason: collision with root package name */
        private i f9017c;

        public a(IAMapDelegate iAMapDelegate, Context context) {
            this.f9015a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.f9016b = new WeakReference<>(context);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (com.autonavi.base.amap.api.mapcore.IAMapDelegate) r2.f9015a.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a() {
            /*
                r2 = this;
                java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r0 = r2.f9015a
                if (r0 == 0) goto L_0x0022
                java.lang.Object r0 = r0.get()
                if (r0 == 0) goto L_0x0022
                java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> r0 = r2.f9015a
                java.lang.Object r0 = r0.get()
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = (com.autonavi.base.amap.api.mapcore.IAMapDelegate) r0
                if (r0 == 0) goto L_0x0022
                com.autonavi.base.amap.mapcore.MapConfig r1 = r0.getMapConfig()
                if (r1 == 0) goto L_0x0022
                com.amap.api.mapcore.util.h$a$1 r1 = new com.amap.api.mapcore.util.h$a$1
                r1.<init>(r0)
                r0.queueEvent(r1)
            L_0x0022:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.h.a.a():void");
        }

        public final void runTask() {
            i.a aVar;
            WeakReference<Context> weakReference;
            try {
                if (!h.f9009g) {
                    if (!(this.f9017c != null || (weakReference = this.f9016b) == null || weakReference.get() == null)) {
                        this.f9017c = new i((Context) this.f9016b.get(), "");
                    }
                    h.b();
                    if (h.f9006c > h.f9007d) {
                        boolean unused = h.f9009g = true;
                        a();
                        return;
                    }
                    i iVar = this.f9017c;
                    if (iVar != null && (aVar = (i.a) iVar.d()) != null) {
                        if (!aVar.f9195d) {
                            a();
                        }
                        boolean unused2 = h.f9009g = true;
                    }
                }
            } catch (Throwable th) {
                fz.c(th, "authForPro", "loadConfigData_uploadException");
                String str = dm.f8271e;
                dn.b(str, "auth exception get data " + th.getMessage());
            }
        }
    }

    public h(Context context, IAMapDelegate iAMapDelegate) {
        if (context != null) {
            this.f9010a = new WeakReference<>(context);
        }
        this.f9011b = iAMapDelegate;
        f();
    }

    static /* synthetic */ int b() {
        int i2 = f9006c;
        f9006c = i2 + 1;
        return i2;
    }

    private static void f() {
        f9006c = 0;
        f9009g = false;
    }

    private void g() {
        if (!f9009g) {
            int i2 = 0;
            while (i2 <= f9007d) {
                i2++;
                this.f9013h.sendEmptyMessageDelayed(0, ((long) i2) * f9008e);
            }
        }
    }

    public final void interrupt() {
        this.f9011b = null;
        this.f9010a = null;
        Handler handler = this.f9013h;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f9013h = null;
        this.f9012f = null;
        f();
        super.interrupt();
    }

    public final void run() {
        try {
            g();
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
            String str = dm.f8271e;
            dn.b(str, "auth pro exception " + th.getMessage());
        }
    }
}
