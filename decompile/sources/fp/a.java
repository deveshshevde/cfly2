package fp;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.h;
import fj.i;
import fj.r;
import fj.s;
import fj.u;
import java.io.IOException;

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Format f27655a;

    /* renamed from: b  reason: collision with root package name */
    private final q f27656b = new q(9);

    /* renamed from: c  reason: collision with root package name */
    private u f27657c;

    /* renamed from: d  reason: collision with root package name */
    private int f27658d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f27659e;

    /* renamed from: f  reason: collision with root package name */
    private long f27660f;

    /* renamed from: g  reason: collision with root package name */
    private int f27661g;

    /* renamed from: h  reason: collision with root package name */
    private int f27662h;

    public a(Format format) {
        this.f27655a = format;
    }

    private boolean b(h hVar) throws IOException, InterruptedException {
        this.f27656b.a();
        if (!hVar.a(this.f27656b.f17159a, 0, 8, true)) {
            return false;
        }
        if (this.f27656b.p() == 1380139777) {
            this.f27659e = this.f27656b.h();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    private boolean c(h hVar) throws IOException, InterruptedException {
        long r2;
        this.f27656b.a();
        int i2 = this.f27659e;
        if (i2 == 0) {
            if (!hVar.a(this.f27656b.f17159a, 0, 5, true)) {
                return false;
            }
            r2 = (this.f27656b.n() * 1000) / 45;
        } else if (i2 != 1) {
            int i3 = this.f27659e;
            StringBuilder sb = new StringBuilder(39);
            sb.append("Unsupported version number: ");
            sb.append(i3);
            throw new ParserException(sb.toString());
        } else if (!hVar.a(this.f27656b.f17159a, 0, 9, true)) {
            return false;
        } else {
            r2 = this.f27656b.r();
        }
        this.f27660f = r2;
        this.f27661g = this.f27656b.h();
        this.f27662h = 0;
        return true;
    }

    private void d(h hVar) throws IOException, InterruptedException {
        while (this.f27661g > 0) {
            this.f27656b.a();
            hVar.b(this.f27656b.f17159a, 0, 3);
            this.f27657c.a(this.f27656b, 3);
            this.f27662h += 3;
            this.f27661g--;
        }
        int i2 = this.f27662h;
        if (i2 > 0) {
            this.f27657c.a(this.f27660f, 1, i2, 0, (u.a) null);
        }
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f27658d;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        d(hVar);
                        this.f27658d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (c(hVar)) {
                    this.f27658d = 2;
                } else {
                    this.f27658d = 0;
                    return -1;
                }
            } else if (!b(hVar)) {
                return -1;
            } else {
                this.f27658d = 1;
            }
        }
    }

    public void a(long j2, long j3) {
        this.f27658d = 0;
    }

    public void a(i iVar) {
        iVar.a(new s.b(-9223372036854775807L));
        this.f27657c = iVar.a(0, 3);
        iVar.a();
        this.f27657c.a(this.f27655a);
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        this.f27656b.a();
        hVar.d(this.f27656b.f17159a, 0, 8);
        return this.f27656b.p() == 1380139777;
    }

    public void c() {
    }
}
