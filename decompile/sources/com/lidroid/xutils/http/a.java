package com.lidroid.xutils.http;

import android.text.TextUtils;
import com.lidroid.xutils.http.client.HttpRequest;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static long f21038c = 60000;

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap<String, Boolean> f21039d;

    /* renamed from: a  reason: collision with root package name */
    private final com.lidroid.xutils.cache.a<String, String> f21040a;

    /* renamed from: b  reason: collision with root package name */
    private int f21041b;

    static {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>(10);
        f21039d = concurrentHashMap;
        concurrentHashMap.put(HttpRequest.HttpMethod.GET.toString(), true);
    }

    public a() {
        this(102400, 60000);
    }

    public a(int i2, long j2) {
        this.f21041b = 102400;
        this.f21041b = i2;
        f21038c = j2;
        this.f21040a = new com.lidroid.xutils.cache.a<String, String>(i2) {
            /* access modifiers changed from: protected */
            public int a(String str, String str2) {
                if (str2 == null) {
                    return 0;
                }
                return str2.length();
            }
        };
    }

    public static long a() {
        return f21038c;
    }

    public String a(String str) {
        if (str != null) {
            return this.f21040a.a(str);
        }
        return null;
    }

    public void a(String str, String str2, long j2) {
        if (str != null && str2 != null && j2 >= 1) {
            this.f21040a.a(str, str2, System.currentTimeMillis() + j2);
        }
    }

    public boolean b(String str) {
        Boolean bool;
        if (!TextUtils.isEmpty(str) && (bool = f21039d.get(str.toUpperCase())) != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
