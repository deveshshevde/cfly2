package ft;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import fi.e;
import ft.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class g<T extends h> implements o, p, Loader.a<d>, Loader.e {

    /* renamed from: a  reason: collision with root package name */
    public final int f28068a;

    /* renamed from: b  reason: collision with root package name */
    long f28069b;

    /* renamed from: c  reason: collision with root package name */
    boolean f28070c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int[] f28071d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Format[] f28072e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f28073f;

    /* renamed from: g  reason: collision with root package name */
    private final T f28074g;

    /* renamed from: h  reason: collision with root package name */
    private final p.a<g<T>> f28075h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final j.a f28076i;

    /* renamed from: j  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.p f28077j;

    /* renamed from: k  reason: collision with root package name */
    private final Loader f28078k = new Loader("Loader:ChunkSampleStream");

    /* renamed from: l  reason: collision with root package name */
    private final f f28079l = new f();

    /* renamed from: m  reason: collision with root package name */
    private final ArrayList<a> f28080m;

    /* renamed from: n  reason: collision with root package name */
    private final List<a> f28081n;

    /* renamed from: o  reason: collision with root package name */
    private final n f28082o;

    /* renamed from: p  reason: collision with root package name */
    private final n[] f28083p;

    /* renamed from: q  reason: collision with root package name */
    private final c f28084q;

    /* renamed from: r  reason: collision with root package name */
    private Format f28085r;

    /* renamed from: s  reason: collision with root package name */
    private b<T> f28086s;

    /* renamed from: t  reason: collision with root package name */
    private long f28087t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public long f28088u;

    /* renamed from: v  reason: collision with root package name */
    private int f28089v;

    public final class a implements o {

        /* renamed from: a  reason: collision with root package name */
        public final g<T> f28090a;

        /* renamed from: c  reason: collision with root package name */
        private final n f28092c;

        /* renamed from: d  reason: collision with root package name */
        private final int f28093d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f28094e;

        public a(g<T> gVar, n nVar, int i2) {
            this.f28090a = gVar;
            this.f28092c = nVar;
            this.f28093d = i2;
        }

        private void d() {
            if (!this.f28094e) {
                g.this.f28076i.a(g.this.f28071d[this.f28093d], g.this.f28072e[this.f28093d], 0, (Object) null, g.this.f28088u);
                this.f28094e = true;
            }
        }

        public int a(com.google.android.exoplayer2.o oVar, e eVar, boolean z2) {
            if (g.this.i()) {
                return -3;
            }
            d();
            return this.f28092c.a(oVar, eVar, z2, g.this.f28070c, g.this.f28069b);
        }

        public void a() {
            com.google.android.exoplayer2.util.a.b(g.this.f28073f[this.f28093d]);
            g.this.f28073f[this.f28093d] = false;
        }

        public int a_(long j2) {
            if (g.this.i()) {
                return 0;
            }
            d();
            return (!g.this.f28070c || j2 <= this.f28092c.k()) ? this.f28092c.a(j2) : this.f28092c.n();
        }

        public boolean b() {
            return !g.this.i() && this.f28092c.b(g.this.f28070c);
        }

        public void c() throws IOException {
        }
    }

    public interface b<T extends h> {
        void a(g<T> gVar);
    }

    public g(int i2, int[] iArr, Format[] formatArr, T t2, p.a<g<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j2, com.google.android.exoplayer2.drm.b<?> bVar2, com.google.android.exoplayer2.upstream.p pVar, j.a aVar2) {
        this.f28068a = i2;
        this.f28071d = iArr;
        this.f28072e = formatArr;
        this.f28074g = t2;
        this.f28075h = aVar;
        this.f28076i = aVar2;
        this.f28077j = pVar;
        ArrayList<a> arrayList = new ArrayList<>();
        this.f28080m = arrayList;
        this.f28081n = Collections.unmodifiableList(arrayList);
        int i3 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.f28083p = new n[length];
        this.f28073f = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        n[] nVarArr = new n[i4];
        n nVar = new n(bVar, (Looper) com.google.android.exoplayer2.util.a.b(Looper.myLooper()), bVar2);
        this.f28082o = nVar;
        iArr2[0] = i2;
        nVarArr[0] = nVar;
        while (i3 < length) {
            n nVar2 = new n(bVar, (Looper) com.google.android.exoplayer2.util.a.b(Looper.myLooper()), b.CC.c());
            this.f28083p[i3] = nVar2;
            int i5 = i3 + 1;
            nVarArr[i5] = nVar2;
            iArr2[i5] = iArr[i3];
            i3 = i5;
        }
        this.f28084q = new c(iArr2, nVarArr);
        this.f28087t = j2;
        this.f28088u = j2;
    }

    private int a(int i2, int i3) {
        do {
            i3++;
            if (i3 >= this.f28080m.size()) {
                return this.f28080m.size() - 1;
            }
        } while (this.f28080m.get(i3).a(0) <= i2);
        return i3 - 1;
    }

    private boolean a(int i2) {
        int h2;
        a aVar = this.f28080m.get(i2);
        if (this.f28082o.h() > aVar.a(0)) {
            return true;
        }
        int i3 = 0;
        do {
            n[] nVarArr = this.f28083p;
            if (i3 >= nVarArr.length) {
                return false;
            }
            h2 = nVarArr[i3].h();
            i3++;
        } while (h2 <= aVar.a(i3));
        return true;
    }

    private boolean a(d dVar) {
        return dVar instanceof a;
    }

    private void b(int i2) {
        int min = Math.min(a(i2, 0), this.f28089v);
        if (min > 0) {
            ad.a(this.f28080m, 0, min);
            this.f28089v -= min;
        }
    }

    private void c(int i2) {
        a aVar = this.f28080m.get(i2);
        Format format = aVar.f13112e;
        if (!format.equals(this.f28085r)) {
            this.f28076i.a(this.f28068a, format, aVar.f13113f, aVar.f13114g, aVar.f13115h);
        }
        this.f28085r = format;
    }

    private a d(int i2) {
        a aVar = this.f28080m.get(i2);
        ArrayList<a> arrayList = this.f28080m;
        ad.a(arrayList, i2, arrayList.size());
        this.f28089v = Math.max(this.f28089v, this.f28080m.size());
        n nVar = this.f28082o;
        int i3 = 0;
        while (true) {
            nVar.b(aVar.a(i3));
            n[] nVarArr = this.f28083p;
            if (i3 >= nVarArr.length) {
                return aVar;
            }
            nVar = nVarArr[i3];
            i3++;
        }
    }

    private void j() {
        int a2 = a(this.f28082o.h(), this.f28089v - 1);
        while (true) {
            int i2 = this.f28089v;
            if (i2 <= a2) {
                this.f28089v = i2 + 1;
                c(i2);
            } else {
                return;
            }
        }
    }

    private a k() {
        ArrayList<a> arrayList = this.f28080m;
        return arrayList.get(arrayList.size() - 1);
    }

    public int a(com.google.android.exoplayer2.o oVar, e eVar, boolean z2) {
        if (i()) {
            return -3;
        }
        j();
        return this.f28082o.a(oVar, eVar, z2, this.f28070c, this.f28069b);
    }

    public long a(long j2, com.google.android.exoplayer2.ad adVar) {
        return this.f28074g.a(j2, adVar);
    }

    public Loader.b a(d dVar, long j2, long j3, IOException iOException, int i2) {
        d dVar2 = dVar;
        long e2 = dVar.e();
        boolean a2 = a(dVar);
        int size = this.f28080m.size() - 1;
        boolean z2 = e2 == 0 || !a2 || !a(size);
        Loader.b bVar = null;
        if (this.f28074g.a(dVar, z2, (Exception) iOException, z2 ? this.f28077j.a(dVar2.f13111d, j3, iOException, i2) : -9223372036854775807L)) {
            if (z2) {
                bVar = Loader.f16945c;
                if (a2) {
                    com.google.android.exoplayer2.util.a.b(d(size) == dVar2);
                    if (this.f28080m.isEmpty()) {
                        this.f28087t = this.f28088u;
                    }
                }
            } else {
                k.c("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            }
        }
        if (bVar == null) {
            long b2 = this.f28077j.b(dVar2.f13111d, j3, iOException, i2);
            bVar = b2 != -9223372036854775807L ? Loader.a(false, b2) : Loader.f16946d;
        }
        Loader.b bVar2 = bVar;
        boolean z3 = !bVar2.a();
        this.f28076i.a(dVar2.f13110c, dVar.f(), dVar.g(), dVar2.f13111d, this.f28068a, dVar2.f13112e, dVar2.f13113f, dVar2.f13114g, dVar2.f13115h, dVar2.f13116i, j2, j3, e2, iOException, z3);
        if (z3) {
            this.f28075h.a(this);
        }
        return bVar2;
    }

    public g<T>.a a(long j2, int i2) {
        for (int i3 = 0; i3 < this.f28083p.length; i3++) {
            if (this.f28071d[i3] == i2) {
                com.google.android.exoplayer2.util.a.b(!this.f28073f[i3]);
                this.f28073f[i3] = true;
                this.f28083p[i3].a(j2, true);
                return new a(this, this.f28083p[i3], i3);
            }
        }
        throw new IllegalStateException();
    }

    public T a() {
        return this.f28074g;
    }

    public void a(long j2) {
        int size;
        int a2;
        if (!this.f28078k.c() && !this.f28078k.a() && !i() && (size = this.f28080m.size()) > (a2 = this.f28074g.a(j2, (List<? extends l>) this.f28081n))) {
            while (true) {
                if (a2 >= size) {
                    a2 = size;
                    break;
                } else if (!a(a2)) {
                    break;
                } else {
                    a2++;
                }
            }
            if (a2 != size) {
                long j3 = k().f13116i;
                a d2 = d(a2);
                if (this.f28080m.isEmpty()) {
                    this.f28087t = this.f28088u;
                }
                this.f28070c = false;
                this.f28076i.a(this.f28068a, d2.f13115h, j3);
            }
        }
    }

    public void a(long j2, boolean z2) {
        if (!i()) {
            int g2 = this.f28082o.g();
            this.f28082o.a(j2, z2, true);
            int g3 = this.f28082o.g();
            if (g3 > g2) {
                long m2 = this.f28082o.m();
                int i2 = 0;
                while (true) {
                    n[] nVarArr = this.f28083p;
                    if (i2 >= nVarArr.length) {
                        break;
                    }
                    nVarArr[i2].a(m2, z2, this.f28073f[i2]);
                    i2++;
                }
            }
            b(g3);
        }
    }

    public void a(d dVar, long j2, long j3) {
        d dVar2 = dVar;
        this.f28074g.a(dVar2);
        this.f28076i.a(dVar2.f13110c, dVar.f(), dVar.g(), dVar2.f13111d, this.f28068a, dVar2.f13112e, dVar2.f13113f, dVar2.f13114g, dVar2.f13115h, dVar2.f13116i, j2, j3, dVar.e());
        this.f28075h.a(this);
    }

    public void a(d dVar, long j2, long j3, boolean z2) {
        d dVar2 = dVar;
        this.f28076i.b(dVar2.f13110c, dVar.f(), dVar.g(), dVar2.f13111d, this.f28068a, dVar2.f13112e, dVar2.f13113f, dVar2.f13114g, dVar2.f13115h, dVar2.f13116i, j2, j3, dVar.e());
        if (!z2) {
            this.f28082o.b();
            for (n b2 : this.f28083p) {
                b2.b();
            }
            this.f28075h.a(this);
        }
    }

    public void a(b<T> bVar) {
        this.f28086s = bVar;
        this.f28082o.e();
        for (n e2 : this.f28083p) {
            e2.e();
        }
        this.f28078k.a((Loader.e) this);
    }

    public int a_(long j2) {
        if (i()) {
            return 0;
        }
        int a2 = (!this.f28070c || j2 <= this.f28082o.k()) ? this.f28082o.a(j2) : this.f28082o.n();
        j();
        return a2;
    }

    public void b(long j2) {
        boolean a2;
        long j3;
        this.f28088u = j2;
        if (i()) {
            this.f28087t = j2;
            return;
        }
        a aVar = null;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f28080m.size()) {
                break;
            }
            a aVar2 = this.f28080m.get(i3);
            long j4 = aVar2.f13115h;
            if (j4 == j2 && aVar2.f28041a == -9223372036854775807L) {
                aVar = aVar2;
                break;
            } else if (j4 > j2) {
                break;
            } else {
                i3++;
            }
        }
        if (aVar != null) {
            a2 = this.f28082o.c(aVar.a(0));
            j3 = 0;
        } else {
            a2 = this.f28082o.a(j2, j2 < e());
            j3 = this.f28088u;
        }
        this.f28069b = j3;
        if (a2) {
            this.f28089v = a(this.f28082o.h(), 0);
            n[] nVarArr = this.f28083p;
            int length = nVarArr.length;
            while (i2 < length) {
                nVarArr[i2].a(j2, true);
                i2++;
            }
            return;
        }
        this.f28087t = j2;
        this.f28070c = false;
        this.f28080m.clear();
        this.f28089v = 0;
        if (this.f28078k.c()) {
            this.f28078k.d();
            return;
        }
        this.f28078k.b();
        this.f28082o.b();
        n[] nVarArr2 = this.f28083p;
        int length2 = nVarArr2.length;
        while (i2 < length2) {
            nVarArr2[i2].b();
            i2++;
        }
    }

    public boolean b() {
        return !i() && this.f28082o.b(this.f28070c);
    }

    public void c() throws IOException {
        this.f28078k.f();
        this.f28082o.f();
        if (!this.f28078k.c()) {
            this.f28074g.a();
        }
    }

    public boolean c(long j2) {
        long j3;
        List<a> list;
        boolean z2 = false;
        if (this.f28070c || this.f28078k.c() || this.f28078k.a()) {
            return false;
        }
        boolean i2 = i();
        if (i2) {
            list = Collections.emptyList();
            j3 = this.f28087t;
        } else {
            list = this.f28081n;
            j3 = k().f13116i;
        }
        T t2 = this.f28074g;
        long j4 = j2;
        t2.a(j4, j3, (List<? extends l>) list, this.f28079l);
        boolean z3 = this.f28079l.f28067b;
        d dVar = this.f28079l.f28066a;
        this.f28079l.a();
        if (z3) {
            this.f28087t = -9223372036854775807L;
            this.f28070c = true;
            return true;
        } else if (dVar == null) {
            return false;
        } else {
            if (a(dVar)) {
                a aVar = (a) dVar;
                if (i2) {
                    long j5 = aVar.f13115h;
                    long j6 = this.f28087t;
                    if (j5 == j6) {
                        z2 = true;
                    }
                    if (z2) {
                        j6 = 0;
                    }
                    this.f28069b = j6;
                    this.f28087t = -9223372036854775807L;
                }
                aVar.a(this.f28084q);
                this.f28080m.add(aVar);
            } else if (dVar instanceof k) {
                ((k) dVar).a(this.f28084q);
            }
            long a2 = this.f28078k.a(dVar, this, this.f28077j.a(dVar.f13111d));
            this.f28076i.a(dVar.f13110c, dVar.f13111d, this.f28068a, dVar.f13112e, dVar.f13113f, dVar.f13114g, dVar.f13115h, dVar.f13116i, a2);
            return true;
        }
    }

    public long d() {
        if (this.f28070c) {
            return Long.MIN_VALUE;
        }
        if (i()) {
            return this.f28087t;
        }
        long j2 = this.f28088u;
        a k2 = k();
        if (!k2.i()) {
            if (this.f28080m.size() > 1) {
                ArrayList<a> arrayList = this.f28080m;
                k2 = arrayList.get(arrayList.size() - 2);
            } else {
                k2 = null;
            }
        }
        if (k2 != null) {
            j2 = Math.max(j2, k2.f13116i);
        }
        return Math.max(j2, this.f28082o.k());
    }

    public long e() {
        if (i()) {
            return this.f28087t;
        }
        if (this.f28070c) {
            return Long.MIN_VALUE;
        }
        return k().f13116i;
    }

    public boolean f() {
        return this.f28078k.c();
    }

    public void g() {
        a((b) null);
    }

    public void h() {
        this.f28082o.a();
        for (n a2 : this.f28083p) {
            a2.a();
        }
        b<T> bVar = this.f28086s;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f28087t != -9223372036854775807L;
    }
}
