package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.internal.m;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zza;
    private final zzfp zzb;
    private final Context zzc;
    private final DataLayer zzd;
    private final zzey zze;
    private final ConcurrentMap<String, zzaa> zzf = new ConcurrentHashMap();
    private final zzap zzg;

    TagManager(Context context, zzfp zzfp, DataLayer dataLayer, zzey zzey) {
        Context applicationContext = context.getApplicationContext();
        this.zzc = applicationContext;
        this.zze = zzey;
        this.zzb = zzfp;
        this.zzd = dataLayer;
        dataLayer.zzg(new zzfm(this));
        dataLayer.zzg(new zzg(applicationContext));
        this.zzg = new zzap();
        m.a(applicationContext);
        applicationContext.registerComponentCallbacks(new zzfo(this));
        m.a(applicationContext);
        zzd.zzb(applicationContext);
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zza == null) {
                if (context != null) {
                    zza = new TagManager(context, new zzfn(), new DataLayer(new zzbe(context)), zzff.zzg());
                } else {
                    zzdh.zza("TagManager.getInstance requires non-null context.");
                    throw null;
                }
            }
            tagManager = zza;
        }
        return tagManager;
    }

    static /* synthetic */ void zzb(TagManager tagManager, String str) {
        m.a(tagManager.zzf);
        for (zzaa zzd2 : tagManager.zzf.values()) {
            zzd2.zzd(str);
        }
    }

    public void dispatch() {
        this.zze.zza();
    }

    public final boolean zzc(zzaa zzaa) {
        return this.zzf.remove(zzaa.zza()) != null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzd(android.net.Uri r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.tagmanager.zzea r0 = com.google.android.gms.tagmanager.zzea.zza()     // Catch:{ all -> 0x0070 }
            boolean r7 = r0.zzd(r7)     // Catch:{ all -> 0x0070 }
            if (r7 == 0) goto L_0x006d
            java.lang.String r7 = r0.zzc()     // Catch:{ all -> 0x0070 }
            int r1 = r0.zze()     // Catch:{ all -> 0x0070 }
            int r2 = r1 + -1
            r3 = 0
            if (r1 == 0) goto L_0x006c
            r1 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r1) goto L_0x0021
            r4 = 2
            if (r2 == r4) goto L_0x0021
            goto L_0x006a
        L_0x0021:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.tagmanager.zzaa> r2 = r6.zzf     // Catch:{ all -> 0x0070 }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x0070 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0070 }
        L_0x002b:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x006a
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0070 }
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.tagmanager.zzaa> r5 = r6.zzf     // Catch:{ all -> 0x0070 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x0070 }
            com.google.android.gms.tagmanager.zzaa r5 = (com.google.android.gms.tagmanager.zzaa) r5     // Catch:{ all -> 0x0070 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x0050
            java.lang.String r4 = r0.zzb()     // Catch:{ all -> 0x0070 }
            r5.zze(r4)     // Catch:{ all -> 0x0070 }
        L_0x004c:
            r5.refresh()     // Catch:{ all -> 0x0070 }
            goto L_0x002b
        L_0x0050:
            java.lang.String r4 = r5.zzb()     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x002b
            r5.zze(r3)     // Catch:{ all -> 0x0070 }
            goto L_0x004c
        L_0x005a:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.tagmanager.zzaa> r0 = r6.zzf     // Catch:{ all -> 0x0070 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0070 }
            com.google.android.gms.tagmanager.zzaa r7 = (com.google.android.gms.tagmanager.zzaa) r7     // Catch:{ all -> 0x0070 }
            if (r7 == 0) goto L_0x006a
            r7.zze(r3)     // Catch:{ all -> 0x0070 }
            r7.refresh()     // Catch:{ all -> 0x0070 }
        L_0x006a:
            monitor-exit(r6)
            return r1
        L_0x006c:
            throw r3     // Catch:{ all -> 0x0070 }
        L_0x006d:
            r7 = 0
            monitor-exit(r6)
            return r7
        L_0x0070:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x0074
        L_0x0073:
            throw r7
        L_0x0074:
            goto L_0x0073
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.TagManager.zzd(android.net.Uri):boolean");
    }
}
