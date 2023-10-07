package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.f;
import com.google.android.gms.internal.gtm.zzfz;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

final class zzbe implements zzax {
    /* access modifiers changed from: private */
    public static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Executor zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    private final zzbc zzd;
    private final d zze;

    public zzbe(Context context) {
        d c2 = f.c();
        ExecutorService zza2 = zzfz.zza().zza(2);
        this.zzc = context;
        this.zze = c2;
        this.zzb = zza2;
        this.zzd = new zzbc(this, context, "google_tagmanager.db");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.io.ObjectInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.io.ObjectInputStream} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0089 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0098 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0083 A[SYNTHETIC, Splitter:B:29:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d A[SYNTHETIC, Splitter:B:37:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0094 A[Catch:{ IOException -> 0x0098 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.List zzf(com.google.android.gms.tagmanager.zzbe r10) {
        /*
            com.google.android.gms.common.util.d r0 = r10.zze     // Catch:{ all -> 0x00a8 }
            long r0 = r0.a()     // Catch:{ all -> 0x00a8 }
            r10.zzk(r0)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = "Error opening database for loadSerialized."
            android.database.sqlite.SQLiteDatabase r1 = r10.zzi(r0)     // Catch:{ all -> 0x00a8 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00a8 }
            r0.<init>()     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x0017
            goto L_0x0048
        L_0x0017:
            java.lang.String r2 = "key"
            java.lang.String r3 = "value"
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "datalayer"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "ID"
            r9 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00a8 }
        L_0x002c:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x0045
            com.google.android.gms.tagmanager.zzbd r2 = new com.google.android.gms.tagmanager.zzbd     // Catch:{ all -> 0x00a3 }
            r3 = 0
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00a3 }
            r4 = 1
            byte[] r4 = r1.getBlob(r4)     // Catch:{ all -> 0x00a3 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00a3 }
            r0.add(r2)     // Catch:{ all -> 0x00a3 }
            goto L_0x002c
        L_0x0045:
            r1.close()     // Catch:{ all -> 0x00a8 }
        L_0x0048:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00a8 }
            r1.<init>()     // Catch:{ all -> 0x00a8 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a8 }
        L_0x0051:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00a8 }
            if (r2 == 0) goto L_0x009f
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.tagmanager.zzbd r2 = (com.google.android.gms.tagmanager.zzbd) r2     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.tagmanager.zzau r3 = new com.google.android.gms.tagmanager.zzau     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x00a8 }
            byte[] r2 = r2.zzb     // Catch:{ all -> 0x00a8 }
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x00a8 }
            r5.<init>(r2)     // Catch:{ all -> 0x00a8 }
            r2 = 0
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0091, ClassNotFoundException -> 0x008a, all -> 0x0080 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0091, ClassNotFoundException -> 0x008a, all -> 0x0080 }
            java.lang.Object r2 = r6.readObject()     // Catch:{ IOException -> 0x007e, ClassNotFoundException -> 0x007c, all -> 0x0079 }
            r6.close()     // Catch:{ IOException -> 0x0098 }
        L_0x0075:
            r5.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x0098
        L_0x0079:
            r0 = move-exception
            r2 = r6
            goto L_0x0081
        L_0x007c:
            goto L_0x008b
        L_0x007e:
            goto L_0x0092
        L_0x0080:
            r0 = move-exception
        L_0x0081:
            if (r2 == 0) goto L_0x0086
            r2.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0086:
            r5.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0089:
            throw r0     // Catch:{ all -> 0x00a8 }
        L_0x008a:
            r6 = r2
        L_0x008b:
            if (r6 == 0) goto L_0x0075
            r6.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x0075
        L_0x0091:
            r6 = r2
        L_0x0092:
            if (r6 == 0) goto L_0x0075
            r6.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x0075
        L_0x0098:
            r3.<init>(r4, r2)     // Catch:{ all -> 0x00a8 }
            r1.add(r3)     // Catch:{ all -> 0x00a8 }
            goto L_0x0051
        L_0x009f:
            r10.zzj()
            return r1
        L_0x00a3:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x00a8 }
            throw r0     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception
            r10.zzj()
            goto L_0x00ae
        L_0x00ad:
            throw r0
        L_0x00ae:
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbe.zzf(com.google.android.gms.tagmanager.zzbe):java.util.List");
    }

    private final SQLiteDatabase zzi(String str) {
        try {
            return this.zzd.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdh.zzc(str);
            return null;
        }
    }

    private final void zzj() {
        try {
            this.zzd.close();
        } catch (SQLiteException unused) {
        }
    }

    private final void zzk(long j2) {
        SQLiteDatabase zzi = zzi("Error opening database for deleteOlderThan.");
        if (zzi != null) {
            try {
                int delete = zzi.delete("datalayer", "expires <= ?", new String[]{Long.toString(j2)});
                StringBuilder sb = new StringBuilder(33);
                sb.append("Deleted ");
                sb.append(delete);
                sb.append(" expired items");
                zzdh.zzb.zzd(sb.toString());
            } catch (SQLiteException unused) {
                zzdh.zzc("Error deleting old entries.");
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        zzj();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x018b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008f, code lost:
        if (r5 != null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bd, code lost:
        if (r5 != null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r0 = java.lang.String.valueOf(java.util.Arrays.toString(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0126, code lost:
        if (r0.length() != 0) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0128, code lost:
        r0 = "Error deleting entries ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x012d, code lost:
        r0 = new java.lang.String("Error deleting entries ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0132, code lost:
        com.google.android.gms.tagmanager.zzdh.zzc(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0187, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0040 A[SYNTHETIC, Splitter:B:27:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0049 A[Catch:{ SQLiteException -> 0x0118, all -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b0 A[Catch:{ all -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b5 A[Catch:{ all -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0138 A[Catch:{ SQLiteException -> 0x0118, all -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0146 A[Catch:{ SQLiteException -> 0x0118, all -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0147 A[Catch:{ SQLiteException -> 0x0118, all -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0183 A[SYNTHETIC, Splitter:B:96:0x0183] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzl(java.util.List<com.google.android.gms.tagmanager.zzbd> r19, long r20) {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            com.google.android.gms.common.util.d r0 = r1.zze     // Catch:{ all -> 0x0187 }
            long r2 = r0.a()     // Catch:{ all -> 0x0187 }
            r1.zzk(r2)     // Catch:{ all -> 0x0187 }
            int r0 = r19.size()     // Catch:{ all -> 0x0187 }
            java.lang.String r4 = "Error opening database for getNumStoredEntries."
            android.database.sqlite.SQLiteDatabase r4 = r1.zzi(r4)     // Catch:{ all -> 0x0187 }
            r5 = 0
            r6 = 0
            if (r4 != 0) goto L_0x001c
        L_0x001a:
            r8 = 0
            goto L_0x0044
        L_0x001c:
            java.lang.String r7 = "SELECT COUNT(*) from datalayer"
            android.database.Cursor r4 = r4.rawQuery(r7, r5)     // Catch:{ SQLiteException -> 0x0038, all -> 0x0035 }
            boolean r7 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0039 }
            if (r7 == 0) goto L_0x002e
            long r7 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0039 }
            int r8 = (int) r7
            goto L_0x002f
        L_0x002e:
            r8 = 0
        L_0x002f:
            if (r4 == 0) goto L_0x0044
            r4.close()     // Catch:{ all -> 0x0187 }
            goto L_0x0044
        L_0x0035:
            r0 = move-exception
            goto L_0x0181
        L_0x0038:
            r4 = r5
        L_0x0039:
            java.lang.String r7 = "Error getting numStoredEntries"
            com.google.android.gms.tagmanager.zzdh.zzc(r7)     // Catch:{ all -> 0x017f }
            if (r4 == 0) goto L_0x001a
            r4.close()     // Catch:{ all -> 0x0187 }
            goto L_0x001a
        L_0x0044:
            int r8 = r8 + -2000
            int r8 = r8 + r0
            if (r8 <= 0) goto L_0x013c
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0187 }
            r4.<init>()     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r9 = r1.zzi(r0)     // Catch:{ all -> 0x0187 }
            r7 = 1
            if (r9 != 0) goto L_0x0058
            goto L_0x00c0
        L_0x0058:
            java.lang.String r0 = "ID"
            java.lang.String[] r11 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x009e, all -> 0x009a }
            java.lang.Object[] r0 = new java.lang.Object[r7]     // Catch:{ SQLiteException -> 0x009e, all -> 0x009a }
            java.lang.String r10 = "ID"
            r0[r6] = r10     // Catch:{ SQLiteException -> 0x009e, all -> 0x009a }
            java.lang.String r10 = "datalayer"
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r5 = "%s ASC"
            java.lang.String r16 = java.lang.String.format(r5, r0)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009a }
            java.lang.String r17 = java.lang.Integer.toString(r8)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009a }
            android.database.Cursor r5 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009a }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0098 }
            if (r0 == 0) goto L_0x008f
        L_0x007e:
            long r8 = r5.getLong(r6)     // Catch:{ SQLiteException -> 0x0098 }
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0098 }
            r4.add(r0)     // Catch:{ SQLiteException -> 0x0098 }
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0098 }
            if (r0 != 0) goto L_0x007e
        L_0x008f:
            if (r5 == 0) goto L_0x00c0
        L_0x0091:
            r5.close()     // Catch:{ all -> 0x0187 }
            goto L_0x00c0
        L_0x0095:
            r0 = move-exception
            goto L_0x0136
        L_0x0098:
            r0 = move-exception
            goto L_0x00a0
        L_0x009a:
            r0 = move-exception
            r5 = 0
            goto L_0x0136
        L_0x009e:
            r0 = move-exception
            r5 = 0
        L_0x00a0:
            java.lang.String r8 = "Error in peekEntries fetching entryIds: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0095 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0095 }
            int r9 = r0.length()     // Catch:{ all -> 0x0095 }
            if (r9 == 0) goto L_0x00b5
            java.lang.String r0 = r8.concat(r0)     // Catch:{ all -> 0x0095 }
            goto L_0x00ba
        L_0x00b5:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0095 }
            r0.<init>(r8)     // Catch:{ all -> 0x0095 }
        L_0x00ba:
            com.google.android.gms.tagmanager.zzdh.zzc(r0)     // Catch:{ all -> 0x0095 }
            if (r5 == 0) goto L_0x00c0
            goto L_0x0091
        L_0x00c0:
            int r0 = r4.size()     // Catch:{ all -> 0x0187 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            r8 = 64
            r5.<init>(r8)     // Catch:{ all -> 0x0187 }
            java.lang.String r8 = "DataLayer store full, deleting "
            r5.append(r8)     // Catch:{ all -> 0x0187 }
            r5.append(r0)     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = " entries to make room."
            r5.append(r0)     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0187 }
            com.google.android.gms.tagmanager.zzbg r5 = com.google.android.gms.tagmanager.zzdh.zzb     // Catch:{ all -> 0x0187 }
            r5.zzb(r0)     // Catch:{ all -> 0x0187 }
            java.lang.String[] r0 = new java.lang.String[r6]     // Catch:{ all -> 0x0187 }
            java.lang.Object[] r0 = r4.toArray(r0)     // Catch:{ all -> 0x0187 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x0187 }
            if (r0 == 0) goto L_0x013c
            int r4 = r0.length     // Catch:{ all -> 0x0187 }
            if (r4 != 0) goto L_0x00ef
            goto L_0x013c
        L_0x00ef:
            java.lang.String r5 = "Error opening database for deleteEntries."
            android.database.sqlite.SQLiteDatabase r5 = r1.zzi(r5)     // Catch:{ all -> 0x0187 }
            if (r5 == 0) goto L_0x013c
            java.lang.String r8 = "%s in (%s)"
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0187 }
            java.lang.String r10 = "ID"
            r9[r6] = r10     // Catch:{ all -> 0x0187 }
            java.lang.String r6 = ","
            java.lang.String r10 = "?"
            java.util.List r4 = java.util.Collections.nCopies(r4, r10)     // Catch:{ all -> 0x0187 }
            java.lang.String r4 = android.text.TextUtils.join(r6, r4)     // Catch:{ all -> 0x0187 }
            r9[r7] = r4     // Catch:{ all -> 0x0187 }
            java.lang.String r4 = java.lang.String.format(r8, r9)     // Catch:{ all -> 0x0187 }
            java.lang.String r6 = "datalayer"
            r5.delete(r6, r4, r0)     // Catch:{ SQLiteException -> 0x0118 }
            goto L_0x013c
        L_0x0118:
            java.lang.String r4 = "Error deleting entries "
            java.lang.String r0 = java.util.Arrays.toString(r0)     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0187 }
            int r5 = r0.length()     // Catch:{ all -> 0x0187 }
            if (r5 == 0) goto L_0x012d
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x0187 }
            goto L_0x0132
        L_0x012d:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0187 }
            r0.<init>(r4)     // Catch:{ all -> 0x0187 }
        L_0x0132:
            com.google.android.gms.tagmanager.zzdh.zzc(r0)     // Catch:{ all -> 0x0187 }
            goto L_0x013c
        L_0x0136:
            if (r5 == 0) goto L_0x013b
            r5.close()     // Catch:{ all -> 0x0187 }
        L_0x013b:
            throw r0     // Catch:{ all -> 0x0187 }
        L_0x013c:
            long r2 = r2 + r20
            java.lang.String r0 = "Error opening database for writeEntryToDatabase."
            android.database.sqlite.SQLiteDatabase r0 = r1.zzi(r0)     // Catch:{ all -> 0x0187 }
            if (r0 != 0) goto L_0x0147
            goto L_0x017a
        L_0x0147:
            java.util.Iterator r4 = r19.iterator()     // Catch:{ all -> 0x0187 }
        L_0x014b:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0187 }
            if (r5 == 0) goto L_0x017a
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0187 }
            com.google.android.gms.tagmanager.zzbd r5 = (com.google.android.gms.tagmanager.zzbd) r5     // Catch:{ all -> 0x0187 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ all -> 0x0187 }
            r6.<init>()     // Catch:{ all -> 0x0187 }
            java.lang.String r7 = "expires"
            java.lang.Long r8 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0187 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0187 }
            java.lang.String r7 = "key"
            java.lang.String r8 = r5.zza     // Catch:{ all -> 0x0187 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0187 }
            java.lang.String r7 = "value"
            byte[] r5 = r5.zzb     // Catch:{ all -> 0x0187 }
            r6.put(r7, r5)     // Catch:{ all -> 0x0187 }
            java.lang.String r5 = "datalayer"
            r7 = 0
            r0.insert(r5, r7, r6)     // Catch:{ all -> 0x0187 }
            goto L_0x014b
        L_0x017a:
            r18.zzj()     // Catch:{ all -> 0x018c }
            monitor-exit(r18)
            return
        L_0x017f:
            r0 = move-exception
            r5 = r4
        L_0x0181:
            if (r5 == 0) goto L_0x0186
            r5.close()     // Catch:{ all -> 0x0187 }
        L_0x0186:
            throw r0     // Catch:{ all -> 0x0187 }
        L_0x0187:
            r0 = move-exception
            r18.zzj()     // Catch:{ all -> 0x018c }
            throw r0     // Catch:{ all -> 0x018c }
        L_0x018c:
            r0 = move-exception
            monitor-exit(r18)
            goto L_0x0190
        L_0x018f:
            throw r0
        L_0x0190:
            goto L_0x018f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbe.zzl(java.util.List, long):void");
    }

    public final void zzb(zzaw zzaw) {
        this.zzb.execute(new zzba(this, zzaw));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.ObjectOutputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r6 != null) goto L_0x002d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c A[SYNTHETIC, Splitter:B:16:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(java.util.List<com.google.android.gms.tagmanager.zzau> r8, long r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0009:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x004e
            java.lang.Object r1 = r8.next()
            com.google.android.gms.tagmanager.zzau r1 = (com.google.android.gms.tagmanager.zzau) r1
            com.google.android.gms.tagmanager.zzbd r2 = new com.google.android.gms.tagmanager.zzbd
            java.lang.String r3 = r1.zza
            java.lang.Object r1 = r1.zzb
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            r5 = 0
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0043, all -> 0x0039 }
            r6.<init>(r4)     // Catch:{ IOException -> 0x0043, all -> 0x0039 }
            r6.writeObject(r1)     // Catch:{ IOException -> 0x0037, all -> 0x0034 }
            byte[] r5 = r4.toByteArray()     // Catch:{ IOException -> 0x0037, all -> 0x0034 }
        L_0x002d:
            r6.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0030:
            r4.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x0047
        L_0x0034:
            r8 = move-exception
            r5 = r6
            goto L_0x003a
        L_0x0037:
            goto L_0x0044
        L_0x0039:
            r8 = move-exception
        L_0x003a:
            if (r5 == 0) goto L_0x003f
            r5.close()     // Catch:{ IOException -> 0x0042 }
        L_0x003f:
            r4.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            throw r8
        L_0x0043:
            r6 = r5
        L_0x0044:
            if (r6 == 0) goto L_0x0030
            goto L_0x002d
        L_0x0047:
            r2.<init>(r3, r5)
            r0.add(r2)
            goto L_0x0009
        L_0x004e:
            java.util.concurrent.Executor r8 = r7.zzb
            com.google.android.gms.tagmanager.zzaz r1 = new com.google.android.gms.tagmanager.zzaz
            r1.<init>(r7, r0, r9)
            r8.execute(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbe.zzc(java.util.List, long):void");
    }
}
