package bm;

import bm.h;
import cc.h;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.s;

public class g extends h<c, s<?>> implements h {

    /* renamed from: a  reason: collision with root package name */
    private h.a f5808a;

    public g(long j2) {
        super(j2);
    }

    /* access modifiers changed from: protected */
    public int a(s<?> sVar) {
        return sVar == null ? super.a(null) : sVar.e();
    }

    public /* synthetic */ s a(c cVar) {
        return (s) super.c(cVar);
    }

    public void a(int i2) {
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }

    public void a(h.a aVar) {
        this.f5808a = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(c cVar, s<?> sVar) {
        h.a aVar = this.f5808a;
        if (aVar != null && sVar != null) {
            aVar.b(sVar);
        }
    }

    public /* bridge */ /* synthetic */ s b(c cVar, s sVar) {
        return (s) super.b(cVar, sVar);
    }
}
