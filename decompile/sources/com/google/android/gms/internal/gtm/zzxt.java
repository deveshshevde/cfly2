package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzxt extends AbstractList<String> implements zzvs, RandomAccess {
    /* access modifiers changed from: private */
    public final zzvs zza;

    public zzxt(zzvs zzvs) {
        this.zza = zzvs;
    }

    public final /* synthetic */ Object get(int i2) {
        return ((zzvr) this.zza).get(i2);
    }

    public final Iterator<String> iterator() {
        return new zzxs(this);
    }

    public final ListIterator<String> listIterator(int i2) {
        return new zzxr(this, i2);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzvs zze() {
        return this;
    }

    public final Object zzf(int i2) {
        return this.zza.zzf(i2);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zztd zztd) {
        throw new UnsupportedOperationException();
    }
}
