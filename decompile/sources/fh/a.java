package fh;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.audio.e;
import com.google.android.exoplayer2.audio.f;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.c;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.video.i;
import com.google.android.exoplayer2.x;
import fh.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class a implements e, f, com.google.android.exoplayer2.drm.a, d, j, c.a, i, com.google.android.exoplayer2.video.j, x.a {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArraySet<b> f13093a = new CopyOnWriteArraySet<>();

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.util.b f13094b;

    /* renamed from: c  reason: collision with root package name */
    private final af.b f13095c = new af.b();

    /* renamed from: d  reason: collision with root package name */
    private final b f13096d = new b();

    /* renamed from: e  reason: collision with root package name */
    private x f13097e;

    /* renamed from: fh.a$a  reason: collision with other inner class name */
    private static final class C0170a {

        /* renamed from: a  reason: collision with root package name */
        public final i.a f27274a;

        /* renamed from: b  reason: collision with root package name */
        public final af f27275b;

        /* renamed from: c  reason: collision with root package name */
        public final int f27276c;

        public C0170a(i.a aVar, af afVar, int i2) {
            this.f27274a = aVar;
            this.f27275b = afVar;
            this.f27276c = i2;
        }
    }

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<C0170a> f27277a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<i.a, C0170a> f27278b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private final af.a f27279c = new af.a();

        /* renamed from: d  reason: collision with root package name */
        private C0170a f27280d;

        /* renamed from: e  reason: collision with root package name */
        private C0170a f27281e;

        /* renamed from: f  reason: collision with root package name */
        private C0170a f27282f;

        /* renamed from: g  reason: collision with root package name */
        private af f27283g = af.f15165a;

        /* renamed from: h  reason: collision with root package name */
        private boolean f27284h;

        private C0170a a(C0170a aVar, af afVar) {
            int a2 = afVar.a(aVar.f27274a.f16367a);
            if (a2 == -1) {
                return aVar;
            }
            return new C0170a(aVar.f27274a, afVar, afVar.a(a2, this.f27279c).f15168c);
        }

        public C0170a a() {
            if (this.f27277a.isEmpty() || this.f27283g.a() || this.f27284h) {
                return null;
            }
            return this.f27277a.get(0);
        }

        public C0170a a(int i2) {
            C0170a aVar = null;
            for (int i3 = 0; i3 < this.f27277a.size(); i3++) {
                C0170a aVar2 = this.f27277a.get(i3);
                int a2 = this.f27283g.a(aVar2.f27274a.f16367a);
                if (a2 != -1 && this.f27283g.a(a2, this.f27279c).f15168c == i2) {
                    if (aVar != null) {
                        return null;
                    }
                    aVar = aVar2;
                }
            }
            return aVar;
        }

        public C0170a a(i.a aVar) {
            return this.f27278b.get(aVar);
        }

        public void a(int i2, i.a aVar) {
            int a2 = this.f27283g.a(aVar.f16367a);
            boolean z2 = a2 != -1;
            af afVar = z2 ? this.f27283g : af.f15165a;
            if (z2) {
                i2 = this.f27283g.a(a2, this.f27279c).f15168c;
            }
            C0170a aVar2 = new C0170a(aVar, afVar, i2);
            this.f27277a.add(aVar2);
            this.f27278b.put(aVar, aVar2);
            this.f27280d = this.f27277a.get(0);
            if (this.f27277a.size() == 1 && !this.f27283g.a()) {
                this.f27281e = this.f27280d;
            }
        }

        public void a(af afVar) {
            for (int i2 = 0; i2 < this.f27277a.size(); i2++) {
                C0170a a2 = a(this.f27277a.get(i2), afVar);
                this.f27277a.set(i2, a2);
                this.f27278b.put(a2.f27274a, a2);
            }
            C0170a aVar = this.f27282f;
            if (aVar != null) {
                this.f27282f = a(aVar, afVar);
            }
            this.f27283g = afVar;
            this.f27281e = this.f27280d;
        }

        public C0170a b() {
            return this.f27281e;
        }

        public void b(int i2) {
            this.f27281e = this.f27280d;
        }

        public boolean b(i.a aVar) {
            C0170a remove = this.f27278b.remove(aVar);
            if (remove == null) {
                return false;
            }
            this.f27277a.remove(remove);
            C0170a aVar2 = this.f27282f;
            if (aVar2 != null && aVar.equals(aVar2.f27274a)) {
                this.f27282f = this.f27277a.isEmpty() ? null : this.f27277a.get(0);
            }
            if (this.f27277a.isEmpty()) {
                return true;
            }
            this.f27280d = this.f27277a.get(0);
            return true;
        }

        public C0170a c() {
            return this.f27282f;
        }

        public void c(i.a aVar) {
            this.f27282f = this.f27278b.get(aVar);
        }

        public C0170a d() {
            if (this.f27277a.isEmpty()) {
                return null;
            }
            ArrayList<C0170a> arrayList = this.f27277a;
            return arrayList.get(arrayList.size() - 1);
        }

        public boolean e() {
            return this.f27284h;
        }

        public void f() {
            this.f27284h = true;
        }

        public void g() {
            this.f27284h = false;
            this.f27281e = this.f27280d;
        }
    }

    public a(com.google.android.exoplayer2.util.b bVar) {
        this.f13094b = (com.google.android.exoplayer2.util.b) com.google.android.exoplayer2.util.a.b(bVar);
    }

    private b.a a(C0170a aVar) {
        com.google.android.exoplayer2.util.a.b(this.f13097e);
        if (aVar == null) {
            int t2 = this.f13097e.t();
            C0170a a2 = this.f13096d.a(t2);
            if (a2 == null) {
                af E = this.f13097e.E();
                if (!(t2 < E.b())) {
                    E = af.f15165a;
                }
                return a(E, t2, (i.a) null);
            }
            aVar = a2;
        }
        return a(aVar.f27275b, aVar.f27276c, aVar.f27274a);
    }

    private b.a d(int i2, i.a aVar) {
        com.google.android.exoplayer2.util.a.b(this.f13097e);
        if (aVar != null) {
            C0170a a2 = this.f13096d.a(aVar);
            return a2 != null ? a(a2) : a(af.f15165a, i2, aVar);
        }
        af E = this.f13097e.E();
        if (!(i2 < E.b())) {
            E = af.f15165a;
        }
        return a(E, i2, (i.a) null);
    }

    private b.a i() {
        return a(this.f13096d.b());
    }

    private b.a j() {
        return a(this.f13096d.a());
    }

    private b.a k() {
        return a(this.f13096d.c());
    }

    private b.a l() {
        return a(this.f13096d.d());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public b.a a(af afVar, int i2, i.a aVar) {
        if (afVar.a()) {
            aVar = null;
        }
        i.a aVar2 = aVar;
        long a2 = this.f13094b.a();
        boolean z2 = true;
        boolean z3 = afVar == this.f13097e.E() && i2 == this.f13097e.t();
        long j2 = 0;
        if (aVar2 != null && aVar2.a()) {
            if (!(z3 && this.f13097e.y() == aVar2.f16368b && this.f13097e.z() == aVar2.f16369c)) {
                z2 = false;
            }
            if (z2) {
                j2 = this.f13097e.v();
            }
        } else if (z3) {
            j2 = this.f13097e.A();
        } else if (!afVar.a()) {
            j2 = afVar.a(i2, this.f13095c).a();
        }
        return new b.a(a2, afVar, i2, aVar2, j2, this.f13097e.v(), this.f13097e.w());
    }

    public final void a() {
        if (!this.f13096d.e()) {
            b.a j2 = j();
            this.f13096d.f();
            Iterator<b> it2 = this.f13093a.iterator();
            while (it2.hasNext()) {
                it2.next().a(j2);
            }
        }
    }

    public void a(int i2, int i3) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(k2, i2, i3);
        }
    }

    public final void a(int i2, int i3, int i4, float f2) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(k2, i2, i3, i4, f2);
        }
    }

    public final void a(int i2, long j2) {
        b.a i3 = i();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(i3, i2, j2);
        }
    }

    public final void a(int i2, long j2, long j3) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().b(k2, i2, j2, j3);
        }
    }

    public final void a(int i2, i.a aVar) {
        this.f13096d.a(i2, aVar);
        b.a d2 = d(i2, aVar);
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().c(d2);
        }
    }

    public final void a(int i2, i.a aVar, j.b bVar, j.c cVar) {
        b.a d2 = d(i2, aVar);
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(d2, bVar, cVar);
        }
    }

    public final void a(int i2, i.a aVar, j.b bVar, j.c cVar, IOException iOException, boolean z2) {
        b.a d2 = d(i2, aVar);
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(d2, bVar, cVar, iOException, z2);
        }
    }

    public final void a(int i2, i.a aVar, j.c cVar) {
        b.a d2 = d(i2, aVar);
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().b(d2, cVar);
        }
    }

    public final void a(Surface surface) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(k2, surface);
        }
    }

    public final void a(ExoPlaybackException exoPlaybackException) {
        b.a i2 = i();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(i2, exoPlaybackException);
        }
    }

    public final void a(Format format) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(k2, 2, format);
        }
    }

    public final void a(af afVar, int i2) {
        this.f13096d.a(afVar);
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().b(j2, i2);
        }
    }

    public /* synthetic */ void a(af afVar, Object obj, int i2) {
        x.a.CC.$default$a(this, afVar, obj, i2);
    }

    public final void a(Metadata metadata) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2, metadata);
        }
    }

    public final void a(TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.f fVar) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2, trackGroupArray, fVar);
        }
    }

    public final void a(v vVar) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2, vVar);
        }
    }

    public void a(x xVar) {
        com.google.android.exoplayer2.util.a.b(this.f13097e == null || this.f13096d.f27277a.isEmpty());
        this.f13097e = (x) com.google.android.exoplayer2.util.a.b(xVar);
    }

    public final void a(fi.d dVar) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2, 2, dVar);
        }
    }

    public final void a(Exception exc) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(k2, exc);
        }
    }

    public final void a(String str, long j2, long j3) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(k2, 2, str, j3);
        }
    }

    public final void a(boolean z2) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().c(j2, z2);
        }
    }

    public final void a(boolean z2, int i2) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2, z2, i2);
        }
    }

    public final void b() {
        if (this.f13096d.e()) {
            this.f13096d.g();
            b.a j2 = j();
            Iterator<b> it2 = this.f13093a.iterator();
            while (it2.hasNext()) {
                it2.next().b(j2);
            }
        }
    }

    public void b(int i2) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2, i2);
        }
    }

    public final void b(int i2, long j2, long j3) {
        b.a l2 = l();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(l2, i2, j2, j3);
        }
    }

    public final void b(int i2, i.a aVar) {
        b.a d2 = d(i2, aVar);
        if (this.f13096d.b(aVar)) {
            Iterator<b> it2 = this.f13093a.iterator();
            while (it2.hasNext()) {
                it2.next().d(d2);
            }
        }
    }

    public final void b(int i2, i.a aVar, j.b bVar, j.c cVar) {
        b.a d2 = d(i2, aVar);
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().b(d2, bVar, cVar);
        }
    }

    public final void b(int i2, i.a aVar, j.c cVar) {
        b.a d2 = d(i2, aVar);
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(d2, cVar);
        }
    }

    public final void b(Format format) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(k2, 1, format);
        }
    }

    public final void b(fi.d dVar) {
        b.a i2 = i();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().b(i2, 2, dVar);
        }
    }

    public final void b(String str, long j2, long j3) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(k2, 1, str, j3);
        }
    }

    public void b(boolean z2) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2, z2);
        }
    }

    public final void c() {
        for (C0170a aVar : new ArrayList(this.f13096d.f27277a)) {
            b(aVar.f27276c, aVar.f27274a);
        }
    }

    public final void c(int i2) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().d(j2, i2);
        }
    }

    public final void c(int i2, i.a aVar) {
        this.f13096d.c(aVar);
        b.a d2 = d(i2, aVar);
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().e(d2);
        }
    }

    public final void c(int i2, i.a aVar, j.b bVar, j.c cVar) {
        b.a d2 = d(i2, aVar);
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().c(d2, bVar, cVar);
        }
    }

    public final void c(fi.d dVar) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().a(j2, 1, dVar);
        }
    }

    public final void c(boolean z2) {
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().b(j2, z2);
        }
    }

    public final void d() {
    }

    public final void d(int i2) {
        this.f13096d.b(i2);
        b.a j2 = j();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().c(j2, i2);
        }
    }

    public final void d(fi.d dVar) {
        b.a i2 = i();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().b(i2, 1, dVar);
        }
    }

    public final void e() {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().f(k2);
        }
    }

    public final void e(int i2) {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().e(k2, i2);
        }
    }

    public final void f() {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().g(k2);
        }
    }

    public final void g() {
        b.a k2 = k();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().h(k2);
        }
    }

    public final void h() {
        b.a i2 = i();
        Iterator<b> it2 = this.f13093a.iterator();
        while (it2.hasNext()) {
            it2.next().i(i2);
        }
    }
}
