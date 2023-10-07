package bu;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import bl.e;
import bz.j;
import cc.k;
import com.bumptech.glide.h;
import com.bumptech.glide.load.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class g {

    /* renamed from: a  reason: collision with root package name */
    final h f6012a;

    /* renamed from: b  reason: collision with root package name */
    private final bj.a f6013b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6014c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f6015d;

    /* renamed from: e  reason: collision with root package name */
    private final e f6016e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6017f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6018g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6019h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.g<Bitmap> f6020i;

    /* renamed from: j  reason: collision with root package name */
    private a f6021j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6022k;

    /* renamed from: l  reason: collision with root package name */
    private a f6023l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f6024m;

    /* renamed from: n  reason: collision with root package name */
    private i<Bitmap> f6025n;

    /* renamed from: o  reason: collision with root package name */
    private a f6026o;

    /* renamed from: p  reason: collision with root package name */
    private d f6027p;

    /* renamed from: q  reason: collision with root package name */
    private int f6028q;

    /* renamed from: r  reason: collision with root package name */
    private int f6029r;

    /* renamed from: s  reason: collision with root package name */
    private int f6030s;

    static class a extends bz.c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final int f6031a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f6032b;

        /* renamed from: c  reason: collision with root package name */
        private final long f6033c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap f6034d;

        a(Handler handler, int i2, long j2) {
            this.f6032b = handler;
            this.f6031a = i2;
            this.f6033c = j2;
        }

        public void a(Bitmap bitmap, ca.b<? super Bitmap> bVar) {
            this.f6034d = bitmap;
            this.f6032b.sendMessageAtTime(this.f6032b.obtainMessage(1, this), this.f6033c);
        }

        public void a(Drawable drawable) {
            this.f6034d = null;
        }

        /* access modifiers changed from: package-private */
        public Bitmap g_() {
            return this.f6034d;
        }
    }

    public interface b {
        void f();
    }

    private class c implements Handler.Callback {
        c() {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                g.this.a((a) message.obj);
                return true;
            } else if (message.what != 2) {
                return false;
            } else {
                g.this.f6012a.a((j<?>) (a) message.obj);
                return false;
            }
        }
    }

    interface d {
        void a();
    }

    g(e eVar, h hVar, bj.a aVar, Handler handler, com.bumptech.glide.g<Bitmap> gVar, i<Bitmap> iVar, Bitmap bitmap) {
        this.f6015d = new ArrayList();
        this.f6012a = hVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f6016e = eVar;
        this.f6014c = handler;
        this.f6020i = gVar;
        this.f6013b = aVar;
        a(iVar, bitmap);
    }

    g(com.bumptech.glide.c cVar, bj.a aVar, int i2, int i3, i<Bitmap> iVar, Bitmap bitmap) {
        this(cVar.a(), com.bumptech.glide.c.b(cVar.c()), aVar, (Handler) null, a(com.bumptech.glide.c.b(cVar.c()), i2, i3), iVar, bitmap);
    }

    private static com.bumptech.glide.g<Bitmap> a(h hVar, int i2, int i3) {
        return hVar.h().b((com.bumptech.glide.request.a<?>) ((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) com.bumptech.glide.request.h.b(com.bumptech.glide.load.engine.h.f10302b).a(true)).b(true)).c(i2, i3));
    }

    private void j() {
        if (!this.f6017f) {
            this.f6017f = true;
            this.f6022k = false;
            l();
        }
    }

    private void k() {
        this.f6017f = false;
    }

    private void l() {
        if (this.f6017f && !this.f6018g) {
            if (this.f6019h) {
                k.a(this.f6026o == null, "Pending target must be null when starting from the first frame");
                this.f6013b.f();
                this.f6019h = false;
            }
            a aVar = this.f6026o;
            if (aVar != null) {
                this.f6026o = null;
                a(aVar);
                return;
            }
            this.f6018g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f6013b.c());
            this.f6013b.b();
            this.f6023l = new a(this.f6014c, this.f6013b.e(), uptimeMillis);
            this.f6020i.b((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.b(n())).a((Object) this.f6013b).a(this.f6023l);
        }
    }

    private void m() {
        Bitmap bitmap = this.f6024m;
        if (bitmap != null) {
            this.f6016e.a(bitmap);
            this.f6024m = null;
        }
    }

    private static com.bumptech.glide.load.c n() {
        return new cb.b(Double.valueOf(Math.random()));
    }

    /* access modifiers changed from: package-private */
    public Bitmap a() {
        return this.f6024m;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        d dVar = this.f6027p;
        if (dVar != null) {
            dVar.a();
        }
        this.f6018g = false;
        if (this.f6022k) {
            this.f6014c.obtainMessage(2, aVar).sendToTarget();
        } else if (this.f6017f) {
            if (aVar.g_() != null) {
                m();
                a aVar2 = this.f6021j;
                this.f6021j = aVar;
                for (int size = this.f6015d.size() - 1; size >= 0; size--) {
                    this.f6015d.get(size).f();
                }
                if (aVar2 != null) {
                    this.f6014c.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        } else if (this.f6019h) {
            this.f6014c.obtainMessage(2, aVar).sendToTarget();
        } else {
            this.f6026o = aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        if (this.f6022k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f6015d.contains(bVar)) {
            boolean isEmpty = this.f6015d.isEmpty();
            this.f6015d.add(bVar);
            if (isEmpty) {
                j();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object, com.bumptech.glide.load.i<android.graphics.Bitmap>, com.bumptech.glide.load.i] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bumptech.glide.load.i<android.graphics.Bitmap> r3, android.graphics.Bitmap r4) {
        /*
            r2 = this;
            java.lang.Object r0 = cc.k.a(r3)
            com.bumptech.glide.load.i r0 = (com.bumptech.glide.load.i) r0
            r2.f6025n = r0
            java.lang.Object r0 = cc.k.a(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.f6024m = r0
            com.bumptech.glide.g<android.graphics.Bitmap> r0 = r2.f6020i
            com.bumptech.glide.request.h r1 = new com.bumptech.glide.request.h
            r1.<init>()
            com.bumptech.glide.request.a r3 = r1.a((com.bumptech.glide.load.i<android.graphics.Bitmap>) r3)
            com.bumptech.glide.g r3 = r0.b((com.bumptech.glide.request.a<?>) r3)
            r2.f6020i = r3
            int r3 = cc.l.a((android.graphics.Bitmap) r4)
            r2.f6028q = r3
            int r3 = r4.getWidth()
            r2.f6029r = r3
            int r3 = r4.getHeight()
            r2.f6030s = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bu.g.a(com.bumptech.glide.load.i, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f6029r;
    }

    /* access modifiers changed from: package-private */
    public void b(b bVar) {
        this.f6015d.remove(bVar);
        if (this.f6015d.isEmpty()) {
            k();
        }
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f6030s;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f6013b.g() + this.f6028q;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        a aVar = this.f6021j;
        if (aVar != null) {
            return aVar.f6031a;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer f() {
        return this.f6013b.a().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f6013b.d();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f6015d.clear();
        m();
        k();
        a aVar = this.f6021j;
        if (aVar != null) {
            this.f6012a.a((j<?>) aVar);
            this.f6021j = null;
        }
        a aVar2 = this.f6023l;
        if (aVar2 != null) {
            this.f6012a.a((j<?>) aVar2);
            this.f6023l = null;
        }
        a aVar3 = this.f6026o;
        if (aVar3 != null) {
            this.f6012a.a((j<?>) aVar3);
            this.f6026o = null;
        }
        this.f6013b.i();
        this.f6022k = true;
    }

    /* access modifiers changed from: package-private */
    public Bitmap i() {
        a aVar = this.f6021j;
        return aVar != null ? aVar.g_() : this.f6024m;
    }
}
