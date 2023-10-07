package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    static HandlerThread f17842a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f17843b = 4225;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f17844c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static bi f17845d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f17846e = false;

    public static int a() {
        return f17843b;
    }

    public static g a(Context context) {
        synchronized (f17844c) {
            if (f17845d == null) {
                f17845d = new bi(context.getApplicationContext(), f17846e ? b().getLooper() : context.getMainLooper());
            }
        }
        return f17845d;
    }

    public static HandlerThread b() {
        synchronized (f17844c) {
            HandlerThread handlerThread = f17842a;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f17842a = handlerThread2;
            handlerThread2.start();
            HandlerThread handlerThread3 = f17842a;
            return handlerThread3;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(be beVar, ServiceConnection serviceConnection, String str);

    public final void a(String str, String str2, int i2, ServiceConnection serviceConnection, String str3, boolean z2) {
        a(new be(str, str2, i2, z2), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(be beVar, ServiceConnection serviceConnection, String str, Executor executor);
}
