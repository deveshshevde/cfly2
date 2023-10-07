package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.stats.a;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;

final class bi extends g {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<be, bf> f17813b = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f17814c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f17815d;

    /* renamed from: e  reason: collision with root package name */
    private final bh f17816e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final a f17817f;

    /* renamed from: g  reason: collision with root package name */
    private final long f17818g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final long f17819h;

    bi(Context context, Looper looper) {
        bh bhVar = new bh(this, (bg) null);
        this.f17816e = bhVar;
        this.f17814c = context.getApplicationContext();
        this.f17815d = new zzi(looper, bhVar);
        this.f17817f = a.a();
        this.f17818g = 5000;
        this.f17819h = 300000;
    }

    /* access modifiers changed from: protected */
    public final void a(be beVar, ServiceConnection serviceConnection, String str) {
        m.a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f17813b) {
            bf bfVar = this.f17813b.get(beVar);
            if (bfVar == null) {
                String obj = beVar.toString();
                StringBuilder sb = new StringBuilder(obj.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString());
            } else if (bfVar.a(serviceConnection)) {
                bfVar.a(serviceConnection, str);
                if (bfVar.d()) {
                    this.f17815d.sendMessageDelayed(this.f17815d.obtainMessage(0, beVar), this.f17818g);
                }
            } else {
                String obj2 = beVar.toString();
                StringBuilder sb2 = new StringBuilder(obj2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(obj2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(be beVar, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean e2;
        m.a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f17813b) {
            bf bfVar = this.f17813b.get(beVar);
            if (bfVar == null) {
                bfVar = new bf(this, beVar);
                bfVar.a(serviceConnection, serviceConnection, str);
                bfVar.a(str, executor);
                this.f17813b.put(beVar, bfVar);
            } else {
                this.f17815d.removeMessages(0, beVar);
                if (!bfVar.a(serviceConnection)) {
                    bfVar.a(serviceConnection, serviceConnection, str);
                    int a2 = bfVar.a();
                    if (a2 == 1) {
                        serviceConnection.onServiceConnected(bfVar.b(), bfVar.c());
                    } else if (a2 == 2) {
                        bfVar.a(str, executor);
                    }
                } else {
                    String obj = beVar.toString();
                    StringBuilder sb = new StringBuilder(obj.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(obj);
                    throw new IllegalStateException(sb.toString());
                }
            }
            e2 = bfVar.e();
        }
        return e2;
    }
}
