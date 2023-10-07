package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

public final class fb {

    /* renamed from: a  reason: collision with root package name */
    private volatile b f8735a = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private gb f8736b = new gb("HttpsDecisionUtil");

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static fb f8737a = new fb();
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f8738a;

        /* renamed from: b  reason: collision with root package name */
        private int f8739b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f8740c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8741d;

        private b() {
            this.f8739b = 0;
            this.f8738a = true;
            this.f8740c = true;
            this.f8741d = false;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void a(Context context) {
            if (context != null && this.f8739b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.f8739b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void a(boolean z2) {
            this.f8738a = z2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x002e A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a() {
            /*
                r5 = this;
                boolean r0 = r5.f8741d
                r1 = 1
                if (r0 != 0) goto L_0x002f
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto L_0x000e
                r0 = 1
                goto L_0x000f
            L_0x000e:
                r0 = 0
            L_0x000f:
                boolean r4 = r5.f8738a
                if (r4 == 0) goto L_0x0023
                int r4 = r5.f8739b
                if (r4 > 0) goto L_0x0019
                r4 = 28
            L_0x0019:
                if (r4 < r2) goto L_0x001d
                r2 = 1
                goto L_0x001e
            L_0x001d:
                r2 = 0
            L_0x001e:
                if (r2 == 0) goto L_0x0021
                goto L_0x0023
            L_0x0021:
                r2 = 0
                goto L_0x0024
            L_0x0023:
                r2 = 1
            L_0x0024:
                if (r0 == 0) goto L_0x002a
                if (r2 == 0) goto L_0x002a
                r0 = 1
                goto L_0x002b
            L_0x002a:
                r0 = 0
            L_0x002b:
                if (r0 == 0) goto L_0x002e
                goto L_0x002f
            L_0x002e:
                return r3
            L_0x002f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fb.b.a():boolean");
        }
    }

    public static fb a() {
        return a.f8737a;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.scheme("https");
            return buildUpon.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void b(Context context) {
        b(context, true);
    }

    private static void b(Context context, boolean z2) {
        SharedPreferences.Editor a2 = gb.a(context, "open_common");
        gb.a(a2, "a3", z2);
        gb.a(a2);
    }

    private boolean b() {
        if (this.f8735a == null) {
            this.f8735a = new b((byte) 0);
        }
        return this.f8735a.a();
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final void a(Context context) {
        if (this.f8735a == null) {
            this.f8735a = new b((byte) 0);
        }
        this.f8735a.a(gb.a(context, "open_common", "a3", true));
        this.f8735a.a(context);
        fi.a(context).a();
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, boolean z2) {
        if (this.f8735a == null) {
            this.f8735a = new b((byte) 0);
        }
        b(context, z2);
        this.f8735a.a(z2);
    }

    public final boolean a(boolean z2) {
        if (c()) {
            return false;
        }
        return z2 || b();
    }
}
