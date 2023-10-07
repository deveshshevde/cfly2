package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.analytics.zzr;
import com.google.android.gms.common.internal.m;
import gi.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzck extends zzbs {
    private boolean zza;
    private final zzce zzb;
    private final zzfe zzc;
    private final zzfc zzd;
    private final zzcc zze;
    private long zzf = Long.MIN_VALUE;
    private final zzcw zzg;
    private final zzcw zzh;
    private final zzfo zzi;
    private long zzj;
    private boolean zzk;

    protected zzck(zzbv zzbv, zzbw zzbw) {
        super(zzbv);
        m.a(zzbw);
        this.zzd = new zzfc(zzbv);
        this.zzb = new zzce(zzbv);
        this.zzc = new zzfe(zzbv);
        this.zze = new zzcc(zzbv);
        this.zzi = new zzfo(zzC());
        this.zzg = new zzcg(this, zzbv);
        this.zzh = new zzch(this, zzbv);
    }

    private final void zzag() {
        zzcy zzy = zzy();
        if (zzy.zze()) {
            zzy.zza();
        }
    }

    private final void zzah() {
        if (this.zzg.zzh()) {
            zzO("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzg.zzf();
    }

    private final void zzai() {
        long j2;
        zzcy zzy = zzy();
        if (zzy.zzc() && !zzy.zze()) {
            zzr.zzh();
            zzW();
            try {
                j2 = this.zzb.zzc();
            } catch (SQLiteException e2) {
                zzK("Failed to get min/max hit times from local store", e2);
                j2 = 0;
            }
            if (j2 != 0) {
                long abs = Math.abs(zzC().a() - j2);
                zzw();
                if (abs <= zzeu.zzn.zzb().longValue()) {
                    zzw();
                    zzP("Dispatch alarm scheduled (ms)", Long.valueOf(zzct.zzd()));
                    zzy.zzb();
                }
            }
        }
    }

    private final void zzaj(zzbx zzbx, zzaw zzaw) {
        m.a(zzbx);
        m.a(zzaw);
        zza zza2 = new zza(zzt());
        zza2.zzc(zzbx.zzc());
        zza2.zzd(zzbx.zzf());
        zzh zza3 = zza2.zza();
        zzbe zzbe = (zzbe) zza3.zzb(zzbe.class);
        zzbe.zzk(AeUtil.ROOT_DATA_PATH_OLD_NAME);
        zzbe.zzl(true);
        zza3.zzg(zzaw);
        zzaz zzaz = (zzaz) zza3.zzb(zzaz.class);
        zzav zzav = (zzav) zza3.zzb(zzav.class);
        for (Map.Entry next : zzbx.zzd().entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if ("an".equals(str)) {
                zzav.zzk(str2);
            } else if ("av".equals(str)) {
                zzav.zzl(str2);
            } else if ("aid".equals(str)) {
                zzav.zzi(str2);
            } else if ("aiid".equals(str)) {
                zzav.zzj(str2);
            } else if ("uid".equals(str)) {
                zzbe.zzm(str2);
            } else {
                zzaz.zze(str, str2);
            }
        }
        zzH("Sending installation campaign to", zzbx.zzc(), zzaw);
        zza3.zzj(zzA().zza());
        zza3.zzk();
    }

    private final boolean zzak(String str) {
        return c.a(zzo()).a(str) == 0;
    }

    static /* synthetic */ void zzc(zzck zzck) {
        try {
            zzck.zzb.zza();
            zzck.zzae();
        } catch (SQLiteException e2) {
            zzck.zzS("Failed to delete stale hits", e2);
        }
        zzcw zzcw = zzck.zzh;
        zzck.zzw();
        zzcw.zzg(86400000);
    }

    public final void zzZ(long j2) {
        zzr.zzh();
        zzW();
        if (j2 < 0) {
            j2 = 0;
        }
        this.zzf = j2;
        zzae();
    }

    public final long zza() {
        long j2 = this.zzf;
        if (j2 != Long.MIN_VALUE) {
            return j2;
        }
        zzw();
        long longValue = zzeu.zzi.zzb().longValue();
        zzft zzB = zzB();
        zzB.zzW();
        if (!zzB.zzc) {
            return longValue;
        }
        zzft zzB2 = zzB();
        zzB2.zzW();
        return ((long) zzB2.zzd) * 1000;
    }

    /* access modifiers changed from: package-private */
    public final void zzaa() {
        zzW();
        m.b(!this.zza, "Analytics backend already started");
        this.zza = true;
        zzq().zzi(new zzci(this));
    }

    /* access modifiers changed from: protected */
    public final void zzab() {
        zzW();
        zzw();
        zzr.zzh();
        Context zza2 = zzt().zza();
        if (!zzfi.zza(zza2)) {
            zzR("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzfn.zzh(zza2)) {
            zzJ("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzb(zza2)) {
            zzR("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzA().zza();
        if (!zzak("android.permission.ACCESS_NETWORK_STATE")) {
            zzJ("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzad();
        }
        if (!zzak("android.permission.INTERNET")) {
            zzJ("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzad();
        }
        if (zzfn.zzh(zzo())) {
            zzO("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzw();
            zzR("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzk) {
            zzw();
            if (!this.zzb.zzac()) {
                zzi();
            }
        }
        zzae();
    }

    public final void zzac() {
        zzr.zzh();
        zzW();
        zzF("Sync dispatching local hits");
        long j2 = this.zzj;
        zzw();
        zzi();
        try {
            zzaf();
            zzA().zzi();
            zzae();
            if (this.zzj != j2) {
                this.zzd.zzb();
            }
        } catch (Exception e2) {
            zzK("Sync local dispatch failed", e2);
            zzae();
        }
    }

    public final void zzad() {
        zzW();
        zzr.zzh();
        this.zzk = true;
        this.zze.zzc();
        zzae();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
        if (r4 <= 0) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzae() {
        /*
            r8 = this;
            com.google.android.gms.analytics.zzr.zzh()
            r8.zzW()
            boolean r0 = r8.zzk
            if (r0 == 0) goto L_0x000c
            goto L_0x00ae
        L_0x000c:
            r8.zzw()
            long r0 = r8.zza()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00ae
            com.google.android.gms.internal.gtm.zzce r0 = r8.zzb
            boolean r0 = r0.zzac()
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.gtm.zzfc r0 = r8.zzd
            r0.zzc()
            r8.zzah()
            r8.zzag()
            return
        L_0x002d:
            com.google.android.gms.internal.gtm.zzet<java.lang.Boolean> r0 = com.google.android.gms.internal.gtm.zzeu.zzJ
            java.lang.Object r0 = r0.zzb()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0053
            com.google.android.gms.internal.gtm.zzfc r0 = r8.zzd
            r0.zza()
            com.google.android.gms.internal.gtm.zzfc r0 = r8.zzd
            boolean r0 = r0.zzd()
            if (r0 == 0) goto L_0x0049
            goto L_0x0053
        L_0x0049:
            r8.zzah()
            r8.zzag()
            r8.zzai()
            return
        L_0x0053:
            r8.zzai()
            long r0 = r8.zza()
            com.google.android.gms.internal.gtm.zzfh r4 = r8.zzA()
            long r4 = r4.zzb()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0079
            com.google.android.gms.common.util.d r6 = r8.zzC()
            long r6 = r6.a()
            long r6 = r6 - r4
            long r4 = java.lang.Math.abs(r6)
            long r4 = r0 - r4
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x0084
        L_0x0079:
            r8.zzw()
            long r2 = com.google.android.gms.internal.gtm.zzct.zze()
            long r4 = java.lang.Math.min(r2, r0)
        L_0x0084:
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            java.lang.String r1 = "Dispatch scheduled (ms)"
            r8.zzP(r1, r0)
            com.google.android.gms.internal.gtm.zzcw r0 = r8.zzg
            boolean r0 = r0.zzh()
            if (r0 == 0) goto L_0x00a8
            com.google.android.gms.internal.gtm.zzcw r0 = r8.zzg
            long r0 = r0.zzb()
            r2 = 1
            long r4 = r4 + r0
            long r0 = java.lang.Math.max(r2, r4)
            com.google.android.gms.internal.gtm.zzcw r2 = r8.zzg
            r2.zze(r0)
            return
        L_0x00a8:
            com.google.android.gms.internal.gtm.zzcw r0 = r8.zzg
            r0.zzg(r4)
            return
        L_0x00ae:
            com.google.android.gms.internal.gtm.zzfc r0 = r8.zzd
            r0.zzc()
            r8.zzah()
            r8.zzag()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzae():void");
    }

    /* access modifiers changed from: protected */
    public final boolean zzaf() {
        boolean z2;
        zzr.zzh();
        zzW();
        zzO("Dispatching a batch of local hits");
        if (!this.zze.zzg()) {
            zzw();
            z2 = true;
        } else {
            z2 = false;
        }
        boolean zze2 = true ^ this.zzc.zze();
        if (!z2 || !zze2) {
            zzw();
            int zzh2 = zzct.zzh();
            zzw();
            long max = (long) Math.max(zzh2, zzct.zzg());
            ArrayList arrayList = new ArrayList();
            long j2 = 0;
            while (true) {
                try {
                    this.zzb.zzm();
                    arrayList.clear();
                    try {
                        List<zzex> zzj2 = this.zzb.zzj(max);
                        if (zzj2.isEmpty()) {
                            zzO("Store is empty, nothing to dispatch");
                            zzah();
                            zzag();
                            try {
                                this.zzb.zzab();
                                this.zzb.zzaa();
                                return false;
                            } catch (SQLiteException e2) {
                                zzK("Failed to commit local dispatch transaction", e2);
                                zzah();
                                zzag();
                                return false;
                            }
                        } else {
                            zzP("Hits loaded from store. count", Integer.valueOf(zzj2.size()));
                            for (zzex zzb2 : zzj2) {
                                if (zzb2.zzb() == j2) {
                                    zzL("Database contains successfully uploaded hit", Long.valueOf(j2), Integer.valueOf(zzj2.size()));
                                    zzah();
                                    zzag();
                                    try {
                                        this.zzb.zzab();
                                        this.zzb.zzaa();
                                        return false;
                                    } catch (SQLiteException e3) {
                                        zzK("Failed to commit local dispatch transaction", e3);
                                        zzah();
                                        zzag();
                                        return false;
                                    }
                                }
                            }
                            if (this.zze.zzg()) {
                                zzw();
                                zzO("Service connected, sending hits to the service");
                                while (true) {
                                    if (!zzj2.isEmpty()) {
                                        zzex zzex = zzj2.get(0);
                                        if (!this.zze.zzh(zzex)) {
                                            break;
                                        }
                                        j2 = Math.max(j2, zzex.zzb());
                                        zzj2.remove(zzex);
                                        zzG("Hit sent do device AnalyticsService for delivery", zzex);
                                        this.zzb.zzn(zzex.zzb());
                                        arrayList.add(Long.valueOf(zzex.zzb()));
                                    }
                                }
                            }
                            if (this.zzc.zze()) {
                                List<Long> zzc2 = this.zzc.zzc(zzj2);
                                for (Long longValue : zzc2) {
                                    j2 = Math.max(j2, longValue.longValue());
                                }
                                try {
                                    this.zzb.zzZ(zzc2);
                                    arrayList.addAll(zzc2);
                                } catch (SQLiteException e4) {
                                    zzK("Failed to remove successfully uploaded hits", e4);
                                    zzah();
                                    zzag();
                                    try {
                                        this.zzb.zzab();
                                        this.zzb.zzaa();
                                        return false;
                                    } catch (SQLiteException e5) {
                                        zzK("Failed to commit local dispatch transaction", e5);
                                        zzah();
                                        zzag();
                                        return false;
                                    }
                                }
                            }
                            if (arrayList.isEmpty()) {
                                try {
                                    this.zzb.zzab();
                                    this.zzb.zzaa();
                                    return false;
                                } catch (SQLiteException e6) {
                                    zzK("Failed to commit local dispatch transaction", e6);
                                    zzah();
                                    zzag();
                                    return false;
                                }
                            } else {
                                try {
                                    this.zzb.zzab();
                                    this.zzb.zzaa();
                                } catch (SQLiteException e7) {
                                    zzK("Failed to commit local dispatch transaction", e7);
                                    zzah();
                                    zzag();
                                    return false;
                                }
                            }
                        }
                    } catch (SQLiteException e8) {
                        zzS("Failed to read hits from persisted store", e8);
                        zzah();
                        zzag();
                        try {
                            this.zzb.zzab();
                            this.zzb.zzaa();
                            return false;
                        } catch (SQLiteException e9) {
                            zzK("Failed to commit local dispatch transaction", e9);
                            zzah();
                            zzag();
                            return false;
                        }
                    }
                } catch (SQLiteException e10) {
                    zzK("Failed to remove hit that was send for delivery", e10);
                    zzah();
                    zzag();
                    try {
                        this.zzb.zzab();
                        this.zzb.zzaa();
                        return false;
                    } catch (SQLiteException e11) {
                        zzK("Failed to commit local dispatch transaction", e11);
                        zzah();
                        zzag();
                        return false;
                    }
                } catch (Throwable th) {
                    try {
                        this.zzb.zzab();
                        this.zzb.zzaa();
                        throw th;
                    } catch (SQLiteException e12) {
                        zzK("Failed to commit local dispatch transaction", e12);
                        zzah();
                        zzag();
                        return false;
                    }
                }
            }
        } else {
            zzO("No network or service available. Will retry later");
            return false;
        }
    }

    public final long zzb(zzbx zzbx, boolean z2) {
        m.a(zzbx);
        zzW();
        zzr.zzh();
        try {
            this.zzb.zzm();
            zzce zzce = this.zzb;
            String zzb2 = zzbx.zzb();
            m.a(zzb2);
            zzce.zzW();
            zzr.zzh();
            int delete = zzce.zzf().delete("properties", "app_uid=? AND cid<>?", new String[]{"0", zzb2});
            if (delete > 0) {
                zzce.zzP("Deleted property records", Integer.valueOf(delete));
            }
            long zze2 = this.zzb.zze(0, zzbx.zzb(), zzbx.zzc());
            zzbx.zze(1 + zze2);
            zzce zzce2 = this.zzb;
            m.a(zzbx);
            zzce2.zzW();
            zzr.zzh();
            SQLiteDatabase zzf2 = zzce2.zzf();
            Map<String, String> zzd2 = zzbx.zzd();
            m.a(zzd2);
            Uri.Builder builder = new Uri.Builder();
            for (Map.Entry next : zzd2.entrySet()) {
                builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
            String encodedQuery = builder.build().getEncodedQuery();
            if (encodedQuery == null) {
                encodedQuery = "";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uid", 0L);
            contentValues.put("cid", zzbx.zzb());
            contentValues.put("tid", zzbx.zzc());
            contentValues.put("adid", Integer.valueOf(zzbx.zzf() ? 1 : 0));
            contentValues.put("hits_count", Long.valueOf(zzbx.zza()));
            contentValues.put("params", encodedQuery);
            try {
                if (zzf2.insertWithOnConflict("properties", (String) null, contentValues, 5) == -1) {
                    zzce2.zzJ("Failed to insert/update a property (got -1)");
                }
            } catch (SQLiteException e2) {
                zzce2.zzK("Error storing a property", e2);
            }
            this.zzb.zzab();
            try {
                this.zzb.zzaa();
            } catch (SQLiteException e3) {
                zzK("Failed to end transaction", e3);
            }
            return zze2;
        } catch (SQLiteException e4) {
            zzK("Failed to update Analytics property", e4);
            try {
                this.zzb.zzaa();
            } catch (SQLiteException e5) {
                zzK("Failed to end transaction", e5);
            }
            return -1;
        } catch (Throwable th) {
            try {
                this.zzb.zzaa();
            } catch (SQLiteException e6) {
                zzK("Failed to end transaction", e6);
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        this.zzb.zzX();
        this.zzc.zzX();
        this.zze.zzX();
    }

    public final void zzf(zzcz zzcz) {
        zzg(zzcz, this.zzj);
    }

    public final void zzg(zzcz zzcz, long j2) {
        zzr.zzh();
        zzW();
        long zzb2 = zzA().zzb();
        zzG("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(zzb2 != 0 ? Math.abs(zzC().a() - zzb2) : -1));
        zzw();
        zzi();
        try {
            zzaf();
            zzA().zzi();
            zzae();
            if (zzcz != null) {
                zzcz.zza((Throwable) null);
            }
            if (this.zzj != j2) {
                this.zzd.zzb();
            }
        } catch (Exception e2) {
            zzK("Local dispatch failed", e2);
            zzA().zzi();
            zzae();
            if (zzcz != null) {
                zzcz.zza(e2);
            }
        }
    }

    public final void zzh() {
        zzr.zzh();
        zzW();
        zzw();
        zzO("Delete all hits from local store");
        try {
            zzce zzce = this.zzb;
            zzr.zzh();
            zzce.zzW();
            zzce.zzf().delete("hits2", (String) null, (String[]) null);
            zzce zzce2 = this.zzb;
            zzr.zzh();
            zzce2.zzW();
            zzce2.zzf().delete("properties", (String) null, (String[]) null);
            zzae();
        } catch (SQLiteException e2) {
            zzS("Failed to delete hits from store", e2);
        }
        zzi();
        if (this.zze.zze()) {
            zzO("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    /* access modifiers changed from: protected */
    public final void zzi() {
        if (!this.zzk) {
            zzw();
            if (zzct.zzl() && !this.zze.zzg()) {
                zzw();
                if (this.zzi.zzc(zzeu.zzO.zzb().longValue())) {
                    this.zzi.zzb();
                    zzO("Connecting to service");
                    if (this.zze.zzf()) {
                        zzO("Connected to service");
                        this.zzi.zza();
                        zzm();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0174, code lost:
        if (r2 != null) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0185, code lost:
        if (r2 != null) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0188, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019e A[Catch:{ SQLiteException -> 0x020a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(com.google.android.gms.internal.gtm.zzex r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.lang.String r2 = "hit_id"
            com.google.android.gms.common.internal.m.a(r22)
            com.google.android.gms.analytics.zzr.zzh()
            r21.zzW()
            boolean r3 = r1.zzk
            if (r3 == 0) goto L_0x0019
            java.lang.String r3 = "Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions"
            r1.zzF(r3)
            goto L_0x001e
        L_0x0019:
            java.lang.String r3 = "Delivering hit"
            r1.zzP(r3, r0)
        L_0x001e:
            java.lang.String r3 = r22.zzf()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r4 = 1
            if (r3 == 0) goto L_0x007b
            com.google.android.gms.internal.gtm.zzfh r3 = r21.zzA()
            com.google.android.gms.internal.gtm.zzfg r3 = r3.zze()
            android.util.Pair r3 = r3.zza()
            if (r3 == 0) goto L_0x007b
            java.lang.Object r5 = r3.second
            java.lang.Long r5 = (java.lang.Long) r5
            java.lang.Object r3 = r3.first
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = java.lang.String.valueOf(r5)
            int r6 = r6.length()
            java.lang.String r7 = java.lang.String.valueOf(r3)
            int r7 = r7.length()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r6 = r6 + r4
            int r6 = r6 + r7
            r8.<init>(r6)
            r8.append(r5)
            java.lang.String r5 = ":"
            r8.append(r5)
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            java.util.HashMap r5 = new java.util.HashMap
            java.util.Map r6 = r22.zzg()
            r5.<init>(r6)
            java.lang.String r6 = "_m"
            r5.put(r6, r3)
            com.google.android.gms.internal.gtm.zzex r0 = com.google.android.gms.internal.gtm.zzex.zze(r1, r0, r5)
        L_0x007b:
            r3 = r0
            r21.zzi()
            com.google.android.gms.internal.gtm.zzcc r0 = r1.zze
            boolean r0 = r0.zzh(r3)
            if (r0 == 0) goto L_0x008d
            java.lang.String r0 = "Hit sent to the device AnalyticsService for delivery"
            r1.zzF(r0)
            return
        L_0x008d:
            r21.zzw()
            com.google.android.gms.internal.gtm.zzce r5 = r1.zzb     // Catch:{ SQLiteException -> 0x020a }
            com.google.android.gms.common.internal.m.a(r3)     // Catch:{ SQLiteException -> 0x020a }
            com.google.android.gms.analytics.zzr.zzh()     // Catch:{ SQLiteException -> 0x020a }
            r5.zzW()     // Catch:{ SQLiteException -> 0x020a }
            com.google.android.gms.common.internal.m.a(r3)     // Catch:{ SQLiteException -> 0x020a }
            android.net.Uri$Builder r0 = new android.net.Uri$Builder     // Catch:{ SQLiteException -> 0x020a }
            r0.<init>()     // Catch:{ SQLiteException -> 0x020a }
            java.util.Map r6 = r3.zzg()     // Catch:{ SQLiteException -> 0x020a }
            java.util.Set r6 = r6.entrySet()     // Catch:{ SQLiteException -> 0x020a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ SQLiteException -> 0x020a }
        L_0x00af:
            boolean r7 = r6.hasNext()     // Catch:{ SQLiteException -> 0x020a }
            if (r7 == 0) goto L_0x00e3
            java.lang.Object r7 = r6.next()     // Catch:{ SQLiteException -> 0x020a }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ SQLiteException -> 0x020a }
            java.lang.Object r8 = r7.getKey()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r9 = "ht"
            boolean r9 = r9.equals(r8)     // Catch:{ SQLiteException -> 0x020a }
            if (r9 != 0) goto L_0x00af
            java.lang.String r9 = "qt"
            boolean r9 = r9.equals(r8)     // Catch:{ SQLiteException -> 0x020a }
            if (r9 != 0) goto L_0x00af
            java.lang.String r9 = "AppUID"
            boolean r9 = r9.equals(r8)     // Catch:{ SQLiteException -> 0x020a }
            if (r9 != 0) goto L_0x00af
            java.lang.Object r7 = r7.getValue()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ SQLiteException -> 0x020a }
            r0.appendQueryParameter(r8, r7)     // Catch:{ SQLiteException -> 0x020a }
            goto L_0x00af
        L_0x00e3:
            android.net.Uri r0 = r0.build()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r0 = r0.getEncodedQuery()     // Catch:{ SQLiteException -> 0x020a }
            if (r0 != 0) goto L_0x00ef
            java.lang.String r0 = ""
        L_0x00ef:
            r6 = r0
            int r0 = r6.length()     // Catch:{ SQLiteException -> 0x020a }
            r7 = 8192(0x2000, float:1.14794E-41)
            if (r0 <= r7) goto L_0x0103
            com.google.android.gms.internal.gtm.zzfb r0 = r5.zzz()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r2 = "Hit length exceeds the maximum allowed size"
            r0.zzb(r3, r2)     // Catch:{ SQLiteException -> 0x020a }
            goto L_0x0206
        L_0x0103:
            r5.zzw()     // Catch:{ SQLiteException -> 0x020a }
            com.google.android.gms.internal.gtm.zzet<java.lang.Integer> r0 = com.google.android.gms.internal.gtm.zzeu.zzf     // Catch:{ SQLiteException -> 0x020a }
            java.lang.Object r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ SQLiteException -> 0x020a }
            int r0 = r0.intValue()     // Catch:{ SQLiteException -> 0x020a }
            long r7 = r5.zzb()     // Catch:{ SQLiteException -> 0x020a }
            int r9 = r0 + -1
            long r9 = (long) r9     // Catch:{ SQLiteException -> 0x020a }
            r11 = 0
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x01a2
            long r9 = (long) r0     // Catch:{ SQLiteException -> 0x020a }
            long r7 = r7 - r9
            r9 = 1
            long r7 = r7 + r9
            com.google.android.gms.analytics.zzr.zzh()     // Catch:{ SQLiteException -> 0x020a }
            r5.zzW()     // Catch:{ SQLiteException -> 0x020a }
            r9 = 0
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 > 0) goto L_0x0134
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x020a }
            goto L_0x0189
        L_0x0134:
            android.database.sqlite.SQLiteDatabase r12 = r5.zzf()     // Catch:{ SQLiteException -> 0x020a }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x020a }
            r9.<init>()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String[] r14 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x017e, all -> 0x017c }
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ SQLiteException -> 0x017e, all -> 0x017c }
            r4 = 0
            r0[r4] = r2     // Catch:{ SQLiteException -> 0x017e, all -> 0x017c }
            java.lang.String r13 = "hits2"
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            java.lang.String r2 = "%s ASC"
            java.lang.String r19 = java.lang.String.format(r2, r0)     // Catch:{ SQLiteException -> 0x017e, all -> 0x017c }
            java.lang.String r20 = java.lang.Long.toString(r7)     // Catch:{ SQLiteException -> 0x017e, all -> 0x017c }
            android.database.Cursor r2 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x017e, all -> 0x017c }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r0 == 0) goto L_0x0174
        L_0x0163:
            long r7 = r2.getLong(r4)     // Catch:{ SQLiteException -> 0x017a }
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x017a }
            r9.add(r0)     // Catch:{ SQLiteException -> 0x017a }
            boolean r0 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x017a }
            if (r0 != 0) goto L_0x0163
        L_0x0174:
            if (r2 == 0) goto L_0x0188
        L_0x0176:
            r2.close()     // Catch:{ SQLiteException -> 0x020a }
            goto L_0x0188
        L_0x017a:
            r0 = move-exception
            goto L_0x0180
        L_0x017c:
            r0 = move-exception
            goto L_0x019c
        L_0x017e:
            r0 = move-exception
            r2 = r11
        L_0x0180:
            java.lang.String r4 = "Error selecting hit ids"
            r5.zzS(r4, r0)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x0188
            goto L_0x0176
        L_0x0188:
            r0 = r9
        L_0x0189:
            java.lang.String r2 = "Store full, deleting hits to make room, count"
            int r4 = r0.size()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x020a }
            r5.zzS(r2, r4)     // Catch:{ SQLiteException -> 0x020a }
            r5.zzZ(r0)     // Catch:{ SQLiteException -> 0x020a }
            goto L_0x01a2
        L_0x019a:
            r0 = move-exception
            r11 = r2
        L_0x019c:
            if (r11 == 0) goto L_0x01a1
            r11.close()     // Catch:{ SQLiteException -> 0x020a }
        L_0x01a1:
            throw r0     // Catch:{ SQLiteException -> 0x020a }
        L_0x01a2:
            android.database.sqlite.SQLiteDatabase r0 = r5.zzf()     // Catch:{ SQLiteException -> 0x020a }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x020a }
            r2.<init>()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r4 = "hit_string"
            r2.put(r4, r6)     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r4 = "hit_time"
            long r6 = r3.zzd()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x020a }
            r2.put(r4, r6)     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r4 = "hit_app_id"
            int r6 = r3.zza()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x020a }
            r2.put(r4, r6)     // Catch:{ SQLiteException -> 0x020a }
            boolean r4 = r3.zzh()     // Catch:{ SQLiteException -> 0x020a }
            if (r4 == 0) goto L_0x01d8
            r5.zzw()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r4 = com.google.android.gms.internal.gtm.zzct.zzi()     // Catch:{ SQLiteException -> 0x020a }
            goto L_0x01df
        L_0x01d8:
            r5.zzw()     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r4 = com.google.android.gms.internal.gtm.zzct.zzk()     // Catch:{ SQLiteException -> 0x020a }
        L_0x01df:
            java.lang.String r6 = "hit_url"
            r2.put(r6, r4)     // Catch:{ SQLiteException -> 0x020a }
            java.lang.String r4 = "hits2"
            long r6 = r0.insert(r4, r11, r2)     // Catch:{ SQLiteException -> 0x0200 }
            r8 = -1
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x01f6
            java.lang.String r0 = "Failed to insert a hit (got -1)"
            r5.zzJ(r0)     // Catch:{ SQLiteException -> 0x0200 }
            goto L_0x0206
        L_0x01f6:
            java.lang.String r0 = "Hit saved to database. db-id, hit"
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r5.zzH(r0, r2, r3)     // Catch:{ SQLiteException -> 0x0200 }
            goto L_0x0206
        L_0x0200:
            r0 = move-exception
            java.lang.String r2 = "Error storing a hit"
            r5.zzK(r2, r0)     // Catch:{ SQLiteException -> 0x020a }
        L_0x0206:
            r21.zzae()     // Catch:{ SQLiteException -> 0x020a }
            return
        L_0x020a:
            r0 = move-exception
            java.lang.String r2 = "Delivery failed to save hit to a database"
            r1.zzK(r2, r0)
            com.google.android.gms.internal.gtm.zzfb r0 = r21.zzz()
            java.lang.String r2 = "deliver: failed to insert hit to database"
            r0.zzb(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzj(com.google.android.gms.internal.gtm.zzex):void");
    }

    /* access modifiers changed from: protected */
    public final void zzk(zzbx zzbx) {
        zzr.zzh();
        zzG("Sending first hit to property", zzbx.zzc());
        zzfo zzf2 = zzA().zzf();
        zzw();
        if (!zzf2.zzc(zzct.zzc())) {
            String zzg2 = zzA().zzg();
            if (!TextUtils.isEmpty(zzg2)) {
                zzaw zzb2 = zzfs.zzb(zzz(), zzg2);
                zzG("Found relevant installation campaign", zzb2);
                zzaj(zzbx, zzb2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        zzr.zzh();
        this.zzj = zzC().a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[LOOP:1: B:14:0x004d->B:22:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080 A[SYNTHETIC, Splitter:B:26:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzm() {
        /*
            r5 = this;
            com.google.android.gms.analytics.zzr.zzh()
            r5.zzw()
            com.google.android.gms.analytics.zzr.zzh()
            r5.zzW()
            r5.zzE()
            r5.zzw()
            boolean r0 = com.google.android.gms.internal.gtm.zzct.zzl()
            if (r0 != 0) goto L_0x001d
            java.lang.String r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService"
            r5.zzR(r0)
        L_0x001d:
            com.google.android.gms.internal.gtm.zzcc r0 = r5.zze
            boolean r0 = r0.zzg()
            if (r0 != 0) goto L_0x002b
            java.lang.String r0 = "Service not connected"
            r5.zzO(r0)
            return
        L_0x002b:
            com.google.android.gms.internal.gtm.zzce r0 = r5.zzb
            boolean r0 = r0.zzac()
            if (r0 == 0) goto L_0x0034
            return
        L_0x0034:
            java.lang.String r0 = "Dispatching local hits to device AnalyticsService"
            r5.zzO(r0)
        L_0x0039:
            com.google.android.gms.internal.gtm.zzce r0 = r5.zzb     // Catch:{ SQLiteException -> 0x0084 }
            r5.zzw()     // Catch:{ SQLiteException -> 0x0084 }
            int r1 = com.google.android.gms.internal.gtm.zzct.zzh()     // Catch:{ SQLiteException -> 0x0084 }
            long r1 = (long) r1     // Catch:{ SQLiteException -> 0x0084 }
            java.util.List r0 = r0.zzj(r1)     // Catch:{ SQLiteException -> 0x0084 }
            boolean r1 = r0.isEmpty()     // Catch:{ SQLiteException -> 0x0084 }
            if (r1 != 0) goto L_0x0080
        L_0x004d:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0039
            r1 = 0
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.gtm.zzex r1 = (com.google.android.gms.internal.gtm.zzex) r1
            com.google.android.gms.internal.gtm.zzcc r2 = r5.zze
            boolean r2 = r2.zzh(r1)
            if (r2 != 0) goto L_0x0066
            r5.zzae()
            return
        L_0x0066:
            r0.remove(r1)
            com.google.android.gms.internal.gtm.zzce r2 = r5.zzb     // Catch:{ SQLiteException -> 0x0073 }
            long r3 = r1.zzb()     // Catch:{ SQLiteException -> 0x0073 }
            r2.zzn(r3)     // Catch:{ SQLiteException -> 0x0073 }
            goto L_0x004d
        L_0x0073:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r5.zzK(r1, r0)
            r5.zzah()
            r5.zzag()
            return
        L_0x0080:
            r5.zzae()     // Catch:{ SQLiteException -> 0x0084 }
            return
        L_0x0084:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from store"
            r5.zzK(r1, r0)
            r5.zzah()
            r5.zzag()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzm():void");
    }

    public final void zzn(String str) {
        String str2 = str;
        m.a(str);
        zzr.zzh();
        zzE();
        zzaw zzb2 = zzfs.zzb(zzz(), str2);
        if (zzb2 == null) {
            zzS("Parsing failed. Ignoring invalid campaign data", str2);
            return;
        }
        String zzg2 = zzA().zzg();
        if (str2.equals(zzg2)) {
            zzR("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(zzg2)) {
            zzL("Ignoring multiple install campaigns. original, new", zzg2, str2);
        } else {
            zzA().zzh(str2);
            zzfo zzf2 = zzA().zzf();
            zzw();
            if (zzf2.zzc(zzct.zzc())) {
                zzS("Campaign received too late, ignoring", zzb2);
                return;
            }
            zzG("Received installation campaign", zzb2);
            zzce zzce = this.zzb;
            zzce.zzW();
            zzr.zzh();
            SQLiteDatabase zzf3 = zzce.zzf();
            Cursor cursor = null;
            try {
                zzce.zzw();
                int intValue = zzeu.zzh.zzb().intValue();
                Cursor query = zzf3.query("properties", new String[]{"cid", "tid", "adid", "hits_count", "params"}, "app_uid=?", new String[]{"0"}, (String) null, (String) null, (String) null, String.valueOf(intValue));
                ArrayList<zzbx> arrayList = new ArrayList<>();
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        boolean z2 = query.getInt(2) != 0;
                        long j2 = (long) query.getInt(3);
                        Map<String, String> zzl = zzce.zzl(query.getString(4));
                        if (!TextUtils.isEmpty(string)) {
                            if (!TextUtils.isEmpty(string2)) {
                                arrayList.add(new zzbx(0, string, string2, z2, j2, zzl));
                            }
                        }
                        zzce.zzT("Read property with empty client id or tracker id", string, string2);
                    } while (query.moveToNext());
                }
                if (arrayList.size() >= intValue) {
                    zzce.zzR("Sending hits to too many properties. Campaign report might be incorrect");
                }
                if (query != null) {
                    query.close();
                }
                for (zzbx zzaj : arrayList) {
                    zzaj(zzaj, zzb2);
                }
            } catch (SQLiteException e2) {
                zzce.zzK("Error loading hits from the database", e2);
                throw e2;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }
}
