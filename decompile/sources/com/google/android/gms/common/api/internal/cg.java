package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.m;

final class cg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f17546a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cj f17547b;

    cg(cj cjVar, g gVar) {
        this.f17547b = cjVar;
        this.f17546a = gVar;
    }

    public final void run() {
        d dVar;
        try {
            BasePendingResult.zaa.set(true);
            e a2 = ((j) m.a(this.f17547b.f17550a)).a(this.f17546a);
            cj cjVar = this.f17547b;
            cjVar.f17557h.sendMessage(cjVar.f17557h.obtainMessage(0, a2));
            BasePendingResult.zaa.set(false);
            cj.b(this.f17546a);
            dVar = (d) this.f17547b.f17556g.get();
            if (dVar == null) {
                return;
            }
        } catch (RuntimeException e2) {
            cj cjVar2 = this.f17547b;
            cjVar2.f17557h.sendMessage(cjVar2.f17557h.obtainMessage(1, e2));
            BasePendingResult.zaa.set(false);
            cj.b(this.f17546a);
            dVar = (d) this.f17547b.f17556g.get();
            if (dVar == null) {
                return;
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(false);
            cj.b(this.f17546a);
            d dVar2 = (d) this.f17547b.f17556g.get();
            if (dVar2 != null) {
                dVar2.b(this.f17547b);
            }
            throw th;
        }
        dVar.b(this.f17547b);
    }
}
