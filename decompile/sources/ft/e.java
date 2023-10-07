package ft;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.q;
import fj.f;
import fj.g;
import fj.h;
import fj.i;
import fj.s;
import fj.u;
import java.io.IOException;

public final class e implements i {

    /* renamed from: a  reason: collision with root package name */
    public final g f28050a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28051b;

    /* renamed from: c  reason: collision with root package name */
    private final Format f28052c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<a> f28053d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f28054e;

    /* renamed from: f  reason: collision with root package name */
    private b f28055f;

    /* renamed from: g  reason: collision with root package name */
    private long f28056g;

    /* renamed from: h  reason: collision with root package name */
    private s f28057h;

    /* renamed from: i  reason: collision with root package name */
    private Format[] f28058i;

    private static final class a implements u {

        /* renamed from: a  reason: collision with root package name */
        public Format f28059a;

        /* renamed from: b  reason: collision with root package name */
        private final int f28060b;

        /* renamed from: c  reason: collision with root package name */
        private final int f28061c;

        /* renamed from: d  reason: collision with root package name */
        private final Format f28062d;

        /* renamed from: e  reason: collision with root package name */
        private final f f28063e = new f();

        /* renamed from: f  reason: collision with root package name */
        private u f28064f;

        /* renamed from: g  reason: collision with root package name */
        private long f28065g;

        public a(int i2, int i3, Format format) {
            this.f28060b = i2;
            this.f28061c = i3;
            this.f28062d = format;
        }

        public int a(h hVar, int i2, boolean z2) throws IOException, InterruptedException {
            return this.f28064f.a(hVar, i2, z2);
        }

        public void a(long j2, int i2, int i3, int i4, u.a aVar) {
            long j3 = this.f28065g;
            if (j3 != -9223372036854775807L && j2 >= j3) {
                this.f28064f = this.f28063e;
            }
            this.f28064f.a(j2, i2, i3, i4, aVar);
        }

        public void a(Format format) {
            Format format2 = this.f28062d;
            if (format2 != null) {
                format = format.a(format2);
            }
            this.f28059a = format;
            this.f28064f.a(format);
        }

        public void a(q qVar, int i2) {
            this.f28064f.a(qVar, i2);
        }

        public void a(b bVar, long j2) {
            if (bVar == null) {
                this.f28064f = this.f28063e;
                return;
            }
            this.f28065g = j2;
            u a2 = bVar.a(this.f28060b, this.f28061c);
            this.f28064f = a2;
            Format format = this.f28059a;
            if (format != null) {
                a2.a(format);
            }
        }
    }

    public interface b {
        u a(int i2, int i3);
    }

    public e(g gVar, int i2, Format format) {
        this.f28050a = gVar;
        this.f28051b = i2;
        this.f28052c = format;
    }

    public u a(int i2, int i3) {
        a aVar = this.f28053d.get(i2);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.b(this.f28058i == null);
            aVar = new a(i2, i3, i3 == this.f28051b ? this.f28052c : null);
            aVar.a(this.f28055f, this.f28056g);
            this.f28053d.put(i2, aVar);
        }
        return aVar;
    }

    public void a() {
        Format[] formatArr = new Format[this.f28053d.size()];
        for (int i2 = 0; i2 < this.f28053d.size(); i2++) {
            formatArr[i2] = this.f28053d.valueAt(i2).f28059a;
        }
        this.f28058i = formatArr;
    }

    public void a(s sVar) {
        this.f28057h = sVar;
    }

    public void a(b bVar, long j2, long j3) {
        this.f28055f = bVar;
        this.f28056g = j3;
        if (!this.f28054e) {
            this.f28050a.a((i) this);
            if (j2 != -9223372036854775807L) {
                this.f28050a.a(0, j2);
            }
            this.f28054e = true;
            return;
        }
        g gVar = this.f28050a;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        gVar.a(0, j2);
        for (int i2 = 0; i2 < this.f28053d.size(); i2++) {
            this.f28053d.valueAt(i2).a(bVar, j3);
        }
    }

    public s b() {
        return this.f28057h;
    }

    public Format[] c() {
        return this.f28058i;
    }
}
