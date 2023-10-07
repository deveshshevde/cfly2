package com.huawei.android.multiscreen.dlna.sdk.dmc.db;

import android.database.sqlite.SQLiteDatabase;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b;
import ie.a;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static b f20817a = new b(b.a().d());

    public static void a(List<String> list, List<String[]> list2) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    if (list2 == null) {
                        return;
                    }
                    if (list2.size() != 0) {
                        SQLiteDatabase writableDatabase = f20817a.getWritableDatabase();
                        if (writableDatabase != null) {
                            writableDatabase.beginTransaction();
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                writableDatabase.execSQL(list.get(i2), (Object[]) list2.get(i2));
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        }
                    }
                }
            } catch (Exception e2) {
                a.a("SqliteDao", "SqliteDao.batchExecSQL exception ", e2);
            }
        }
    }
}
