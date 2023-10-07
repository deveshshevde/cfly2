package com.bumptech.glide.request;

import com.bumptech.glide.load.c;

public class h extends a<h> {

    /* renamed from: a  reason: collision with root package name */
    private static h f10610a;

    /* renamed from: b  reason: collision with root package name */
    private static h f10611b;

    public static h b(c cVar) {
        return (h) new h().a(cVar);
    }

    public static h b(com.bumptech.glide.load.engine.h hVar) {
        return (h) new h().a(hVar);
    }

    public static h b(Class<?> cls) {
        return (h) new h().a(cls);
    }

    public static h c(boolean z2) {
        if (z2) {
            if (f10610a == null) {
                f10610a = (h) ((h) new h().b(true)).n();
            }
            return f10610a;
        }
        if (f10611b == null) {
            f10611b = (h) ((h) new h().b(false)).n();
        }
        return f10611b;
    }
}
