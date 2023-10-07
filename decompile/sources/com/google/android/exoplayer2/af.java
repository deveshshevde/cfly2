package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.util.ad;
import fs.a;

public abstract class af {

    /* renamed from: a  reason: collision with root package name */
    public static final af f15165a = new af() {
        public int a(Object obj) {
            return -1;
        }

        public a a(int i2, a aVar, boolean z2) {
            throw new IndexOutOfBoundsException();
        }

        public b a(int i2, b bVar, long j2) {
            throw new IndexOutOfBoundsException();
        }

        public Object a(int i2) {
            throw new IndexOutOfBoundsException();
        }

        public int b() {
            return 0;
        }

        public int c() {
            return 0;
        }
    };

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object f15166a;

        /* renamed from: b  reason: collision with root package name */
        public Object f15167b;

        /* renamed from: c  reason: collision with root package name */
        public int f15168c;

        /* renamed from: d  reason: collision with root package name */
        public long f15169d;

        /* renamed from: e  reason: collision with root package name */
        private long f15170e;

        /* renamed from: f  reason: collision with root package name */
        private fs.a f15171f = fs.a.f28031a;

        public int a(int i2, int i3) {
            return this.f15171f.f28034d[i2].a(i3);
        }

        public int a(long j2) {
            return this.f15171f.a(j2, this.f15169d);
        }

        public long a() {
            return this.f15169d;
        }

        public long a(int i2) {
            return this.f15171f.f28033c[i2];
        }

        public a a(Object obj, Object obj2, int i2, long j2, long j3) {
            return a(obj, obj2, i2, j2, j3, fs.a.f28031a);
        }

        public a a(Object obj, Object obj2, int i2, long j2, long j3, fs.a aVar) {
            this.f15166a = obj;
            this.f15167b = obj2;
            this.f15168c = i2;
            this.f15169d = j2;
            this.f15170e = j3;
            this.f15171f = aVar;
            return this;
        }

        public int b(int i2) {
            return this.f15171f.f28034d[i2].a();
        }

        public int b(long j2) {
            return this.f15171f.b(j2, this.f15169d);
        }

        public long b() {
            return e.a(this.f15170e);
        }

        public boolean b(int i2, int i3) {
            a.C0177a aVar = this.f15171f.f28034d[i2];
            return (aVar.f28037a == -1 || aVar.f28039c[i3] == 0) ? false : true;
        }

        public long c() {
            return this.f15170e;
        }

        public long c(int i2, int i3) {
            a.C0177a aVar = this.f15171f.f28034d[i2];
            if (aVar.f28037a != -1) {
                return aVar.f28040d[i3];
            }
            return -9223372036854775807L;
        }

        public boolean c(int i2) {
            return !this.f15171f.f28034d[i2].b();
        }

        public int d() {
            return this.f15171f.f28032b;
        }

        public int d(int i2) {
            return this.f15171f.f28034d[i2].f28037a;
        }

        public long e() {
            return this.f15171f.f28035e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !getClass().equals(obj.getClass())) {
                return false;
            }
            a aVar = (a) obj;
            return ad.a(this.f15166a, aVar.f15166a) && ad.a(this.f15167b, aVar.f15167b) && this.f15168c == aVar.f15168c && this.f15169d == aVar.f15169d && this.f15170e == aVar.f15170e && ad.a((Object) this.f15171f, (Object) aVar.f15171f);
        }

        public int hashCode() {
            Object obj = this.f15166a;
            int i2 = 0;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f15167b;
            int hashCode2 = obj2 == null ? 0 : obj2.hashCode();
            long j2 = this.f15169d;
            long j3 = this.f15170e;
            int i3 = (((((((hashCode + hashCode2) * 31) + this.f15168c) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            fs.a aVar = this.f15171f;
            if (aVar != null) {
                i2 = aVar.hashCode();
            }
            return i3 + i2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Object f15172a = new Object();

        /* renamed from: b  reason: collision with root package name */
        public Object f15173b = f15172a;

        /* renamed from: c  reason: collision with root package name */
        public Object f15174c;

        /* renamed from: d  reason: collision with root package name */
        public Object f15175d;

        /* renamed from: e  reason: collision with root package name */
        public long f15176e;

        /* renamed from: f  reason: collision with root package name */
        public long f15177f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15178g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15179h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15180i;

        /* renamed from: j  reason: collision with root package name */
        public int f15181j;

        /* renamed from: k  reason: collision with root package name */
        public int f15182k;

        /* renamed from: l  reason: collision with root package name */
        public long f15183l;

        /* renamed from: m  reason: collision with root package name */
        public long f15184m;

        /* renamed from: n  reason: collision with root package name */
        public long f15185n;

        public long a() {
            return e.a(this.f15183l);
        }

        public b a(Object obj, Object obj2, Object obj3, long j2, long j3, boolean z2, boolean z3, boolean z4, long j4, long j5, int i2, int i3, long j6) {
            this.f15173b = obj;
            this.f15174c = obj2;
            this.f15175d = obj3;
            this.f15176e = j2;
            this.f15177f = j3;
            this.f15178g = z2;
            this.f15179h = z3;
            this.f15180i = z4;
            this.f15183l = j4;
            this.f15184m = j5;
            this.f15181j = i2;
            this.f15182k = i3;
            this.f15185n = j6;
            return this;
        }

        public long b() {
            return this.f15183l;
        }

        public long c() {
            return e.a(this.f15184m);
        }

        public long d() {
            return this.f15185n;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !getClass().equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return ad.a(this.f15173b, bVar.f15173b) && ad.a(this.f15174c, bVar.f15174c) && ad.a(this.f15175d, bVar.f15175d) && this.f15176e == bVar.f15176e && this.f15177f == bVar.f15177f && this.f15178g == bVar.f15178g && this.f15179h == bVar.f15179h && this.f15180i == bVar.f15180i && this.f15183l == bVar.f15183l && this.f15184m == bVar.f15184m && this.f15181j == bVar.f15181j && this.f15182k == bVar.f15182k && this.f15185n == bVar.f15185n;
        }

        public int hashCode() {
            int hashCode = (217 + this.f15173b.hashCode()) * 31;
            Object obj = this.f15174c;
            int i2 = 0;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f15175d;
            if (obj2 != null) {
                i2 = obj2.hashCode();
            }
            long j2 = this.f15176e;
            long j3 = this.f15177f;
            long j4 = this.f15183l;
            long j5 = this.f15184m;
            long j6 = this.f15185n;
            return ((((((((((((((((((((hashCode2 + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f15178g ? 1 : 0)) * 31) + (this.f15179h ? 1 : 0)) * 31) + (this.f15180i ? 1 : 0)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.f15181j) * 31) + this.f15182k) * 31) + ((int) (j6 ^ (j6 >>> 32)));
        }
    }

    public int a(int i2, int i3, boolean z2) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 == 2) {
                return i2 == a(z2) ? b(z2) : i2 + 1;
            }
            throw new IllegalStateException();
        } else if (i2 == a(z2)) {
            return -1;
        } else {
            return i2 + 1;
        }
    }

    public final int a(int i2, a aVar, b bVar, int i3, boolean z2) {
        int i4 = a(i2, aVar).f15168c;
        if (a(i4, bVar).f15182k != i2) {
            return i2 + 1;
        }
        int a2 = a(i4, i3, z2);
        if (a2 == -1) {
            return -1;
        }
        return a(a2, bVar).f15181j;
    }

    public abstract int a(Object obj);

    public int a(boolean z2) {
        if (a()) {
            return -1;
        }
        return b() - 1;
    }

    public final Pair<Object, Long> a(b bVar, a aVar, int i2, long j2) {
        return (Pair) com.google.android.exoplayer2.util.a.b(a(bVar, aVar, i2, j2, 0));
    }

    public final Pair<Object, Long> a(b bVar, a aVar, int i2, long j2, long j3) {
        com.google.android.exoplayer2.util.a.a(i2, 0, b());
        a(i2, bVar, j3);
        if (j2 == -9223372036854775807L) {
            j2 = bVar.b();
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = bVar.f15181j;
        long d2 = bVar.d() + j2;
        while (true) {
            long a2 = a(i3, aVar, true).a();
            if (a2 != -9223372036854775807L && d2 >= a2 && i3 < bVar.f15182k) {
                d2 -= a2;
                i3++;
            }
        }
        return Pair.create(com.google.android.exoplayer2.util.a.b(aVar.f15167b), Long.valueOf(d2));
    }

    public final a a(int i2, a aVar) {
        return a(i2, aVar, false);
    }

    public abstract a a(int i2, a aVar, boolean z2);

    public a a(Object obj, a aVar) {
        return a(a(obj), aVar, true);
    }

    public final b a(int i2, b bVar) {
        return a(i2, bVar, 0);
    }

    public abstract b a(int i2, b bVar, long j2);

    public abstract Object a(int i2);

    public final boolean a() {
        return b() == 0;
    }

    public abstract int b();

    public int b(int i2, int i3, boolean z2) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 == 2) {
                return i2 == b(z2) ? a(z2) : i2 - 1;
            }
            throw new IllegalStateException();
        } else if (i2 == b(z2)) {
            return -1;
        } else {
            return i2 - 1;
        }
    }

    public int b(boolean z2) {
        return a() ? -1 : 0;
    }

    public final boolean b(int i2, a aVar, b bVar, int i3, boolean z2) {
        return a(i2, aVar, bVar, i3, z2) == -1;
    }

    public abstract int c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof af)) {
            return false;
        }
        af afVar = (af) obj;
        if (afVar.b() != b() || afVar.c() != c()) {
            return false;
        }
        b bVar = new b();
        a aVar = new a();
        b bVar2 = new b();
        a aVar2 = new a();
        for (int i2 = 0; i2 < b(); i2++) {
            if (!a(i2, bVar).equals(afVar.a(i2, bVar2))) {
                return false;
            }
        }
        for (int i3 = 0; i3 < c(); i3++) {
            if (!a(i3, aVar, true).equals(afVar.a(i3, aVar2, true))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2;
        b bVar = new b();
        a aVar = new a();
        int b2 = 217 + b();
        int i3 = 0;
        while (true) {
            i2 = b2 * 31;
            if (i3 >= b()) {
                break;
            }
            b2 = i2 + a(i3, bVar).hashCode();
            i3++;
        }
        int c2 = i2 + c();
        for (int i4 = 0; i4 < c(); i4++) {
            c2 = (c2 * 31) + a(i4, aVar, true).hashCode();
        }
        return c2;
    }
}
