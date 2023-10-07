package fm;

import com.google.android.exoplayer2.ParserException;
import fj.h;
import java.io.IOException;
import java.util.ArrayDeque;

final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f27478a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<C0173a> f27479b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final f f27480c = new f();

    /* renamed from: d  reason: collision with root package name */
    private b f27481d;

    /* renamed from: e  reason: collision with root package name */
    private int f27482e;

    /* renamed from: f  reason: collision with root package name */
    private int f27483f;

    /* renamed from: g  reason: collision with root package name */
    private long f27484g;

    /* renamed from: fm.a$a  reason: collision with other inner class name */
    private static final class C0173a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f27485a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f27486b;

        private C0173a(int i2, long j2) {
            this.f27485a = i2;
            this.f27486b = j2;
        }
    }

    private long a(h hVar, int i2) throws IOException, InterruptedException {
        hVar.b(this.f27478a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.f27478a[i3] & 255));
        }
        return j2;
    }

    private double b(h hVar, int i2) throws IOException, InterruptedException {
        long a2 = a(hVar, i2);
        return i2 == 4 ? (double) Float.intBitsToFloat((int) a2) : Double.longBitsToDouble(a2);
    }

    private long b(h hVar) throws IOException, InterruptedException {
        hVar.a();
        while (true) {
            hVar.d(this.f27478a, 0, 4);
            int a2 = f.a(this.f27478a[0]);
            if (a2 != -1 && a2 <= 4) {
                int a3 = (int) f.a(this.f27478a, a2, false);
                if (this.f27481d.b(a3)) {
                    hVar.b(a2);
                    return (long) a3;
                }
            }
            hVar.b(1);
        }
    }

    private String c(h hVar, int i2) throws IOException, InterruptedException {
        if (i2 == 0) {
            return "";
        }
        byte[] bArr = new byte[i2];
        hVar.b(bArr, 0, i2);
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        return new String(bArr, 0, i2);
    }

    public void a() {
        this.f27482e = 0;
        this.f27479b.clear();
        this.f27480c.a();
    }

    public void a(b bVar) {
        this.f27481d = bVar;
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.b(this.f27481d);
        while (true) {
            if (this.f27479b.isEmpty() || hVar.c() < this.f27479b.peek().f27486b) {
                if (this.f27482e == 0) {
                    long a2 = this.f27480c.a(hVar, true, false, 4);
                    if (a2 == -2) {
                        a2 = b(hVar);
                    }
                    if (a2 == -1) {
                        return false;
                    }
                    this.f27483f = (int) a2;
                    this.f27482e = 1;
                }
                if (this.f27482e == 1) {
                    this.f27484g = this.f27480c.a(hVar, false, true, 8);
                    this.f27482e = 2;
                }
                int a3 = this.f27481d.a(this.f27483f);
                if (a3 == 0) {
                    hVar.b((int) this.f27484g);
                    this.f27482e = 0;
                } else if (a3 == 1) {
                    long c2 = hVar.c();
                    this.f27479b.push(new C0173a(this.f27483f, this.f27484g + c2));
                    this.f27481d.a(this.f27483f, c2, this.f27484g);
                    this.f27482e = 0;
                    return true;
                } else if (a3 == 2) {
                    long j2 = this.f27484g;
                    if (j2 <= 8) {
                        this.f27481d.a(this.f27483f, a(hVar, (int) j2));
                        this.f27482e = 0;
                        return true;
                    }
                    long j3 = this.f27484g;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j3);
                    throw new ParserException(sb.toString());
                } else if (a3 == 3) {
                    long j4 = this.f27484g;
                    if (j4 <= 2147483647L) {
                        this.f27481d.a(this.f27483f, c(hVar, (int) j4));
                        this.f27482e = 0;
                        return true;
                    }
                    long j5 = this.f27484g;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j5);
                    throw new ParserException(sb2.toString());
                } else if (a3 == 4) {
                    this.f27481d.a(this.f27483f, (int) this.f27484g, hVar);
                    this.f27482e = 0;
                    return true;
                } else if (a3 == 5) {
                    long j6 = this.f27484g;
                    if (j6 == 4 || j6 == 8) {
                        this.f27481d.a(this.f27483f, b(hVar, (int) j6));
                        this.f27482e = 0;
                        return true;
                    }
                    long j7 = this.f27484g;
                    StringBuilder sb3 = new StringBuilder(40);
                    sb3.append("Invalid float size: ");
                    sb3.append(j7);
                    throw new ParserException(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(a3);
                    throw new ParserException(sb4.toString());
                }
            } else {
                this.f27481d.c(this.f27479b.pop().f27485a);
                return true;
            }
        }
    }
}
