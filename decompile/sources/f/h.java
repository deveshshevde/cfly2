package f;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import t.ag;
import t.ah;
import t.ai;

public class h {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<ag> f27065a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ah f27066b;

    /* renamed from: c  reason: collision with root package name */
    private long f27067c = -1;

    /* renamed from: d  reason: collision with root package name */
    private Interpolator f27068d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27069e;

    /* renamed from: f  reason: collision with root package name */
    private final ai f27070f = new ai() {

        /* renamed from: b  reason: collision with root package name */
        private boolean f27072b = false;

        /* renamed from: c  reason: collision with root package name */
        private int f27073c = 0;

        /* access modifiers changed from: package-private */
        public void a() {
            this.f27073c = 0;
            this.f27072b = false;
            h.this.b();
        }

        public void a(View view) {
            if (!this.f27072b) {
                this.f27072b = true;
                if (h.this.f27066b != null) {
                    h.this.f27066b.a((View) null);
                }
            }
        }

        public void b(View view) {
            int i2 = this.f27073c + 1;
            this.f27073c = i2;
            if (i2 == h.this.f27065a.size()) {
                if (h.this.f27066b != null) {
                    h.this.f27066b.b((View) null);
                }
                a();
            }
        }
    };

    public h a(long j2) {
        if (!this.f27069e) {
            this.f27067c = j2;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.f27069e) {
            this.f27068d = interpolator;
        }
        return this;
    }

    public h a(ag agVar) {
        if (!this.f27069e) {
            this.f27065a.add(agVar);
        }
        return this;
    }

    public h a(ag agVar, ag agVar2) {
        this.f27065a.add(agVar);
        agVar2.b(agVar.a());
        this.f27065a.add(agVar2);
        return this;
    }

    public h a(ah ahVar) {
        if (!this.f27069e) {
            this.f27066b = ahVar;
        }
        return this;
    }

    public void a() {
        if (!this.f27069e) {
            Iterator<ag> it2 = this.f27065a.iterator();
            while (it2.hasNext()) {
                ag next = it2.next();
                long j2 = this.f27067c;
                if (j2 >= 0) {
                    next.a(j2);
                }
                Interpolator interpolator = this.f27068d;
                if (interpolator != null) {
                    next.a(interpolator);
                }
                if (this.f27066b != null) {
                    next.a((ah) this.f27070f);
                }
                next.c();
            }
            this.f27069e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f27069e = false;
    }

    public void c() {
        if (this.f27069e) {
            Iterator<ag> it2 = this.f27065a.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
            this.f27069e = false;
        }
    }
}
