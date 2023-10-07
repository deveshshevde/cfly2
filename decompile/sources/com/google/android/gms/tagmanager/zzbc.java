package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

final class zzbc extends SQLiteOpenHelper {
    final /* synthetic */ zzbe zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbc(zzbe zzbe, Context context, String str) {
        super(context, "google_tagmanager.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzbe;
    }

    public final SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.zza.zzc.getDatabasePath("google_tagmanager.db").delete();
            sQLiteDatabase = null;
        }
        return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzbv.zza(sQLiteDatabase.getPath());
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a0 */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onOpen(android.database.sqlite.SQLiteDatabase r13) {
        /*
            r12 = this;
            java.lang.String r0 = "Error querying for table datalayer"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            r3 = 15
            if (r1 >= r3) goto L_0x001b
            java.lang.String r1 = "PRAGMA journal_mode=memory"
            android.database.Cursor r1 = r13.rawQuery(r1, r2)
            r1.moveToFirst()     // Catch:{ all -> 0x0016 }
            r1.close()
            goto L_0x001b
        L_0x0016:
            r13 = move-exception
            r1.close()
            throw r13
        L_0x001b:
            java.lang.String r1 = "datalayer"
            java.lang.String r3 = "name"
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x00a0 }
            java.lang.String[] r8 = new java.lang.String[]{r1}     // Catch:{ SQLiteException -> 0x00a0 }
            java.lang.String r5 = "SQLITE_MASTER"
            java.lang.String r7 = "name=?"
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r13
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00a0 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x009c, all -> 0x0099 }
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            if (r0 != 0) goto L_0x003f
            goto L_0x00a8
        L_0x003f:
            java.lang.String r0 = "SELECT * FROM datalayer WHERE 0"
            android.database.Cursor r13 = r13.rawQuery(r0, r2)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.lang.String[] r1 = r13.getColumnNames()     // Catch:{ all -> 0x0094 }
            r2 = 0
        L_0x004f:
            int r3 = r1.length     // Catch:{ all -> 0x0094 }
            if (r2 >= r3) goto L_0x005a
            r3 = r1[r2]     // Catch:{ all -> 0x0094 }
            r0.add(r3)     // Catch:{ all -> 0x0094 }
            int r2 = r2 + 1
            goto L_0x004f
        L_0x005a:
            r13.close()
            java.lang.String r13 = "key"
            boolean r13 = r0.remove(r13)
            if (r13 == 0) goto L_0x008c
            java.lang.String r13 = "value"
            boolean r13 = r0.remove(r13)
            if (r13 == 0) goto L_0x008c
            java.lang.String r13 = "ID"
            boolean r13 = r0.remove(r13)
            if (r13 == 0) goto L_0x008c
            java.lang.String r13 = "expires"
            boolean r13 = r0.remove(r13)
            if (r13 == 0) goto L_0x008c
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L_0x0084
            return
        L_0x0084:
            android.database.sqlite.SQLiteException r13 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database has extra columns"
            r13.<init>(r0)
            throw r13
        L_0x008c:
            android.database.sqlite.SQLiteException r13 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database column missing"
            r13.<init>(r0)
            throw r13
        L_0x0094:
            r0 = move-exception
            r13.close()
            throw r0
        L_0x0099:
            r13 = move-exception
            r2 = r1
            goto L_0x00b0
        L_0x009c:
            r2 = r1
            goto L_0x00a0
        L_0x009e:
            r13 = move-exception
            goto L_0x00b0
        L_0x00a0:
            com.google.android.gms.tagmanager.zzdh.zzc(r0)     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x00a8
            r2.close()
        L_0x00a8:
            java.lang.String r0 = com.google.android.gms.tagmanager.zzbe.zza
            r13.execSQL(r0)
            return
        L_0x00b0:
            if (r2 == 0) goto L_0x00b5
            r2.close()
        L_0x00b5:
            goto L_0x00b7
        L_0x00b6:
            throw r13
        L_0x00b7:
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbc.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
