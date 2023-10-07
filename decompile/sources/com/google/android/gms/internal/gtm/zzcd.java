package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

final class zzcd extends SQLiteOpenHelper {
    final /* synthetic */ zzce zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcd(zzce zzce, Context context, String str) {
        super(context, "google_analytics_v4.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzce;
    }

    private final boolean zza(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, (String) null, (String) null, (String) null);
            boolean moveToFirst = query.moveToFirst();
            if (query != null) {
                query.close();
            }
            return moveToFirst;
        } catch (SQLiteException e2) {
            this.zza.zzT("Error querying for table", str, e2);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static final Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(str.length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), (String[]) null);
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (String add : columnNames) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (this.zza.zze.zzc(3600000)) {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.zza.zze.zzb();
                this.zza.zzJ("Opening the database failed, dropping the table and recreating it");
                this.zza.zzo().getDatabasePath(this.zza.zzae()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    this.zza.zze.zza();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    this.zza.zzK("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        } else {
            throw new SQLiteException("Database open failed");
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        try {
            if (Integer.parseInt(Build.VERSION.SDK) >= 9) {
                File file = new File(path);
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        } catch (NumberFormatException unused) {
            zzfa.zzb("Invalid version number", Build.VERSION.SDK);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onOpen(android.database.sqlite.SQLiteDatabase r10) {
        /*
            r9 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 15
            if (r0 >= r1) goto L_0x0019
            r0 = 0
            java.lang.String r1 = "PRAGMA journal_mode=memory"
            android.database.Cursor r0 = r10.rawQuery(r1, r0)
            r0.moveToFirst()     // Catch:{ all -> 0x0014 }
            r0.close()
            goto L_0x0019
        L_0x0014:
            r10 = move-exception
            r0.close()
            throw r10
        L_0x0019:
            java.lang.String r0 = "hits2"
            boolean r1 = r9.zza(r10, r0)
            r2 = 0
            if (r1 != 0) goto L_0x002a
            java.lang.String r0 = com.google.android.gms.internal.gtm.zzce.zza
        L_0x0026:
            r10.execSQL(r0)
            goto L_0x0078
        L_0x002a:
            java.util.Set r0 = zzb(r10, r0)
            java.lang.String r1 = "hit_id"
            java.lang.String r3 = "hit_string"
            java.lang.String r4 = "hit_time"
            java.lang.String r5 = "hit_url"
            java.lang.String[] r1 = new java.lang.String[]{r1, r3, r4, r5}
            r3 = 0
        L_0x003b:
            r4 = 4
            if (r3 >= r4) goto L_0x0065
            r4 = r1[r3]
            boolean r5 = r0.remove(r4)
            if (r5 != 0) goto L_0x0062
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "Database hits2 is missing required column: "
            int r2 = r0.length()
            if (r2 == 0) goto L_0x0059
            java.lang.String r0 = r1.concat(r0)
            goto L_0x005e
        L_0x0059:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x005e:
            r10.<init>(r0)
            throw r10
        L_0x0062:
            int r3 = r3 + 1
            goto L_0x003b
        L_0x0065:
            java.lang.String r1 = "hit_app_id"
            boolean r1 = r0.remove(r1)
            r1 = r1 ^ 1
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00d3
            if (r1 == 0) goto L_0x0078
            java.lang.String r0 = "ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER"
            goto L_0x0026
        L_0x0078:
            java.lang.String r0 = "properties"
            boolean r1 = r9.zza(r10, r0)
            if (r1 == 0) goto L_0x00cd
            java.util.Set r10 = zzb(r10, r0)
            java.lang.String r3 = "app_uid"
            java.lang.String r4 = "cid"
            java.lang.String r5 = "tid"
            java.lang.String r6 = "params"
            java.lang.String r7 = "adid"
            java.lang.String r8 = "hits_count"
            java.lang.String[] r0 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}
        L_0x0094:
            r1 = 6
            if (r2 >= r1) goto L_0x00be
            r1 = r0[r2]
            boolean r3 = r10.remove(r1)
            if (r3 != 0) goto L_0x00bb
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "Database properties is missing required column: "
            int r2 = r0.length()
            if (r2 == 0) goto L_0x00b2
            java.lang.String r0 = r1.concat(r0)
            goto L_0x00b7
        L_0x00b2:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x00b7:
            r10.<init>(r0)
            throw r10
        L_0x00bb:
            int r2 = r2 + 1
            goto L_0x0094
        L_0x00be:
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x00c5
            return
        L_0x00c5:
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database properties table has extra columns"
            r10.<init>(r0)
            throw r10
        L_0x00cd:
            java.lang.String r0 = "CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;"
            r10.execSQL(r0)
            return
        L_0x00d3:
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database hits2 has extra columns"
            r10.<init>(r0)
            goto L_0x00dc
        L_0x00db:
            throw r10
        L_0x00dc:
            goto L_0x00db
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcd.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
