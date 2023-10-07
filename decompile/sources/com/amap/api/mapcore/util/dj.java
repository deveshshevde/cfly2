package com.amap.api.mapcore.util;

public class dj {

    /* renamed from: b  reason: collision with root package name */
    private static volatile dj f8262b;

    /* renamed from: a  reason: collision with root package name */
    private id f8263a;

    private dj() {
        this.f8263a = null;
        this.f8263a = dk.a("AMapThreadUtil");
    }

    public static dj a() {
        if (f8262b == null) {
            synchronized (dj.class) {
                if (f8262b == null) {
                    f8262b = new dj();
                }
            }
        }
        return f8262b;
    }

    public static void b() {
        if (f8262b != null) {
            try {
                if (f8262b.f8263a != null) {
                    f8262b.f8263a.c();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f8262b.f8263a = null;
            f8262b = null;
        }
    }

    public static void b(ie ieVar) {
        if (ieVar != null) {
            try {
                ieVar.cancelTask();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(ie ieVar) {
        try {
            this.f8263a.a(ieVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
