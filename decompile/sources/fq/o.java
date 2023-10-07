package fq;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.c;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;
import java.util.Collections;
import java.util.List;

public final class o implements j {

    /* renamed from: a  reason: collision with root package name */
    private final String f27902a;

    /* renamed from: b  reason: collision with root package name */
    private final q f27903b;

    /* renamed from: c  reason: collision with root package name */
    private final p f27904c;

    /* renamed from: d  reason: collision with root package name */
    private u f27905d;

    /* renamed from: e  reason: collision with root package name */
    private Format f27906e;

    /* renamed from: f  reason: collision with root package name */
    private String f27907f;

    /* renamed from: g  reason: collision with root package name */
    private int f27908g;

    /* renamed from: h  reason: collision with root package name */
    private int f27909h;

    /* renamed from: i  reason: collision with root package name */
    private int f27910i;

    /* renamed from: j  reason: collision with root package name */
    private int f27911j;

    /* renamed from: k  reason: collision with root package name */
    private long f27912k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27913l;

    /* renamed from: m  reason: collision with root package name */
    private int f27914m;

    /* renamed from: n  reason: collision with root package name */
    private int f27915n;

    /* renamed from: o  reason: collision with root package name */
    private int f27916o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f27917p;

    /* renamed from: q  reason: collision with root package name */
    private long f27918q;

    /* renamed from: r  reason: collision with root package name */
    private int f27919r;

    /* renamed from: s  reason: collision with root package name */
    private long f27920s;

    /* renamed from: t  reason: collision with root package name */
    private int f27921t;

    public o(String str) {
        this.f27902a = str;
        q qVar = new q(1024);
        this.f27903b = qVar;
        this.f27904c = new p(qVar.f17159a);
    }

    private void a(int i2) {
        this.f27903b.a(i2);
        this.f27904c.a(this.f27903b.f17159a);
    }

    private void a(p pVar) throws ParserException {
        if (!pVar.e()) {
            this.f27913l = true;
            b(pVar);
        } else if (!this.f27913l) {
            return;
        }
        if (this.f27914m != 0) {
            throw new ParserException();
        } else if (this.f27915n == 0) {
            a(pVar, e(pVar));
            if (this.f27917p) {
                pVar.b((int) this.f27918q);
            }
        } else {
            throw new ParserException();
        }
    }

    private void a(p pVar, int i2) {
        int b2 = pVar.b();
        if ((b2 & 7) == 0) {
            this.f27903b.c(b2 >> 3);
        } else {
            pVar.a(this.f27903b.f17159a, 0, i2 * 8);
            this.f27903b.c(0);
        }
        this.f27905d.a(this.f27903b, i2);
        this.f27905d.a(this.f27912k, 1, i2, 0, (u.a) null);
        this.f27912k += this.f27920s;
    }

    private void b(p pVar) throws ParserException {
        boolean e2;
        p pVar2 = pVar;
        int c2 = pVar2.c(1);
        int c3 = c2 == 1 ? pVar2.c(1) : 0;
        this.f27914m = c3;
        if (c3 == 0) {
            if (c2 == 1) {
                f(pVar);
            }
            if (pVar.e()) {
                this.f27915n = pVar2.c(6);
                int c4 = pVar2.c(4);
                int c5 = pVar2.c(3);
                if (c4 == 0 && c5 == 0) {
                    if (c2 == 0) {
                        int b2 = pVar.b();
                        int d2 = d(pVar);
                        pVar2.a(b2);
                        byte[] bArr = new byte[((d2 + 7) / 8)];
                        pVar2.a(bArr, 0, d2);
                        Format a2 = Format.a(this.f27907f, "audio/mp4a-latm", (String) null, -1, -1, this.f27921t, this.f27919r, (List<byte[]>) Collections.singletonList(bArr), (DrmInitData) null, 0, this.f27902a);
                        if (!a2.equals(this.f27906e)) {
                            this.f27906e = a2;
                            this.f27920s = 1024000000 / ((long) a2.f15106w);
                            this.f27905d.a(a2);
                        }
                    } else {
                        pVar2.b(((int) f(pVar)) - d(pVar));
                    }
                    c(pVar);
                    boolean e3 = pVar.e();
                    this.f27917p = e3;
                    this.f27918q = 0;
                    if (e3) {
                        if (c2 == 1) {
                            this.f27918q = f(pVar);
                        } else {
                            do {
                                e2 = pVar.e();
                                this.f27918q = (this.f27918q << 8) + ((long) pVar2.c(8));
                            } while (e2);
                        }
                    }
                    if (pVar.e()) {
                        pVar2.b(8);
                        return;
                    }
                    return;
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
        throw new ParserException();
    }

    private void c(p pVar) {
        int i2;
        int c2 = pVar.c(3);
        this.f27916o = c2;
        if (c2 == 0) {
            i2 = 8;
        } else if (c2 == 1) {
            i2 = 9;
        } else if (c2 == 3 || c2 == 4 || c2 == 5) {
            pVar.b(6);
            return;
        } else if (c2 == 6 || c2 == 7) {
            pVar.b(1);
            return;
        } else {
            throw new IllegalStateException();
        }
        pVar.b(i2);
    }

    private int d(p pVar) throws ParserException {
        int a2 = pVar.a();
        Pair<Integer, Integer> a3 = c.a(pVar, true);
        this.f27919r = ((Integer) a3.first).intValue();
        this.f27921t = ((Integer) a3.second).intValue();
        return a2 - pVar.a();
    }

    private int e(p pVar) throws ParserException {
        int c2;
        if (this.f27916o == 0) {
            int i2 = 0;
            do {
                c2 = pVar.c(8);
                i2 += c2;
            } while (c2 == 255);
            return i2;
        }
        throw new ParserException();
    }

    private static long f(p pVar) {
        return (long) pVar.c((pVar.c(2) + 1) * 8);
    }

    public void a() {
        this.f27908g = 0;
        this.f27913l = false;
    }

    public void a(long j2, int i2) {
        this.f27912k = j2;
    }

    public void a(q qVar) throws ParserException {
        while (qVar.b() > 0) {
            int i2 = this.f27908g;
            if (i2 != 0) {
                if (i2 == 1) {
                    int h2 = qVar.h();
                    if ((h2 & 224) == 224) {
                        this.f27911j = h2;
                        this.f27908g = 2;
                    } else if (h2 == 86) {
                    }
                } else if (i2 == 2) {
                    int h3 = ((this.f27911j & -225) << 8) | qVar.h();
                    this.f27910i = h3;
                    if (h3 > this.f27903b.f17159a.length) {
                        a(this.f27910i);
                    }
                    this.f27909h = 0;
                    this.f27908g = 3;
                } else if (i2 == 3) {
                    int min = Math.min(qVar.b(), this.f27910i - this.f27909h);
                    qVar.a(this.f27904c.f17155a, this.f27909h, min);
                    int i3 = this.f27909h + min;
                    this.f27909h = i3;
                    if (i3 == this.f27910i) {
                        this.f27904c.a(0);
                        a(this.f27904c);
                    }
                } else {
                    throw new IllegalStateException();
                }
                this.f27908g = 0;
            } else if (qVar.h() == 86) {
                this.f27908g = 1;
            }
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27905d = iVar.a(dVar.b(), 1);
        this.f27907f = dVar.c();
    }

    public void b() {
    }
}
