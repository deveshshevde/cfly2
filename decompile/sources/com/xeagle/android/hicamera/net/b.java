package com.xeagle.android.hicamera.net;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.ab;
import okhttp3.x;
import okhttp3.z;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f23634a;

    /* renamed from: b  reason: collision with root package name */
    private static x f23635b = new x();

    public static int a(String str, Map<String, String> map) {
        a a2 = a(str);
        return (a2.f23632a == 200 && c.a(a2.f23633b, map) > 0) ? 0 : -1;
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            ab b2 = f23635b.a(new z.a().a(str).b()).b();
            aVar.f23632a = b2.b();
            aVar.f23633b = b2.g().string();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public static String a(String str, String str2) {
        a a2 = a(str);
        if (a2.f23632a != 200) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        c.a(a2.f23633b, treeMap);
        return (String) treeMap.get(str2);
    }

    public static int b(String str) {
        return a(str).f23632a == 200 ? 0 : -1;
    }

    public static int b(String str, String str2) {
        String a2 = a(str, str2);
        if (a2 == null) {
            return -1;
        }
        try {
            int parseInt = Integer.parseInt(a2);
            if (parseInt < 0) {
                return -1;
            }
            return parseInt;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static Boolean c(String str) {
        String a2 = a(str, "enable");
        if (a2 == null) {
            return null;
        }
        if (a2.equals("1")) {
            return Boolean.TRUE;
        }
        if (a2.equals("0")) {
            return Boolean.FALSE;
        }
        return null;
    }
}
