package iy;

import com.permissionx.guolindev.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class i extends a {
    i(f fVar) {
        super(fVar);
    }

    public /* bridge */ /* synthetic */ c a() {
        return super.a();
    }

    public void a(List<String> list) {
        HashSet hashSet = new HashSet(this.f29395b.f29414k);
        hashSet.addAll(list);
        this.f29395b.a((Set<String>) hashSet, (b) this);
    }

    public /* bridge */ /* synthetic */ d b() {
        return super.b();
    }

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public void d() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.f29395b.f29407d) {
            if (b.a(this.f29395b.f29404a, next)) {
                this.f29395b.f29414k.add(next);
            } else {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            c();
        } else if (!this.f29395b.f29410g || (this.f29395b.f29420q == null && this.f29395b.f29421r == null)) {
            this.f29395b.a(this.f29395b.f29407d, (b) this);
        } else {
            this.f29395b.f29410g = false;
            this.f29395b.f29415l.addAll(arrayList);
            if (this.f29395b.f29421r != null) {
                this.f29395b.f29421r.onExplainReason(this.f29396c, arrayList, true);
            } else {
                this.f29395b.f29420q.a(this.f29396c, arrayList);
            }
        }
    }
}
