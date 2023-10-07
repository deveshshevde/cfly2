package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.tasks.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class x {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<BasePendingResult<?>, Boolean> f17657a = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map<c<?>, Boolean> f17658b = Collections.synchronizedMap(new WeakHashMap());

    private final void a(boolean z2, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f17657a) {
            hashMap = new HashMap(this.f17657a);
        }
        synchronized (this.f17658b) {
            hashMap2 = new HashMap(this.f17658b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((c) entry2.getKey()).b((Exception) new ApiException(status));
            }
        }
    }

    public final void a() {
        a(false, f.f11811a);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The connection to Google Play services was lost"
            r0.<init>(r1)
            r1 = 1
            if (r4 != r1) goto L_0x0010
            java.lang.String r4 = " due to service disconnection."
        L_0x000c:
            r0.append(r4)
            goto L_0x0016
        L_0x0010:
            r2 = 3
            if (r4 != r2) goto L_0x0016
            java.lang.String r4 = " due to dead object exception."
            goto L_0x000c
        L_0x0016:
            if (r5 == 0) goto L_0x0020
            java.lang.String r4 = " Last reason for disconnect: "
            r0.append(r4)
            r0.append(r5)
        L_0x0020:
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r5 = 20
            java.lang.String r0 = r0.toString()
            r4.<init>((int) r5, (java.lang.String) r0)
            r3.a((boolean) r1, (com.google.android.gms.common.api.Status) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.x.a(int, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends g> basePendingResult, boolean z2) {
        this.f17657a.put(basePendingResult, Boolean.valueOf(z2));
        basePendingResult.addStatusListener(new v(this, basePendingResult));
    }

    /* access modifiers changed from: package-private */
    public final <TResult> void a(c<TResult> cVar, boolean z2) {
        this.f17658b.put(cVar, Boolean.valueOf(z2));
        cVar.a().a(new w(this, cVar));
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return !this.f17657a.isEmpty() || !this.f17658b.isEmpty();
    }
}
