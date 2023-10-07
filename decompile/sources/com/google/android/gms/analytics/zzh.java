package com.google.android.gms.analytics;

import android.os.Build;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzh {
    private final zzk zza;
    private final d zzb;
    private boolean zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private final Map<Class<? extends zzj>, zzj> zzj;
    private final List<zzt> zzk;

    zzh(zzh zzh2) {
        this.zza = zzh2.zza;
        this.zzb = zzh2.zzb;
        this.zzd = zzh2.zzd;
        this.zze = zzh2.zze;
        this.zzf = zzh2.zzf;
        this.zzg = zzh2.zzg;
        this.zzh = zzh2.zzh;
        this.zzk = new ArrayList(zzh2.zzk);
        this.zzj = new HashMap(zzh2.zzj.size());
        for (Map.Entry next : zzh2.zzj.entrySet()) {
            zzj zzn = zzn((Class) next.getKey());
            ((zzj) next.getValue()).zzc(zzn);
            this.zzj.put((Class) next.getKey(), zzn);
        }
    }

    zzh(zzk zzk2, d dVar) {
        m.a(zzk2);
        m.a(dVar);
        this.zza = zzk2;
        this.zzb = dVar;
        this.zzg = 1800000;
        this.zzh = 3024000000L;
        this.zzj = new HashMap();
        this.zzk = new ArrayList();
    }

    private static <T extends zzj> T zzn(Class<T> cls) {
        try {
            return (zzj) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            if (e2 instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e2);
            } else if (e2 instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
            } else if (Build.VERSION.SDK_INT < 19 || !(e2 instanceof ReflectiveOperationException)) {
                throw new RuntimeException(e2);
            } else {
                throw new IllegalArgumentException("Linkage exception", e2);
            }
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final <T extends zzj> T zzb(Class<T> cls) {
        T t2 = (zzj) this.zzj.get(cls);
        if (t2 != null) {
            return t2;
        }
        T zzn = zzn(cls);
        this.zzj.put(cls, zzn);
        return zzn;
    }

    public final <T extends zzj> T zzc(Class<T> cls) {
        return (zzj) this.zzj.get(cls);
    }

    /* access modifiers changed from: package-private */
    public final zzk zzd() {
        return this.zza;
    }

    public final Collection<zzj> zze() {
        return this.zzj.values();
    }

    public final List<zzt> zzf() {
        return this.zzk;
    }

    public final void zzg(zzj zzj2) {
        m.a(zzj2);
        Class cls = zzj2.getClass();
        if (cls.getSuperclass() == zzj.class) {
            zzj2.zzc(zzb(cls));
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final void zzh() {
        this.zzi = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzi() {
        this.zzf = this.zzb.b();
        long j2 = this.zze;
        if (j2 == 0) {
            j2 = this.zzb.a();
        }
        this.zzd = j2;
        this.zzc = true;
    }

    public final void zzj(long j2) {
        this.zze = j2;
    }

    public final void zzk() {
        this.zza.zzm().zzk(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl() {
        return this.zzi;
    }

    public final boolean zzm() {
        return this.zzc;
    }
}
