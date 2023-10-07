package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.common.internal.bk;
import com.google.android.gms.common.util.g;
import com.google.android.gms.internal.common.zzd;
import gi.c;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final d f17672a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final int f17673b = f.f17696b;

    d() {
    }

    public static d b() {
        return f17672a;
    }

    public int a(Context context) {
        return a(context, f17673b);
    }

    public int a(Context context, int i2) {
        int b2 = f.b(context, i2);
        if (f.c(context, b2)) {
            return 18;
        }
        return b2;
    }

    public PendingIntent a(Context context, int i2, int i3) {
        return a(context, i2, i3, (String) null);
    }

    public PendingIntent a(Context context, int i2, int i3, String str) {
        Intent a2 = a(context, i2, str);
        if (a2 == null) {
            return null;
        }
        return zzd.zza(context, i3, a2, zzd.zza | AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    public Intent a(Context context, int i2, String str) {
        if (i2 == 1 || i2 == 2) {
            if (context != null && g.c(context)) {
                return bk.a();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("gcore_");
            sb.append(f17673b);
            sb.append("-");
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            sb.append("-");
            if (context != null) {
                sb.append(context.getPackageName());
            }
            sb.append("-");
            if (context != null) {
                try {
                    sb.append(c.a(context).b(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return bk.a("com.google.android.gms", sb.toString());
        } else if (i2 != 3) {
            return null;
        } else {
            return bk.a("com.google.android.gms");
        }
    }

    public String a(int i2) {
        return f.a(i2);
    }

    public boolean a(Context context, String str) {
        return f.a(context, str);
    }

    public boolean b(int i2) {
        return f.b(i2);
    }

    @Deprecated
    public Intent c(int i2) {
        return a((Context) null, i2, (String) null);
    }

    public void c(Context context) {
        f.g(context);
    }

    public boolean c(Context context, int i2) {
        return f.c(context, i2);
    }
}
