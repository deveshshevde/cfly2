package by;

import cc.j;
import j.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<j> f6116a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final a<j, List<Class<?>>> f6117b = new a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        j andSet = this.f6116a.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new j(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f6117b) {
            list = this.f6117b.get(andSet);
        }
        this.f6116a.set(andSet);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f6117b) {
            this.f6117b.put(new j(cls, cls2, cls3), list);
        }
    }
}
