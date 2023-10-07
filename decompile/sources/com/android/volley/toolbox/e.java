package com.android.volley.toolbox;

import com.android.volley.a;
import com.android.volley.g;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class e {
    public static long a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0;
        }
    }

    public static a.C0077a a(g gVar) {
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = gVar.f9919c;
        String str = map.get("Date");
        long j3 = 0;
        long a2 = str != null ? a(str) : 0;
        String str2 = map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] split = str2.split(",");
            j2 = 0;
            while (i2 < split.length) {
                String trim = split[i2].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    j2 = 0;
                }
                i2++;
            }
            i2 = 1;
        } else {
            j2 = 0;
        }
        String str3 = map.get("Expires");
        long a3 = str3 != null ? a(str3) : 0;
        String str4 = map.get("ETag");
        if (i2 != 0) {
            j3 = currentTimeMillis + (j2 * 1000);
        } else if (a2 > 0 && a3 >= a2) {
            j3 = currentTimeMillis + (a3 - a2);
        }
        a.C0077a aVar = new a.C0077a();
        aVar.f9887a = gVar.f9918b;
        aVar.f9888b = str4;
        aVar.f9891e = j3;
        aVar.f9890d = aVar.f9891e;
        aVar.f9889c = a2;
        aVar.f9892f = map;
        return aVar;
    }

    public static String a(Map<String, String> map) {
        String str = map.get("Content-Type");
        if (str == null) {
            return "ISO-8859-1";
        }
        String[] split = str.split(";");
        for (int i2 = 1; i2 < split.length; i2++) {
            String[] split2 = split[i2].trim().split("=");
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return "ISO-8859-1";
    }
}
