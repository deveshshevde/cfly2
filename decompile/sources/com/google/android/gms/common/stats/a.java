package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.bj;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.l;
import gi.c;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f17942b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f17943c;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> f17944a = new ConcurrentHashMap<>();

    private a() {
    }

    public static a a() {
        if (f17943c == null) {
            synchronized (f17942b) {
                if (f17943c == null) {
                    f17943c = new a();
                }
            }
        }
        a aVar = f17943c;
        m.a(aVar);
        return aVar;
    }

    private static final boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2, Executor executor) {
        return (!l.h() || executor == null) ? context.bindService(intent, serviceConnection, i2) : context.bindService(intent, i2, executor, serviceConnection);
    }

    private final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, boolean z2, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((c.a(context).a(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!a(serviceConnection)) {
            return a(context, intent, serviceConnection, i2, executor);
        }
        ServiceConnection putIfAbsent = this.f17944a.putIfAbsent(serviceConnection, serviceConnection);
        if (!(putIfAbsent == null || serviceConnection == putIfAbsent)) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[]{serviceConnection, str, intent.getAction()}));
        }
        try {
            boolean a2 = a(context, intent, serviceConnection, i2, executor);
            if (a2) {
                return a2;
            }
            return false;
        } finally {
            this.f17944a.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean a(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof bj);
    }

    private static void b(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public void a(Context context, ServiceConnection serviceConnection) {
        if (!a(serviceConnection) || !this.f17944a.containsKey(serviceConnection)) {
            b(context, serviceConnection);
            return;
        }
        try {
            b(context, this.f17944a.get(serviceConnection));
        } finally {
            this.f17944a.remove(serviceConnection);
        }
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i2, true, (Executor) null);
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, Executor executor) {
        return a(context, str, intent, serviceConnection, i2, true, executor);
    }
}
