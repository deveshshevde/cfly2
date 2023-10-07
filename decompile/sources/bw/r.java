package bw;

import android.util.Log;
import cc.l;
import com.bumptech.glide.request.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final Set<e> f6077a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final Set<e> f6078b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private boolean f6079c;

    public void a() {
        this.f6079c = true;
        for (T t2 : l.a(this.f6077a)) {
            if (t2.d()) {
                t2.c();
                this.f6078b.add(t2);
            }
        }
    }

    public void a(e eVar) {
        this.f6077a.add(eVar);
        if (!this.f6079c) {
            eVar.a();
            return;
        }
        eVar.b();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f6078b.add(eVar);
    }

    public void b() {
        this.f6079c = true;
        for (T t2 : l.a(this.f6077a)) {
            if (t2.d() || t2.e()) {
                t2.b();
                this.f6078b.add(t2);
            }
        }
    }

    public boolean b(e eVar) {
        boolean z2 = true;
        if (eVar == null) {
            return true;
        }
        boolean remove = this.f6077a.remove(eVar);
        if (!this.f6078b.remove(eVar) && !remove) {
            z2 = false;
        }
        if (z2) {
            eVar.b();
        }
        return z2;
    }

    public void c() {
        this.f6079c = false;
        for (T t2 : l.a(this.f6077a)) {
            if (!t2.e() && !t2.d()) {
                t2.a();
            }
        }
        this.f6078b.clear();
    }

    public void d() {
        for (T b2 : l.a(this.f6077a)) {
            b(b2);
        }
        this.f6078b.clear();
    }

    public void e() {
        for (T t2 : l.a(this.f6077a)) {
            if (!t2.e() && !t2.f()) {
                t2.b();
                if (!this.f6079c) {
                    t2.a();
                } else {
                    this.f6078b.add(t2);
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f6077a.size() + ", isPaused=" + this.f6079c + "}";
    }
}
