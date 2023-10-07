package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

final class zzvo<K> implements Iterator<Map.Entry<K, Object>> {
    private final Iterator<Map.Entry<K, Object>> zza;

    public zzvo(Iterator<Map.Entry<K, Object>> it2) {
        this.zza = it2;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        return next.getValue() instanceof zzvp ? new zzvn(next, (zzvm) null) : next;
    }

    public final void remove() {
        this.zza.remove();
    }
}
