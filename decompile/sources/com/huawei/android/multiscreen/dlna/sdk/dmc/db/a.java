package com.huawei.android.multiscreen.dlna.sdk.dmc.db;

import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f20816a = new a();

    private a() {
    }

    public static a a() {
        return f20816a;
    }

    public void a(int i2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            String[] strArr = {String.valueOf(i2)};
            arrayList.add("delete from Image where device_id=?");
            arrayList2.add(strArr);
            arrayList.add("delete from Video where device_id=?");
            arrayList2.add(strArr);
            arrayList.add("delete from Audio where device_id=?");
            arrayList2.add(strArr);
            arrayList.add("delete from Tuner where device_id=?");
            arrayList2.add(strArr);
            arrayList.add("delete from Folder where device_id=?");
            arrayList2.add(strArr);
            arrayList.add("delete from Device where device_id=?");
            arrayList2.add(strArr);
            c.a(arrayList, arrayList2);
        } catch (Exception e2) {
            ie.a.a("BrowseResultDao", "BrowseResultDao.deleteFolder exception ", e2);
        }
    }
}
