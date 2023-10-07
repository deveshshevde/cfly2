package fq;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.s;
import fq.ac;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ab implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27675a = $$Lambda$ab$th0IXnuopdrt5FUHXnRk6ZxfoOg.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f27676b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final List<aa> f27677c;

    /* renamed from: d  reason: collision with root package name */
    private final q f27678d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseIntArray f27679e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ac.c f27680f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<ac> f27681g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final SparseBooleanArray f27682h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final SparseBooleanArray f27683i;

    /* renamed from: j  reason: collision with root package name */
    private final aa f27684j;

    /* renamed from: k  reason: collision with root package name */
    private z f27685k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public i f27686l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f27687m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f27688n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f27689o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f27690p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public ac f27691q;

    /* renamed from: r  reason: collision with root package name */
    private int f27692r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f27693s;

    private class a implements v {

        /* renamed from: b  reason: collision with root package name */
        private final p f27695b = new p(new byte[4]);

        public a() {
        }

        public void a(aa aaVar, i iVar, ac.d dVar) {
        }

        public void a(q qVar) {
            if (qVar.h() == 0 && (qVar.h() & 128) != 0) {
                qVar.d(6);
                int b2 = qVar.b() / 4;
                for (int i2 = 0; i2 < b2; i2++) {
                    qVar.a(this.f27695b, 4);
                    int c2 = this.f27695b.c(16);
                    this.f27695b.b(3);
                    if (c2 == 0) {
                        this.f27695b.b(13);
                    } else {
                        int c3 = this.f27695b.c(13);
                        ab.this.f27681g.put(c3, new w(new b(c3)));
                        ab.b(ab.this);
                    }
                }
                if (ab.this.f27676b != 2) {
                    ab.this.f27681g.remove(0);
                }
            }
        }
    }

    private class b implements v {

        /* renamed from: b  reason: collision with root package name */
        private final p f27697b = new p(new byte[5]);

        /* renamed from: c  reason: collision with root package name */
        private final SparseArray<ac> f27698c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        private final SparseIntArray f27699d = new SparseIntArray();

        /* renamed from: e  reason: collision with root package name */
        private final int f27700e;

        public b(int i2) {
            this.f27700e = i2;
        }

        private ac.b a(q qVar, int i2) {
            int d2 = qVar.d();
            int i3 = i2 + d2;
            String str = null;
            ArrayList arrayList = null;
            int i4 = -1;
            while (qVar.d() < i3) {
                int h2 = qVar.h();
                int d3 = qVar.d() + qVar.h();
                if (h2 == 5) {
                    long n2 = qVar.n();
                    if (n2 != 1094921523) {
                        if (n2 != 1161904947) {
                            if (n2 != 1094921524) {
                                if (n2 == 1212503619) {
                                    i4 = 36;
                                }
                                qVar.d(d3 - qVar.d());
                            }
                        }
                        i4 = IChannelListener.CMD_CHANNEL_NO_MORE_SPACE;
                        qVar.d(d3 - qVar.d());
                    }
                    i4 = IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN;
                    qVar.d(d3 - qVar.d());
                } else {
                    if (h2 != 106) {
                        if (h2 != 122) {
                            if (h2 == 127) {
                                if (qVar.h() != 21) {
                                }
                            } else if (h2 == 123) {
                                i4 = 138;
                            } else if (h2 == 10) {
                                str = qVar.e(3).trim();
                            } else if (h2 == 89) {
                                arrayList = new ArrayList();
                                while (qVar.d() < d3) {
                                    String trim = qVar.e(3).trim();
                                    int h3 = qVar.h();
                                    byte[] bArr = new byte[4];
                                    qVar.a(bArr, 0, 4);
                                    arrayList.add(new ac.a(trim, h3, bArr));
                                }
                                i4 = 89;
                            }
                            qVar.d(d3 - qVar.d());
                        }
                        i4 = IChannelListener.CMD_CHANNEL_NO_MORE_SPACE;
                        qVar.d(d3 - qVar.d());
                    }
                    i4 = IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN;
                    qVar.d(d3 - qVar.d());
                }
                i4 = 172;
                qVar.d(d3 - qVar.d());
            }
            qVar.c(i3);
            return new ac.b(i4, str, arrayList, Arrays.copyOfRange(qVar.f17159a, d2, i3));
        }

        public void a(aa aaVar, i iVar, ac.d dVar) {
        }

        public void a(q qVar) {
            aa aaVar;
            q qVar2 = qVar;
            if (qVar.h() == 2) {
                int i2 = 0;
                if (ab.this.f27676b == 1 || ab.this.f27676b == 2 || ab.this.f27687m == 1) {
                    aaVar = (aa) ab.this.f27677c.get(0);
                } else {
                    aaVar = new aa(((aa) ab.this.f27677c.get(0)).a());
                    ab.this.f27677c.add(aaVar);
                }
                if ((qVar.h() & 128) != 0) {
                    qVar2.d(1);
                    int i3 = qVar.i();
                    int i4 = 3;
                    qVar2.d(3);
                    qVar2.a(this.f27697b, 2);
                    this.f27697b.b(3);
                    int i5 = 13;
                    int unused = ab.this.f27693s = this.f27697b.c(13);
                    qVar2.a(this.f27697b, 2);
                    int i6 = 4;
                    this.f27697b.b(4);
                    qVar2.d(this.f27697b.c(12));
                    if (ab.this.f27676b == 2 && ab.this.f27691q == null) {
                        ac.b bVar = new ac.b(21, (String) null, (List<ac.a>) null, ad.f11760f);
                        ab abVar = ab.this;
                        ac unused2 = abVar.f27691q = abVar.f27680f.a(21, bVar);
                        ab.this.f27691q.a(aaVar, ab.this.f27686l, new ac.d(i3, 21, 8192));
                    }
                    this.f27698c.clear();
                    this.f27699d.clear();
                    int b2 = qVar.b();
                    while (b2 > 0) {
                        qVar2.a(this.f27697b, 5);
                        int c2 = this.f27697b.c(8);
                        this.f27697b.b(i4);
                        int c3 = this.f27697b.c(i5);
                        this.f27697b.b(i6);
                        int c4 = this.f27697b.c(12);
                        ac.b a2 = a(qVar2, c4);
                        if (c2 == 6) {
                            c2 = a2.f27704a;
                        }
                        b2 -= c4 + 5;
                        int i7 = ab.this.f27676b == 2 ? c2 : c3;
                        if (!ab.this.f27682h.get(i7)) {
                            ac f2 = (ab.this.f27676b == 2 && c2 == 21) ? ab.this.f27691q : ab.this.f27680f.a(c2, a2);
                            if (ab.this.f27676b != 2 || c3 < this.f27699d.get(i7, 8192)) {
                                this.f27699d.put(i7, c3);
                                this.f27698c.put(i7, f2);
                            }
                        }
                        i4 = 3;
                        i6 = 4;
                        i5 = 13;
                    }
                    int size = this.f27699d.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        int keyAt = this.f27699d.keyAt(i8);
                        int valueAt = this.f27699d.valueAt(i8);
                        ab.this.f27682h.put(keyAt, true);
                        ab.this.f27683i.put(valueAt, true);
                        ac valueAt2 = this.f27698c.valueAt(i8);
                        if (valueAt2 != null) {
                            if (valueAt2 != ab.this.f27691q) {
                                valueAt2.a(aaVar, ab.this.f27686l, new ac.d(i3, keyAt, 8192));
                            }
                            ab.this.f27681g.put(valueAt, valueAt2);
                        }
                    }
                    if (ab.this.f27676b != 2) {
                        ab.this.f27681g.remove(this.f27700e);
                        ab abVar2 = ab.this;
                        if (abVar2.f27676b != 1) {
                            i2 = ab.this.f27687m - 1;
                        }
                        int unused3 = abVar2.f27687m = i2;
                        if (ab.this.f27687m == 0) {
                            ab.this.f27686l.a();
                        } else {
                            return;
                        }
                    } else if (!ab.this.f27688n) {
                        ab.this.f27686l.a();
                        int unused4 = ab.this.f27687m = 0;
                    } else {
                        return;
                    }
                    boolean unused5 = ab.this.f27688n = true;
                }
            }
        }
    }

    public ab() {
        this(0);
    }

    public ab(int i2) {
        this(1, i2);
    }

    public ab(int i2, int i3) {
        this(i2, new aa(0), new g(i3));
    }

    public ab(int i2, aa aaVar, ac.c cVar) {
        this.f27680f = (ac.c) com.google.android.exoplayer2.util.a.b(cVar);
        this.f27676b = i2;
        if (i2 == 1 || i2 == 2) {
            this.f27677c = Collections.singletonList(aaVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f27677c = arrayList;
            arrayList.add(aaVar);
        }
        this.f27678d = new q(new byte[9400], 0);
        this.f27682h = new SparseBooleanArray();
        this.f27683i = new SparseBooleanArray();
        this.f27681g = new SparseArray<>();
        this.f27679e = new SparseIntArray();
        this.f27684j = new aa();
        this.f27693s = -1;
        b();
    }

    private int a() throws ParserException {
        int d2 = this.f27678d.d();
        int c2 = this.f27678d.c();
        int a2 = ad.a(this.f27678d.f17159a, d2, c2);
        this.f27678d.c(a2);
        int i2 = a2 + 188;
        if (i2 > c2) {
            int i3 = this.f27692r + (a2 - d2);
            this.f27692r = i3;
            if (this.f27676b == 2 && i3 > 376) {
                throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.f27692r = 0;
        }
        return i2;
    }

    private void a(long j2) {
        s sVar;
        i iVar;
        if (!this.f27689o) {
            this.f27689o = true;
            if (this.f27684j.b() != -9223372036854775807L) {
                z zVar = new z(this.f27684j.c(), this.f27684j.b(), j2, this.f27693s);
                this.f27685k = zVar;
                iVar = this.f27686l;
                sVar = zVar.a();
            } else {
                iVar = this.f27686l;
                sVar = new s.b(this.f27684j.b());
            }
            iVar.a(sVar);
        }
    }

    private boolean a(int i2) {
        return this.f27676b == 2 || this.f27688n || !this.f27683i.get(i2, false);
    }

    static /* synthetic */ int b(ab abVar) {
        int i2 = abVar.f27687m;
        abVar.f27687m = i2 + 1;
        return i2;
    }

    private void b() {
        this.f27682h.clear();
        this.f27681g.clear();
        SparseArray<ac> a2 = this.f27680f.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f27681g.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.f27681g.put(0, new w(new a()));
        this.f27691q = null;
    }

    private boolean b(h hVar) throws IOException, InterruptedException {
        byte[] bArr = this.f27678d.f17159a;
        if (9400 - this.f27678d.d() < 188) {
            int b2 = this.f27678d.b();
            if (b2 > 0) {
                System.arraycopy(bArr, this.f27678d.d(), bArr, 0, b2);
            }
            this.f27678d.a(bArr, b2);
        }
        while (this.f27678d.b() < 188) {
            int c2 = this.f27678d.c();
            int a2 = hVar.a(bArr, c2, 9400 - c2);
            if (a2 == -1) {
                return false;
            }
            this.f27678d.b(c2 + a2);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] d() {
        return new g[]{new ab()};
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        h hVar2 = hVar;
        r rVar2 = rVar;
        long d2 = hVar.d();
        if (this.f27688n) {
            if (((d2 == -1 || this.f27676b == 2) ? false : true) && !this.f27684j.a()) {
                return this.f27684j.a(hVar2, rVar2, this.f27693s);
            }
            a(d2);
            if (this.f27690p) {
                this.f27690p = false;
                a(0, 0);
                if (hVar.c() != 0) {
                    rVar2.f27401a = 0;
                    return 1;
                }
            }
            z zVar = this.f27685k;
            if (zVar != null && zVar.b()) {
                return this.f27685k.a(hVar2, rVar2);
            }
        }
        if (!b(hVar)) {
            return -1;
        }
        int a2 = a();
        int c2 = this.f27678d.c();
        if (a2 > c2) {
            return 0;
        }
        int p2 = this.f27678d.p();
        if ((8388608 & p2) == 0) {
            int i2 = ((4194304 & p2) != 0 ? 1 : 0) | 0;
            int i3 = (2096896 & p2) >> 8;
            boolean z2 = (p2 & 32) != 0;
            ac acVar = (p2 & 16) != 0 ? this.f27681g.get(i3) : null;
            if (acVar != null) {
                if (this.f27676b != 2) {
                    int i4 = p2 & 15;
                    int i5 = this.f27679e.get(i3, i4 - 1);
                    this.f27679e.put(i3, i4);
                    if (i5 != i4) {
                        if (i4 != ((i5 + 1) & 15)) {
                            acVar.a();
                        }
                    }
                }
                if (z2) {
                    int h2 = this.f27678d.h();
                    i2 |= (this.f27678d.h() & 64) != 0 ? 2 : 0;
                    this.f27678d.d(h2 - 1);
                }
                boolean z3 = this.f27688n;
                if (a(i3)) {
                    this.f27678d.b(a2);
                    acVar.a(this.f27678d, i2);
                    this.f27678d.b(c2);
                }
                if (this.f27676b != 2 && !z3 && this.f27688n && d2 != -1) {
                    this.f27690p = true;
                }
            }
        }
        this.f27678d.c(a2);
        return 0;
    }

    public void a(long j2, long j3) {
        z zVar;
        com.google.android.exoplayer2.util.a.b(this.f27676b != 2);
        int size = this.f27677c.size();
        for (int i2 = 0; i2 < size; i2++) {
            aa aaVar = this.f27677c.get(i2);
            if ((aaVar.c() == -9223372036854775807L) || !(aaVar.c() == 0 || aaVar.a() == j3)) {
                aaVar.d();
                aaVar.a(j3);
            }
        }
        if (!(j3 == 0 || (zVar = this.f27685k) == null)) {
            zVar.a(j3);
        }
        this.f27678d.a();
        this.f27679e.clear();
        for (int i3 = 0; i3 < this.f27681g.size(); i3++) {
            this.f27681g.valueAt(i3).a();
        }
        this.f27692r = 0;
    }

    public void a(i iVar) {
        this.f27686l = iVar;
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        boolean z2;
        byte[] bArr = this.f27678d.f17159a;
        hVar.d(bArr, 0, 940);
        for (int i2 = 0; i2 < 188; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= 5) {
                    z2 = true;
                    break;
                } else if (bArr[(i3 * 188) + i2] != 71) {
                    z2 = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                hVar.b(i2);
                return true;
            }
        }
        return false;
    }

    public void c() {
    }
}
