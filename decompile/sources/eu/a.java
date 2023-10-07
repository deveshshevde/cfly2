package eu;

import android.view.MotionEvent;
import et.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private d f26968a;

    /* renamed from: b  reason: collision with root package name */
    private c f26969b;

    /* renamed from: c  reason: collision with root package name */
    private g f26970c;

    /* renamed from: d  reason: collision with root package name */
    private i f26971d;

    /* renamed from: e  reason: collision with root package name */
    private f f26972e;

    /* renamed from: f  reason: collision with root package name */
    private h f26973f;

    /* renamed from: g  reason: collision with root package name */
    private b f26974g;

    /* renamed from: h  reason: collision with root package name */
    private b f26975h;

    /* renamed from: i  reason: collision with root package name */
    private j f26976i;

    /* renamed from: j  reason: collision with root package name */
    private e f26977j;

    /* renamed from: k  reason: collision with root package name */
    private b f26978k;

    public c a() {
        return this.f26969b;
    }

    public void a(int i2) {
        d dVar = this.f26968a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void a(int i2, float f2) {
        h hVar = this.f26973f;
        if (hVar != null) {
            hVar.a(i2, f2);
        }
    }

    public void a(int i2, int i3) {
        f fVar = this.f26972e;
        if (fVar != null) {
            fVar.a(i2, i3);
        }
    }

    public void a(b bVar) {
        this.f26978k = bVar;
    }

    public void a(b bVar) {
        this.f26974g = bVar;
    }

    public void a(c cVar) {
        this.f26969b = cVar;
    }

    public void a(d dVar) {
        this.f26968a = dVar;
    }

    public void a(e eVar) {
        this.f26977j = eVar;
    }

    public void a(f fVar) {
        this.f26972e = fVar;
    }

    public void a(g gVar) {
        this.f26970c = gVar;
    }

    public void a(h hVar) {
        this.f26973f = hVar;
    }

    public void a(i iVar) {
        this.f26971d = iVar;
    }

    public void a(j jVar) {
        this.f26976i = jVar;
    }

    public void a(ev.a aVar) {
        b bVar = this.f26978k;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public boolean a(int i2, Throwable th) {
        g gVar = this.f26970c;
        if (gVar == null) {
            return false;
        }
        gVar.a(i2, th);
        return true;
    }

    public boolean a(MotionEvent motionEvent) {
        j jVar = this.f26976i;
        return jVar != null && jVar.a(motionEvent);
    }

    public b b() {
        return this.f26974g;
    }

    public void b(int i2) {
        i iVar = this.f26971d;
        if (iVar != null) {
            iVar.a(i2);
        }
    }

    public void b(MotionEvent motionEvent) {
        e eVar = this.f26977j;
        if (eVar != null) {
            eVar.a(motionEvent);
        }
    }

    public void b(b bVar) {
        this.f26975h = bVar;
    }

    public b c() {
        return this.f26975h;
    }
}
