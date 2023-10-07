package com.bumptech.glide.load.engine;

import java.security.MessageDigest;

final class c implements com.bumptech.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.c f10273b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.c f10274c;

    c(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2) {
        this.f10273b = cVar;
        this.f10274c = cVar2;
    }

    public void a(MessageDigest messageDigest) {
        this.f10273b.a(messageDigest);
        this.f10274c.a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f10273b.equals(cVar.f10273b) && this.f10274c.equals(cVar.f10274c);
    }

    public int hashCode() {
        return (this.f10273b.hashCode() * 31) + this.f10274c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f10273b + ", signature=" + this.f10274c + '}';
    }
}
