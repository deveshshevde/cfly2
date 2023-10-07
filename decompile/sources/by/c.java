package by;

import cc.j;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.q;
import j.a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import s.e;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final q<?, ?, ?> f6113a = new q(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new bv.g(), (e.a<List<Throwable>>) null)), (e.a<List<Throwable>>) null);

    /* renamed from: b  reason: collision with root package name */
    private final a<j, q<?, ?, ?>> f6114b = new a<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<j> f6115c = new AtomicReference<>();

    private j b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        j andSet = this.f6115c.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new j();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVar;
        j b2 = b(cls, cls2, cls3);
        synchronized (this.f6114b) {
            qVar = this.f6114b.get(b2);
        }
        this.f6115c.set(b2);
        return qVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, q<?, ?, ?> qVar) {
        synchronized (this.f6114b) {
            a<j, q<?, ?, ?>> aVar = this.f6114b;
            j jVar = new j(cls, cls2, cls3);
            if (qVar == null) {
                qVar = f6113a;
            }
            aVar.put(jVar, qVar);
        }
    }

    public boolean a(q<?, ?, ?> qVar) {
        return f6113a.equals(qVar);
    }
}
