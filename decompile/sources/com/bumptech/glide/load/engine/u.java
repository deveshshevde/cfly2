package com.bumptech.glide.load.engine;

import bl.b;
import cc.h;
import cc.l;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class u implements c {

    /* renamed from: b  reason: collision with root package name */
    private static final h<Class<?>, byte[]> f10402b = new h<>(50);

    /* renamed from: c  reason: collision with root package name */
    private final b f10403c;

    /* renamed from: d  reason: collision with root package name */
    private final c f10404d;

    /* renamed from: e  reason: collision with root package name */
    private final c f10405e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10406f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10407g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f10408h;

    /* renamed from: i  reason: collision with root package name */
    private final f f10409i;

    /* renamed from: j  reason: collision with root package name */
    private final i<?> f10410j;

    u(b bVar, c cVar, c cVar2, int i2, int i3, i<?> iVar, Class<?> cls, f fVar) {
        this.f10403c = bVar;
        this.f10404d = cVar;
        this.f10405e = cVar2;
        this.f10406f = i2;
        this.f10407g = i3;
        this.f10410j = iVar;
        this.f10408h = cls;
        this.f10409i = fVar;
    }

    private byte[] a() {
        h<Class<?>, byte[]> hVar = f10402b;
        byte[] b2 = hVar.b(this.f10408h);
        if (b2 != null) {
            return b2;
        }
        byte[] bytes = this.f10408h.getName().getBytes(f10157a);
        hVar.b(this.f10408h, bytes);
        return bytes;
    }

    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f10403c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f10406f).putInt(this.f10407g).array();
        this.f10405e.a(messageDigest);
        this.f10404d.a(messageDigest);
        messageDigest.update(bArr);
        i<?> iVar = this.f10410j;
        if (iVar != null) {
            iVar.a(messageDigest);
        }
        this.f10409i.a(messageDigest);
        messageDigest.update(a());
        this.f10403c.a(bArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f10407g == uVar.f10407g && this.f10406f == uVar.f10406f && l.a((Object) this.f10410j, (Object) uVar.f10410j) && this.f10408h.equals(uVar.f10408h) && this.f10404d.equals(uVar.f10404d) && this.f10405e.equals(uVar.f10405e) && this.f10409i.equals(uVar.f10409i);
    }

    public int hashCode() {
        int hashCode = (((((this.f10404d.hashCode() * 31) + this.f10405e.hashCode()) * 31) + this.f10406f) * 31) + this.f10407g;
        i<?> iVar = this.f10410j;
        if (iVar != null) {
            hashCode = (hashCode * 31) + iVar.hashCode();
        }
        return (((hashCode * 31) + this.f10408h.hashCode()) * 31) + this.f10409i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f10404d + ", signature=" + this.f10405e + ", width=" + this.f10406f + ", height=" + this.f10407g + ", decodedResourceClass=" + this.f10408h + ", transformation='" + this.f10410j + '\'' + ", options=" + this.f10409i + '}';
    }
}
