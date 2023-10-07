package fo;

import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.q;
import fj.h;
import java.io.IOException;
import java.util.Arrays;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private final e f27612a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final q f27613b = new q(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f27614c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f27615d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27616e;

    d() {
    }

    private int a(int i2) {
        int i3 = 0;
        this.f27615d = 0;
        while (this.f27615d + i2 < this.f27612a.f27623g) {
            int[] iArr = this.f27612a.f27626j;
            int i4 = this.f27615d;
            this.f27615d = i4 + 1;
            int i5 = iArr[i4 + i2];
            i3 += i5;
            if (i5 != 255) {
                break;
            }
        }
        return i3;
    }

    public void a() {
        this.f27612a.a();
        this.f27613b.a();
        this.f27614c = -1;
        this.f27616e = false;
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        int i2;
        a.b(hVar != null);
        if (this.f27616e) {
            this.f27616e = false;
            this.f27613b.a();
        }
        while (!this.f27616e) {
            if (this.f27614c < 0) {
                if (!this.f27612a.a(hVar, true)) {
                    return false;
                }
                int i3 = this.f27612a.f27624h;
                if ((this.f27612a.f27618b & 1) == 1 && this.f27613b.c() == 0) {
                    i3 += a(0);
                    i2 = this.f27615d + 0;
                } else {
                    i2 = 0;
                }
                hVar.b(i3);
                this.f27614c = i2;
            }
            int a2 = a(this.f27614c);
            int i4 = this.f27614c + this.f27615d;
            if (a2 > 0) {
                if (this.f27613b.e() < this.f27613b.c() + a2) {
                    q qVar = this.f27613b;
                    qVar.f17159a = Arrays.copyOf(qVar.f17159a, this.f27613b.c() + a2);
                }
                hVar.b(this.f27613b.f17159a, this.f27613b.c(), a2);
                q qVar2 = this.f27613b;
                qVar2.b(qVar2.c() + a2);
                this.f27616e = this.f27612a.f27626j[i4 + -1] != 255;
            }
            if (i4 == this.f27612a.f27623g) {
                i4 = -1;
            }
            this.f27614c = i4;
        }
        return true;
    }

    public e b() {
        return this.f27612a;
    }

    public q c() {
        return this.f27613b;
    }

    public void d() {
        if (this.f27613b.f17159a.length != 65025) {
            q qVar = this.f27613b;
            qVar.f17159a = Arrays.copyOf(qVar.f17159a, Math.max(65025, this.f27613b.c()));
        }
    }
}
