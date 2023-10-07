package fo;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.q;
import fj.h;
import java.io.EOFException;
import java.io.IOException;

final class e {

    /* renamed from: a  reason: collision with root package name */
    public int f27617a;

    /* renamed from: b  reason: collision with root package name */
    public int f27618b;

    /* renamed from: c  reason: collision with root package name */
    public long f27619c;

    /* renamed from: d  reason: collision with root package name */
    public long f27620d;

    /* renamed from: e  reason: collision with root package name */
    public long f27621e;

    /* renamed from: f  reason: collision with root package name */
    public long f27622f;

    /* renamed from: g  reason: collision with root package name */
    public int f27623g;

    /* renamed from: h  reason: collision with root package name */
    public int f27624h;

    /* renamed from: i  reason: collision with root package name */
    public int f27625i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f27626j = new int[255];

    /* renamed from: k  reason: collision with root package name */
    private final q f27627k = new q(255);

    e() {
    }

    public void a() {
        this.f27617a = 0;
        this.f27618b = 0;
        this.f27619c = 0;
        this.f27620d = 0;
        this.f27621e = 0;
        this.f27622f = 0;
        this.f27623g = 0;
        this.f27624h = 0;
        this.f27625i = 0;
    }

    public boolean a(h hVar, boolean z2) throws IOException, InterruptedException {
        this.f27627k.a();
        a();
        if (!(hVar.d() == -1 || hVar.d() - hVar.b() >= 27) || !hVar.b(this.f27627k.f17159a, 0, 27, true)) {
            if (z2) {
                return false;
            }
            throw new EOFException();
        } else if (this.f27627k.n() == 1332176723) {
            int h2 = this.f27627k.h();
            this.f27617a = h2;
            if (h2 == 0) {
                this.f27618b = this.f27627k.h();
                this.f27619c = this.f27627k.s();
                this.f27620d = this.f27627k.o();
                this.f27621e = this.f27627k.o();
                this.f27622f = this.f27627k.o();
                int h3 = this.f27627k.h();
                this.f27623g = h3;
                this.f27624h = h3 + 27;
                this.f27627k.a();
                hVar.d(this.f27627k.f17159a, 0, this.f27623g);
                for (int i2 = 0; i2 < this.f27623g; i2++) {
                    this.f27626j[i2] = this.f27627k.h();
                    this.f27625i += this.f27626j[i2];
                }
                return true;
            } else if (z2) {
                return false;
            } else {
                throw new ParserException("unsupported bit stream revision");
            }
        } else if (z2) {
            return false;
        } else {
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
    }
}
