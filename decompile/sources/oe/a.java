package oe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.model.Unit;
import org.jcodec.common.model.c;
import org.jcodec.common.model.e;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.aj;
import org.jcodec.containers.mp4.boxes.ak;
import org.jcodec.containers.mp4.boxes.al;
import org.jcodec.containers.mp4.boxes.an;
import org.jcodec.containers.mp4.boxes.ao;
import org.jcodec.containers.mp4.boxes.aq;
import org.jcodec.containers.mp4.boxes.as;
import org.jcodec.containers.mp4.boxes.bf;
import org.jcodec.containers.mp4.boxes.bj;
import org.jcodec.containers.mp4.boxes.i;
import org.jcodec.containers.mp4.boxes.m;
import org.jcodec.containers.mp4.boxes.n;
import org.jcodec.containers.mp4.boxes.o;
import org.jcodec.containers.mp4.boxes.p;
import org.jcodec.containers.mp4.boxes.q;
import org.jcodec.containers.mp4.boxes.y;
import org.jcodec.containers.mp4.boxes.z;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f31685a;

    /* renamed from: b  reason: collision with root package name */
    protected TrackType f31686b;

    /* renamed from: c  reason: collision with root package name */
    protected int f31687c;

    /* renamed from: d  reason: collision with root package name */
    protected c f31688d;

    /* renamed from: e  reason: collision with root package name */
    protected Unit f31689e;

    /* renamed from: f  reason: collision with root package name */
    protected long f31690f;

    /* renamed from: g  reason: collision with root package name */
    protected List<ByteBuffer> f31691g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    protected List<as.a> f31692h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    protected int f31693i = -1;

    /* renamed from: j  reason: collision with root package name */
    protected int f31694j = 0;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f31695k;

    /* renamed from: l  reason: collision with root package name */
    protected List<aq> f31696l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    protected List<o> f31697m;

    /* renamed from: n  reason: collision with root package name */
    private String f31698n;

    /* renamed from: oe.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31699a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.jcodec.containers.mp4.TrackType[] r0 = org.jcodec.containers.mp4.TrackType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31699a = r0
                org.jcodec.containers.mp4.TrackType r1 = org.jcodec.containers.mp4.TrackType.VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31699a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jcodec.containers.mp4.TrackType r1 = org.jcodec.containers.mp4.TrackType.SOUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31699a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jcodec.containers.mp4.TrackType r1 = org.jcodec.containers.mp4.TrackType.TIMECODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: oe.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(int i2, TrackType trackType, int i3) {
        this.f31685a = i2;
        this.f31686b = trackType;
        this.f31687c = i3;
    }

    public abstract long a();

    /* access modifiers changed from: protected */
    public abstract org.jcodec.containers.mp4.boxes.c a(aj ajVar) throws IOException;

    public void a(c cVar, Unit unit) {
        this.f31688d = cVar;
        this.f31689e = unit;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: org.jcodec.containers.mp4.boxes.bi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: org.jcodec.containers.mp4.boxes.av} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: org.jcodec.containers.mp4.boxes.al} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: org.jcodec.containers.mp4.boxes.bi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: org.jcodec.containers.mp4.boxes.bi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: org.jcodec.containers.mp4.boxes.bi} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.jcodec.containers.mp4.boxes.ad r12, org.jcodec.containers.mp4.TrackType r13) {
        /*
            r11 = this;
            int[] r0 = oe.a.AnonymousClass1.f31699a
            int r1 = r13.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x0077
            r2 = 2
            if (r0 == r2) goto L_0x006e
            r1 = 3
            if (r0 != r1) goto L_0x004e
            org.jcodec.containers.mp4.boxes.al r13 = new org.jcodec.containers.mp4.boxes.al
            org.jcodec.containers.mp4.boxes.y r0 = new org.jcodec.containers.mp4.boxes.y
            java.lang.String r2 = "gmhd"
            r0.<init>(r2)
            r13.<init>(r0)
            org.jcodec.containers.mp4.boxes.w r0 = new org.jcodec.containers.mp4.boxes.w
            r0.<init>()
            r13.a((org.jcodec.containers.mp4.boxes.c) r0)
            org.jcodec.containers.mp4.boxes.al r0 = new org.jcodec.containers.mp4.boxes.al
            org.jcodec.containers.mp4.boxes.y r2 = new org.jcodec.containers.mp4.boxes.y
            java.lang.String r3 = "tmcd"
            r2.<init>(r3)
            r0.<init>(r2)
            r13.a((org.jcodec.containers.mp4.boxes.c) r0)
            org.jcodec.containers.mp4.boxes.ay r2 = new org.jcodec.containers.mp4.boxes.ay
            r5 = 0
            r6 = 0
            r7 = 12
            short[] r8 = new short[r1]
            r8 = {0, 0, 0} // fill-array
            short[] r9 = new short[r1]
            r9 = {255, 255, 255} // fill-array
            java.lang.String r10 = "Lucida Grande"
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.a((org.jcodec.containers.mp4.boxes.c) r2)
            goto L_0x0080
        L_0x004e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Handler "
            r0.append(r1)
            java.lang.String r13 = r13.a()
            r0.append(r13)
            java.lang.String r13 = " not supported"
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x006e:
            org.jcodec.containers.mp4.boxes.av r13 = new org.jcodec.containers.mp4.boxes.av
            r13.<init>()
            r13.a((int) r1)
            goto L_0x0080
        L_0x0077:
            org.jcodec.containers.mp4.boxes.bi r13 = new org.jcodec.containers.mp4.boxes.bi
            r0 = 0
            r13.<init>(r0, r0, r0, r0)
            r13.a((int) r1)
        L_0x0080:
            r12.a((org.jcodec.containers.mp4.boxes.c) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: oe.a.a(org.jcodec.containers.mp4.boxes.ad, org.jcodec.containers.mp4.TrackType):void");
    }

    /* access modifiers changed from: protected */
    public void a(al alVar) {
        m mVar = new m();
        alVar.a((org.jcodec.containers.mp4.boxes.c) mVar);
        n nVar = new n();
        mVar.a((org.jcodec.containers.mp4.boxes.c) nVar);
        nVar.a((org.jcodec.containers.mp4.boxes.c) new z(new y("alis", 0), ByteBuffer.wrap(new byte[]{0, 0, 0, 1})));
    }

    public void a(aq aqVar) {
        if (!this.f31695k) {
            this.f31696l.add(aqVar);
            return;
        }
        throw new IllegalStateException("The muxer track has finished muxing");
    }

    public void a(bf bfVar) {
        e d2 = d();
        if (this.f31686b == TrackType.VIDEO) {
            al alVar = new al(new y("tapt"));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new i(d2.a(), d2.b()));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new ao(d2.a(), d2.b()));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new q(d2.a(), d2.b()));
            bfVar.a((org.jcodec.containers.mp4.boxes.c) alVar);
        }
    }

    public int b() {
        return this.f31687c;
    }

    /* access modifiers changed from: protected */
    public void b(bf bfVar) {
        if (this.f31697m != null) {
            al alVar = new al(new y("edts"));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new p(this.f31697m));
            bfVar.a((org.jcodec.containers.mp4.boxes.c) alVar);
        }
    }

    /* access modifiers changed from: protected */
    public void c(bf bfVar) {
        if (this.f31698n != null) {
            al alVar = new al(new y("udta"));
            alVar.a((org.jcodec.containers.mp4.boxes.c) new ak(this.f31698n));
            bfVar.a((org.jcodec.containers.mp4.boxes.c) alVar);
        }
    }

    public boolean c() {
        return this.f31686b == TrackType.VIDEO;
    }

    public e d() {
        int i2;
        int i3 = 0;
        if (this.f31696l.get(0) instanceof bj) {
            bj bjVar = (bj) this.f31696l.get(0);
            an anVar = (an) org.jcodec.containers.mp4.boxes.c.a((al) bjVar, an.class, an.b());
            c a2 = anVar != null ? anVar.a() : new c(1, 1);
            i3 = (a2.a() * bjVar.a()) / a2.b();
            i2 = bjVar.c();
        } else {
            i2 = 0;
        }
        return new e(i3, i2);
    }
}
