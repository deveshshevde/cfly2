package fq;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.c;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class f implements j {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f27757a = {73, 68, 51};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f27758b;

    /* renamed from: c  reason: collision with root package name */
    private final p f27759c;

    /* renamed from: d  reason: collision with root package name */
    private final q f27760d;

    /* renamed from: e  reason: collision with root package name */
    private final String f27761e;

    /* renamed from: f  reason: collision with root package name */
    private String f27762f;

    /* renamed from: g  reason: collision with root package name */
    private u f27763g;

    /* renamed from: h  reason: collision with root package name */
    private u f27764h;

    /* renamed from: i  reason: collision with root package name */
    private int f27765i;

    /* renamed from: j  reason: collision with root package name */
    private int f27766j;

    /* renamed from: k  reason: collision with root package name */
    private int f27767k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27768l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f27769m;

    /* renamed from: n  reason: collision with root package name */
    private int f27770n;

    /* renamed from: o  reason: collision with root package name */
    private int f27771o;

    /* renamed from: p  reason: collision with root package name */
    private int f27772p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f27773q;

    /* renamed from: r  reason: collision with root package name */
    private long f27774r;

    /* renamed from: s  reason: collision with root package name */
    private int f27775s;

    /* renamed from: t  reason: collision with root package name */
    private long f27776t;

    /* renamed from: u  reason: collision with root package name */
    private u f27777u;

    /* renamed from: v  reason: collision with root package name */
    private long f27778v;

    public f(boolean z2) {
        this(z2, (String) null);
    }

    public f(boolean z2, String str) {
        this.f27759c = new p(new byte[7]);
        this.f27760d = new q(Arrays.copyOf(f27757a, 10));
        e();
        this.f27770n = -1;
        this.f27771o = -1;
        this.f27774r = -9223372036854775807L;
        this.f27758b = z2;
        this.f27761e = str;
    }

    private void a(u uVar, long j2, int i2, int i3) {
        this.f27765i = 4;
        this.f27766j = i2;
        this.f27777u = uVar;
        this.f27778v = j2;
        this.f27775s = i3;
    }

    private boolean a(byte b2, byte b3) {
        return a((int) ((b2 & 255) << 8) | (b3 & 255));
    }

    public static boolean a(int i2) {
        return (i2 & 65526) == 65520;
    }

    private boolean a(q qVar, int i2) {
        qVar.c(i2 + 1);
        if (!b(qVar, this.f27759c.f17155a, 1)) {
            return false;
        }
        this.f27759c.a(4);
        int c2 = this.f27759c.c(1);
        int i3 = this.f27770n;
        if (i3 != -1 && c2 != i3) {
            return false;
        }
        if (this.f27771o != -1) {
            if (!b(qVar, this.f27759c.f17155a, 1)) {
                return true;
            }
            this.f27759c.a(2);
            if (this.f27759c.c(4) != this.f27771o) {
                return false;
            }
            qVar.c(i2 + 2);
        }
        if (!b(qVar, this.f27759c.f17155a, 4)) {
            return true;
        }
        this.f27759c.a(14);
        int c3 = this.f27759c.c(13);
        if (c3 < 7) {
            return false;
        }
        byte[] bArr = qVar.f17159a;
        int c4 = qVar.c();
        int i4 = i2 + c3;
        if (i4 >= c4) {
            return true;
        }
        if (bArr[i4] == -1) {
            int i5 = i4 + 1;
            if (i5 == c4) {
                return true;
            }
            return a((byte) -1, bArr[i5]) && ((bArr[i5] & 8) >> 3) == c2;
        } else if (bArr[i4] != 73) {
            return false;
        } else {
            int i6 = i4 + 1;
            if (i6 == c4) {
                return true;
            }
            if (bArr[i6] != 68) {
                return false;
            }
            int i7 = i4 + 2;
            return i7 == c4 || bArr[i7] == 51;
        }
    }

    private boolean a(q qVar, byte[] bArr, int i2) {
        int min = Math.min(qVar.b(), i2 - this.f27766j);
        qVar.a(bArr, this.f27766j, min);
        int i3 = this.f27766j + min;
        this.f27766j = i3;
        return i3 == i2;
    }

    private void b(q qVar) {
        int i2;
        byte[] bArr = qVar.f17159a;
        int d2 = qVar.d();
        int c2 = qVar.c();
        while (d2 < c2) {
            int i3 = d2 + 1;
            byte b2 = bArr[d2] & 255;
            if (this.f27767k != 512 || !a((byte) -1, (byte) b2) || (!this.f27769m && !a(qVar, i3 - 2))) {
                int i4 = this.f27767k;
                byte b3 = b2 | i4;
                if (b3 != 329) {
                    if (b3 == 511) {
                        this.f27767k = 512;
                    } else if (b3 == 836) {
                        i2 = 1024;
                    } else if (b3 == 1075) {
                        f();
                        qVar.c(i3);
                        return;
                    } else if (i4 != 256) {
                        this.f27767k = 256;
                        i3--;
                    }
                    d2 = i3;
                } else {
                    i2 = 768;
                }
                this.f27767k = i2;
                d2 = i3;
            } else {
                this.f27772p = (b2 & 8) >> 3;
                boolean z2 = true;
                if ((b2 & 1) != 0) {
                    z2 = false;
                }
                this.f27768l = z2;
                if (!this.f27769m) {
                    h();
                } else {
                    g();
                }
                qVar.c(i3);
                return;
            }
        }
        qVar.c(d2);
    }

    private boolean b(q qVar, byte[] bArr, int i2) {
        if (qVar.b() < i2) {
            return false;
        }
        qVar.a(bArr, 0, i2);
        return true;
    }

    private void c(q qVar) {
        if (qVar.b() != 0) {
            this.f27759c.f17155a[0] = qVar.f17159a[qVar.d()];
            this.f27759c.a(2);
            int c2 = this.f27759c.c(4);
            int i2 = this.f27771o;
            if (i2 == -1 || c2 == i2) {
                if (!this.f27769m) {
                    this.f27769m = true;
                    this.f27770n = this.f27772p;
                    this.f27771o = c2;
                }
                g();
                return;
            }
            d();
        }
    }

    private void d() {
        this.f27769m = false;
        e();
    }

    private void d(q qVar) {
        int min = Math.min(qVar.b(), this.f27775s - this.f27766j);
        this.f27777u.a(qVar, min);
        int i2 = this.f27766j + min;
        this.f27766j = i2;
        int i3 = this.f27775s;
        if (i2 == i3) {
            this.f27777u.a(this.f27776t, 1, i3, 0, (u.a) null);
            this.f27776t += this.f27778v;
            e();
        }
    }

    private void e() {
        this.f27765i = 0;
        this.f27766j = 0;
        this.f27767k = 256;
    }

    private void f() {
        this.f27765i = 2;
        this.f27766j = f27757a.length;
        this.f27775s = 0;
        this.f27760d.c(0);
    }

    private void g() {
        this.f27765i = 3;
        this.f27766j = 0;
    }

    private void h() {
        this.f27765i = 1;
        this.f27766j = 0;
    }

    private void i() {
        this.f27764h.a(this.f27760d, 10);
        this.f27760d.c(6);
        a(this.f27764h, 0, 10, this.f27760d.u() + 10);
    }

    private void j() throws ParserException {
        this.f27759c.a(0);
        if (!this.f27773q) {
            int c2 = this.f27759c.c(2) + 1;
            if (c2 != 2) {
                StringBuilder sb = new StringBuilder(61);
                sb.append("Detected audio object type: ");
                sb.append(c2);
                sb.append(", but assuming AAC LC.");
                k.c("AdtsReader", sb.toString());
                c2 = 2;
            }
            this.f27759c.b(5);
            byte[] a2 = c.a(c2, this.f27771o, this.f27759c.c(3));
            Pair<Integer, Integer> a3 = c.a(a2);
            Format a4 = Format.a(this.f27762f, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) a3.second).intValue(), ((Integer) a3.first).intValue(), (List<byte[]>) Collections.singletonList(a2), (DrmInitData) null, 0, this.f27761e);
            this.f27774r = 1024000000 / ((long) a4.f15106w);
            this.f27763g.a(a4);
            this.f27773q = true;
        } else {
            this.f27759c.b(10);
        }
        this.f27759c.b(4);
        int c3 = (this.f27759c.c(13) - 2) - 5;
        if (this.f27768l) {
            c3 -= 2;
        }
        a(this.f27763g, this.f27774r, 0, c3);
    }

    public void a() {
        d();
    }

    public void a(long j2, int i2) {
        this.f27776t = j2;
    }

    public void a(q qVar) throws ParserException {
        while (qVar.b() > 0) {
            int i2 = this.f27765i;
            if (i2 == 0) {
                b(qVar);
            } else if (i2 == 1) {
                c(qVar);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (a(qVar, this.f27759c.f17155a, this.f27768l ? 7 : 5)) {
                        j();
                    }
                } else if (i2 == 4) {
                    d(qVar);
                } else {
                    throw new IllegalStateException();
                }
            } else if (a(qVar, this.f27760d.f17159a, 10)) {
                i();
            }
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27762f = dVar.c();
        this.f27763g = iVar.a(dVar.b(), 1);
        if (this.f27758b) {
            dVar.a();
            u a2 = iVar.a(dVar.b(), 4);
            this.f27764h = a2;
            a2.a(Format.a(dVar.c(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.f27764h = new fj.f();
    }

    public void b() {
    }

    public long c() {
        return this.f27774r;
    }
}
