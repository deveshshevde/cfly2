package com.google.android.exoplayer2;

import java.util.HashSet;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<String> f15968a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private static String f15969b = "goog.exo.core";

    public static synchronized String a() {
        String str;
        synchronized (n.class) {
            str = f15969b;
        }
        return str;
    }

    public static synchronized void a(String str) {
        synchronized (n.class) {
            if (f15968a.add(str)) {
                String str2 = f15969b;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length());
                sb.append(str2);
                sb.append(", ");
                sb.append(str);
                f15969b = sb.toString();
            }
        }
    }
}
