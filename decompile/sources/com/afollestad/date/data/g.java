package com.afollestad.date.data;

import androidx.recyclerview.widget.g;
import com.afollestad.date.data.f;
import java.util.List;
import kotlin.jvm.internal.h;

public final class g extends g.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f7427a;

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f7428b;

    public g(List<? extends f> list, List<? extends f> list2) {
        h.c(list, "oldItems");
        h.c(list2, "newItems");
        this.f7427a = list;
        this.f7428b = list2;
    }

    public int a() {
        return this.f7427a.size();
    }

    public boolean a(int i2, int i3) {
        f fVar = this.f7427a.get(i2);
        f fVar2 = this.f7428b.get(i3);
        if (!(fVar instanceof f.b) || !(fVar2 instanceof f.b)) {
            if ((fVar instanceof f.a) && (fVar2 instanceof f.a)) {
                f.a aVar = (f.a) fVar;
                f.a aVar2 = (f.a) fVar2;
                return h.a((Object) aVar.b(), (Object) aVar2.b()) && aVar.c() == aVar2.c();
            }
        } else if (((f.b) fVar).a() == ((f.b) fVar2).a()) {
            return true;
        }
    }

    public int b() {
        return this.f7428b.size();
    }

    public boolean b(int i2, int i3) {
        f fVar = this.f7427a.get(i2);
        f fVar2 = this.f7428b.get(i3);
        if (!(fVar instanceof f.b) || !(fVar2 instanceof f.b)) {
            if ((fVar instanceof f.a) && (fVar2 instanceof f.a)) {
                f.a aVar = (f.a) fVar;
                f.a aVar2 = (f.a) fVar2;
                return h.a((Object) aVar.b(), (Object) aVar2.b()) && aVar.c() == aVar2.c() && aVar.d() == aVar2.d();
            }
        } else if (((f.b) fVar).a() == ((f.b) fVar2).a()) {
            return true;
        }
    }
}
