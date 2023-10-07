package com.xeagle.android.hicamera.unity;

import com.xeagle.android.hicamera.net.b;
import java.util.Map;

public class d {
    public static int a(String str, Map<String, String> map) {
        return b.a(String.format("http://%s%s/sdcommand.cgi?-format&-partition=1", new Object[]{str, "/cgi-bin/hi3510"}), map);
    }
}
