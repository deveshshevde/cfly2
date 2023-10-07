package com.xeagle.android.hicamera.net;

import java.util.Map;

public class c {
    public static int a(String str, Map<String, String> map) {
        int i2 = 0;
        if (map == null) {
            return 0;
        }
        int indexOf = str.indexOf("var ", 0);
        while (indexOf >= 0) {
            int indexOf2 = str.indexOf("=\"", indexOf);
            int indexOf3 = str.indexOf("\";\r\n", indexOf);
            if (indexOf >= indexOf2 || indexOf2 >= indexOf3) {
                break;
            }
            map.put(str.substring(indexOf + 4, indexOf2).trim(), str.substring(indexOf2 + 2, indexOf3).trim());
            i2++;
            indexOf = str.indexOf("var ", indexOf3 + 4);
        }
        return i2;
    }
}
