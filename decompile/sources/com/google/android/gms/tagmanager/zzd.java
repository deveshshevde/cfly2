package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.f;
import gf.a;

public final class zzd {
    private static final Object zza = new Object();
    private static zzd zzb;
    private volatile long zzc = 900000;
    private volatile long zzd = 30000;
    private volatile boolean zze = false;
    private volatile a.C0184a zzf;
    private volatile long zzg;
    private volatile long zzh;
    /* access modifiers changed from: private */
    public final Context zzi;
    private final d zzj;
    private final Thread zzk;
    private final Object zzl = new Object();
    private final zzc zzm = new zza(this);

    public zzd(Context context, zzc zzc2, d dVar) {
        this.zzj = dVar;
        this.zzi = context != null ? context.getApplicationContext() : null;
        this.zzg = dVar.a();
        this.zzk = new Thread(new zzb(this));
    }

    public static zzd zzb(Context context) {
        if (zzb == null) {
            synchronized (zza) {
                if (zzb == null) {
                    zzd zzd2 = new zzd(context, (zzc) null, f.c());
                    zzb = zzd2;
                    zzd2.zzk.start();
                }
            }
        }
        return zzb;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    static /* synthetic */ void zzd(com.google.android.gms.tagmanager.zzd r4) {
        /*
            r0 = 10
            android.os.Process.setThreadPriority(r0)
        L_0x0005:
            boolean r0 = r4.zze
            if (r0 != 0) goto L_0x0041
            com.google.android.gms.tagmanager.zzc r0 = r4.zzm
            gf.a$a r0 = r0.zza()
            if (r0 == 0) goto L_0x0022
            r4.zzf = r0
            com.google.android.gms.common.util.d r0 = r4.zzj
            long r0 = r0.a()
            r4.zzh = r0
            com.google.android.gms.tagmanager.zzbg r0 = com.google.android.gms.tagmanager.zzdh.zzb
            java.lang.String r1 = "Obtained fresh AdvertisingId info from GmsCore."
            r0.zzb(r1)
        L_0x0022:
            monitor-enter(r4)
            r4.notifyAll()     // Catch:{ all -> 0x003e }
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            java.lang.Object r0 = r4.zzl     // Catch:{ InterruptedException -> 0x0036 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0036 }
            java.lang.Object r1 = r4.zzl     // Catch:{ all -> 0x0033 }
            long r2 = r4.zzc     // Catch:{ all -> 0x0033 }
            r1.wait(r2)     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            goto L_0x0005
        L_0x0033:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1     // Catch:{ InterruptedException -> 0x0036 }
        L_0x0036:
            com.google.android.gms.tagmanager.zzbg r0 = com.google.android.gms.tagmanager.zzdh.zzb
            java.lang.String r1 = "sleep interrupted in AdvertiserDataPoller thread; continuing"
            r0.zzb(r1)
            goto L_0x0005
        L_0x003e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003e }
            throw r0
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzd.zzd(com.google.android.gms.tagmanager.zzd):void");
    }

    public final void zze() {
        this.zze = true;
        this.zzk.interrupt();
    }
}
