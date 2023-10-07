package com.amap.api.mapcore.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class ba implements gc {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ba f8046a;

    private ba() {
    }

    public static ba a() {
        if (f8046a == null) {
            synchronized (ba.class) {
                if (f8046a == null) {
                    f8046a = new ba();
                }
            }
        }
        return f8046a;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
            } catch (Throwable th) {
                fz.c(th, "DB", "onCreate");
                th.printStackTrace();
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase, int i2) {
        if (sQLiteDatabase != null && i2 == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            Cursor query = sQLiteDatabase.query("update_item", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
                    String substring = string.substring(string.lastIndexOf("/") + 1);
                    sQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
            }
        }
    }

    public final String b() {
        return "offlineDbV4.db";
    }
}
