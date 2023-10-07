package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.v;

public final class w implements m {

    /* renamed from: a  reason: collision with root package name */
    private final b f17181a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17182b;

    /* renamed from: c  reason: collision with root package name */
    private long f17183c;

    /* renamed from: d  reason: collision with root package name */
    private long f17184d;

    /* renamed from: e  reason: collision with root package name */
    private v f17185e = v.f17191a;

    public w(b bVar) {
        this.f17181a = bVar;
    }

    public void a() {
        if (!this.f17182b) {
            this.f17184d = this.f17181a.a();
            this.f17182b = true;
        }
    }

    public void a(long j2) {
        this.f17183c = j2;
        if (this.f17182b) {
            this.f17184d = this.f17181a.a();
        }
    }

    public void a(v vVar) {
        if (this.f17182b) {
            a(l_());
        }
        this.f17185e = vVar;
    }

    public void b() {
        if (this.f17182b) {
            a(l_());
            this.f17182b = false;
        }
    }

    public v d() {
        return this.f17185e;
    }

    public long l_() {
        long j2 = this.f17183c;
        if (!this.f17182b) {
            return j2;
        }
        long a2 = this.f17181a.a() - this.f17184d;
        return j2 + (this.f17185e.f17192b == 1.0f ? e.b(a2) : this.f17185e.a(a2));
    }
}
