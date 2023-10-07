package oe;

import com.blankj.utilcode.constant.MemoryConstants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jcodec.common.d;
import org.jcodec.common.h;
import org.jcodec.common.j;
import org.jcodec.common.model.Unit;
import org.jcodec.common.model.c;
import org.jcodec.common.model.e;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.a;
import org.jcodec.containers.mp4.boxes.ab;
import org.jcodec.containers.mp4.boxes.ac;
import org.jcodec.containers.mp4.boxes.ad;
import org.jcodec.containers.mp4.boxes.aj;
import org.jcodec.containers.mp4.boxes.al;
import org.jcodec.containers.mp4.boxes.ap;
import org.jcodec.containers.mp4.boxes.aq;
import org.jcodec.containers.mp4.boxes.ar;
import org.jcodec.containers.mp4.boxes.as;
import org.jcodec.containers.mp4.boxes.aw;
import org.jcodec.containers.mp4.boxes.ax;
import org.jcodec.containers.mp4.boxes.be;
import org.jcodec.containers.mp4.boxes.bf;
import org.jcodec.containers.mp4.boxes.f;
import org.jcodec.containers.mp4.boxes.l;
import org.jcodec.containers.mp4.boxes.o;
import org.jcodec.containers.mp4.boxes.x;
import org.jcodec.containers.mp4.boxes.y;

public class b extends a {
    private boolean A = true;
    private d B;
    private j C;

    /* renamed from: n  reason: collision with root package name */
    private List<ax.a> f31700n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private long f31701o = 0;

    /* renamed from: p  reason: collision with root package name */
    private long f31702p = -1;

    /* renamed from: q  reason: collision with root package name */
    private h f31703q = new h();

    /* renamed from: r  reason: collision with root package name */
    private d f31704r = new d();

    /* renamed from: s  reason: collision with root package name */
    private d f31705s = new d();

    /* renamed from: t  reason: collision with root package name */
    private List<l.a> f31706t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private int f31707u = 0;

    /* renamed from: v  reason: collision with root package name */
    private int f31708v = 0;

    /* renamed from: w  reason: collision with root package name */
    private long f31709w = 0;

    /* renamed from: x  reason: collision with root package name */
    private int f31710x = -1;

    /* renamed from: y  reason: collision with root package name */
    private long f31711y;

    /* renamed from: z  reason: collision with root package name */
    private int f31712z;

    public b(j jVar, int i2, TrackType trackType, int i3) {
        super(i2, trackType, i3);
        this.C = jVar;
        a(new c(1, 1), Unit.FRAME);
    }

    public static int a(List<l.a> list) {
        int i2 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        for (l.a next : list) {
            if (next.a() < i2) {
                i2 = next.a();
            }
        }
        return i2;
    }

    private void b(int i2) throws IOException {
        org.jcodec.common.b.a(this.f31689e == Unit.FRAME || this.f31689e == Unit.SEC);
        if ((this.f31689e == Unit.FRAME && this.f31691g.size() * this.f31688d.b() == this.f31688d.a()) || (this.f31689e == Unit.SEC && this.f31690f > 0 && this.f31690f * ((long) this.f31688d.b()) >= ((long) (this.f31688d.a() * this.f31687c)))) {
            a(i2);
        }
    }

    private void b(a aVar) throws IOException {
        d dVar = this.B;
        if (dVar != null) {
            dVar.a((org.jcodec.common.model.a) aVar);
        }
    }

    private void b(al alVar) {
        if (this.f31706t.size() > 0) {
            this.f31706t.add(new l.a(this.f31708v, this.f31707u));
            int a2 = a(this.f31706t);
            if (a2 > 0) {
                for (l.a aVar : this.f31706t) {
                    aVar.f33525b -= a2;
                }
            }
            l.a aVar2 = this.f31706t.get(0);
            if (aVar2.a() > 0) {
                if (this.f31697m == null) {
                    this.f31697m = new ArrayList();
                    this.f31697m.add(new o(this.f31711y, (long) aVar2.a(), 1.0f));
                } else {
                    for (o oVar : this.f31697m) {
                        oVar.a(oVar.b() + ((long) aVar2.a()));
                    }
                }
            }
            alVar.a((org.jcodec.containers.mp4.boxes.c) new l((l.a[]) this.f31706t.toArray(new l.a[0])));
        }
    }

    public long a() {
        return this.f31711y;
    }

    /* access modifiers changed from: protected */
    public org.jcodec.containers.mp4.boxes.c a(aj ajVar) throws IOException {
        if (!this.f31695k) {
            a(this.f31710x);
            long j2 = this.f31701o;
            if (j2 > 0) {
                this.f31700n.add(new ax.a((int) j2, (int) this.f31702p));
            }
            this.f31695k = true;
            bf bfVar = new bf();
            e d2 = d();
            be beVar = r3;
            be beVar2 = new be(this.f31685a, (((long) ajVar.b()) * this.f31711y) / ((long) this.f31687c), (float) d2.a(), (float) d2.b(), new Date().getTime(), new Date().getTime(), 1.0f, 0, 0, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, MemoryConstants.GB});
            be beVar3 = beVar;
            beVar3.a(15);
            bfVar.a((org.jcodec.containers.mp4.boxes.c) beVar3);
            a(bfVar);
            ab abVar = new ab();
            bfVar.a((org.jcodec.containers.mp4.boxes.c) abVar);
            abVar.a((org.jcodec.containers.mp4.boxes.c) new ac(this.f31687c, this.f31711y, 0, new Date().getTime(), new Date().getTime(), 0));
            abVar.a((org.jcodec.containers.mp4.boxes.c) new x("mhlr", this.f31686b.a(), "appl", 0, 0));
            ad adVar = new ad();
            abVar.a((org.jcodec.containers.mp4.boxes.c) adVar);
            a(adVar, this.f31686b);
            adVar.a((org.jcodec.containers.mp4.boxes.c) new x("dhlr", "url ", "appl", 0, 0));
            a((al) adVar);
            al alVar = new al(new y("stbl"));
            adVar.a((org.jcodec.containers.mp4.boxes.c) alVar);
            b(alVar);
            b(bfVar);
            c(bfVar);
            alVar.a((org.jcodec.containers.mp4.boxes.c) new ap((aq[]) this.f31696l.toArray(new aq[0])));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new as((as.a[]) this.f31692h.toArray(new as.a[0])));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new ar(this.f31704r.a()));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new ax((ax.a[]) this.f31700n.toArray(new ax.a[0])));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new f(this.f31703q.a()));
            if (!this.A && this.f31705s.c() > 0) {
                alVar.a((org.jcodec.containers.mp4.boxes.c) new aw(this.f31705s.a()));
            }
            return bfVar;
        }
        throw new IllegalStateException("The muxer track has finished muxing");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) throws IOException {
        if (this.f31691g.size() != 0) {
            this.f31703q.a(this.C.a());
            for (ByteBuffer byteBuffer : this.f31691g) {
                this.f31704r.a(byteBuffer.remaining());
                this.C.write(byteBuffer);
            }
            if (this.f31693i == -1 || this.f31693i != this.f31691g.size()) {
                this.f31692h.add(new as.a((long) (this.f31694j + 1), this.f31691g.size(), i2));
            }
            this.f31693i = this.f31691g.size();
            this.f31694j++;
            this.f31690f = 0;
            this.f31691g.clear();
        }
    }

    public void a(a aVar) throws IOException {
        if (!this.f31695k) {
            int g2 = aVar.g() + 1;
            int b2 = (int) (aVar.b() - this.f31709w);
            int i2 = this.f31707u;
            if (b2 != i2) {
                int i3 = this.f31708v;
                if (i3 > 0) {
                    this.f31706t.add(new l.a(i3, i2));
                }
                this.f31707u = b2;
                this.f31708v = 0;
            }
            this.f31708v++;
            this.f31709w += aVar.c();
            int i4 = this.f31710x;
            if (!(i4 == -1 || i4 == g2)) {
                a(i4);
                this.f31693i = -1;
            }
            this.f31691g.add(aVar.a());
            if (aVar.f()) {
                this.f31705s.a(this.f31712z + 1);
            } else {
                this.A = false;
            }
            this.f31712z++;
            this.f31690f += aVar.c();
            if (this.f31702p != -1) {
                long c2 = aVar.c();
                long j2 = this.f31702p;
                if (c2 != j2) {
                    this.f31700n.add(new ax.a((int) this.f31701o, (int) j2));
                    this.f31701o = 0;
                }
            }
            this.f31702p = aVar.c();
            this.f31701o++;
            this.f31711y += aVar.c();
            b(g2);
            b(aVar);
            this.f31710x = g2;
            return;
        }
        throw new IllegalStateException("The muxer track has finished muxing");
    }
}
