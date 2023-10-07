package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class gg extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8917b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8918c = false;

    /* renamed from: a  reason: collision with root package name */
    private gc f8919a;

    public gg(Context context, String str, gc gcVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        this.f8919a = gcVar;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f8919a.a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        this.f8919a.a(sQLiteDatabase, i2);
    }
}
