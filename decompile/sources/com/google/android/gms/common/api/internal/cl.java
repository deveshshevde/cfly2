package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class cl {

    /* renamed from: a  reason: collision with root package name */
    public static final Status f17560a = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: b  reason: collision with root package name */
    final Set<BasePendingResult<?>> f17561b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: c  reason: collision with root package name */
    private final ck f17562c = new ck(this);

    public final void a() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f17561b.toArray(new BasePendingResult[0])) {
            basePendingResult.zan((ck) null);
            if (basePendingResult.zam()) {
                this.f17561b.remove(basePendingResult);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends g> basePendingResult) {
        this.f17561b.add(basePendingResult);
        basePendingResult.zan(this.f17562c);
    }
}
