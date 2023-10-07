package iy;

import com.permissionx.guolindev.b;
import java.util.ArrayList;

abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    protected b f29394a;

    /* renamed from: b  reason: collision with root package name */
    protected f f29395b;

    /* renamed from: c  reason: collision with root package name */
    c f29396c;

    /* renamed from: d  reason: collision with root package name */
    d f29397d = new d(this.f29395b, this);

    a(f fVar) {
        this.f29395b = fVar;
        this.f29396c = new c(fVar, this);
    }

    public c a() {
        return this.f29396c;
    }

    public d b() {
        return this.f29397d;
    }

    public void c() {
        b bVar = this.f29394a;
        if (bVar != null) {
            bVar.d();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f29395b.f29415l);
        arrayList.addAll(this.f29395b.f29416m);
        arrayList.addAll(this.f29395b.f29408e);
        if (this.f29395b.f29409f) {
            if (b.a(this.f29395b.f29404a, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                this.f29395b.f29414k.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            } else {
                arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            }
        }
        if (this.f29395b.f29419p != null) {
            this.f29395b.f29419p.onResult(arrayList.isEmpty(), new ArrayList(this.f29395b.f29414k), arrayList);
        }
    }
}
