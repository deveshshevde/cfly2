package com.google.android.gms.internal.gtm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzr;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.h;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzce extends zzbs implements Closeable {
    /* access modifiers changed from: private */
    public static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String zzb = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final zzcd zzc;
    private final zzfo zzd = new zzfo(zzC());
    /* access modifiers changed from: private */
    public final zzfo zze = new zzfo(zzC());

    zzce(zzbv zzbv) {
        super(zzbv);
        this.zzc = new zzcd(this, zzbv.zza(), zzae());
    }

    private final long zzad(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzf().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j3 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j3;
            } else if (rawQuery == null) {
                return 0;
            } else {
                rawQuery.close();
                return 0;
            }
        } catch (SQLiteException e2) {
            zzL("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final String zzae() {
        zzw();
        zzw();
        return "google_analytics_v4.db";
    }

    public final void close() {
        String str;
        try {
            this.zzc.close();
        } catch (SQLiteException e2) {
            e = e2;
            str = "Sql error closing database";
            zzK(str, e);
        } catch (IllegalStateException e3) {
            e = e3;
            str = "Error closing database";
            zzK(str, e);
        }
    }

    public final void zzZ(List<Long> list) {
        m.a(list);
        zzr.zzh();
        zzW();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            for (int i2 = 0; i2 < list.size(); i2++) {
                Long l2 = list.get(i2);
                if (l2 == null || l2.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(l2);
            }
            sb.append(")");
            String sb2 = sb.toString();
            try {
                SQLiteDatabase zzf = zzf();
                zzP("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = zzf.delete("hits2", sb2, (String[]) null);
                if (delete != list.size()) {
                    zzU("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                }
            } catch (SQLiteException e2) {
                zzK("Error deleting hits", e2);
                throw e2;
            }
        }
    }

    public final int zza() {
        zzr.zzh();
        zzW();
        if (!this.zzd.zzc(86400000)) {
            return 0;
        }
        this.zzd.zzb();
        zzO("Deleting stale hits (if any)");
        int delete = zzf().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzC().a() - 2592000000L)});
        zzP("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final void zzaa() {
        zzW();
        zzf().endTransaction();
    }

    public final void zzab() {
        zzW();
        zzf().setTransactionSuccessful();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzac() {
        return zzb() == 0;
    }

    public final long zzb() {
        zzr.zzh();
        zzW();
        Cursor cursor = null;
        try {
            cursor = zzf().rawQuery("SELECT COUNT(*) FROM hits2", (String[]) null);
            if (cursor.moveToFirst()) {
                long j2 = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j2;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            zzL("Database error", "SELECT COUNT(*) FROM hits2", e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zzc() {
        zzr.zzh();
        zzW();
        return zzad(zzb, (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
    }

    public final long zze(long j2, String str, String str2) {
        m.a(str);
        m.a(str2);
        zzW();
        zzr.zzh();
        return zzad("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{"0", str, str2}, 0);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase zzf() {
        try {
            return this.zzc.getWritableDatabase();
        } catch (SQLiteException e2) {
            zzS("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.gtm.zzex> zzj(long r17) {
        /*
            r16 = this;
            r11 = r16
            java.lang.String r0 = "hit_id"
            r12 = 0
            r13 = 1
            r1 = 0
            int r3 = (r17 > r1 ? 1 : (r17 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x000e
            r1 = 1
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            com.google.android.gms.common.internal.m.a((boolean) r1)
            com.google.android.gms.analytics.zzr.zzh()
            r16.zzW()
            android.database.sqlite.SQLiteDatabase r2 = r16.zzf()
            r1 = 0
            java.lang.String r3 = "hit_time"
            java.lang.String r4 = "hit_string"
            java.lang.String r5 = "hit_url"
            java.lang.String r6 = "hit_app_id"
            java.lang.String[] r4 = new java.lang.String[]{r0, r3, r4, r5, r6}     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ SQLiteException -> 0x009a }
            r3[r12] = r0     // Catch:{ SQLiteException -> 0x009a }
            java.lang.String r0 = "hits2"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "%s ASC"
            java.lang.String r9 = java.lang.String.format(r9, r3)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.String r10 = java.lang.Long.toString(r17)     // Catch:{ SQLiteException -> 0x009a }
            r3 = r0
            android.database.Cursor r14 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x009a }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r1 == 0) goto L_0x008c
        L_0x004d:
            long r7 = r14.getLong(r12)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            long r4 = r14.getLong(r13)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r1 = 2
            java.lang.String r1 = r14.getString(r1)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r2 = 3
            java.lang.String r2 = r14.getString(r2)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r3 = 4
            int r9 = r14.getInt(r3)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.util.Map r3 = r11.zzk(r1)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r1 == 0) goto L_0x0070
        L_0x006e:
            r6 = 1
            goto L_0x007a
        L_0x0070:
            java.lang.String r1 = "http:"
            boolean r1 = r2.startsWith(r1)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r1 != 0) goto L_0x0079
            goto L_0x006e
        L_0x0079:
            r6 = 0
        L_0x007a:
            com.google.android.gms.internal.gtm.zzex r15 = new com.google.android.gms.internal.gtm.zzex     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r10 = 0
            r1 = r15
            r2 = r16
            r1.<init>(r2, r3, r4, r6, r7, r9, r10)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r0.add(r15)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r1 != 0) goto L_0x004d
        L_0x008c:
            if (r14 == 0) goto L_0x0091
            r14.close()
        L_0x0091:
            return r0
        L_0x0092:
            r0 = move-exception
            r1 = r14
            goto L_0x00a1
        L_0x0095:
            r0 = move-exception
            r1 = r14
            goto L_0x009b
        L_0x0098:
            r0 = move-exception
            goto L_0x00a1
        L_0x009a:
            r0 = move-exception
        L_0x009b:
            java.lang.String r2 = "Error loading hits from the database"
            r11.zzK(r2, r0)     // Catch:{ all -> 0x0098 }
            throw r0     // Catch:{ all -> 0x0098 }
        L_0x00a1:
            if (r1 == 0) goto L_0x00a6
            r1.close()
        L_0x00a6:
            goto L_0x00a8
        L_0x00a7:
            throw r0
        L_0x00a8:
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzce.zzj(long):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzk(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            return h.a(new URI(str), "UTF-8");
        } catch (URISyntaxException e2) {
            zzK("Error parsing hit parameters", e2);
            return new HashMap(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzl(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String valueOf = String.valueOf(str);
            return h.a(new URI(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")), "UTF-8");
        } catch (URISyntaxException e2) {
            zzK("Error parsing property parameters", e2);
            return new HashMap(0);
        }
    }

    public final void zzm() {
        zzW();
        zzf().beginTransaction();
    }

    public final void zzn(long j2) {
        zzr.zzh();
        zzW();
        ArrayList arrayList = new ArrayList(1);
        Long valueOf = Long.valueOf(j2);
        arrayList.add(valueOf);
        zzP("Deleting hit, id", valueOf);
        zzZ(arrayList);
    }
}
