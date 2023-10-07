package com.bumptech.glide.load.engine;

import cc.k;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import java.security.MessageDigest;
import java.util.Map;

class l implements c {

    /* renamed from: b  reason: collision with root package name */
    private final Object f10365b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10366c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10367d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f10368e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f10369f;

    /* renamed from: g  reason: collision with root package name */
    private final c f10370g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, i<?>> f10371h;

    /* renamed from: i  reason: collision with root package name */
    private final f f10372i;

    /* renamed from: j  reason: collision with root package name */
    private int f10373j;

    l(Object obj, c cVar, int i2, int i3, Map<Class<?>, i<?>> map, Class<?> cls, Class<?> cls2, f fVar) {
        this.f10365b = k.a(obj);
        this.f10370g = (c) k.a(cVar, "Signature must not be null");
        this.f10366c = i2;
        this.f10367d = i3;
        this.f10371h = (Map) k.a(map);
        this.f10368e = (Class) k.a(cls, "Resource class must not be null");
        this.f10369f = (Class) k.a(cls2, "Transcode class must not be null");
        this.f10372i = (f) k.a(fVar);
    }

    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f10365b.equals(lVar.f10365b) && this.f10370g.equals(lVar.f10370g) && this.f10367d == lVar.f10367d && this.f10366c == lVar.f10366c && this.f10371h.equals(lVar.f10371h) && this.f10368e.equals(lVar.f10368e) && this.f10369f.equals(lVar.f10369f) && this.f10372i.equals(lVar.f10372i);
    }

    public int hashCode() {
        if (this.f10373j == 0) {
            int hashCode = this.f10365b.hashCode();
            this.f10373j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f10370g.hashCode();
            this.f10373j = hashCode2;
            int i2 = (hashCode2 * 31) + this.f10366c;
            this.f10373j = i2;
            int i3 = (i2 * 31) + this.f10367d;
            this.f10373j = i3;
            int hashCode3 = (i3 * 31) + this.f10371h.hashCode();
            this.f10373j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f10368e.hashCode();
            this.f10373j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f10369f.hashCode();
            this.f10373j = hashCode5;
            this.f10373j = (hashCode5 * 31) + this.f10372i.hashCode();
        }
        return this.f10373j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f10365b + ", width=" + this.f10366c + ", height=" + this.f10367d + ", resourceClass=" + this.f10368e + ", transcodeClass=" + this.f10369f + ", signature=" + this.f10370g + ", hashCode=" + this.f10373j + ", transformations=" + this.f10371h + ", options=" + this.f10372i + '}';
    }
}
