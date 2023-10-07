package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.c;
import com.google.android.gms.internal.base.zaq;
import java.util.concurrent.atomic.AtomicReference;

public abstract class cw extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    protected volatile boolean f17585b;

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicReference<ct> f17586c = new AtomicReference<>((Object) null);

    /* renamed from: d  reason: collision with root package name */
    protected final c f17587d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f17588e = new zaq(Looper.getMainLooper());

    cw(i iVar, c cVar) {
        super(iVar);
        this.f17587d = cVar;
    }

    private static final int a(ct ctVar) {
        if (ctVar == null) {
            return -1;
        }
        return ctVar.a();
    }

    /* access modifiers changed from: private */
    public final void c(ConnectionResult connectionResult, int i2) {
        this.f17586c.set((Object) null);
        a(connectionResult, i2);
    }

    /* access modifiers changed from: private */
    public final void f() {
        this.f17586c.set((Object) null);
        g();
    }

    public final void a(int i2, int i3, Intent intent) {
        ct ctVar = this.f17586c.get();
        if (i2 != 1) {
            if (i2 == 2) {
                int a2 = this.f17587d.a((Context) a());
                if (a2 == 0) {
                    f();
                    return;
                } else if (ctVar != null) {
                    if (ctVar.b().a() == 18 && a2 == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i3 == -1) {
            f();
            return;
        } else if (i3 == 0) {
            if (ctVar != null) {
                int i4 = 13;
                if (intent != null) {
                    i4 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                c(new ConnectionResult(i4, (PendingIntent) null, ctVar.b().toString()), a(ctVar));
                return;
            }
            return;
        }
        if (ctVar != null) {
            c(ctVar.b(), ctVar.a());
        }
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            this.f17586c.set(bundle.getBoolean("resolving_error", false) ? new ct(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(ConnectionResult connectionResult, int i2);

    public final void b(Bundle bundle) {
        super.b(bundle);
        ct ctVar = this.f17586c.get();
        if (ctVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", ctVar.a());
            bundle.putInt("failed_status", ctVar.b().a());
            bundle.putParcelable("failed_resolution", ctVar.b().b());
        }
    }

    public final void b(ConnectionResult connectionResult, int i2) {
        ct ctVar = new ct(connectionResult, i2);
        if (this.f17586c.compareAndSet((Object) null, ctVar)) {
            this.f17588e.post(new cv(this, ctVar));
        }
    }

    public void d() {
        super.d();
        this.f17585b = true;
    }

    public void e() {
        super.e();
        this.f17585b = false;
    }

    /* access modifiers changed from: protected */
    public abstract void g();

    public final void onCancel(DialogInterface dialogInterface) {
        c(new ConnectionResult(13, (PendingIntent) null), a(this.f17586c.get()));
    }
}
