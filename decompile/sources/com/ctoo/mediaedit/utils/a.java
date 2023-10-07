package com.ctoo.mediaedit.utils;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f10956a;

    private a() {
    }

    public static a a() {
        if (f10956a == null) {
            synchronized (a.class) {
                if (f10956a == null) {
                    f10956a = new a();
                }
            }
        }
        return f10956a;
    }

    public String b() {
        return b.a() + "/origin" + System.currentTimeMillis() + "-video.mp4";
    }
}
