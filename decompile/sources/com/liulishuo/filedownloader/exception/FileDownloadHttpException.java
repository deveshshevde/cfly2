package com.liulishuo.filedownloader.exception;

import iq.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDownloadHttpException extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private final int f21340a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<String>> f21341b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<String>> f21342c;

    public FileDownloadHttpException(int i2, Map<String, List<String>> map, Map<String, List<String>> map2) {
        super(f.a("response code error: %d, \n request headers: %s \n response headers: %s", Integer.valueOf(i2), map, map2));
        this.f21340a = i2;
        this.f21341b = a(map);
        this.f21342c = a(map);
    }

    private static Map<String, List<String>> a(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put((String) next.getKey(), new ArrayList((Collection) next.getValue()));
        }
        return hashMap;
    }

    public int a() {
        return this.f21340a;
    }
}
