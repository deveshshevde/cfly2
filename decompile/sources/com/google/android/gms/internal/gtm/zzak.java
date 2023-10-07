package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;

public final class zzak extends zzuv<zzak, zzal> implements zzwl {
    private static final zzvf<Integer, zzao> zze = new zzvf<Integer, zzao>() {
        /* renamed from: zza */
        public zzao zzb(Integer num) {
            zzao zzb = zzao.zzb(num.intValue());
            return zzb == null ? zzao.ESCAPE_HTML : zzb;
        }
    };
    /* access modifiers changed from: private */
    public static final zzak zzf;
    private int zzg;
    private int zzh = 1;
    private String zzi = "";
    /* access modifiers changed from: private */
    public zzvh<zzak> zzj = zzag();
    /* access modifiers changed from: private */
    public zzvh<zzak> zzk = zzag();
    /* access modifiers changed from: private */
    public zzvh<zzak> zzl = zzag();
    private String zzm = "";
    private String zzn = "";
    private long zzo;
    private boolean zzp;
    /* access modifiers changed from: private */
    public zzvh<zzak> zzq = zzag();
    /* access modifiers changed from: private */
    public zzve zzr = zzaf();
    private boolean zzs;
    private byte zzt = 2;

    static {
        zzak zzak = new zzak();
        zzf = zzak;
        zzuz.zzak(zzak.class, zzak);
    }

    private zzak() {
    }

    static /* synthetic */ void zzA(zzak zzak, String str) {
        str.getClass();
        zzak.zzg |= 4;
        zzak.zzm = str;
    }

    static /* synthetic */ void zzB(zzak zzak, String str) {
        str.getClass();
        zzak.zzg |= 8;
        zzak.zzn = str;
    }

    static /* synthetic */ void zzC(zzak zzak, String str) {
        str.getClass();
        zzak.zzg |= 2;
        zzak.zzi = str;
    }

    static /* synthetic */ void zzD(zzak zzak, long j2) {
        zzak.zzg |= 16;
        zzak.zzo = j2;
    }

    static /* synthetic */ void zzE(zzak zzak, boolean z2) {
        zzak.zzg |= 32;
        zzak.zzp = z2;
    }

    static /* synthetic */ void zzF(zzak zzak, zzak zzak2) {
        zzak2.getClass();
        zzvh<zzak> zzvh = zzak.zzq;
        if (!zzvh.zzc()) {
            zzak.zzq = zzuz.zzah(zzvh);
        }
        zzak.zzq.add(zzak2);
    }

    static /* synthetic */ void zzH(zzak zzak, Iterable iterable) {
        zzve zzve = zzak.zzr;
        if (!zzve.zzc()) {
            int size = zzve.size();
            zzak.zzr = zzve.zzg(size == 0 ? 10 : size + size);
        }
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            zzak.zzr.zzh(((zzao) it2.next()).zza());
        }
    }

    static /* synthetic */ void zzJ(zzak zzak, boolean z2) {
        zzak.zzg |= 64;
        zzak.zzs = z2;
    }

    static /* synthetic */ void zzK(zzak zzak, zzak zzak2) {
        zzak2.getClass();
        zzak.zzal();
        zzak.zzj.add(zzak2);
    }

    static /* synthetic */ void zzL(zzak zzak, Iterable iterable) {
        zzak.zzal();
        zzsh.zzS(iterable, zzak.zzj);
    }

    static /* synthetic */ void zzP(zzak zzak, int i2) {
        zzak.zzh = i2;
        zzak.zzg |= 1;
    }

    private final void zzal() {
        zzvh<zzak> zzvh = this.zzj;
        if (!zzvh.zzc()) {
            this.zzj = zzuz.zzah(zzvh);
        }
    }

    private final void zzam() {
        zzvh<zzak> zzvh = this.zzk;
        if (!zzvh.zzc()) {
            this.zzk = zzuz.zzah(zzvh);
        }
    }

    private final void zzan() {
        zzvh<zzak> zzvh = this.zzl;
        if (!zzvh.zzc()) {
            this.zzl = zzuz.zzah(zzvh);
        }
    }

    public static zzal zzg() {
        return (zzal) zzf.zzY();
    }

    public static zzak zzi() {
        return zzf;
    }

    static /* synthetic */ void zzu(zzak zzak, zzak zzak2) {
        zzak2.getClass();
        zzak.zzam();
        zzak.zzk.add(zzak2);
    }

    static /* synthetic */ void zzv(zzak zzak, Iterable iterable) {
        zzak.zzam();
        zzsh.zzS(iterable, zzak.zzk);
    }

    static /* synthetic */ void zzx(zzak zzak, zzak zzak2) {
        zzak2.getClass();
        zzak.zzan();
        zzak.zzl.add(zzak2);
    }

    static /* synthetic */ void zzy(zzak zzak, Iterable iterable) {
        zzak.zzan();
        zzsh.zzS(iterable, zzak.zzl);
    }

    public final boolean zzM() {
        return this.zzp;
    }

    public final boolean zzN() {
        return this.zzs;
    }

    public final int zzO() {
        int zza = zzar.zza(this.zzh);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zza() {
        return this.zzj.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        Class<zzak> cls = zzak.class;
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.zzt);
        }
        byte b2 = 1;
        if (i3 == 2) {
            return zzaj(zzf, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0005\u0005\u0001ᔌ\u0000\u0002ဈ\u0001\u0003Л\u0004Л\u0005Л\u0006ဈ\u0002\u0007ဈ\u0003\bဂ\u0004\tဇ\u0006\n\u001e\u000bЛ\fဇ\u0005", new Object[]{"zzg", "zzh", zzaq.zza, "zzi", "zzj", cls, "zzk", cls, "zzl", cls, "zzm", "zzn", "zzo", "zzs", "zzr", zzao.zzc(), "zzq", cls, "zzp"});
        } else if (i3 == 3) {
            return new zzak();
        } else {
            if (i3 == 4) {
                return new zzal((zzaj) null);
            }
            if (i3 == 5) {
                return zzf;
            }
            if (obj == null) {
                b2 = 0;
            }
            this.zzt = b2;
            return null;
        }
    }

    public final int zzc() {
        return this.zzk.size();
    }

    public final int zzd() {
        return this.zzl.size();
    }

    public final int zze() {
        return this.zzq.size();
    }

    public final long zzf() {
        return this.zzo;
    }

    public final zzak zzj(int i2) {
        return (zzak) this.zzj.get(i2);
    }

    public final zzak zzk(int i2) {
        return (zzak) this.zzk.get(i2);
    }

    public final zzak zzl(int i2) {
        return (zzak) this.zzl.get(i2);
    }

    public final zzak zzm(int i2) {
        return (zzak) this.zzq.get(i2);
    }

    public final String zzn() {
        return this.zzn;
    }

    public final String zzo() {
        return this.zzm;
    }

    public final String zzp() {
        return this.zzi;
    }

    public final List<zzao> zzq() {
        return new zzvg(this.zzr, zze);
    }

    public final List<zzak> zzr() {
        return this.zzj;
    }

    public final List<zzak> zzs() {
        return this.zzq;
    }
}
