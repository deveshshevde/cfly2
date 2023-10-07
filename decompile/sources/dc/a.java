package dc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.l;
import com.danikula.videocache.p;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

class a extends SQLiteOpenHelper implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f26692a = {"_id", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "length", IMediaFormat.KEY_MIME};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        l.a(context);
    }

    private ContentValues a(p pVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, pVar.f11091a);
        contentValues.put("length", Long.valueOf(pVar.f11092b));
        contentValues.put(IMediaFormat.KEY_MIME, pVar.f11093c);
        return contentValues;
    }

    private p a(Cursor cursor) {
        return new p(cursor.getString(cursor.getColumnIndexOrThrow(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL)), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(IMediaFormat.KEY_MIME)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.danikula.videocache.p a(java.lang.String r11) {
        /*
            r10 = this;
            com.danikula.videocache.l.a(r11)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "SourceInfo"
            java.lang.String[] r3 = f26692a     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = "url=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0031 }
            r6 = 0
            r5[r6] = r11     // Catch:{ all -> 0x0031 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0031 }
            if (r11 == 0) goto L_0x002b
            boolean r1 = r11.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0024
            goto L_0x002b
        L_0x0024:
            com.danikula.videocache.p r0 = r10.a((android.database.Cursor) r11)     // Catch:{ all -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            r0 = move-exception
            goto L_0x0035
        L_0x002b:
            if (r11 == 0) goto L_0x0030
            r11.close()
        L_0x0030:
            return r0
        L_0x0031:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x0035:
            if (r11 == 0) goto L_0x003a
            r11.close()
        L_0x003a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.a.a(java.lang.String):com.danikula.videocache.p");
    }

    public void a() {
        close();
    }

    public void a(String str, p pVar) {
        l.a(str, pVar);
        boolean z2 = a(str) != null;
        ContentValues a2 = a(pVar);
        if (z2) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", (String) null, a2);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        l.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
