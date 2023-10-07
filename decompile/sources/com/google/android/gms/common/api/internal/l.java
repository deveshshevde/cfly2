package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

public final class l implements ServiceConnection, a.f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17616a = "l";

    /* renamed from: b  reason: collision with root package name */
    private final String f17617b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17618c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentName f17619d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f17620e;

    /* renamed from: f  reason: collision with root package name */
    private final e f17621f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f17622g;

    /* renamed from: h  reason: collision with root package name */
    private final m f17623h;

    /* renamed from: i  reason: collision with root package name */
    private IBinder f17624i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17625j;

    /* renamed from: k  reason: collision with root package name */
    private String f17626k;

    /* renamed from: l  reason: collision with root package name */
    private String f17627l;

    private final void b() {
        if (Thread.currentThread() != this.f17622g.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    private final void b(String str) {
        String.valueOf(String.valueOf(this.f17624i)).length();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.f17625j = false;
        this.f17624i = null;
        b("Disconnected.");
        this.f17621f.a(1);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(IBinder iBinder) {
        this.f17625j = false;
        this.f17624i = iBinder;
        b("Connected.");
        this.f17621f.a(new Bundle());
    }

    public final void a(String str) {
        this.f17627l = str;
    }

    public final void connect(d.c cVar) {
        b();
        b("Connect started.");
        if (isConnected()) {
            try {
                disconnect("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f17619d;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f17617b).setAction(this.f17618c);
            }
            boolean bindService = this.f17620e.bindService(intent, this, g.a());
            this.f17625j = bindService;
            if (!bindService) {
                this.f17624i = null;
                this.f17623h.a(new ConnectionResult(16));
            }
            b("Finished connect.");
        } catch (SecurityException e2) {
            this.f17625j = false;
            this.f17624i = null;
            throw e2;
        }
    }

    public final void disconnect() {
        b();
        b("Disconnect called.");
        try {
            this.f17620e.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f17625j = false;
        this.f17624i = null;
    }

    public final void disconnect(String str) {
        b();
        this.f17626k = str;
        disconnect();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    public final String getEndpointPackageName() {
        String str = this.f17617b;
        if (str != null) {
            return str;
        }
        m.a(this.f17619d);
        return this.f17619d.getPackageName();
    }

    public final String getLastDisconnectMessage() {
        return this.f17626k;
    }

    public final int getMinApkVersion() {
        return 0;
    }

    public final void getRemoteService(h hVar, Set<Scope> set) {
    }

    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    public final Intent getSignInIntent() {
        return new Intent();
    }

    public final boolean isConnected() {
        b();
        return this.f17624i != null;
    }

    public final boolean isConnecting() {
        b();
        return this.f17625j;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f17622g.post(new bv(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f17622g.post(new bu(this));
    }

    public final void onUserSignOut(d.e eVar) {
    }

    public final boolean providesSignIn() {
        return false;
    }

    public final boolean requiresGooglePlayServices() {
        return false;
    }

    public final boolean requiresSignIn() {
        return false;
    }
}
