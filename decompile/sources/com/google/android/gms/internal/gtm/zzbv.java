package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzr;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.f;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public final class zzbv {
    private static volatile zzbv zza;
    private final Context zzb;
    private final Context zzc;
    private final d zzd = f.c();
    private final zzct zze = new zzct(this);
    private final zzfb zzf;
    private final zzr zzg;
    private final zzbq zzh;
    private final zzcy zzi;
    private final zzft zzj;
    private final zzfh zzk;
    private final GoogleAnalytics zzl;
    private final zzcn zzm;
    private final zzbi zzn;
    private final zzcf zzo;
    private final zzcx zzp;

    protected zzbv(zzbw zzbw) {
        Context zza2 = zzbw.zza();
        m.a(zza2, (Object) "Application context can't be null");
        Context zzb2 = zzbw.zzb();
        m.a(zzb2);
        this.zzb = zza2;
        this.zzc = zzb2;
        zzfb zzfb = new zzfb(this);
        zzfb.zzX();
        this.zzf = zzfb;
        zzfb zzm2 = zzm();
        String str = zzbt.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + IChannelListener.CMD_CHANNEL_ERROR_CONNECT);
        sb.append("Google Analytics ");
        sb.append(str);
        sb.append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        zzm2.zzM(sb.toString());
        zzfh zzfh = new zzfh(this);
        zzfh.zzX();
        this.zzk = zzfh;
        zzft zzft = new zzft(this);
        zzft.zzX();
        this.zzj = zzft;
        zzbq zzbq = new zzbq(this, zzbw);
        zzcn zzcn = new zzcn(this);
        zzbi zzbi = new zzbi(this);
        zzcf zzcf = new zzcf(this);
        zzcx zzcx = new zzcx(this);
        zzr zzb3 = zzr.zzb(zza2);
        zzb3.zzj(new zzbu(this));
        this.zzg = zzb3;
        GoogleAnalytics googleAnalytics = new GoogleAnalytics(this);
        zzcn.zzX();
        this.zzm = zzcn;
        zzbi.zzX();
        this.zzn = zzbi;
        zzcf.zzX();
        this.zzo = zzcf;
        zzcx.zzX();
        this.zzp = zzcx;
        zzcy zzcy = new zzcy(this);
        zzcy.zzX();
        this.zzi = zzcy;
        zzbq.zzX();
        this.zzh = zzbq;
        googleAnalytics.zzg();
        this.zzl = googleAnalytics;
        zzbq.zzm();
    }

    public static zzbv zzg(Context context) {
        m.a(context);
        if (zza == null) {
            synchronized (zzbv.class) {
                if (zza == null) {
                    d c2 = f.c();
                    long b2 = c2.b();
                    zzbv zzbv = new zzbv(new zzbw(context));
                    zza = zzbv;
                    GoogleAnalytics.zzf();
                    long b3 = c2.b() - b2;
                    long longValue = zzeu.zzQ.zzb().longValue();
                    if (b3 > longValue) {
                        zzbv.zzm().zzT("Slow initialization (ms)", Long.valueOf(b3), Long.valueOf(longValue));
                    }
                }
            }
        }
        return zza;
    }

    private static final void zzs(zzbs zzbs) {
        m.a(zzbs, (Object) "Analytics service not created/initialized");
        m.a(zzbs.zzY(), (Object) "Analytics service not initialized");
    }

    public final Context zza() {
        return this.zzb;
    }

    public final Context zzb() {
        return this.zzc;
    }

    public final GoogleAnalytics zzc() {
        m.a(this.zzl);
        m.a(this.zzl.zzj(), (Object) "Analytics instance not initialized");
        return this.zzl;
    }

    public final zzr zzd() {
        m.a(this.zzg);
        return this.zzg;
    }

    public final zzbi zze() {
        zzs(this.zzn);
        return this.zzn;
    }

    public final zzbq zzf() {
        zzs(this.zzh);
        return this.zzh;
    }

    public final zzcf zzh() {
        zzs(this.zzo);
        return this.zzo;
    }

    public final zzcn zzi() {
        zzs(this.zzm);
        return this.zzm;
    }

    public final zzct zzj() {
        return this.zze;
    }

    public final zzcx zzk() {
        return this.zzp;
    }

    public final zzcy zzl() {
        zzs(this.zzi);
        return this.zzi;
    }

    public final zzfb zzm() {
        zzs(this.zzf);
        return this.zzf;
    }

    public final zzfb zzn() {
        return this.zzf;
    }

    public final zzfh zzo() {
        zzs(this.zzk);
        return this.zzk;
    }

    public final zzfh zzp() {
        zzfh zzfh = this.zzk;
        if (zzfh == null || !zzfh.zzY()) {
            return null;
        }
        return this.zzk;
    }

    public final zzft zzq() {
        zzs(this.zzj);
        return this.zzj;
    }

    public final d zzr() {
        return this.zzd;
    }
}
