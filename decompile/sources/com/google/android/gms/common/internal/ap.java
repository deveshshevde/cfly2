package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import gi.c;

public final class ap {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f17784a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f17785b;

    /* renamed from: c  reason: collision with root package name */
    private static String f17786c;

    /* renamed from: d  reason: collision with root package name */
    private static int f17787d;

    public static int a(Context context) {
        b(context);
        return f17787d;
    }

    private static void b(Context context) {
        synchronized (f17784a) {
            if (!f17785b) {
                f17785b = true;
                try {
                    Bundle bundle = c.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f17786c = bundle.getString("com.google.app.id");
                        f17787d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e2);
                }
            }
        }
    }
}
