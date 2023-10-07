package org.jcodec.common.model;

import java.nio.ByteBuffer;
import java.util.Comparator;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<a> f33213a = new Comparator<a>() {
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar == null) {
                return -1;
            }
            if (aVar2 == null) {
                return 1;
            }
            if (aVar.f33218f < aVar2.f33218f) {
                return -1;
            }
            return aVar.f33218f == aVar2.f33218f ? 0 : 1;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f33214b;

    /* renamed from: c  reason: collision with root package name */
    private long f33215c;

    /* renamed from: d  reason: collision with root package name */
    private long f33216d;

    /* renamed from: e  reason: collision with root package name */
    private long f33217e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f33218f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f33219g;

    /* renamed from: h  reason: collision with root package name */
    private f f33220h;

    /* renamed from: i  reason: collision with root package name */
    private int f33221i;

    public a(ByteBuffer byteBuffer, long j2, long j3, long j4, long j5, boolean z2, f fVar) {
        this(byteBuffer, j2, j3, j4, j5, z2, fVar, 0);
    }

    public a(ByteBuffer byteBuffer, long j2, long j3, long j4, long j5, boolean z2, f fVar, int i2) {
        this.f33214b = byteBuffer;
        this.f33215c = j2;
        this.f33216d = j3;
        this.f33217e = j4;
        this.f33218f = j5;
        this.f33219g = z2;
        this.f33220h = fVar;
        this.f33221i = i2;
    }

    public a(a aVar, ByteBuffer byteBuffer) {
        this(byteBuffer, aVar.f33215c, aVar.f33216d, aVar.f33217e, aVar.f33218f, aVar.f33219g, aVar.f33220h);
        this.f33221i = aVar.f33221i;
    }

    public ByteBuffer a() {
        return this.f33214b.duplicate();
    }

    public long b() {
        return this.f33215c;
    }

    public long c() {
        return this.f33217e;
    }

    public f d() {
        return this.f33220h;
    }

    public int e() {
        return this.f33221i;
    }

    public boolean f() {
        return this.f33219g;
    }
}
