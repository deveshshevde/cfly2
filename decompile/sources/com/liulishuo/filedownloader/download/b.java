package com.liulishuo.filedownloader.download;

import iq.e;
import iq.f;
import java.net.ProtocolException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    final long f21257a;

    /* renamed from: b  reason: collision with root package name */
    final long f21258b;

    /* renamed from: c  reason: collision with root package name */
    final long f21259c;

    /* renamed from: d  reason: collision with root package name */
    final long f21260d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f21261e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f21262f;

    public static class a {
        public static b a() {
            return new b();
        }

        public static b a(long j2) {
            return new b(0, 0, -1, j2);
        }

        public static b a(long j2, long j3, long j4) {
            return new b(j2, j3, -1, j4);
        }

        public static b a(long j2, long j3, long j4, long j5) {
            return new b(j2, j3, j4, j5);
        }

        public static b b() {
            return new b(0, 0, 0, 0, true);
        }
    }

    private b() {
        this.f21257a = 0;
        this.f21258b = 0;
        this.f21259c = 0;
        this.f21260d = 0;
        this.f21261e = false;
        this.f21262f = true;
    }

    private b(long j2, long j3, long j4, long j5) {
        this(j2, j3, j4, j5, false);
    }

    private b(long j2, long j3, long j4, long j5, boolean z2) {
        if (!(j2 == 0 && j4 == 0) && z2) {
            throw new IllegalArgumentException();
        }
        this.f21257a = j2;
        this.f21258b = j3;
        this.f21259c = j4;
        this.f21260d = j5;
        this.f21261e = z2;
        this.f21262f = false;
    }

    public void a(im.b bVar) throws ProtocolException {
        String str;
        if (!this.f21261e) {
            if (this.f21262f && e.a().f29065h) {
                bVar.b("HEAD");
            }
            if (this.f21259c == -1) {
                str = f.a("bytes=%d-", Long.valueOf(this.f21258b));
            } else {
                str = f.a("bytes=%d-%d", Long.valueOf(this.f21258b), Long.valueOf(this.f21259c));
            }
            bVar.a("Range", str);
        }
    }

    public String toString() {
        return f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.f21257a), Long.valueOf(this.f21259c), Long.valueOf(this.f21258b));
    }
}
