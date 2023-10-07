package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class cr extends cw {

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<cq> f17573e = new SparseArray<>();

    private cr(i iVar) {
        super(iVar, c.a());
        this.f17414a.a("AutoManageHelper", (LifecycleCallback) this);
    }

    private final cq b(int i2) {
        if (this.f17573e.size() <= i2) {
            return null;
        }
        SparseArray<cq> sparseArray = this.f17573e;
        return sparseArray.get(sparseArray.keyAt(i2));
    }

    public static cr b(h hVar) {
        i a2 = a(hVar);
        cr crVar = (cr) a2.a("AutoManageHelper", cr.class);
        return crVar != null ? crVar : new cr(a2);
    }

    public final void a(int i2) {
        cq cqVar = this.f17573e.get(i2);
        this.f17573e.remove(i2);
        if (cqVar != null) {
            cqVar.f17570b.b((d.c) cqVar);
            cqVar.f17570b.c();
        }
    }

    public final void a(int i2, d dVar, d.c cVar) {
        m.a(dVar, (Object) "GoogleApiClient instance cannot be null");
        boolean z2 = this.f17573e.indexOfKey(i2) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i2);
        m.b(z2, sb.toString());
        ct ctVar = (ct) this.f17586c.get();
        boolean z3 = this.f17585b;
        String valueOf = String.valueOf(ctVar);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i2);
        sb2.append(" ");
        sb2.append(z3);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        cq cqVar = new cq(this, i2, dVar, cVar);
        dVar.a((d.c) cqVar);
        this.f17573e.put(i2, cqVar);
        if (this.f17585b && ctVar == null) {
            Log.d("AutoManageHelper", "connecting ".concat(dVar.toString()));
            dVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(ConnectionResult connectionResult, int i2) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        cq cqVar = this.f17573e.get(i2);
        if (cqVar != null) {
            a(i2);
            d.c cVar = cqVar.f17571c;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.f17573e.size(); i2++) {
            cq b2 = b(i2);
            if (b2 != null) {
                printWriter.append(str).append("GoogleApiClient #").print(b2.f17569a);
                printWriter.println(":");
                b2.f17570b.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void d() {
        super.d();
        boolean z2 = this.f17585b;
        String valueOf = String.valueOf(this.f17573e);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z2);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f17586c.get() == null) {
            for (int i2 = 0; i2 < this.f17573e.size(); i2++) {
                cq b2 = b(i2);
                if (b2 != null) {
                    b2.f17570b.b();
                }
            }
        }
    }

    public final void e() {
        super.e();
        for (int i2 = 0; i2 < this.f17573e.size(); i2++) {
            cq b2 = b(i2);
            if (b2 != null) {
                b2.f17570b.c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        for (int i2 = 0; i2 < this.f17573e.size(); i2++) {
            cq b2 = b(i2);
            if (b2 != null) {
                b2.f17570b.b();
            }
        }
    }
}
