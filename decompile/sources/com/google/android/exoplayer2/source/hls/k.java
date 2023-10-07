package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.a;
import fi.e;
import java.io.IOException;

final class k implements o {

    /* renamed from: a  reason: collision with root package name */
    private final int f16248a;

    /* renamed from: b  reason: collision with root package name */
    private final l f16249b;

    /* renamed from: c  reason: collision with root package name */
    private int f16250c = -1;

    public k(l lVar, int i2) {
        this.f16249b = lVar;
        this.f16248a = i2;
    }

    private boolean e() {
        int i2 = this.f16250c;
        return (i2 == -1 || i2 == -3 || i2 == -2) ? false : true;
    }

    public int a(com.google.android.exoplayer2.o oVar, e eVar, boolean z2) {
        if (this.f16250c == -3) {
            eVar.addFlag(4);
            return -4;
        } else if (e()) {
            return this.f16249b.a(this.f16250c, oVar, eVar, z2);
        } else {
            return -3;
        }
    }

    public void a() {
        a.a(this.f16250c == -1);
        this.f16250c = this.f16249b.a(this.f16248a);
    }

    public int a_(long j2) {
        if (e()) {
            return this.f16249b.a(this.f16250c, j2);
        }
        return 0;
    }

    public boolean b() {
        return this.f16250c == -3 || (e() && this.f16249b.c(this.f16250c));
    }

    public void c() throws IOException {
        int i2 = this.f16250c;
        if (i2 == -2) {
            throw new SampleQueueMappingException(this.f16249b.g().a(this.f16248a).a(0).f15092i);
        } else if (i2 == -1) {
            this.f16249b.j();
        } else if (i2 != -3) {
            this.f16249b.d(i2);
        }
    }

    public void d() {
        if (this.f16250c != -1) {
            this.f16249b.b(this.f16248a);
            this.f16250c = -1;
        }
    }
}
