package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.google.android.gms.common.internal.m;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f17700a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17701b;

    public g(Context context) {
        this.f17701b = context.getApplicationContext();
    }

    public static g a(Context context) {
        m.a(context);
        synchronized (g.class) {
            if (f17700a == null) {
                u.a(context);
                f17700a = new g(context);
            }
        }
        return f17700a;
    }

    static final p a(PackageInfo packageInfo, p... pVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        q qVar = new q(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < pVarArr.length; i2++) {
            if (pVarArr[i2].equals(qVar)) {
                return pVarArr[i2];
            }
        }
        return null;
    }

    public static final boolean a(PackageInfo packageInfo, boolean z2) {
        p pVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z2) {
                pVar = a(packageInfo, t.f17945a);
            } else {
                pVar = a(packageInfo, t.f17945a[0]);
            }
            if (pVar != null) {
                return true;
            }
        }
        return false;
    }
}
