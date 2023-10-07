package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.a;
import com.google.android.exoplayer2.audio.c;
import com.google.android.exoplayer2.audio.e;
import com.google.android.exoplayer2.audio.f;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.video.g;
import com.google.android.exoplayer2.x;
import com.google.android.exoplayer2.y;
import fi.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class ae extends c implements k, x.b, x.c {
    private int A;
    /* access modifiers changed from: private */
    public d B;
    /* access modifiers changed from: private */
    public d C;
    /* access modifiers changed from: private */
    public int D;
    private c E;
    private float F;
    private i G;
    /* access modifiers changed from: private */
    public List<com.google.android.exoplayer2.text.b> H;
    private g I;
    private ge.a J;
    private boolean K;
    /* access modifiers changed from: private */
    public t L;
    /* access modifiers changed from: private */
    public boolean M;
    private boolean N;

    /* renamed from: b  reason: collision with root package name */
    protected final z[] f15129b;

    /* renamed from: c  reason: collision with root package name */
    private final l f15130c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f15131d;

    /* renamed from: e  reason: collision with root package name */
    private final b f15132e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArraySet<com.google.android.exoplayer2.video.i> f15133f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final CopyOnWriteArraySet<e> f15134g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final CopyOnWriteArraySet<j> f15135h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.d> f15136i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final CopyOnWriteArraySet<com.google.android.exoplayer2.video.j> f15137j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final CopyOnWriteArraySet<f> f15138k;

    /* renamed from: l  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.c f15139l;

    /* renamed from: m  reason: collision with root package name */
    private final fh.a f15140m;

    /* renamed from: n  reason: collision with root package name */
    private final a f15141n;

    /* renamed from: o  reason: collision with root package name */
    private final b f15142o;

    /* renamed from: p  reason: collision with root package name */
    private final ag f15143p;

    /* renamed from: q  reason: collision with root package name */
    private final ah f15144q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public Format f15145r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public Format f15146s;

    /* renamed from: t  reason: collision with root package name */
    private com.google.android.exoplayer2.video.e f15147t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public Surface f15148u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f15149v;

    /* renamed from: w  reason: collision with root package name */
    private int f15150w;

    /* renamed from: x  reason: collision with root package name */
    private SurfaceHolder f15151x;

    /* renamed from: y  reason: collision with root package name */
    private TextureView f15152y;

    /* renamed from: z  reason: collision with root package name */
    private int f15153z;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15154a;

        /* renamed from: b  reason: collision with root package name */
        private final ac f15155b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.android.exoplayer2.util.b f15156c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.android.exoplayer2.trackselection.g f15157d;

        /* renamed from: e  reason: collision with root package name */
        private p f15158e;

        /* renamed from: f  reason: collision with root package name */
        private com.google.android.exoplayer2.upstream.c f15159f;

        /* renamed from: g  reason: collision with root package name */
        private fh.a f15160g;

        /* renamed from: h  reason: collision with root package name */
        private Looper f15161h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f15162i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f15163j;

        public a(Context context) {
            this(context, new j(context));
        }

        public a(Context context, ac acVar) {
            this(context, acVar, new DefaultTrackSelector(context), new h(), com.google.android.exoplayer2.upstream.j.a(context), ad.a(), new fh.a(com.google.android.exoplayer2.util.b.f17099a), true, com.google.android.exoplayer2.util.b.f17099a);
        }

        public a(Context context, ac acVar, com.google.android.exoplayer2.trackselection.g gVar, p pVar, com.google.android.exoplayer2.upstream.c cVar, Looper looper, fh.a aVar, boolean z2, com.google.android.exoplayer2.util.b bVar) {
            this.f15154a = context;
            this.f15155b = acVar;
            this.f15157d = gVar;
            this.f15158e = pVar;
            this.f15159f = cVar;
            this.f15161h = looper;
            this.f15160g = aVar;
            this.f15162i = z2;
            this.f15156c = bVar;
        }

        public ae a() {
            com.google.android.exoplayer2.util.a.b(!this.f15163j);
            this.f15163j = true;
            return new ae(this.f15154a, this.f15155b, this.f15157d, this.f15158e, this.f15159f, this.f15160g, this.f15156c, this.f15161h);
        }
    }

    private final class b implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, a.b, f, b.C0109b, com.google.android.exoplayer2.metadata.d, j, com.google.android.exoplayer2.video.j, x.a {
        private b() {
        }

        public void a() {
            ae.this.a(false);
        }

        public void a(float f2) {
            ae.this.I();
        }

        public void a(int i2) {
            ae aeVar = ae.this;
            aeVar.a(aeVar.n(), i2);
        }

        public void a(int i2, int i3, int i4, float f2) {
            Iterator it2 = ae.this.f15133f.iterator();
            while (it2.hasNext()) {
                com.google.android.exoplayer2.video.i iVar = (com.google.android.exoplayer2.video.i) it2.next();
                if (!ae.this.f15137j.contains(iVar)) {
                    iVar.a(i2, i3, i4, f2);
                }
            }
            Iterator it3 = ae.this.f15137j.iterator();
            while (it3.hasNext()) {
                ((com.google.android.exoplayer2.video.j) it3.next()).a(i2, i3, i4, f2);
            }
        }

        public void a(int i2, long j2) {
            Iterator it2 = ae.this.f15137j.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.j) it2.next()).a(i2, j2);
            }
        }

        public void a(int i2, long j2, long j3) {
            Iterator it2 = ae.this.f15138k.iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).a(i2, j2, j3);
            }
        }

        public void a(Surface surface) {
            if (ae.this.f15148u == surface) {
                Iterator it2 = ae.this.f15133f.iterator();
                while (it2.hasNext()) {
                    ((com.google.android.exoplayer2.video.i) it2.next()).d();
                }
            }
            Iterator it3 = ae.this.f15137j.iterator();
            while (it3.hasNext()) {
                ((com.google.android.exoplayer2.video.j) it3.next()).a(surface);
            }
        }

        public /* synthetic */ void a(ExoPlaybackException exoPlaybackException) {
            x.a.CC.$default$a((x.a) this, exoPlaybackException);
        }

        public void a(Format format) {
            Format unused = ae.this.f15145r = format;
            Iterator it2 = ae.this.f15137j.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.j) it2.next()).a(format);
            }
        }

        public /* synthetic */ void a(af afVar, int i2) {
            x.a.CC.$default$a((x.a) this, afVar, i2);
        }

        public /* synthetic */ void a(af afVar, Object obj, int i2) {
            x.a.CC.$default$a(this, afVar, obj, i2);
        }

        public void a(Metadata metadata) {
            Iterator it2 = ae.this.f15136i.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.metadata.d) it2.next()).a(metadata);
            }
        }

        public /* synthetic */ void a(TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.f fVar) {
            x.a.CC.$default$a((x.a) this, trackGroupArray, fVar);
        }

        public /* synthetic */ void a(v vVar) {
            x.a.CC.$default$a((x.a) this, vVar);
        }

        public void a(d dVar) {
            d unused = ae.this.B = dVar;
            Iterator it2 = ae.this.f15137j.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.j) it2.next()).a(dVar);
            }
        }

        public void a(String str, long j2, long j3) {
            Iterator it2 = ae.this.f15137j.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.j) it2.next()).a(str, j2, j3);
            }
        }

        public void a(List<com.google.android.exoplayer2.text.b> list) {
            List unused = ae.this.H = list;
            Iterator it2 = ae.this.f15135h.iterator();
            while (it2.hasNext()) {
                ((j) it2.next()).a(list);
            }
        }

        public void a(boolean z2) {
            ae aeVar;
            if (ae.this.L != null) {
                boolean z3 = false;
                if (z2 && !ae.this.M) {
                    ae.this.L.a(0);
                    aeVar = ae.this;
                    z3 = true;
                } else if (!z2 && ae.this.M) {
                    ae.this.L.b(0);
                    aeVar = ae.this;
                } else {
                    return;
                }
                boolean unused = aeVar.M = z3;
            }
        }

        public void a(boolean z2, int i2) {
            ae.this.K();
        }

        public /* synthetic */ void b() {
            x.a.CC.$default$b(this);
        }

        public /* synthetic */ void b(int i2) {
            x.a.CC.$default$b((x.a) this, i2);
        }

        public void b(Format format) {
            Format unused = ae.this.f15146s = format;
            Iterator it2 = ae.this.f15138k.iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).b(format);
            }
        }

        public void b(d dVar) {
            Iterator it2 = ae.this.f15137j.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.j) it2.next()).b(dVar);
            }
            Format unused = ae.this.f15145r = null;
            d unused2 = ae.this.B = null;
        }

        public void b(String str, long j2, long j3) {
            Iterator it2 = ae.this.f15138k.iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).b(str, j2, j3);
            }
        }

        public /* synthetic */ void b(boolean z2) {
            x.a.CC.$default$b((x.a) this, z2);
        }

        public /* synthetic */ void c(int i2) {
            x.a.CC.$default$c((x.a) this, i2);
        }

        public void c(d dVar) {
            d unused = ae.this.C = dVar;
            Iterator it2 = ae.this.f15138k.iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).c(dVar);
            }
        }

        public /* synthetic */ void c(boolean z2) {
            x.a.CC.$default$c((x.a) this, z2);
        }

        public /* synthetic */ void d(int i2) {
            x.a.CC.$default$d(this, i2);
        }

        public void d(d dVar) {
            Iterator it2 = ae.this.f15138k.iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).d(dVar);
            }
            Format unused = ae.this.f15146s = null;
            d unused2 = ae.this.C = null;
            int unused3 = ae.this.D = 0;
        }

        public void e(int i2) {
            if (ae.this.D != i2) {
                int unused = ae.this.D = i2;
                Iterator it2 = ae.this.f15134g.iterator();
                while (it2.hasNext()) {
                    e eVar = (e) it2.next();
                    if (!ae.this.f15138k.contains(eVar)) {
                        eVar.e(i2);
                    }
                }
                Iterator it3 = ae.this.f15138k.iterator();
                while (it3.hasNext()) {
                    ((f) it3.next()).e(i2);
                }
            }
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            ae.this.a(new Surface(surfaceTexture), true);
            ae.this.a(i2, i3);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ae.this.a((Surface) null, true);
            ae.this.a(0, 0);
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            ae.this.a(i2, i3);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            ae.this.a(i3, i4);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ae.this.a(surfaceHolder.getSurface(), false);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ae.this.a((Surface) null, false);
            ae.this.a(0, 0);
        }
    }

    @Deprecated
    protected ae(Context context, ac acVar, com.google.android.exoplayer2.trackselection.g gVar, p pVar, com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.f> bVar, com.google.android.exoplayer2.upstream.c cVar, fh.a aVar, com.google.android.exoplayer2.util.b bVar2, Looper looper) {
        Context context2 = context;
        com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.f> bVar3 = bVar;
        com.google.android.exoplayer2.upstream.c cVar2 = cVar;
        fh.a aVar2 = aVar;
        this.f15139l = cVar2;
        this.f15140m = aVar2;
        b bVar4 = new b();
        this.f15132e = bVar4;
        CopyOnWriteArraySet<com.google.android.exoplayer2.video.i> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        this.f15133f = copyOnWriteArraySet;
        CopyOnWriteArraySet<e> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
        this.f15134g = copyOnWriteArraySet2;
        this.f15135h = new CopyOnWriteArraySet<>();
        this.f15136i = new CopyOnWriteArraySet<>();
        CopyOnWriteArraySet<com.google.android.exoplayer2.video.j> copyOnWriteArraySet3 = new CopyOnWriteArraySet<>();
        this.f15137j = copyOnWriteArraySet3;
        CopyOnWriteArraySet<f> copyOnWriteArraySet4 = new CopyOnWriteArraySet<>();
        this.f15138k = copyOnWriteArraySet4;
        Handler handler = new Handler(looper);
        this.f15131d = handler;
        z[] a2 = acVar.a(handler, bVar4, bVar4, bVar4, bVar4, bVar);
        this.f15129b = a2;
        this.F = 1.0f;
        this.D = 0;
        this.E = c.f15267a;
        this.f15150w = 1;
        this.H = Collections.emptyList();
        Handler handler2 = handler;
        l lVar = r2;
        l lVar2 = new l(a2, gVar, pVar, cVar, bVar2, looper);
        this.f15130c = lVar;
        aVar2.a((x) lVar);
        lVar.a((x.a) aVar2);
        lVar.a((x.a) bVar4);
        copyOnWriteArraySet3.add(aVar2);
        copyOnWriteArraySet.add(aVar2);
        copyOnWriteArraySet4.add(aVar2);
        copyOnWriteArraySet2.add(aVar2);
        a((com.google.android.exoplayer2.metadata.d) aVar2);
        Handler handler3 = handler2;
        cVar2.a(handler3, aVar2);
        com.google.android.exoplayer2.drm.b<com.google.android.exoplayer2.drm.f> bVar5 = bVar;
        if (bVar5 instanceof DefaultDrmSessionManager) {
            ((DefaultDrmSessionManager) bVar5).a(handler3, (com.google.android.exoplayer2.drm.a) aVar2);
        }
        Handler handler4 = handler3;
        Context context3 = context;
        this.f15141n = new a(context3, handler4, bVar4);
        this.f15142o = new b(context3, handler4, bVar4);
        this.f15143p = new ag(context3);
        this.f15144q = new ah(context3);
    }

    protected ae(Context context, ac acVar, com.google.android.exoplayer2.trackselection.g gVar, p pVar, com.google.android.exoplayer2.upstream.c cVar, fh.a aVar, com.google.android.exoplayer2.util.b bVar, Looper looper) {
        this(context, acVar, gVar, pVar, b.CC.c(), cVar, aVar, bVar, looper);
    }

    private void H() {
        TextureView textureView = this.f15152y;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f15132e) {
                k.c("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f15152y.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.f15152y = null;
        }
        SurfaceHolder surfaceHolder = this.f15151x;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f15132e);
            this.f15151x = null;
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        float a2 = this.F * this.f15142o.a();
        for (z zVar : this.f15129b) {
            if (zVar.a() == 1) {
                this.f15130c.a((y.b) zVar).a(2).a((Object) Float.valueOf(a2)).i();
            }
        }
    }

    private void J() {
        if (Looper.myLooper() != j()) {
            k.a("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.K ? null : new IllegalStateException());
            this.K = true;
        }
    }

    /* access modifiers changed from: private */
    public void K() {
        boolean z2;
        ah ahVar;
        int k2 = k();
        if (k2 != 1) {
            if (k2 == 2 || k2 == 3) {
                this.f15143p.a(n());
                ahVar = this.f15144q;
                z2 = n();
                ahVar.a(z2);
            } else if (k2 != 4) {
                throw new IllegalStateException();
            }
        }
        z2 = false;
        this.f15143p.a(false);
        ahVar = this.f15144q;
        ahVar.a(z2);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        if (i2 != this.f15153z || i3 != this.A) {
            this.f15153z = i2;
            this.A = i3;
            Iterator<com.google.android.exoplayer2.video.i> it2 = this.f15133f.iterator();
            while (it2.hasNext()) {
                it2.next().a(i2, i3);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Surface surface, boolean z2) {
        ArrayList<y> arrayList = new ArrayList<>();
        for (z zVar : this.f15129b) {
            if (zVar.a() == 2) {
                arrayList.add(this.f15130c.a((y.b) zVar).a(1).a((Object) surface).i());
            }
        }
        Surface surface2 = this.f15148u;
        if (!(surface2 == null || surface2 == surface)) {
            try {
                for (y k2 : arrayList) {
                    k2.k();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.f15149v) {
                this.f15148u.release();
            }
        }
        this.f15148u = surface;
        this.f15149v = z2;
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, int i2) {
        int i3 = 0;
        boolean z3 = z2 && i2 != -1;
        if (z3 && i2 != 1) {
            i3 = 1;
        }
        this.f15130c.a(z3, i3);
    }

    private void b(com.google.android.exoplayer2.video.e eVar) {
        for (z zVar : this.f15129b) {
            if (zVar.a() == 2) {
                this.f15130c.a((y.b) zVar).a(8).a((Object) eVar).i();
            }
        }
        this.f15147t = eVar;
    }

    public long A() {
        J();
        return this.f15130c.A();
    }

    public long B() {
        J();
        return this.f15130c.B();
    }

    public TrackGroupArray C() {
        J();
        return this.f15130c.C();
    }

    public com.google.android.exoplayer2.trackselection.f D() {
        J();
        return this.f15130c.D();
    }

    public af E() {
        J();
        return this.f15130c.E();
    }

    public void F() {
        J();
        b((com.google.android.exoplayer2.video.e) null);
    }

    public void G() {
        J();
        this.f15141n.a(false);
        this.f15143p.a(false);
        this.f15144q.a(false);
        this.f15142o.b();
        this.f15130c.r();
        H();
        Surface surface = this.f15148u;
        if (surface != null) {
            if (this.f15149v) {
                surface.release();
            }
            this.f15148u = null;
        }
        i iVar = this.G;
        if (iVar != null) {
            iVar.a((com.google.android.exoplayer2.source.j) this.f15140m);
            this.G = null;
        }
        if (this.M) {
            ((t) com.google.android.exoplayer2.util.a.b(this.L)).b(0);
            this.M = false;
        }
        this.f15139l.a(this.f15140m);
        this.H = Collections.emptyList();
        this.N = true;
    }

    public void a(int i2) {
        J();
        this.f15130c.a(i2);
    }

    public void a(int i2, long j2) {
        J();
        this.f15140m.a();
        this.f15130c.a(i2, j2);
    }

    public void a(Surface surface) {
        J();
        if (surface != null && surface == this.f15148u) {
            r();
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        J();
        H();
        if (surfaceHolder != null) {
            F();
        }
        this.f15151x = surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.f15132e);
            Surface surface = surfaceHolder.getSurface();
            if (surface != null && surface.isValid()) {
                a(surface, false);
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                a(surfaceFrame.width(), surfaceFrame.height());
                return;
            }
        }
        a((Surface) null, false);
        a(0, 0);
    }

    public void a(SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    public void a(TextureView textureView) {
        J();
        H();
        if (textureView != null) {
            F();
        }
        this.f15152y = textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != null) {
                k.c("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.f15132e);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (surfaceTexture != null) {
                a(new Surface(surfaceTexture), true);
                a(textureView.getWidth(), textureView.getHeight());
                return;
            }
        }
        a((Surface) null, true);
        a(0, 0);
    }

    public void a(com.google.android.exoplayer2.metadata.d dVar) {
        this.f15136i.add(dVar);
    }

    public void a(i iVar) {
        a(iVar, true, true);
    }

    public void a(i iVar, boolean z2, boolean z3) {
        J();
        i iVar2 = this.G;
        if (iVar2 != null) {
            iVar2.a((com.google.android.exoplayer2.source.j) this.f15140m);
            this.f15140m.c();
        }
        this.G = iVar;
        iVar.a(this.f15131d, (com.google.android.exoplayer2.source.j) this.f15140m);
        boolean n2 = n();
        a(n2, this.f15142o.a(n2, 2));
        this.f15130c.a(iVar, z2, z3);
    }

    public void a(j jVar) {
        if (!this.H.isEmpty()) {
            jVar.a(this.H);
        }
        this.f15135h.add(jVar);
    }

    public void a(com.google.android.exoplayer2.video.e eVar) {
        J();
        if (eVar != null) {
            r();
        }
        b(eVar);
    }

    public void a(g gVar) {
        J();
        this.I = gVar;
        for (z zVar : this.f15129b) {
            if (zVar.a() == 2) {
                this.f15130c.a((y.b) zVar).a(6).a((Object) gVar).i();
            }
        }
    }

    public void a(com.google.android.exoplayer2.video.i iVar) {
        this.f15133f.add(iVar);
    }

    public void a(x.a aVar) {
        J();
        this.f15130c.a(aVar);
    }

    public void a(ge.a aVar) {
        J();
        this.J = aVar;
        for (z zVar : this.f15129b) {
            if (zVar.a() == 5) {
                this.f15130c.a((y.b) zVar).a(7).a((Object) aVar).i();
            }
        }
    }

    public void a(boolean z2) {
        J();
        a(z2, this.f15142o.a(z2, k()));
    }

    public int b(int i2) {
        J();
        return this.f15130c.b(i2);
    }

    public void b(Surface surface) {
        J();
        H();
        if (surface != null) {
            F();
        }
        int i2 = 0;
        a(surface, false);
        if (surface != null) {
            i2 = -1;
        }
        a(i2, i2);
    }

    public void b(SurfaceHolder surfaceHolder) {
        J();
        if (surfaceHolder != null && surfaceHolder == this.f15151x) {
            a((SurfaceHolder) null);
        }
    }

    public void b(SurfaceView surfaceView) {
        b(surfaceView == null ? null : surfaceView.getHolder());
    }

    public void b(TextureView textureView) {
        J();
        if (textureView != null && textureView == this.f15152y) {
            a((TextureView) null);
        }
    }

    public void b(j jVar) {
        this.f15135h.remove(jVar);
    }

    public void b(g gVar) {
        J();
        if (this.I == gVar) {
            for (z zVar : this.f15129b) {
                if (zVar.a() == 2) {
                    this.f15130c.a((y.b) zVar).a(6).a((Object) null).i();
                }
            }
        }
    }

    public void b(com.google.android.exoplayer2.video.i iVar) {
        this.f15133f.remove(iVar);
    }

    public void b(x.a aVar) {
        J();
        this.f15130c.b(aVar);
    }

    public void b(ge.a aVar) {
        J();
        if (this.J == aVar) {
            for (z zVar : this.f15129b) {
                if (zVar.a() == 5) {
                    this.f15130c.a((y.b) zVar).a(7).a((Object) null).i();
                }
            }
        }
    }

    public void b(boolean z2) {
        J();
        this.f15130c.b(z2);
    }

    public x.c h() {
        return this;
    }

    public x.b i() {
        return this;
    }

    public Looper j() {
        return this.f15130c.j();
    }

    public int k() {
        J();
        return this.f15130c.k();
    }

    public int l() {
        J();
        return this.f15130c.l();
    }

    public ExoPlaybackException m() {
        J();
        return this.f15130c.m();
    }

    public boolean n() {
        J();
        return this.f15130c.n();
    }

    public int o() {
        J();
        return this.f15130c.o();
    }

    public boolean p() {
        J();
        return this.f15130c.p();
    }

    public v q() {
        J();
        return this.f15130c.q();
    }

    public void r() {
        J();
        H();
        a((Surface) null, false);
        a(0, 0);
    }

    public int s() {
        J();
        return this.f15130c.s();
    }

    public int t() {
        J();
        return this.f15130c.t();
    }

    public long u() {
        J();
        return this.f15130c.u();
    }

    public long v() {
        J();
        return this.f15130c.v();
    }

    public long w() {
        J();
        return this.f15130c.w();
    }

    public boolean x() {
        J();
        return this.f15130c.x();
    }

    public int y() {
        J();
        return this.f15130c.y();
    }

    public int z() {
        J();
        return this.f15130c.z();
    }
}
