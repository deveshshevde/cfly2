package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.util.a;
import fi.f;
import java.util.List;

public abstract class i extends f implements e {

    /* renamed from: a  reason: collision with root package name */
    private e f16603a;

    /* renamed from: b  reason: collision with root package name */
    private long f16604b;

    public int a() {
        return ((e) a.b(this.f16603a)).a();
    }

    public int a(long j2) {
        return ((e) a.b(this.f16603a)).a(j2 - this.f16604b);
    }

    public long a(int i2) {
        return ((e) a.b(this.f16603a)).a(i2) + this.f16604b;
    }

    public void a(long j2, e eVar, long j3) {
        this.timeUs = j2;
        this.f16603a = eVar;
        if (j3 == Long.MAX_VALUE) {
            j3 = this.timeUs;
        }
        this.f16604b = j3;
    }

    public List<b> b(long j2) {
        return ((e) a.b(this.f16603a)).b(j2 - this.f16604b);
    }

    public void clear() {
        super.clear();
        this.f16603a = null;
    }

    public abstract void release();
}
