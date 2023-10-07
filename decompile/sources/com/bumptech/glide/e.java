package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import bl.b;
import bz.g;
import bz.k;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.request.h;
import java.util.List;
import java.util.Map;

public class e extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    static final i<?, ?> f10079a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final b f10080b;

    /* renamed from: c  reason: collision with root package name */
    private final Registry f10081c;

    /* renamed from: d  reason: collision with root package name */
    private final g f10082d;

    /* renamed from: e  reason: collision with root package name */
    private final c.a f10083e;

    /* renamed from: f  reason: collision with root package name */
    private final List<com.bumptech.glide.request.g<Object>> f10084f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Class<?>, i<?, ?>> f10085g;

    /* renamed from: h  reason: collision with root package name */
    private final i f10086h;

    /* renamed from: i  reason: collision with root package name */
    private final f f10087i;

    /* renamed from: j  reason: collision with root package name */
    private final int f10088j;

    /* renamed from: k  reason: collision with root package name */
    private h f10089k;

    public e(Context context, b bVar, Registry registry, g gVar, c.a aVar, Map<Class<?>, i<?, ?>> map, List<com.bumptech.glide.request.g<Object>> list, i iVar, f fVar, int i2) {
        super(context.getApplicationContext());
        this.f10080b = bVar;
        this.f10081c = registry;
        this.f10082d = gVar;
        this.f10083e = aVar;
        this.f10084f = list;
        this.f10085g = map;
        this.f10086h = iVar;
        this.f10087i = fVar;
        this.f10088j = i2;
    }

    public <X> k<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f10082d.a(imageView, cls);
    }

    public <T> i<?, T> a(Class<T> cls) {
        i<?, T> iVar = this.f10085g.get(cls);
        if (iVar == null) {
            for (Map.Entry next : this.f10085g.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    iVar = (i) next.getValue();
                }
            }
        }
        return iVar == null ? f10079a : iVar;
    }

    public List<com.bumptech.glide.request.g<Object>> a() {
        return this.f10084f;
    }

    public synchronized h b() {
        if (this.f10089k == null) {
            this.f10089k = (h) this.f10083e.a().m();
        }
        return this.f10089k;
    }

    public i c() {
        return this.f10086h;
    }

    public Registry d() {
        return this.f10081c;
    }

    public int e() {
        return this.f10088j;
    }

    public b f() {
        return this.f10080b;
    }

    public f g() {
        return this.f10087i;
    }
}
