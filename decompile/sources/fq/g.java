package fq;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.q;
import fq.ac;
import fw.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class g implements ac.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f27779a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Format> f27780b;

    public g() {
        this(0);
    }

    public g(int i2) {
        this(i2, Collections.singletonList(Format.a((String) null, "application/cea-608", 0, (String) null)));
    }

    public g(int i2, List<Format> list) {
        this.f27779a = i2;
        this.f27780b = list;
    }

    private x a(ac.b bVar) {
        return new x(c(bVar));
    }

    private boolean a(int i2) {
        return (i2 & this.f27779a) != 0;
    }

    private ae b(ac.b bVar) {
        return new ae(c(bVar));
    }

    private List<Format> c(ac.b bVar) {
        int i2;
        String str;
        List<byte[]> list;
        if (a(32)) {
            return this.f27780b;
        }
        q qVar = new q(bVar.f27707d);
        List<Format> list2 = this.f27780b;
        while (qVar.b() > 0) {
            int h2 = qVar.h();
            int d2 = qVar.d() + qVar.h();
            if (h2 == 134) {
                list2 = new ArrayList<>();
                int h3 = qVar.h() & 31;
                for (int i3 = 0; i3 < h3; i3++) {
                    String e2 = qVar.e(3);
                    int h4 = qVar.h();
                    boolean z2 = true;
                    boolean z3 = (h4 & 128) != 0;
                    if (z3) {
                        i2 = h4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte h5 = (byte) qVar.h();
                    qVar.d(1);
                    if (z3) {
                        if ((h5 & 64) == 0) {
                            z2 = false;
                        }
                        list = d.a(z2);
                    } else {
                        list = null;
                    }
                    list2.add(Format.a((String) null, str, (String) null, -1, 0, e2, i2, (DrmInitData) null, Long.MAX_VALUE, list));
                }
            }
            qVar.c(d2);
        }
        return list2;
    }

    public SparseArray<ac> a() {
        return new SparseArray<>();
    }

    public ac a(int i2, ac.b bVar) {
        if (i2 == 2) {
            return new r(new k(b(bVar)));
        }
        if (i2 == 3 || i2 == 4) {
            return new r(new p(bVar.f27705b));
        }
        if (i2 != 15) {
            if (i2 != 17) {
                if (i2 == 21) {
                    return new r(new n());
                }
                if (i2 != 27) {
                    if (i2 == 36) {
                        return new r(new m(a(bVar)));
                    }
                    if (i2 == 89) {
                        return new r(new i(bVar.f27706c));
                    }
                    if (i2 != 138) {
                        if (i2 == 172) {
                            return new r(new d(bVar.f27705b));
                        }
                        if (i2 != 129) {
                            if (i2 != 130) {
                                if (i2 != 134) {
                                    if (i2 != 135) {
                                        return null;
                                    }
                                } else if (a(16)) {
                                    return null;
                                } else {
                                    return new w(new y());
                                }
                            } else if (!a(64)) {
                                return null;
                            }
                        }
                        return new r(new b(bVar.f27705b));
                    }
                    return new r(new h(bVar.f27705b));
                } else if (a(4)) {
                    return null;
                } else {
                    return new r(new l(a(bVar), a(1), a(8)));
                }
            } else if (a(2)) {
                return null;
            } else {
                return new r(new o(bVar.f27705b));
            }
        } else if (a(2)) {
            return null;
        } else {
            return new r(new f(false, bVar.f27705b));
        }
    }
}
