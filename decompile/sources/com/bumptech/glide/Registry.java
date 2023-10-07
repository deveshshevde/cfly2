package com.bumptech.glide;

import bo.n;
import bo.o;
import bo.p;
import by.a;
import by.b;
import by.c;
import by.d;
import by.e;
import by.f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import s.e;

public class Registry {

    /* renamed from: a  reason: collision with root package name */
    private final p f10038a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10039b;

    /* renamed from: c  reason: collision with root package name */
    private final e f10040c;

    /* renamed from: d  reason: collision with root package name */
    private final f f10041d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.data.f f10042e;

    /* renamed from: f  reason: collision with root package name */
    private final bv.f f10043f;

    /* renamed from: g  reason: collision with root package name */
    private final b f10044g;

    /* renamed from: h  reason: collision with root package name */
    private final d f10045h = new d();

    /* renamed from: i  reason: collision with root package name */
    private final c f10046i = new c();

    /* renamed from: j  reason: collision with root package name */
    private final e.a<List<Throwable>> f10047j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m2, List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        e.a<List<Throwable>> a2 = cd.a.a();
        this.f10047j = a2;
        this.f10038a = new p(a2);
        this.f10039b = new a();
        this.f10040c = new by.e();
        this.f10041d = new f();
        this.f10042e = new com.bumptech.glide.load.data.f();
        this.f10043f = new bv.f();
        this.f10044g = new b();
        a((List<String>) Arrays.asList(new String[]{"Animation", "Bitmap", "BitmapDrawable"}));
    }

    private <Data, TResource, Transcode> List<g<Data, TResource, Transcode>> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f10040c.b(cls, cls2)) {
            for (Class next2 : this.f10043f.b(next, cls3)) {
                arrayList.add(new g(cls, next, next2, this.f10040c.a(cls, next), this.f10043f.a(next, next2), this.f10047j));
            }
        }
        return arrayList;
    }

    public Registry a(ImageHeaderParser imageHeaderParser) {
        this.f10044g.a(imageHeaderParser);
        return this;
    }

    public Registry a(e.a<?> aVar) {
        this.f10042e.a(aVar);
        return this;
    }

    public <Data> Registry a(Class<Data> cls, com.bumptech.glide.load.a<Data> aVar) {
        this.f10039b.a(cls, aVar);
        return this;
    }

    public <TResource> Registry a(Class<TResource> cls, h<TResource> hVar) {
        this.f10041d.a(cls, hVar);
        return this;
    }

    public <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f10038a.a(cls, cls2, oVar);
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, bv.e<TResource, Transcode> eVar) {
        this.f10043f.a(cls, cls2, eVar);
        return this;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.g<Data, TResource> gVar) {
        a("legacy_append", cls, cls2, gVar);
        return this;
    }

    public <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.g<Data, TResource> gVar) {
        this.f10040c.a(str, gVar, cls, cls2);
        return this;
    }

    public final Registry a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        for (String add : list) {
            arrayList.add(add);
        }
        arrayList.add("legacy_append");
        this.f10040c.a((List<String>) arrayList);
        return this;
    }

    public <X> com.bumptech.glide.load.a<X> a(X x2) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> a2 = this.f10039b.a(x2.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new NoSourceEncoderAvailableException(x2.getClass());
    }

    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> a2 = this.f10046i.a(cls, cls2, cls3);
        if (this.f10046i.a(a2)) {
            return null;
        }
        if (a2 == null) {
            List<g<Data, TResource, Transcode>> c2 = c(cls, cls2, cls3);
            if (c2.isEmpty()) {
                a2 = null;
            } else {
                a2 = new q<>(cls, cls2, cls3, c2, this.f10047j);
            }
            this.f10046i.a(cls, cls2, cls3, a2);
        }
        return a2;
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.f10044g.a();
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new NoImageHeaderParserException();
    }

    public boolean a(s<?> sVar) {
        return this.f10041d.a(sVar.c()) != null;
    }

    public <Model, Data> Registry b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f10038a.b(cls, cls2, oVar);
        return this;
    }

    public <X> com.bumptech.glide.load.data.e<X> b(X x2) {
        return this.f10042e.a(x2);
    }

    public <X> h<X> b(s<X> sVar) throws NoResultEncoderAvailableException {
        h<X> a2 = this.f10041d.a(sVar.c());
        if (a2 != null) {
            return a2;
        }
        throw new NoResultEncoderAvailableException(sVar.c());
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.f10045h.a(cls, cls2, cls3);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class<?> b2 : this.f10038a.a((Class<?>) cls)) {
                for (Class next : this.f10040c.b(b2, cls2)) {
                    if (!this.f10043f.b(next, cls3).isEmpty() && !a2.contains(next)) {
                        a2.add(next);
                    }
                }
            }
            this.f10045h.a(cls, cls2, cls3, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public <Model> List<n<Model, ?>> c(Model model) {
        return this.f10038a.a(model);
    }
}
