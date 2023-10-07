package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzvr extends zzsj<String> implements zzvs, RandomAccess {
    public static final zzvs zza;
    private static final zzvr zzb;
    private final List<Object> zzc;

    static {
        zzvr zzvr = new zzvr(10);
        zzb = zzvr;
        zzvr.zzb();
        zza = zzvr;
    }

    public zzvr() {
        this(10);
    }

    public zzvr(int i2) {
        this.zzc = new ArrayList(i2);
    }

    private zzvr(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zztd ? ((zztd) obj).zzr(zzvi.zza) : zzvi.zzh((byte[]) obj);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        zza();
        this.zzc.add(i2, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzvs) {
            collection = ((zzvs) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* synthetic */ Object remove(int i2) {
        zza();
        Object remove = this.zzc.remove(i2);
        this.modCount++;
        return zzj(remove);
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        zza();
        return zzj(this.zzc.set(i2, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* synthetic */ zzvh zzd(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.zzc);
            return new zzvr((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzvs zze() {
        return zzc() ? new zzxt(this) : this;
    }

    public final Object zzf(int i2) {
        return this.zzc.get(i2);
    }

    /* renamed from: zzg */
    public final String get(int i2) {
        Object obj = this.zzc.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zztd) {
            zztd zztd = (zztd) obj;
            String zzr = zztd.zzr(zzvi.zza);
            if (zztd.zzj()) {
                this.zzc.set(i2, zzr);
            }
            return zzr;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzvi.zzh(bArr);
        if (zzvi.zzj(bArr)) {
            this.zzc.set(i2, zzh);
        }
        return zzh;
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zztd zztd) {
        zza();
        this.zzc.add(zztd);
        this.modCount++;
    }
}
